package spaceInvaders.dominio;
import spaceInvaders.util.Constantes;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class AlienTres extends Alien {
  public AlienTres(int x, int y){
    super(x,y);
    this.importarImagenes("spaceInvaders/recursos/Alien3P1_BLANCO.png","spaceInvaders/recursos/Alien3P2_BLANCO.png","spaceInvaders/recursos/AlienPM_BLANCO.png");
    this.setPuntos(Constantes.PUNTOS_ALIEN_TRES);
  }
}
