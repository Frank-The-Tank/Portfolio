package prob0720;

/**
 *
 * @author Frank Garcia
 */
public class DotBlock extends ACode {
    
    private final AArg aArg;
    
    public DotBlock(AArg aArgument) {
        aArg = aArgument; 
    }
    
    @Override
    public String generateListing() {
        return String.format(".BLOCK %s\n", aArg.generateCode());
    }
    
    @Override
    public String generateCode() {
        return "For Later";
    }
}
