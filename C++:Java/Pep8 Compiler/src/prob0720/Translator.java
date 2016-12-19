package prob0720;

import java.util.ArrayList;

/**
 *
 * @author Frank Garcia
 */
public class Translator {
    private final InBuffer b;
    private Tokenizer t;
    private ACode aCode;
    public Translator(InBuffer inBuffer) {
        b = inBuffer;
    }
    
    private boolean parseLine() {
        boolean terminate = false;
        AArg localArg = new intArg(0);
        Mnemon localMnemon = Mnemon.M_STOP;
        AddressingMode localAddr = AddressingMode.M_IMMEDIATE;
        ParseState state = ParseState.PS_START;
        AToken aToken;
        aCode = new EmptyInstr();
        do {
            aToken = t.getToken();
            switch(state) {
                case PS_START:
                    if (aToken instanceof TIdentifier) {
                        TIdentifier localTIdentifier = (TIdentifier) aToken;
                        String tempStr = localTIdentifier.getStringValue();
                        if (Maps.unaryMnemonTable.containsKey(tempStr.toLowerCase())) {
                            localMnemon = Maps.unaryMnemonTable.get(tempStr.toLowerCase());
                            aCode = new UnaryInstr(localMnemon);
                            terminate = localMnemon == Mnemon.M_END;
                            state = ParseState.PS_INSTR;
                        } else if (Maps.nonUnaryMnemonTable.containsKey(tempStr.toLowerCase())) {
                            localMnemon = Maps.nonUnaryMnemonTable.get(tempStr.toLowerCase());
                            terminate = localMnemon == Mnemon.M_END;
                            state = ParseState.PS_INSTR;
                        } else {
                            aCode = new Error("Not a valid identifier");
                        }
                    } else if (aToken instanceof TDotCommand) {
                        TDotCommand localTDotCommand = (TDotCommand) aToken;
                        String tempStr = localTDotCommand.getStringValue();
                        if (Maps.dotCommandMnemonTable.containsKey(tempStr.toLowerCase())) {
                            localMnemon = Maps.dotCommandMnemonTable.get(tempStr.toLowerCase());
                            if (localMnemon == Mnemon.M_BLOCK) {
                                terminate = localMnemon == Mnemon.M_END;
                                state = ParseState.PS_DOT1;
                            } else {
                                aCode = new DotEnd();
                                terminate = localMnemon == Mnemon.M_END;
                                state = ParseState.PS_STOP;
                            }
                        } else {
                            aCode = new Error("Not a valid dot command");
                        }
                    } else if (aToken instanceof TEmpty) {
                        aCode = new EmptyInstr();
                        state = ParseState.PS_STOP;
                    } else {
                        aCode = new Error("Line must start with Identifier, Dot Command, or Empty String");
                    }
                    break;
                case PS_DOT1:
                    if (aToken instanceof TInteger) {
                        TInteger localTInteger = (TInteger) aToken;
                        localArg = new intArg(localTInteger.getIntValue());
                        terminate = localMnemon == Mnemon.M_END;
                        state = ParseState.PS_DOT2;
                    } else if (aToken instanceof THexConstant) {
                        THexConstant localTHexConstant = (THexConstant) aToken;
                        localArg = new hexArg(localTHexConstant.getIntValue());
                        terminate = localMnemon == Mnemon.M_END;
                        state = ParseState.PS_DOT2;
                    } else if (aToken instanceof TEmpty){
                        state = ParseState.PS_STOP;
                    } else {
                        aCode = new Error("Line must start with a Constant or Empty String");
                    }
                    break;
                case PS_DOT2:
                    if (aToken instanceof TEmpty) {
                        aCode = new DotBlock(localArg);
                        terminate = localMnemon == Mnemon.M_END;
                        state = ParseState.PS_STOP;
                    } else {
                        aCode = new Error("Line must be empty to accept");
                    }
                    break;
                case PS_INSTR:
                    if (aToken instanceof TInteger) {
                        TInteger localTInteger = (TInteger) aToken;
                        localArg = new intArg(localTInteger.getIntValue());
                        terminate = localMnemon == Mnemon.M_END;
                        state = ParseState.PS_INT;
                    } else if (aToken instanceof THexConstant) {
                        THexConstant localTHexConstant = (THexConstant) aToken;
                        localArg = new hexArg(localTHexConstant.getIntValue());
                        terminate = localMnemon == Mnemon.M_END;
                        state = ParseState.PS_INT;
                    } else if (aToken instanceof TEmpty) {
                        aCode = new UnaryInstr(localMnemon);
                        state = ParseState.PS_STOP;
                    } else {
                        aCode = new Error("Line must start with constant or empty string");
                    }
                    break;
                case PS_INT:
                    if (aToken instanceof TAddress) {
                        TAddress localTAddress = (TAddress) aToken;
                        String tempStr = localTAddress.getStringValue();
                        if (Maps.addrModeTable.containsKey(tempStr.toLowerCase())) {
                            localAddr = Maps.addrModeTable.get(tempStr.toLowerCase());
                            terminate = localMnemon == Mnemon.M_END;
                            state = ParseState.PS_ADDR;
                        } else {
                            aCode = new Error("Not a valid address");
                        }
                    } else if (aToken instanceof TEmpty) {
                        localAddr = Maps.addrModeTable.get("empty");
                        aCode = new NonUnaryInstr(localMnemon, localArg, localAddr);
                        terminate = localMnemon == Mnemon.M_END;
                        state = ParseState.PS_STOP;
                    } else {
                        aCode = new Error("Line must start with an Address or Empty String");
                    }
                    break;
                case PS_ADDR:
                    if (aToken instanceof TEmpty) {
                        if (localMnemon == Mnemon.M_BR) {
                            if (localAddr == AddressingMode.M_IMMEDIATE) {
                                localAddr = Maps.addrModeTable.get("empty");
                            } else {
                                // Do nothing, output will stay as is
                            }
                        }
                        aCode = new NonUnaryInstr(localMnemon, localArg, localAddr);
                        state = ParseState.PS_STOP;
                    } else {
                        aCode = new Error("Line must start with an Empty String");
                    }
                    break;
            }
        } while (state != ParseState.PS_STOP && !(aCode instanceof Error));
        return terminate;
    }
    
    public void translate() {
        ArrayList<ACode> codeTable = new ArrayList<>();
        int numErrors = 0;
        t = new Tokenizer(b);
        boolean terminateWithEnd = false; 
        b.getLine();
        while (b.inputRemains() && !terminateWithEnd) {
            terminateWithEnd = parseLine(); // Sets aCode and returns boolean
            codeTable.add(aCode);
            if (aCode instanceof Error) {
                numErrors++;
            }
            b.getLine();
        }
        if (!terminateWithEnd) {
            aCode = new Error("Missing \"end\" sentinel.");
            codeTable.add(aCode);
            numErrors++;
        }
//        if (numErrors == 0) {
//            System.out.printf("Object code: \n");
//            for (int i = 0; i < codeTable.size(); i++) {
//                System.out.printf("%s", codeTable.get(i).generateCode());
//            }
//        }
        if (numErrors == 1) {
            System.out.printf("One error was detected. \n");
        } else if (numErrors > 1) {
            System.out.printf("%d errors were detected.\n", numErrors);
        }
        System.out.printf("\nProgram listing:\n");
        for (int i =0; i < codeTable.size(); i++) {
            System.out.printf("%s", codeTable.get(i).generateListing());
        }
    }

}

    
