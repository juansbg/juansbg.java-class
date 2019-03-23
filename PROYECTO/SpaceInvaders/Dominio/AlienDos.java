package SpaceInvaders.Dominio;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class AlienDos extends Alien {
  public AlienDos(int x, int y){
    super(x,y);
    this.importarImagenes("/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/Alien2P1_BLANCO.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/Alien2P2_BLANCO.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/AlienPM_BLANCO.png");
  }
}
