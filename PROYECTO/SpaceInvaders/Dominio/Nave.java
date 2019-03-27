package spaceInvaders.dominio;

import spaceInvaders.ui.JVentanaJuego;
import spaceInvaders.util.Constantes;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Nave extends Volador {
  Proyectil proyectil = new PNave();

  public Nave(){
    super("/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/NaveP1.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/NavePM1.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/NavePM2.png");
    this.setX((Integer) Constantes.X_SIZE_VENTANA/2 -26);
    this.setY(Constantes.Y_SIZE_VENTANA - 100);
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

    public Proyectil getProyectil(){
      return proyectil;
    }
}
