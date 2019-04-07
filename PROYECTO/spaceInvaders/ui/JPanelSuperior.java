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
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.*;
import java.lang.StringBuilder;

public class JPanelSuperior extends JPanel {
  JLabel score;
  JLabel hiscore;
  JLabel jugadorHiscore;
  JLabel vidas;
  JLabel puntos;
  JLabel espacio;
  JPanel panelWest;
  JPanel panelEast;
  JPanel panelVidas;
  JPanel panelIzquierdo;
  ImageIcon icon = new ImageIcon("spaceInvaders/recursos/vida.png");
  JLabel vida1;
  JLabel vida2;
  JLabel vida3;

  public JPanelSuperior(){
    score       = new JLabel("     Score: ");
    hiscore     = new JLabel("Hi-Score: ");
    jugadorHiscore = new JLabel(Constantes.JUGADOR_PRIMERO);
    vidas       = new JLabel("Vidas: ");
    espacio     = new JLabel("     ");
    puntos      = new JLabel("--------");
    panelWest   = new JPanel();
    panelEast   = new JPanel();
    panelVidas  = new JPanel();
    panelIzquierdo = new JPanel();
    vida1     = new JLabel("");
    vida2     = new JLabel("");
    vida3     = new JLabel("");
    vida1.setIcon(icon);
    vida2.setIcon(icon);
    vida3.setIcon(icon);
    this.configLabels();
    this.setBackground(Color.black);
    this.configLayout();
  }

  public void actualizarValores(){
    StringBuilder sb = new StringBuilder();
    sb.append("")
      .append(Integer.toString(Constantes.PUNTUACION))
      .append("   ");
    puntos.setText(sb.toString());
    panelWest.add(puntos,BorderLayout.CENTER);
    if(Constantes.VIDAS<3)
      vida3.setIcon(null);
    if(Constantes.VIDAS<2)
      vida2.setIcon(null);
    if(Constantes.VIDAS<1)
      vida1.setIcon(null);
    jugadorHiscore.setText(Constantes.JUGADOR_PRIMERO);
    puntos.repaint();
    panelVidas.repaint();
    panelEast.repaint();
    panelWest.repaint();
    this.repaint();
  }

  private void configLabels(){
    score.setForeground(Color.CYAN);
    score.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 22));
    hiscore.setForeground(Color.GREEN);
    hiscore.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 22));
    jugadorHiscore.setForeground(Color.GREEN);
    jugadorHiscore.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 22));
    vidas.setForeground(Color.RED);
    vidas.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 22));
    puntos.setForeground(Color.CYAN);
    puntos.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 22));
  }

  private void configLayout(){
    this.setLayout(new BorderLayout());
    panelWest.setLayout(new BorderLayout());
    panelEast.setLayout(new FlowLayout());
    panelIzquierdo.setLayout(new FlowLayout());
    panelWest.add(score,BorderLayout.WEST);
    panelWest.add(puntos,BorderLayout.CENTER);
    panelWest.add(espacio,BorderLayout.EAST);
    panelWest.setBackground(Color.black);
    panelEast.add(vidas);
    panelVidas.add(vida1);
    panelVidas.add(vida2);
    panelVidas.add(vida3);
    panelEast.add(panelVidas);
    panelEast.setBackground(Color.black);
    panelVidas.setBackground(Color.black);
    panelIzquierdo.setBackground(Color.black);
    panelIzquierdo.add(hiscore);
    panelIzquierdo.add(jugadorHiscore);
    this.add(panelWest,BorderLayout.CENTER);
    this.add(panelIzquierdo,BorderLayout.WEST);
    this.add(panelEast,BorderLayout.EAST);
  }
}
