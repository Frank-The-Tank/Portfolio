package prob0720;

/**
 *
 * @author Frank Garcia
 */
public class NonUnaryInstr extends ACode {
    
    private final Mnemon mnemonic;
    private final AArg aArg;
    private final AddressingMode addrMode; 
    
    public NonUnaryInstr(Mnemon mn, AArg aArgument, AddressingMode addressingMode) {
        mnemonic = mn;
        aArg = aArgument;
        addrMode = addressingMode;
    }
    
    @Override
    public String generateListing() {
        return String.format("%s %s%s\n", Maps.mnemonStringTable.get(mnemonic), aArg.generateCode(), Maps.addrModeStringTable.get(addrMode));
    }
    
    @Override
    public String generateCode() {
        return "For Later";
    }
}
