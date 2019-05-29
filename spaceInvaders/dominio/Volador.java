package spaceInvaders.dominio;
import java.net.URL;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
/**Clase para objetos del juego que no tendran posicion fija por lo
*que se implementa su movimiento.
*/
public abstract class Volador extends ObjetoJuego {
  /**Derivada de movimiento en X, lo que se movera cada turno en direccion X.*/
  private int movX;
  /**Derivada de movimiento en Y, lo que se movera cada turno en direccion Y.*/
  private int movY;
  /**Constructor heredado de ObjetoJuego, con la misma funcionalidad.
  *@param dirImagen1 Sera un String con el path de la Primera imagen del objeto.
  *@param dirImagen2 Sera un String con el path de la Segunda imagen del objeto.
  *@param dirImagen3 Sera un String con el path de la Tercera imagen del objeto.
  */
  public Volador(String dirImagen1, String dirImagen2, String dirImagen3){
    super(dirImagen1,dirImagen2, dirImagen3);
  }
  /**Utilizado para conseguir el movimiento en X.*/
  public int getMovX(){
    return movX;
  }
  /**Utilizado para conseguir el movimiento en Y.*/
  public int getMovY(){
    return movY;
  }
  /**Utilizado para fijar el movimiento en X.
  *@param m Nuevo movimiento en X*/
  public void setMovX(int m){
    this.movX = m;
  }
  /**Utilizado para fijar el movimiento en Y.
  *@param m Nuevo movimiento en X*/
  public void setMovY(int m){
    this.movY = m;
  }
  /**Método para desplazar los objetos por el canvas.*/
  public void mover() {
    this.setX(this.getX()+movX);
    this.setY(this.getY()+movY);
  }
}
