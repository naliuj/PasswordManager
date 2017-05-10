/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.safe;

import passwordmanager.safe.encrypt.Encryptable;
import passwordmanager.safe.encrypt.EncryptionFactory;

/**
 *
 * @author julian
 */
public class Entry {
    
    private static int entryCount = 0;
    final private int id;
    private String title;
    private String username;
    private byte[] password;
    private Encryptable crypt = new EncryptionFactory()
            .getEncryption("dummy");
    
    public int getId() { return id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return crypt.decrypt(password); }
    public void setPassword(String password) { this.password = crypt.encrypt(password); }
    
    public Entry(String title, String username, String password) {
        this.id = entryCount;
        this.title = title;
        this.username = username;
        this.password = crypt.encrypt(password);
        entryCount++;
    }
        
}
