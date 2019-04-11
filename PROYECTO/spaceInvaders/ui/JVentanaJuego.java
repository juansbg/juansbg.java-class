package spaceInvaders.ui;

import spaceInvaders.dominio.Alien;
import spaceInvaders.dominio.Nave;
import spaceInvaders.dominio.ObjetoJuego;
import spaceInvaders.util.Constantes;
import spaceInvaders.dominio.Usuario;
import spaceInvaders.io.IOUsuario;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JTextField;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class JVentanaJuego extends JFrame implements ActionListener {
  public static int imf = ObjetoJuego.IM1; // Imagen final de cada alien
  public static int cnt = 1; // Contador para actualizar imagen aliens
  IOUsuario iou = new IOUsuario();
  JVentanaFinal jvf;

  HashMap listaLeaderboard = new HashMap();

  public JVentanaJuego(JPanelJuego jpj,JPanelSuperior jps,JVentanaFinal jvf) {
    this.jvf = jvf;
    this.ordenarLeaderboard();
    this.setLayout(new BorderLayout());
    this.add(jpj,BorderLayout.CENTER);
    this.add(jps,BorderLayout.NORTH);
    this.configurarJFrame();
    this.setBackground(Color.black);
    jpj.repaint();
    this.setVisible(false);
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
  public void comprobarVida(){
    if(Constantes.READY)
      if(Constantes.VIDAS==0){
        Constantes.JUGADOR.setPuntos(Constantes.PUNTUACION);
        Constantes.JUGADORES.add(Constantes.JUGADOR);
        iou.escribirUsuarios(Constantes.JUGADORES);
        Constantes.READY=false;
        this.setVisible(false);
        this.ordenarLeaderboard();
        jvf.actualizarLeaderboard();
        jvf.setVisible(true);
      }
  }

  public void ordenarLeaderboard(){
    Constantes.JUGADORES = iou.leerUsuarios();
    Integer[] puntosOrdenados = new Integer[Constantes.JUGADORES.size()];
    Iterator it = Constantes.JUGADORES.iterator();
    int i = 0;
    while(it.hasNext()){
      Usuario u = (Usuario) it.next();
      listaLeaderboard.put(u.getPuntos(),u);
      puntosOrdenados[i] = u.getPuntos();
      i += 1;
    }
    try{
      Arrays.sort(puntosOrdenados, Collections.reverseOrder());
    } catch(Exception e){

    }
    Constantes.JUGADOR_PRIMERO = construirString(0,puntosOrdenados);
    Constantes.JUGADOR_SEGUNDO = construirString(1,puntosOrdenados);
    Constantes.JUGADOR_TERCERO = construirString(2,puntosOrdenados);
    Constantes.JUGADOR_CUARTO  = construirString(3,puntosOrdenados);
    Constantes.JUGADOR_QUINTO  = construirString(4,puntosOrdenados);
  }

  private String construirString(int i,Integer[] puntosOrdenados){
    StringBuilder jpri = new StringBuilder();
    String s;
    try{
      Usuario u = (Usuario) listaLeaderboard.get(puntosOrdenados[i]);
      jpri.append(" ")
          .append(u.getNick())
          .append(": ")
          .append(u.getPuntos());
      s = jpri.toString();
    } catch(NullPointerException npe) {
      jpri.append(" ")
          .append("-----")
          .append(": ")
          .append("-----");
      s = jpri.toString();
    } catch(ArrayIndexOutOfBoundsException aioobe) {
      jpri.append(" ")
          .append("-----")
          .append(": ")
          .append("-----");
      s = jpri.toString();
    }
    return s;
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
