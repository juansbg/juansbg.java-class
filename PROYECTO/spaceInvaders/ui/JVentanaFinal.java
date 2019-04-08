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
import java.io.IOException;

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

public class JVentanaFinal extends JFrame implements ActionListener {
  JLabel gameOver;
  JPanel leaderboard;
  JPanel panelInferior;
  JPanel panelSuperior;
  JLabel jugadorPrimero;
  JLabel jugadorSegundo;
  JLabel jugadorTercero;
  JLabel jugadorCuarto;
  JLabel jugadorQuinto;
  ImageIcon iconButtonRestart = new ImageIcon("spaceInvaders/recursos/elementos/botonRestart.png");
  ImageIcon iconButtonExit = new ImageIcon("spaceInvaders/recursos/elementos/botonExit.png");
  JButton restart;
  JButton exit;

  public JVentanaFinal(){
    this.configurarJFrame();
    this.setLayout(new BorderLayout());
    this.iniciarComponentes();
    this.colocarComponentes();
    this.ponerListener();
    this.setBackground(Color.black);
    this.repaint();
    this.setVisible(false);
  }
  private void configurarJFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Space Invaders Leaderboard");
    this.setSize(Constantes.X_SIZE_VENTANA_FINAL,Constantes.Y_SIZE_VENTANA_FINAL);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
  }
  private void iniciarComponentes(){
    gameOver = new JLabel("GAME OVER",SwingConstants.CENTER);
    gameOver.setForeground(Color.green);
    gameOver.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 45));
    restart = new JButton();
    restart.setIcon(iconButtonRestart);
    restart.setBorder(BorderFactory.createEmptyBorder());
    restart.setContentAreaFilled(false);
    exit = new JButton();
    exit.setIcon(iconButtonExit);
    exit.setBorder(BorderFactory.createEmptyBorder());
    exit.setContentAreaFilled(false);
    panelInferior = new JPanel();
    panelInferior.setLayout(new GridLayout(1,2));
    panelInferior.setBackground(Color.black);
    panelSuperior = new JPanel();
    panelSuperior.setLayout(new FlowLayout());
    panelSuperior.setBackground(Color.black);
    leaderboard = new JPanel();
    leaderboard.setLayout(new GridLayout(5,1));
    leaderboard.setBackground(Color.black);
    jugadorPrimero = new JLabel("");
    jugadorPrimero.setForeground(Color.green);
    jugadorPrimero.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 25));
    jugadorSegundo = new JLabel("");
    jugadorSegundo.setForeground(new Color(153,255,51));
    jugadorSegundo.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 25));
    jugadorTercero = new JLabel("");
    jugadorTercero.setForeground(new Color(255,255,51));
    jugadorTercero.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 25));
    jugadorCuarto  = new JLabel("");
    jugadorCuarto.setForeground(new Color(255,153,51));
    jugadorCuarto.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 25));
    jugadorQuinto  = new JLabel("");
    jugadorQuinto.setForeground(new Color(255,153,51));
    jugadorQuinto.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 25));
  }
  private void colocarComponentes(){
    panelSuperior.add(gameOver);
    this.add(panelSuperior,BorderLayout.NORTH);
    panelInferior.add(restart);
    panelInferior.add(exit);
    leaderboard.add(jugadorPrimero);
    leaderboard.add(jugadorSegundo);
    leaderboard.add(jugadorTercero);
    leaderboard.add(jugadorCuarto);
    leaderboard.add(jugadorQuinto);
    this.add(panelInferior,BorderLayout.SOUTH);
    this.add(leaderboard,BorderLayout.CENTER);
  }
  public void actualizarLeaderboard(){
    String s = "                       ";
    jugadorPrimero.setText(s + Constantes.JUGADOR_PRIMERO);
    jugadorSegundo.setText(s + Constantes.JUGADOR_SEGUNDO);
    jugadorTercero.setText(s + Constantes.JUGADOR_TERCERO);
    jugadorCuarto.setText(s + Constantes.JUGADOR_CUARTO);
    jugadorQuinto.setText(s + Constantes.JUGADOR_QUINTO);
    leaderboard.repaint();
    this.repaint();
  }

  private void ponerListener(){
    restart.addActionListener(this);
    exit.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e){
    Object target = e.getSource();
    if(target == exit)
      System.exit(0);
    else if(target == restart)
      //Runtime.getRuntime().exec("java -jar myApp.jar");
      try{
          Runtime.getRuntime().exec("java spaceInvaders.ui.AppSpaceInvaders");
      } catch(IOException ioe) {
        ioe.printStackTrace();
      }
      System.exit(0);
  }
}
