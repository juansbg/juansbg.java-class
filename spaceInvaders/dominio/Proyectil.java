package spaceInvaders.dominio;
import spaceInvaders.util.Constantes;
import java.net.URL;

public abstract class Proyectil extends Volador {

  public Proyectil(String dirImagen1, String dirImagen2) {
    super(dirImagen1,dirImagen2,dirImagen2);
    this.setX(0);
    this.setY(0);
    this.setVisible(false);
  }

  public void disparo(Volador v){
    if (!this.isVisible()){
      this.setX(v.getX()+25);
      this.setY(v.getY());
      this.setVisible(true);
    }
  }

  public void resetProyectil(){
    this.setVisible(false);
    this.setX(0);
    this.setY(0);
  }

  public void comprobarPosicion(){
    if (this.getY() <= 0)
      this.setVisible(false);
    else if (this.getY() >= Constantes.Y_SIZE_VENTANA)
      this.setVisible(false);
  }
}
