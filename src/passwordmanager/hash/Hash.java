/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.hash;

import java.io.Serializable;

/**
 *
 * @author julian
 */
public class Hash implements Hashable, Serializable {

    @Override
    public String getSaltedHash(String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean check(String password, String stored) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
