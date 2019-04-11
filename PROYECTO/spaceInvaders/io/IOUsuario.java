package spaceInvaders.io;

import spaceInvaders.dominio.Usuario;

import java.util.*;
import java.io.*;

public class IOUsuario {
  public static void escribirUsuarios(Collection usuarios){
    try {
      FileOutputStream fos = new FileOutputStream("spaceInvaders/datos/usuarios.spa");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      Iterator it = usuarios.iterator();
      Usuario u;
      while (it.hasNext())
        oos.writeObject(it.next());
      oos.close();
      fos.close();
    }
    catch(IOException ioe){
      ioe.printStackTrace();
    }
  }

  public static Collection leerUsuarios(){
    Collection usuarios = new ArrayList();
    ObjectInputStream ois = null;
    try {
      ois = new ObjectInputStream(new FileInputStream("spaceInvaders/datos/usuarios.spa"));
        try {
          while(true)
            usuarios.add((Usuario) ois.readObject());
        } catch (EOFException eof){
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
        ois.close();
    } catch (FileNotFoundException e) {  
    } catch (IOException e) {
        e.printStackTrace();
    }
    return usuarios;
  }
}
