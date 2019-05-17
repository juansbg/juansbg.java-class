package spaceInvaders.ui;

import spaceInvaders.util.Constantes;
import spaceInvaders.dominio.Usuario;
import java.util.Iterator;

import javax.swing.ImageIcon;

import javax.swing.UIManager;

public class AppSpaceInvaders {
  public static JPanelJuego jpj;
  public static JPanelSuperior jps;
  public static JVentanaInicio jvInicio;
  public static JVentanaJuego jvJuego;
  public static JVentanaFinal jvFinal;
  public static void main(String[] args) {
    if(Constantes.RETRO){
      AppSpaceInvaders.setRetro();
    }
    jpj       = new JPanelJuego(JVentanaJuego.imf);
    jps       = new JPanelSuperior();
    jvFinal   = new JVentanaFinal();
    jvJuego   = new JVentanaJuego(jpj,jps,jvFinal);
    jvInicio  = new JVentanaInicio(jvJuego);
    jvInicio.setIconImage(new ImageIcon("spaceInvaders/recursos/icon/icon1.png").getImage());
    jvJuego.setIconImage(new ImageIcon("spaceInvaders/recursos/icon/icon1.png").getImage());
    jvFinal.setIconImage(new ImageIcon("spaceInvaders/recursos/icon/icon1.png").getImage());
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
  private static void setRetro(){
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      jvInicio.setDefaultLookAndFeelDecorated(true);
      jvJuego.setDefaultLookAndFeelDecorated(true);
      jvFinal.setDefaultLookAndFeelDecorated(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
