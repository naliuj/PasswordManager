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

    public Hashable getHash(int key) {
        switch (key) {
            case 0:
                return new DummyHash();
            case 1:
                return new Hash();
            default:
                throw new Error("key is out of range");
        }
    }
    
}
