package spaceInvaders.ui;

import spaceInvaders.util.Constantes;

public class AppSpaceInvaders {
  public static JPanelJuego jpj;
  public static JPanelSuperior jps;
  public static JVentanaInicio jvInicio;
  public static JVentanaJuego jvJuego;
  public static void main(String[] args) {
    jpj = new JPanelJuego(JVentanaJuego.imf);
    jps = new JPanelSuperior();
    jvJuego = new JVentanaJuego(jpj,jps);
    jvInicio = new JVentanaInicio(jvJuego);
    //jvJuego.setIconImage(new ImageIcon("spaceInvaders/recursos/Alien1P1_BLANCO.png").getImage());
    while(true){
      if(Constantes.READY){
        JVentanaJuego.actualizarAliens(jpj);
        JPanelJuego.IMF=JVentanaJuego.imf;
        jpj.comprobarColision();
        jps.actualizarValores();
      }
      jvJuego.esperar(1);
      jvJuego.repaint();
    }
  }
}
