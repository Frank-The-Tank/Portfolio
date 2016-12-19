package prob0720;


import java.util.HashMap;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @Frank Garcia
 */
public class Maps {
    
    public static final Map<String, Mnemon> unaryMnemonTable;
    public static final Map<String, Mnemon> nonUnaryMnemonTable;
    public static final Map<String, Mnemon> dotCommandMnemonTable;
    public static final Map<String, AddressingMode> addrModeTable;
    public static final Map<Mnemon, String> mnemonStringTable; 
    public static final Map<AddressingMode, String> addrModeStringTable;
    
    static {
        unaryMnemonTable = new HashMap<>();
        unaryMnemonTable.put("stop", Mnemon.M_STOP);
        unaryMnemonTable.put("asla", Mnemon.M_ASLA);
        unaryMnemonTable.put("asra", Mnemon.M_ASRA);
        
        nonUnaryMnemonTable = new HashMap<>();
        nonUnaryMnemonTable.put("br", Mnemon.M_BR);
        nonUnaryMnemonTable.put("brlt", Mnemon.M_BRLT);
        nonUnaryMnemonTable.put("breq", Mnemon.M_BREQ);
        nonUnaryMnemonTable.put("brle", Mnemon.M_BRLE);
        nonUnaryMnemonTable.put("cpa", Mnemon.M_CPA);
        nonUnaryMnemonTable.put("deci", Mnemon.M_DECI);
        nonUnaryMnemonTable.put("deco", Mnemon.M_DECO);
        nonUnaryMnemonTable.put("adda", Mnemon.M_ADDA);
        nonUnaryMnemonTable.put("suba", Mnemon.M_SUBA);
        nonUnaryMnemonTable.put("sta", Mnemon.M_STA);
        nonUnaryMnemonTable.put("lda", Mnemon.M_LDA);
        
        dotCommandMnemonTable = new HashMap<>();
        dotCommandMnemonTable.put("block", Mnemon.M_BLOCK);
        dotCommandMnemonTable.put("end", Mnemon.M_END);

        addrModeTable = new HashMap<>();
        addrModeTable.put("i", AddressingMode.M_IMMEDIATE);
        addrModeTable.put("d", AddressingMode.M_DIRECT);
        addrModeTable.put("n", AddressingMode.M_INDIRECT);
        addrModeTable.put("s", AddressingMode.M_STACKRELATIVE);
        addrModeTable.put("sf",AddressingMode.M_STACKRELATIVEDEFERRED);
        addrModeTable.put("x",AddressingMode.M_INDEXED);
        addrModeTable.put("sx",AddressingMode.M_STACKINDEXED);
        addrModeTable.put("sxf",AddressingMode.M_STACKINDEXEDDEFERRED);
        addrModeTable.put("empty",AddressingMode.M_E);
           
        mnemonStringTable = new EnumMap<>(Mnemon.class);
        mnemonStringTable.put(Mnemon.M_STOP, "STOP");
        mnemonStringTable.put(Mnemon.M_ASLA, "ASLA");
        mnemonStringTable.put(Mnemon.M_ASRA, "ASRA");
        mnemonStringTable.put(Mnemon.M_BR, "BR");
        mnemonStringTable.put(Mnemon.M_BRLT, "BRLT");
        mnemonStringTable.put(Mnemon.M_BREQ, "BREQ");
        mnemonStringTable.put(Mnemon.M_BRLE, "BRLE");
        mnemonStringTable.put(Mnemon.M_CPA, "CPA");
        mnemonStringTable.put(Mnemon.M_DECI, "DECI");
        mnemonStringTable.put(Mnemon.M_DECO, "DECO");
        mnemonStringTable.put(Mnemon.M_ADDA, "ADDA");
        mnemonStringTable.put(Mnemon.M_SUBA, "SUBA");
        mnemonStringTable.put(Mnemon.M_STA, "STA");
        mnemonStringTable.put(Mnemon.M_LDA, "LDA");
        mnemonStringTable.put(Mnemon.M_BLOCK, ".BLOCK");
        mnemonStringTable.put(Mnemon.M_END, ".END"); 
        
        addrModeStringTable = new EnumMap<>(AddressingMode.class);
        addrModeStringTable.put(AddressingMode.M_IMMEDIATE, ",i");
        addrModeStringTable.put(AddressingMode.M_DIRECT, ",d");
        addrModeStringTable.put(AddressingMode.M_INDIRECT, ",n");
        addrModeStringTable.put(AddressingMode.M_STACKRELATIVE, ",s");
        addrModeStringTable.put(AddressingMode.M_STACKRELATIVEDEFERRED, ",sf");
        addrModeStringTable.put(AddressingMode.M_INDEXED, ",x");
        addrModeStringTable.put(AddressingMode.M_STACKINDEXED, ",sx");
        addrModeStringTable.put(AddressingMode.M_STACKINDEXEDDEFERRED, ",sxf"); 
        addrModeStringTable.put(AddressingMode.M_E, "");
    }
}
