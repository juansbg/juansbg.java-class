package spaceInvaders.ui;

import spaceInvaders.util.Constantes;
import spaceInvaders.dominio.Usuario;
import java.util.Iterator;

public class AppSpaceInvaders {
  public static JPanelJuego jpj;
  public static JPanelSuperior jps;
  public static JVentanaInicio jvInicio;
  public static JVentanaJuego jvJuego;
  public static JVentanaFinal jvFinal;
  public static void main(String[] args) {
    jpj       = new JPanelJuego(JVentanaJuego.imf);
    jps       = new JPanelSuperior();
    jvFinal   = new JVentanaFinal();
    jvJuego   = new JVentanaJuego(jpj,jps,jvFinal);
    jvInicio  = new JVentanaInicio(jvJuego);
    //jvJuego.setIconImage(new ImageIcon("spaceInvaders/recursos/Alien1P1_BLANCO.png").getImage());
    while(true){
      if(Constantes.READY){
        JVentanaJuego.actualizarAliens(jpj);
        JPanelJuego.IMF=JVentanaJuego.imf;
        jpj.comprobarColision();
        jps.actualizarValores();
      }
      jvJuego.comprobarVida();
      jvJuego.esperar(1);
      jvJuego.repaint();
    }
  }
}
