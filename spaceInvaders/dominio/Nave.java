package spaceInvaders.dominio;

import spaceInvaders.ui.JVentanaJuego;
import spaceInvaders.ui.JPanelJuego;
import spaceInvaders.util.Constantes;
import spaceInvaders.util.Recursos;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Nave extends Volador {
  private Proyectil proyectil = new PNave();

  public Nave(){
    super(Recursos.navePrimero,Recursos.naveMuertoUno,Recursos.naveMuertoDos);
    this.setX(Constantes.X_INICIAL_NAVE);
    this.setY(Constantes.Y_INICIAL_NAVE);
  }

  public void comprobarColision(PAlien proyectil, JPanelJuego jpj){
    if(proyectil.isVisible() && this.isVisible())
      if((proyectil.getX()>this.getX()) && (proyectil.getX()<(this.getX()+this.getAncho())))
        if(proyectil.getY()>this.getY()){
          proyectil.setVisible(false);
          if(Constantes.VIDAS>0)
            Constantes.VIDAS += -1;
          jpj.muerteNave();
        }
  }

  public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
          if (this.getX() > (50)){
            this.setMovX(-Constantes.VELOCIDAD);
            this.mover();
          }
          else
            this.setMovX(0);
        }
        if (key == KeyEvent.VK_RIGHT) {
          if (this.getX() < (Constantes.X_SIZE_VENTANA-100)){
            this.setMovX(Constantes.VELOCIDAD);
            this.mover();
          }
          else
            this.setMovX(0);
        }
        this.mover();
        if (key == KeyEvent.VK_SPACE) {
          proyectil.disparo(this);
        }
    }

    public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_LEFT) {
          this.setMovX(0);
      }
      if (key == KeyEvent.VK_RIGHT) {
          this.setMovX(0);
      }
      if (key == KeyEvent.VK_RIGHT) {
          this.setMovX(0);
      }
    }

    public PNave getProyectil(){
      return (PNave) proyectil;
    }
}
