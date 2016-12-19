package prob0720;

/**
 * The identifier token subclass of the abstract token.
 *
 * <p>
 * File: <code>TIdentifier.java</code>
 *
 * @author J. Stanley Warford
 */
public class TIdentifier extends AToken {

    private final String stringValue;

    public TIdentifier(StringBuffer stringBuffer) {
        stringValue = new String(stringBuffer);
    }

    @Override
    public String getDescription() {
        return String.format("Identifier = %s\n", stringValue);
    }
    
    public String getStringValue() {
        return stringValue;
    }
}
