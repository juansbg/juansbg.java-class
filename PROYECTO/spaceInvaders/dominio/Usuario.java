package spaceInvaders.dominio;

import spaceInvaders.util.Constantes;

public class Usuario implements java.io.Serializable {
  private static final long serialVersionUID = 693866;
  private String nick;
  private int puntos;

  public Usuario(String nick){
    this.setNick(nick);
  }

  public void setNick(String n){
    this.nick = n;
  }
  public void setPuntos(int p){
    this.puntos = p;
  }
  public String getNick(){
    return nick;
  }
  public int getPuntos(){
    return puntos;
  }
}
