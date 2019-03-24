package SpaceInvaders.Dominio;

import SpaceInvaders.UI.JPanelJuego;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Alien extends Volador {
  public Alien(){
    this(100,100);
  }

  public Alien(int x, int y){
    super("/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/Alien1P1_BLANCO.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/Alien1P2_BLANCO.png","/Users/juansb/Documents/GitHub/juansbg.github.io/PROYECTO/SpaceInvaders/Recursos/AlienPM_BLANCO.png");
    this.setX(x);
    this.setY(y);
    this.setVisible(true);
  }

  public void comprobarColision(Proyectil proyectil){
    if(proyectil.getX()>this.getX() && proyectil.getX()<(this.getX()+this.getAncho())){
      if(proyectil.getY()>this.getY() && proyectil.getY()<(this.getX()+this.getAltura())){
        this.setVisible(false);
      }
    }
  }
}
