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
public class DummyEncrypt implements Encryptable, Serializable {

    @Override
    public byte[] encrypt(String password) {
        return password.getBytes();
    }

    @Override
    public String decrypt(byte[] password) {
        return new String(password);
    }
    
}
