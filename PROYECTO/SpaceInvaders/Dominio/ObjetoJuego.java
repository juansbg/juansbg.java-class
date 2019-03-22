package SpaceInvaders.Dominio;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public abstract class ObjetoJuego {
  public static int IM1 = 0;
  public static int IM2 = 1;
  public static int IM3 = 2;

  private int x;
  private int y;
  private int altura;
  private int ancho;
  private Image imagen1;
  private Image imagen2;
  private Image imagen3;

  public ObjetoJuego(String dirImagen1, String dirImagen2, String dirImagen3){
    this.importarImagenes(dirImagen1,dirImagen2,dirImagen3);
    // Color HEX Recursos: 3ffc4a
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  public int getAltura(){
    return altura;
  }

  public int getAncho(){
    return ancho;
  }

  public void setX(int i){
    this.x = i;
  }

  public void setY(int i){
    this.y = i;
  }

  public void importarImagenes(String dirImagen1, String dirImagen2, String dirImagen3){
    ImageIcon ic1 = new ImageIcon(dirImagen1);
    ImageIcon ic2 = new ImageIcon(dirImagen2);
    ImageIcon ic3 = new ImageIcon(dirImagen3);
    imagen1 = ic1.getImage();
    imagen2 = ic2.getImage();
    imagen3 = ic3.getImage();
    ancho = (int) imagen1.getWidth(null)/3;
    altura = (int) imagen1.getHeight(null)/3;
  }

  public Image getImagen(int im){
    Image imagen = null;      // Mirar
    if(im == IM1) {
      imagen = this.imagen1;
    }else if(im == IM2) {
      imagen = this.imagen2;
    }else if(im == IM3) {
      imagen = this.imagen3;
    }
    return imagen;
  }
}
