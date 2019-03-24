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
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JVentanaJuego extends JFrame implements ActionListener {
  public static final int X_SIZE_VENTANA = 1200;
  public static final int Y_SIZE_VENTANA = 750;
  public static int imf = ObjetoJuego.IM1; // Imagen final de cada alien
  public static int cnt = 1; // Contador para actualizar imagen aliens

  public static void main(String[] args) {

    JPanelJuego jpj = new JPanelJuego(imf);
    JVentanaJuego JVJuego = new JVentanaJuego(jpj);
    while(true){
      actualizarAliens();
      JPanelJuego.IMF=imf;
      JVJuego.esperar(1);
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
      Thread.sleep(i*50);
    }
    catch(Exception e){
    }
  }

  public static void actualizarAliens(){
    if(imf == ObjetoJuego.IM1 && cnt==4)
      imf = ObjetoJuego.IM2;
    else if(cnt==4)
      imf = ObjetoJuego.IM1;
    if(cnt==4)
      cnt=1;
    else
      cnt+=1;
  }

  private void configurarJFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Space Invaders");
    this.setSize(X_SIZE_VENTANA,Y_SIZE_VENTANA);
    //this.setMinimumSize(new Dimension(800,550));
    this.setLocationRelativeTo(null);
    this.setResizable(false);
  }
  @Override
  public void actionPerformed(ActionEvent e){
  }
}
