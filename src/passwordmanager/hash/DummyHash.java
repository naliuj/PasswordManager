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
public class DummyHash implements Hashable, Serializable {

    @Override
    public String getSaltedHash(String password) {
        return password;
    }

    @Override
    public boolean check(String password, String stored) {
        return (password == null ? stored == null : password.equals(stored));
    }
    
}
