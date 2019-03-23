package SpaceInvaders.Dominio;

import SpaceInvaders.UI.JVentanaJuego;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Nave extends Volador {
  public Nave(){
    super("/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/NaveP1.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/NavePM1.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/NavePM2.png");
    this.setX((Integer) JVentanaJuego.X_SIZE_VENTANA/2 -26);
    this.setY(JVentanaJuego.Y_SIZE_VENTANA - 100);
  }

  public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            this.setMovX(-2);
        }
        if (key == KeyEvent.VK_RIGHT) {
            this.setMovX(2);
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
    }
}
