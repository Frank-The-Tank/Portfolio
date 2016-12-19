package prob0720;

/**
 * The integer token subclass of the abstract token.
 *
 * <p>
 * File: <code>TInteger.java</code>
 *
 * @author J. Stanley Warford
 */
public class TInteger extends AToken {

    private final int intValue;

    public TInteger(int i) {
        intValue = i;
    }

    @Override
    public String getDescription() {
        return String.format("Integer = %d", intValue);
    }
    
    public int getIntValue() {
        return intValue;
    }
}
