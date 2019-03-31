package spaceInvaders.dominio;

import spaceInvaders.ui.JVentanaJuego;
import spaceInvaders.ui.JPanelJuego;
import spaceInvaders.util.Constantes;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Nave extends Volador {
  private Proyectil proyectil = new PNave();

  public Nave(){
    super("/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/NaveP1.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/NavePM1.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/NavePM2.png");
    this.setX((Integer) Constantes.X_SIZE_VENTANA/2 -26);
    this.setY(Constantes.Y_SIZE_VENTANA - 100);
  }

  public void comprobarColision(PAlien proyectil, JPanelJuego jpj){
    if(proyectil.isVisible() && this.isVisible())
      if((proyectil.getX()>this.getX()) && (proyectil.getX()<(this.getX()+this.getAncho())))
        if(proyectil.getY()>this.getY()){
          // No se llega a cumplir
          proyectil.setVisible(false);
          //this.setVisible(false);
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
