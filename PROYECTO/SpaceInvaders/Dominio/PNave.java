package SpaceInvaders.Dominio;

import SpaceInvaders.UI.JPanelJuego;
import SpaceInvaders.Util.Constantes;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class PNave extends Proyectil {
  public PNave() {
    super("/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/PJugador.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/PJugador.png");
  }

  public void disparo(Volador v){
    super.disparo(v);
    this.setMovY(-Constantes.VELOC_PROYEC);
  }
}
