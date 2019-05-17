package spaceInvaders.dominio;

import spaceInvaders.ui.JPanelJuego;
import spaceInvaders.util.Constantes;
import spaceInvaders.util.Recursos;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.Random;

public class Alien extends Volador {
  private int puntos;
  Random rand         = new Random();
  private Proyectil proyectil = new PAlien();
  public Alien(){
    this(100,100);
    this.setPuntos(Constantes.PUNTOS_ALIEN_UNO);
  }

  public Alien(int x, int y){
    super(Recursos.alienUnoBlancoPrimero,Recursos.alienUnoBlancoSegundo,Recursos.alienUnoBlancoSegundo);
    this.setX(x);
    this.setY(y);
    this.setVisible(true);
    this.setPuntos(Constantes.PUNTOS_ALIEN_UNO);
  }

  public void comprobarColision(PNave proyectil){
    if(proyectil.isVisible() && this.isVisible() && (proyectil.getX()>this.getX()) && (proyectil.getX()<(this.getX()+this.getAncho())))
      if((proyectil.getY()>this.getY()) && (proyectil.getY()<(this.getY()+this.getAltura()))){
        proyectil.setVisible(false);
        Constantes.PUNTUACION += this.getPuntos();
        this.setVisible(false);
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
