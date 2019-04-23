package spaceInvaders.ui;

import spaceInvaders.dominio.Usuario;
import spaceInvaders.util.Constantes;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
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
import java.awt.event.KeyListener;

public class JVentanaInicio extends JFrame implements ActionListener {
  JLabel logo;
  JPanel logoDisp;
  JPanel interfaz;
  ImageIcon icon = new ImageIcon("spaceInvaders/recursos/logo/logoFinal.png");
  ImageIcon iconButton = new ImageIcon("spaceInvaders/recursos/elementos/boton.png");
  JLabel ponerNombre;
  JButton start;
  JTextField nombre;
  JVentanaJuego jvJuego;

  public JVentanaInicio(JVentanaJuego jvJuego){
    this.jvJuego = jvJuego;
    this.configurarJFrame();
    this.setLayout(new BorderLayout());
    this.iniciarComponentes();
    this.colocarComponentes();
    this.ponerListener();
    this.repaint();
    this.setVisible(true);
  }

  private void configurarJFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Space Invaders Inicio");
    this.setSize(Constantes.X_SIZE_VENTANA_INICIO,Constantes.Y_SIZE_VENTANA_INICIO);
    this.setLocationRelativeTo(null);
    this.setBackground(Color.black);
    this.setPropioCursor();
    this.setResizable(false);
  }

  private void setPropioCursor(){
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage("spaceInvaders/recursos/elementos/raton.png");
    Cursor c = toolkit.createCustomCursor(image , new Point(0, 0), "img");
    this.setCursor (c);
  }

  private void iniciarComponentes(){
    logo = new JLabel("",SwingConstants.CENTER);
    logoDisp = new JPanel();
    interfaz = new JPanel();
    ponerNombre = new JLabel("Nombre:   ",SwingConstants.RIGHT);
    start = new JButton();
    nombre = new JTextField();
    start.setIcon(iconButton);
    logoDisp.setLayout(new FlowLayout());
    logoDisp.setBackground(Color.black);
    interfaz.setLayout(new GridLayout(1,3));
    interfaz.setBackground(Color.black);
    logo.setIcon(icon);
    logo.setBackground(Color.black);
    logo.setVerticalAlignment(JLabel.CENTER);
    ponerNombre.setForeground(Color.yellow);
    ponerNombre.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 26));
    nombre.setForeground(Color.yellow);
    nombre.setBackground(Color.black);
    //nombre.setBorder(BorderFactory.createEmptyBorder());
    nombre.setBorder(BorderFactory.createEtchedBorder(Color.yellow,Color.green));
    nombre.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 26));
    nombre.addKeyListener(new InicioKeyAdapter());
    start.setBorder(BorderFactory.createEmptyBorder());
    start.setContentAreaFilled(false);
  }

  private void colocarComponentes(){
    logoDisp.add(logo);
    interfaz.add(ponerNombre);
    interfaz.add(nombre);
    interfaz.add(start);
    this.add(logoDisp,BorderLayout.CENTER);
    this.add(interfaz,BorderLayout.SOUTH);
  }

  private void ponerListener(){
    start.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e){
    this.comenzar();
  }

  private class InicioKeyAdapter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_ENTER) {
        JVentanaInicio.this.comenzar();
      }
    }
  }

  private void comenzar(){
    String nom = nombre.getText();
    Constantes.JUGADOR = new Usuario(nom);
    this.setVisible(false);
    Constantes.READY = true;
    jvJuego.setVisible(true);
  }
}
