package spaceInvaders.io;

import spaceInvaders.dominio.Usuario;
import spaceInvaders.util.Constantes;

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

  public static void imprimirLeaderboard(){
    try{
      FileWriter fw = new FileWriter("spaceInvaders/leaderboard/leaderboard.txt");
      PrintWriter pw = new PrintWriter(fw);
      int limite;
      if(Constantes.PUNTUACIONES_EN_ORDEN.length>=100)
        limite = 100;
      else
        limite = Constantes.PUNTUACIONES_EN_ORDEN.length;
      for(int i=0;i<limite;i++){
        Usuario u = (Usuario) Constantes.USUARIOS_POR_PUNTOS.get(Constantes.PUNTUACIONES_EN_ORDEN[i]);
        pw.println(u.toImprimir());
      }
      pw.close();
      fw.close();
    }
    catch(IOException ioe){
      ioe.printStackTrace();
      javax.swing.JOptionPane.showMessageDialog(null, "No se pudo escribir en el fichero", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
  }
}
