package spaceInvaders.dominio;
import spaceInvaders.util.Constantes;
import spaceInvaders.util.Recursos;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class AlienTres extends Alien {
  public AlienTres(int x, int y){
    super(x,y);
    this.importarImagenes(Recursos.alienTresBlancoPrimero,Recursos.alienTresBlancoSegundo,Recursos.alienTresBlancoSegundo);
    this.setPuntos(Constantes.PUNTOS_ALIEN_TRES);
  }
}
