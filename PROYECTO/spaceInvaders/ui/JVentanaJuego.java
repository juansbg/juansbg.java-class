package spaceInvaders.ui;

import spaceInvaders.dominio.Alien;
import spaceInvaders.dominio.Nave;
import spaceInvaders.dominio.ObjetoJuego;
import spaceInvaders.util.Constantes;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JVentanaJuego extends JFrame implements ActionListener {
  public static int imf = ObjetoJuego.IM1; // Imagen final de cada alien
  public static int cnt = 1; // Contador para actualizar imagen aliens

  public JVentanaJuego(JPanelJuego jpj,JPanelSuperior jps) {
    this.setLayout(new BorderLayout());
    this.add(jpj,BorderLayout.CENTER);
    this.add(jps,BorderLayout.NORTH);
    this.configurarJFrame();
    this.setBackground(Color.black);
    ImageIcon iconImage = new ImageIcon("spaceInvaders/recursos/icon.png"); // ESTO NO FUNCIONA
    this.setIconImage(iconImage.getImage());                                // ESTO NO FUNCIONA
    jpj.repaint();
    this.setVisible(true);
  }

  public void esperar(int i){
    try {
      Thread.sleep(i*50);
    }
    catch(Exception e){
    }
  }

  public static void actualizarAliens(JPanelJuego jpj){
    if(imf == ObjetoJuego.IM1 && cnt==Constantes.RATIO_ACTUALIZACION_ALIENS){
      imf = ObjetoJuego.IM2;
      jpj.desplazarGrupo();
    } else if(cnt==Constantes.RATIO_ACTUALIZACION_ALIENS) {
      imf = ObjetoJuego.IM1;
      jpj.desplazarGrupo();
    }
    if(cnt>=Constantes.RATIO_ACTUALIZACION_ALIENS)
      cnt=1;
    else
      cnt+=1;
  }

  private void configurarJFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Space Invaders");
    this.setSize(Constantes.X_SIZE_VENTANA,Constantes.Y_SIZE_VENTANA);
    //this.setMinimumSize(new Dimension(800,550));
    this.setLocationRelativeTo(null);
    this.setResizable(false);
  }
  @Override
  public void actionPerformed(ActionEvent e){
  }
}
