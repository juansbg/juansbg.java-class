package spaceInvaders.dominio;
import spaceInvaders.util.Recursos;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class AlienMuerto extends Alien {
  public AlienMuerto(int x, int y){
    super(x,y);
    this.setVisible(false);
    this.importarImagenes(Recursos.alienMuerto,Recursos.alienMuerto,Recursos.alienMuerto);
  }
}
