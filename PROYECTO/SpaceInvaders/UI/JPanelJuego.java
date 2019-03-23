package SpaceInvaders.UI;

import SpaceInvaders.Dominio.Alien;
import SpaceInvaders.Dominio.AlienDos;
import SpaceInvaders.Dominio.AlienTres;
import SpaceInvaders.Dominio.Nave;
import SpaceInvaders.Dominio.ObjetoJuego;

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
  public static final int X_INICIAL = 50;
  public static final int Y_INICIAL = 50;
  public static final int SEPARACION_LATERAL = 70;
  public static final int SEPARACION_VERTICAL = 60;
  public static final boolean ALIENS_BLANCOS = true;
  public static int IMF = ObjetoJuego.IM1;

  ArrayList aliens = new ArrayList();
  Nave nave = new Nave();

  public JPanelJuego(int im){
    super(new GridLayout(3,10));
    this.setBackground(Color.black);
    this.setFocusable(true);
    this.addKeyListener(new JuegoKeyAdapter());
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
    int x = X_INICIAL;
    int y = Y_INICIAL;
    for(int i = 0;i<=8;i++){
      aliens.add(new AlienDos(x+SEPARACION_LATERAL*i+10,y));
    }
    for(int i = 0;i<=8;i++){
      aliens.add(new Alien(x+SEPARACION_LATERAL*i+5,y+SEPARACION_VERTICAL));
    }
    for(int i = 0;i<=8;i++){
      aliens.add(new AlienTres(x+SEPARACION_LATERAL*i,y+2*SEPARACION_VERTICAL));
    }
    nave = new Nave();
    this.repaint();
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
    // ARREGLAR CONSTANTE
  }
  @Override
  public void actionPerformed(ActionEvent e){
    System.out.println("Buenas");
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
