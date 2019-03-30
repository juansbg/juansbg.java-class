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

public class JPanelSuperior extends JPanel {
  JLabel score;
  JLabel hiscore;
  JLabel vidas;
  JLabel puntos;
  JLabel espacio;
  JPanel panelWest;

  public JPanelSuperior(){
    score       = new JLabel("Score: ");
    hiscore     = new JLabel("Hi-Score: ");
    vidas       = new JLabel("Vidas: ");
    espacio     = new JLabel("     ");
    puntos      = new JLabel("00000");
    panelWest   = new JPanel();
    this.configLabels();
    this.setBackground(Color.black);
    this.configLayout();
  }

  public void actualizarValores(){
    puntos.setText(Integer.toString(Constantes.PUNTUACION));
    panelWest.add(puntos,BorderLayout.CENTER);
    puntos.repaint();
    panelWest.repaint();
    this.repaint();
  }

  private void configLabels(){
    score.setForeground(Color.CYAN);
    score.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 22));
    hiscore.setForeground(Color.GREEN);
    hiscore.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 22));
    vidas.setForeground(Color.RED);
    vidas.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 22));
    puntos.setForeground(Color.CYAN);
    puntos.setFont(new java.awt.Font("SANS_SERIF", java.awt.Font.BOLD, 22));
  }

  private void configLayout(){
    this.setLayout(new BorderLayout());
    panelWest.setLayout(new BorderLayout());
    panelWest.add(score,BorderLayout.WEST);
    panelWest.add(puntos,BorderLayout.CENTER);
    panelWest.add(espacio,BorderLayout.EAST);
    panelWest.setBackground(Color.black);
    this.add(panelWest,BorderLayout.WEST);
    this.add(hiscore,BorderLayout.CENTER);
    this.add(vidas,BorderLayout.EAST);
  }
}
