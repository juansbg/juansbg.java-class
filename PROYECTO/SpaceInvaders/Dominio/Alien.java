package spaceInvaders.dominio;

import spaceInvaders.ui.JPanelJuego;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Alien extends Volador {
  public Alien(){
    this(100,100);
  }

  public Alien(int x, int y){
    super("spaceInvaders/recursos/Alien1P1_BLANCO.png","spaceInvaders/recursos/Alien1P2_BLANCO.png","spaceInvaders/recursos/AlienPM_BLANCO.png");
    this.setX(x);
    this.setY(y);
    this.setVisible(true);
  }

  public void comprobarColision(Proyectil proyectil){
    if(proyectil.getVisible() && this.getVisible() && (proyectil.getX()>this.getX()) && (proyectil.getX()<(this.getX()+this.getAncho()))){
      if((proyectil.getY()>this.getY()) && (proyectil.getY()<(this.getY()+this.getAltura()))){
        proyectil.setVisible(false);
        //this.setImagen(1,this.getImagen(3));
        //this.setImagen(2,this.getImagen(3));
        this.setVisible(false);
      }
    }
  }
}
