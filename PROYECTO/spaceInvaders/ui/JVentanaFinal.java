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
  JLabel      gameOver;
  JPanel      leaderboard;
  JPanel      panelInferior;
  JPanel      panelSuperior;
  JLabel      leaderboardTitle;
  JLabel      tuPuntuacionTitle;
  JLabel      resultadoJugador;
  JLabel      jugadorPrimero;
  JLabel      jugadorSegundo;
  JLabel      jugadorTercero;
  JLabel      jugadorCuarto;
  JLabel      jugadorQuinto;
  ImageIcon   iconButtonRestart = new ImageIcon("spaceInvaders/recursos/elementos/botonRestart.png");
  ImageIcon   iconButtonExit = new ImageIcon("spaceInvaders/recursos/elementos/botonExit.png");
  JButton     restart;
  JButton     exit;
  String st = "         ";
  String s  = "              ";

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
    leaderboard.setLayout(new GridLayout(8,1));
    leaderboard.setBackground(Color.black);
    leaderboardTitle = new JLabel(st + "Leaderboard:");
    leaderboardTitle.setForeground(Color.white);
    leaderboardTitle.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 28));
    tuPuntuacionTitle = new JLabel(st + "Tu resultado:");
    tuPuntuacionTitle.setForeground(Color.white);
    tuPuntuacionTitle.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 28));
    resultadoJugador = new JLabel("");
    resultadoJugador.setForeground(Color.green);
    resultadoJugador.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 25));
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
    leaderboard.add(leaderboardTitle);
    leaderboard.add(jugadorPrimero);
    leaderboard.add(jugadorSegundo);
    leaderboard.add(jugadorTercero);
    leaderboard.add(jugadorCuarto);
    leaderboard.add(jugadorQuinto);
    leaderboard.add(tuPuntuacionTitle);
    leaderboard.add(resultadoJugador);
    this.add(panelInferior,BorderLayout.SOUTH);
    this.add(leaderboard,BorderLayout.CENTER);
  }
  public void actualizarLeaderboard(){
    jugadorPrimero.setText(s + (Constantes.JUGADOR_PRIMERO).trim());
    jugadorSegundo.setText(s + (Constantes.JUGADOR_SEGUNDO).trim());
    jugadorTercero.setText(s + (Constantes.JUGADOR_TERCERO).trim());
    jugadorCuarto.setText(s + (Constantes.JUGADOR_CUARTO).trim());
    jugadorQuinto.setText(s + (Constantes.JUGADOR_QUINTO).trim());
    resultadoJugador.setText(s + (this.contruirPuntos(Constantes.JUGADOR)).trim());
    try{
      if(Constantes.JUGADOR.getPuntos() == Constantes.PUNTUACIONES_EN_ORDEN[0])
        resultadoJugador.setForeground(Color.green);
      else if(Constantes.JUGADOR.getPuntos() == Constantes.PUNTUACIONES_EN_ORDEN[1])
        resultadoJugador.setForeground(new Color(153,255,51));
      else if(Constantes.JUGADOR.getPuntos() == Constantes.PUNTUACIONES_EN_ORDEN[2])
        resultadoJugador.setForeground(new Color(255,255,51));
      else if(Constantes.JUGADOR.getPuntos() == Constantes.PUNTUACIONES_EN_ORDEN[3])
        resultadoJugador.setForeground(new Color(255,153,51));
      else if(Constantes.JUGADOR.getPuntos() == Constantes.PUNTUACIONES_EN_ORDEN[4])
        resultadoJugador.setForeground(new Color(255,153,51));
      else
        resultadoJugador.setForeground(Color.red);
    }
    catch(NullPointerException npe){
        resultadoJugador.setForeground(Color.green);
    }
    leaderboard.repaint();
    this.repaint();
  }

  private void ponerListener(){
    restart.addActionListener(this);
    exit.addActionListener(this);
  }

  private String contruirPuntos(Usuario u){
    StringBuilder jpri = new StringBuilder();
    jpri.append(" ")
        .append(u.getNick())
        .append(": ")
        .append(u.getPuntos());
    s = jpri.toString();
    return s;
  }

  @Override
  public void actionPerformed(ActionEvent e){
    Object target = e.getSource();
    if(target == exit)
      System.exit(0);
    else if(target == restart)
      try{
          Runtime.getRuntime().exec("java spaceInvaders.ui.AppSpaceInvaders");
      } catch(IOException ioe) {
        ioe.printStackTrace();
      }
      System.exit(0);
  }
}
