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
public interface Hashable {
    
    public String getSaltedHash(String password);
    public boolean check(String password, String stored);
    
}
