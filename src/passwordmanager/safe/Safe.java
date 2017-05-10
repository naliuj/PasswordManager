/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.safe;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import passwordmanager.hash.*;

/**
 *
 * @author julian
 */
public class Safe {
    
    private String passwordHash;
    private final String path;
    private final ArrayList<Entry> entries = new ArrayList<>();
    
    final private Hashable hash = new HashFactory().getHash("dummy");
    
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
    public Iterator<Entry> getAllEntries() {
        return entries.iterator();
    }
    
    /**
     * Find the Entry from the ArrayList of entries by ID
     * @param id The ID of the entry
     * @return The Entry that matches the given ID
     */
    public Entry getEntry(int id) {
        Entry e;
        Iterator<Entry> i = getAllEntries();
        while(i.hasNext()) {
            e = i.next();
            if (e.getId() == id) {
                return e;
            }
        }
        throw new Error("Can't find Entry by ID: " + id);
    }
    
    /**
     * Function to create or change a password that automatically hashes it.
     * @param password The new password as a String
     */
    public void hashNewPassword(String password) {
        passwordHash = hash.getSaltedHash(password);
    }
    
    /**
     * Serializes the safe object to a file.
     */
    public void saveSafe() {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    
    /**
     * Get the file path of the Safe
     * @return File path of the Safe as a String.
     */
    public String getPath() {
        return path;
    }
        
    /**
     * 
     * @param path The file path to the serialized Safe object
     */
    public Safe(String path) {
        this.path = path;
    }
    
    /**
     * The default constructor defaults to using "safe.psafe" as the file path.
     */
    public Safe() {
        this.path = "safe.psafe";
    }
    
}
