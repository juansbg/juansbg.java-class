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

  public String toImprimir(){
    String puntosTexto = Integer.toString(this.puntos);
    String nombreTexto;
    StringBuilder sb = new StringBuilder();
    if(this.nick.length()>25)
      nombreTexto = this.nick.substring(0,25);
    else
      nombreTexto = this.nick;
    sb.append(nombreTexto);
    int buclePuntos = 40 - nombreTexto.length() - puntosTexto.length();
    for(int i = 0; i<buclePuntos;i++)
      sb.append(".");
    sb.append(puntosTexto);
    return sb.toString();
  }
  
  public String toImprimirHTML(){
    String puntosTexto = Integer.toString(this.puntos);
    String nombreTexto;
    StringBuilder sb = new StringBuilder();
    sb.append("<p>");
    if(this.nick.length()>25)
      nombreTexto = this.nick.substring(0,25);
    else
      nombreTexto = this.nick;
    sb.append(nombreTexto);
    int buclePuntos = 40 - nombreTexto.length() - puntosTexto.length();
    for(int i = 0; i<buclePuntos;i++)
      sb.append(".");
    sb.append(puntosTexto);
    sb.append("</p>");
    return sb.toString();
  }
}
