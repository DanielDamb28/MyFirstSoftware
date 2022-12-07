package model.entities;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
 
public class Serializar {
 
    public Serializar() {}
     
    public void serializar(String path, Object obj) throws Exception {
            FileOutputStream outFile = new FileOutputStream(path);
    ObjectOutputStream s = new ObjectOutputStream(outFile);
    s.writeObject(obj);
    s.close();
    } 
}