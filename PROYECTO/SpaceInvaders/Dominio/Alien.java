package SpaceInvaders.Dominio;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Alien extends Volador {
  public Alien(){
    super("/Users/juansb/Library/Mobile Documents/com~apple~CloudDocs/Desktop/OneDrive - Universidad Pontificia Comillas/SEGUNDO GITT BA/Prog. Objetos/PROYECTO/SpaceInvaders/Dominio/Recursos/Alien1P1.png","/Users/juansb/Library/Mobile Documents/com~apple~CloudDocs/Desktop/OneDrive - Universidad Pontificia Comillas/SEGUNDO GITT BA/Prog. Objetos/PROYECTO/SpaceInvaders/Dominio/Recursos/Alien1P2.png","/Users/juansb/Library/Mobile Documents/com~apple~CloudDocs/Desktop/OneDrive - Universidad Pontificia Comillas/SEGUNDO GITT BA/Prog. Objetos/PROYECTO/SpaceInvaders/Dominio/Recursos/Alien1PM.png");
    this.setX(100);
    this.setY(100);
  }
  public Alien(int x, int y){
    super("/Users/juansb/Library/Mobile Documents/com~apple~CloudDocs/Desktop/OneDrive - Universidad Pontificia Comillas/SEGUNDO GITT BA/Prog. Objetos/PROYECTO/SpaceInvaders/Dominio/Recursos/Alien1P1.png","/Users/juansb/Library/Mobile Documents/com~apple~CloudDocs/Desktop/OneDrive - Universidad Pontificia Comillas/SEGUNDO GITT BA/Prog. Objetos/PROYECTO/SpaceInvaders/Dominio/Recursos/Alien1P2.png","/Users/juansb/Library/Mobile Documents/com~apple~CloudDocs/Desktop/OneDrive - Universidad Pontificia Comillas/SEGUNDO GITT BA/Prog. Objetos/PROYECTO/SpaceInvaders/Dominio/Recursos/Alien1PM.png");
    this.setX(x);
    this.setY(y);
  }
}
