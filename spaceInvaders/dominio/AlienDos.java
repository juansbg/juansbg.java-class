package spaceInvaders.dominio;
import spaceInvaders.util.Constantes;
import spaceInvaders.util.Recursos;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class AlienDos extends Alien {
  public AlienDos(int x, int y){
    super(x,y);
    this.importarImagenes(Recursos.alienDosBlancoPrimero,Recursos.alienDosBlancoSegundo,Recursos.alienDosBlancoSegundo);
    this.setPuntos(Constantes.PUNTOS_ALIEN_DOS);
  }
}
