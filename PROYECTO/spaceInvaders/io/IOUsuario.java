package spaceInvaders.io;

import java.util.*;
import java.io.*;

public class IOUsuario {
  // Poner en Usuario implements java.io.Serializable
  public static void escribirUsuarios(Collection usuarios){
    try {
      FileOutputStream fos = new FileOutputStream("spaceInvaders/datos/usuarios.obj");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("spaceInvaders/datos/usuarios.obj"));
      Iterator it = usuarios.iterator();
      Usuario u;
      while (it.hasNext())
        oos.writeObject(it.next());
      oos.close();
      fos.close();
    }
    /*catch(FileNotFoundException fnfe){

    }*/
    catch(IOException ioe){
      e.printStackTrace();
    }
  }
  public static Collection leerUsuarios(){

  }
}
