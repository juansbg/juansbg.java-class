package spaceInvaders.ui;

import spaceInvaders.dominio.Alien;
import spaceInvaders.dominio.AlienDos;
import spaceInvaders.dominio.AlienTres;
import spaceInvaders.dominio.Nave;
import spaceInvaders.dominio.Proyectil;
import spaceInvaders.dominio.PNave;
import spaceInvaders.dominio.ObjetoJuego;
import spaceInvaders.util.Constantes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JPanelJuego extends JPanel implements ActionListener {
  public static int IMF = ObjetoJuego.IM1;

  ArrayList aliens = new ArrayList();
  Nave nave = new Nave();

  public JPanelJuego(int im){
    super(new GridLayout(3,10));
    this.setBackground(Color.black);
    this.addKeyListener(new JuegoKeyAdapter());
    this.setFocusable(true);
    this.configObjetos();
    this.IMF = im;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.pintarAlien(g);
    Toolkit.getDefaultToolkit().sync();
  }

  private void configObjetos(){
    int x = Constantes.X_INICIAL;
    int y = Constantes.Y_INICIAL;
    for(int i = 0;i<=Constantes.NUM_ALIENS-1;i++)
      aliens.add(new AlienDos(x+Constantes.SEPARACION_LATERAL*i+10,y));
    for(int i = 0;i<=Constantes.NUM_ALIENS-1;i++)
      aliens.add(new AlienDos(x+Constantes.SEPARACION_LATERAL*i+10,y+Constantes.SEPARACION_VERTICAL));
    for(int i = 0;i<=Constantes.NUM_ALIENS-1;i++)
      aliens.add(new Alien(x+Constantes.SEPARACION_LATERAL*i+5,y+2*Constantes.SEPARACION_VERTICAL));
    for(int i = 0;i<=Constantes.NUM_ALIENS-1;i++)
      aliens.add(new Alien(x+Constantes.SEPARACION_LATERAL*i+5,y+3*Constantes.SEPARACION_VERTICAL));
    for(int i = 0;i<=Constantes.NUM_ALIENS-1;i++)
      aliens.add(new AlienTres(x+Constantes.SEPARACION_LATERAL*i,y+4*Constantes.SEPARACION_VERTICAL));
    nave = new Nave();
    this.repaint();
  }

  public void desplazarGrupo(){
    Iterator it = aliens.iterator();
    while(it.hasNext()){
      Alien alien = (Alien) it.next();
      alien.desplazar();
    }
    if (Constantes.CONTADOR_MOVIMIENTO == -(Constantes.CONTADOR_MOVIMIENTO_INICIAL))
      Constantes.CONTADOR_MOVIMIENTO = Constantes.CONTADOR_MOVIMIENTO_INICIAL;
    Constantes.CONTADOR_MOVIMIENTO += -1;
  }

  private void pintarAlien(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    Iterator it = aliens.iterator();
    while(it.hasNext()){
      Alien alien = (Alien) it.next();
      if(alien.getVisible())
        g2d.drawImage(alien.getImagen(IMF), alien.getX(), alien.getY(), this);
    }
    g2d.drawImage(nave.getImagen(ObjetoJuego.IM1), nave.getX(), nave.getY(), this);
    nave.getProyectil().mover();
    if(nave.getProyectil().getVisible())
      g2d.drawImage(nave.getProyectil().getImagen(ObjetoJuego.IM1), nave.getProyectil().getX(), nave.getProyectil().getY(), this);
    // this.comprobarColision();
    // ARREGLAR CONSTANTE
  }

  public void comprobarColision() {
    Iterator it = aliens.iterator();
    while(it.hasNext()){
      Alien alien = (Alien) it.next();
      alien.comprobarColision(nave.getProyectil());
    }
  }

  @Override
  public void actionPerformed(ActionEvent e){
    nave.mover();
    this.repaint(nave.getX()-1, nave.getY()-1,
                 nave.getAncho()+2, nave.getAltura()+2);
  }

  private class JuegoKeyAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            nave.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            nave.keyPressed(e);
        }
    }
}
