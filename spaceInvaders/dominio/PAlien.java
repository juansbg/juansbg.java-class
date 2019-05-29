package spaceInvaders.dominio;

import spaceInvaders.ui.JPanelJuego;
import spaceInvaders.util.Constantes;
import spaceInvaders.util.Recursos;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class PAlien extends Proyectil {
  public PAlien() {
    super(Recursos.proyectilAlien,Recursos.proyectilAlien);
  }

  public void disparo(Volador v){
    super.disparo(v);
    this.setMovY(Constantes.VELOC_PROYEC);
  }
}
