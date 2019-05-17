package spaceInvaders.dominio;

import spaceInvaders.ui.JPanelJuego;
import spaceInvaders.util.Constantes;
import spaceInvaders.util.Recursos;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class PNave extends Proyectil {
  public PNave() {
    super(Recursos.proyectilNave,Recursos.proyectilNave);
  }

  public void disparo(Volador v){
    super.disparo(v);
    this.setMovY(-Constantes.VELOC_PROYEC);
  }
}
