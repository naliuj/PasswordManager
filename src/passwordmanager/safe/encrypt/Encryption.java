/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.safe.encrypt;

import java.io.Serializable;

/**
 *
 * @author julian
 */
public class Encryption implements Encryptable, Serializable {

    @Override
    public byte[] encrypt(String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String decrypt(byte[] password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
