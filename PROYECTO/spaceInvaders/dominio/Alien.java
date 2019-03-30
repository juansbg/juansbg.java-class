package spaceInvaders.dominio;

import spaceInvaders.ui.JPanelJuego;
import spaceInvaders.util.Constantes;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.Random;

public class Alien extends Volador {
  private int puntos  = Constantes.PUNTOS_ALIEN_UNO;
  Random rand         = new Random();
  private Proyectil proyectil = new PAlien();

  public Alien(){
    this(100,100);
    this.setPuntos(5);
  }

  public Alien(int x, int y){
    super("spaceInvaders/recursos/Alien1P1_BLANCO.png","spaceInvaders/recursos/Alien1P2_BLANCO.png","spaceInvaders/recursos/AlienPM_BLANCO.png");
    this.setX(x);
    this.setY(y);
    this.setVisible(true);
  }

  public void comprobarColision(PNave proyectil){
    if(proyectil.getVisible() && this.getVisible() && (proyectil.getX()>this.getX()) && (proyectil.getX()<(this.getX()+this.getAncho()))){
      if((proyectil.getY()>this.getY()) && (proyectil.getY()<(this.getY()+this.getAltura()))){
        proyectil.setVisible(false);
        Constantes.PUNTUACION += this.getPuntos();
        this.setVisible(false);
      }
    }
    if (rand.nextInt(Constantes.CANTIDAD_DISPAROS_ALIENS) == 50)
      this.getProyectil().disparo(this);
  }
 
  public int getPuntos(){
    return puntos;
  }

  public void setPuntos(int p){
    this.puntos = p;
  }

  public void desplazar(){
    if (Constantes.CONTADOR_MOVIMIENTO > 0){
      this.setMovX(Constantes.VELOCIDAD_ALIENS);
      this.setMovY(0);
      this.mover();
    } else if(Constantes.CONTADOR_MOVIMIENTO == 0 || Constantes.CONTADOR_MOVIMIENTO == -(Constantes.CONTADOR_MOVIMIENTO_INICIAL)) {
      this.setMovX(0);
      this.setMovY(Constantes.VELOCIDAD_ALIENS);
      this.mover();
    } else {
      this.setMovX(-Constantes.VELOCIDAD_ALIENS);
      this.setMovY(0);
      this.mover();
    }
  }
  public PAlien getProyectil(){
    return (PAlien) proyectil;
  }
}
