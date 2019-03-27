package spaceInvaders.dominio;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public abstract class Volador extends ObjetoJuego {
  private int movX;
  private int movY;

  public Volador(String dirImagen1, String dirImagen2, String dirImagen3){
    super(dirImagen1,dirImagen2, dirImagen3);
  }

  public int getMovX(){
    return movX;
  }

  public int getMovY(){
    return movY;
  }

  public void setMovX(int m){
    this.movX = m;
  }

  public void setMovY(int m){
    this.movY = m;
  }

  public void mover() {
    this.setX(this.getX()+movX);
    this.setY(this.getY()+movY);
  }
}
