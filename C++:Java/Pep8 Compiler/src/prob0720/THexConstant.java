package prob0720;

/**
 *
 * @author cosc
 */
public class THexConstant extends AToken {
    
    private final int hexValue;

    public THexConstant(int i) {
        hexValue = i;
    }

    @Override
    public String getDescription() {
        return String.format("Hexadecimal constant = %d", hexValue);
    }
   
    
    public int getIntValue() {
        return hexValue;
    }
}
