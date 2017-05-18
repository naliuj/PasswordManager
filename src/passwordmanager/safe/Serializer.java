/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.safe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author julian
 */
public class Serializer {
        
    public static Safe load(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Safe safe = (Safe) in.readObject();
        in.close();
        fileIn.close();
        safe.setPath(path);
        return safe;
    }
    
    public static void save(Safe safe) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(safe.getPath());
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(safe);
        out.close();
        fileOut.close();
    }
        
}
