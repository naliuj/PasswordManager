/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.hash;

/**
 *
 * @author julian
 */
public class HashFactory {

    public Hashable getHash(String key) {
        switch (key) {
            case "dummy":
                return new DummyHash();
            case "real":
                return new Hash();
            default:
                throw new Error("Unsupported key");
        }
    }
    
}
