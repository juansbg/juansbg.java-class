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
    boolean cont = true;
    try {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("spaceInvaders/datos/usuarios.spa"));
        while(cont){
              Usuario user=null;
            try {
                user =(Usuario) ois.readObject();
            } catch (EOFException eof){
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
              if(user != null)
                 usuarios.add(user);
              else
                 cont = false;
           }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return usuarios;
  }
}
