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
public class EncryptionFactory {
    
    public Encryptable getEncryption(String key) {
        switch (key) {
            case "dummy":
                return new DummyEncrypt();
            case "real":
                return new Encryption();
            default:
                throw new Error("Unsupported key");
        }
    }
    
}
