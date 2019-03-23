package SpaceInvaders.Dominio;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class AlienTres extends Alien {
  public AlienTres(int x, int y){
    super(x,y);
    this.importarImagenes("/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/Alien3P1_BLANCO.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/Alien3P2_BLANCO.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/AlienPM_BLANCO.png");
  }
}
