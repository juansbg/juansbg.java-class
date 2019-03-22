package SpaceInvaders.UI;

import SpaceInvaders.Dominio.Alien;
import SpaceInvaders.Dominio.Nave;
import SpaceInvaders.Util.Util;
import SpaceInvaders.Dominio.ObjetoJuego;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JVentanaJuego extends JFrame implements ActionListener {

  public static void main(String[] args) {
    int imf = ObjetoJuego.IM1; // Imagen final de cada alien
    JPanelJuego jpj = new JPanelJuego(imf);
    JVentanaJuego JVJuego = new JVentanaJuego(jpj);
    while(true){
      if(imf == ObjetoJuego.IM1){
        imf = ObjetoJuego.IM2;
      } else {
        imf = ObjetoJuego.IM1;
      }
      jpj = new JPanelJuego(imf);
      JVJuego.esperar(2);
      JVJuego.repaint();
    }
  }

  public JVentanaJuego(JPanelJuego jpj) {
    this.setLayout(new BorderLayout());
    this.add(jpj,BorderLayout.CENTER);
    this.configurarJFrame();
    this.setBackground(Color.black);
    jpj.repaint();
    this.setVisible(true);
  }

  private void esperar(int i){
    try {
      Thread.sleep(i*100);
    }
    catch(Exception e){
    }
  }

  private void configurarJFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Space Invaders");
    this.setSize(1000,650);
    //this.setMinimumSize(new Dimension(800,550));
    this.setLocationRelativeTo(null);
    this.setResizable(false);
  }

  @Override
  public void actionPerformed(ActionEvent e){
    Object target = e.getSource();
  }
}
