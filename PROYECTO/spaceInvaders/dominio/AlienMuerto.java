package spaceInvaders.dominio;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class AlienMuerto extends Alien {
  public AlienMuerto(int x, int y){
    super(x,y);
    this.setVisible(false);
    this.importarImagenes("spaceInvaders/recursos/AlienPM_BLANCO.png","spaceInvaders/recursos/AlienPM_BLANCO.png","spaceInvaders/recursos/AlienPM_BLANCO.png");
  }
}
