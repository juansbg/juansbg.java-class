package spaceInvaders.dominio;

import spaceInvaders.ui.JPanelJuego;
import spaceInvaders.util.Constantes;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class PAlien extends Proyectil {
  public PAlien() {
    super("spaceInvaders/recursos/PAlien.png","spaceInvaders/recursos/PAlien.png");
  }

  public void disparo(Volador v){
    super.disparo(v);
    this.setMovY(Constantes.VELOC_PROYEC);
  }
}
