package prob0720;

/**
 *
 * @author Frank Garcia
 */
public class UnaryInstr extends ACode {
    
    private final Mnemon mnemonic;
    
    public UnaryInstr(Mnemon mn) {
        mnemonic = mn;
    }
    
    @Override
    public String generateListing() {
        return String.format("%s\n", Maps.mnemonStringTable.get(mnemonic));
    }
    
    @Override
    public String generateCode() {
        return "For Later";
    }
}
