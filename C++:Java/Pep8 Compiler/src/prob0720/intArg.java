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
public class intArg extends AArg {
    
    private final int num; 
    
    public intArg(int number) {
        num = number;
    }
    
    @Override
    public String generateCode() {
        return String.format("%s", num);
    }
}
