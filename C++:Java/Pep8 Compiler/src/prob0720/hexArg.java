/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prob0720;

/**
 *
 * @author cosc
 */
public class hexArg extends AArg {
    
    private final int hexValue;
    
    public hexArg(int hex) {
        hexValue = hex;
    }
    
    @Override
    public String generateCode() {
        return String.format("0x%04X", hexValue);
    }
}
