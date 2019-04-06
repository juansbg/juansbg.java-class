package spaceInvaders.dominio;

import spaceInvaders.util.Constantes;

public class Usuario {
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
}
