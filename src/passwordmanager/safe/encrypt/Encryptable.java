/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.safe.encrypt;

/**
 *
 * @author julian
 */
public interface Encryptable {
    
    public byte[] encrypt(String password);
    public String decrypt(byte[] password);
    
}
