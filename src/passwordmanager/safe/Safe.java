/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.safe;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import passwordmanager.hash.*;

/**
 *
 * @author julian
 */
public class Safe implements Serializable {
    
    private transient String path;
    private String passwordHash;
    private final ArrayList<Entry> entries = new ArrayList<>();
    
    final private Hashable hash = new HashFactory().getHash("dummy");
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public String getPath() {
        return path;
    }
    
//    public void save(String path) {
//        try {
//            FileOutputStream fileOut = new FileOutputStream(path);
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(this);
//            out.close();
//            fileOut.close();
//        } catch (IOException i) {
//            i.printStackTrace();
//        }
//    }

    
    /**
     * Adds an entry to the entries ArrayList
     * @param e The new entry to be added
     */
    public void addEntry(Entry e) {
        entries.add(e);
    }
    
    /**
     * Get all the items in the entries ArrayList
     * @return An Iterator object for the entries in the Safe
     */
    public ArrayList<Entry> getAllEntries() {
        return entries;
    }
    
    /**
     * Find the Entry from the ArrayList of entries by ID
     * @param id The ID of the entry
     * @return The Entry that matches the given ID
     */
    public Entry getEntry(int id) {
        for (Entry e : entries) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    
    public void deleteEntry(Entry entry) {
        entries.remove(entry);
    }
    
    /**
     * Function to create or change a password that automatically hashes it.
     * @param password The new password as a String
     */
    public void hashNewPassword(String password) {
        passwordHash = hash.getSaltedHash(password);
    }
        
    public String getPasswordHash() {
        return passwordHash;
    }

    public Safe(String password, String path) {
        this.path = path;
        this.passwordHash = hash.getSaltedHash(password);
    }
    
    public Safe() {}
    
}
