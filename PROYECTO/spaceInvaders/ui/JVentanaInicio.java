package spaceInvaders.ui;

import spaceInvaders.dominio.Usuario;
import spaceInvaders.util.Constantes;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JVentanaInicio extends JFrame implements ActionListener {
  JLabel logo;
  JPanel logoDisp;
  ImageIcon icon = new ImageIcon("spaceInvaders/recursos/logo/logoFinal.png");

  public JVentanaInicio(){
    this.configurarJFrame();
    this.setLayout(new BorderLayout());
    this.iniciarComponentes();
    this.colocarComponentes();
    this.repaint();
    this.setVisible(true);
  }

  private void configurarJFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Space Invaders Inicio");
    this.setSize(Constantes.X_SIZE_VENTANA_INICIO,Constantes.Y_SIZE_VENTANA_INICIO);
    this.setLocationRelativeTo(null);
    this.setBackground(Color.black);
    this.setResizable(false);
  }

  private void iniciarComponentes(){
    logo = new JLabel("");
    logoDisp = new JPanel();
    logoDisp.setLayout(new FlowLayout());
    logoDisp.setBackground(Color.black);
    logo.setIcon(icon);
    logo.setBackground(Color.black);
  }

  private void colocarComponentes(){
    logoDisp.add(logo);
    this.add(logoDisp,BorderLayout.CENTER);
  }

  @Override
  public void actionPerformed(ActionEvent e){
  }
}
