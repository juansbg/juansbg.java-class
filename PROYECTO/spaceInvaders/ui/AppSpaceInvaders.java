package spaceInvaders.ui;

public class AppSpaceInvaders {
  public static void main(String[] args) {
    JPanelJuego jpj = new JPanelJuego(JVentanaJuego.imf);
    JPanelSuperior jps = new JPanelSuperior();
    JVentanaInicio jvInicio = new JVentanaInicio();
    JVentanaJuego jvJuego = new JVentanaJuego(jpj,jps);
    //jvJuego.setIconImage(new ImageIcon("spaceInvaders/recursos/Alien1P1_BLANCO.png").getImage());

    while(true){
      JVentanaJuego.actualizarAliens(jpj);
      JPanelJuego.IMF=JVentanaJuego.imf;
      jpj.comprobarColision();
      jps.actualizarValores();
      jvJuego.esperar(1);
      jvJuego.repaint();
    }
  }
}
