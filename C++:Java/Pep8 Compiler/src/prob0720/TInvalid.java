package prob0720;

/**
 * The invalid token subclass of the abstract token.
 *
 * <p>
 * File: <code>TInvalid.java</code>
 *
 * @author J. Stanley Warford
 */
public class TInvalid extends AToken {

    @Override
    public String getDescription() {
        return "Syntax error";
    }
}
