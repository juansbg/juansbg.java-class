package spaceInvaders.dominio;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class AlienDos extends Alien {
  public AlienDos(int x, int y){
    super(x,y);
    this.importarImagenes("spaceInvaders/recursos/Alien2P1_BLANCO.png","spaceInvaders/recursos/Alien2P2_BLANCO.png","spaceInvaders/recursos/AlienPM_BLANCO.png");
  }
}
