package spaceInvaders.dominio;

import spaceInvaders.ui.JPanelJuego;
import spaceInvaders.util.Constantes;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class PNave extends Proyectil {
  public PNave() {
    super("spaceInvaders/recursos/PJugador.png","spaceInvaders/recursos/PJugador.png");
  }

  public void disparo(Volador v){
    super.disparo(v);
    this.setMovY(-Constantes.VELOC_PROYEC);
  }
}
