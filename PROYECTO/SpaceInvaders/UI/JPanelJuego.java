package SpaceInvaders.UI;

import SpaceInvaders.Dominio.Alien;
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
import java.util.List;
import javax.swing.JPanel;

public class JPanelJuego extends JPanel {
  Alien alien;
  Alien alien1;
  Alien alien2;
  public static int IMF = ObjetoJuego.IM1;

  public JPanelJuego(int im){
    super(new GridLayout(3,10));
    this.setBackground(Color.black);
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
    alien = new Alien(100,10);
    alien1 = new Alien(300,10);
    alien2 = new Alien(500,10);
    this.repaint();
  }

  private void pintarAlien(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawImage(alien.getImagen(IMF), alien.getX(), alien.getY(), this);
    g2d.drawImage(alien1.getImagen(IMF), alien1.getX(), alien1.getY(), this);
    g2d.drawImage(alien2.getImagen(IMF), alien2.getX(), alien2.getY(), this);
    // ARREGLAR CONSTANTE
  }
}
