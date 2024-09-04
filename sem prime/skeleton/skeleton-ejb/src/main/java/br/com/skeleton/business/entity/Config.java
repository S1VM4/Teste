package br.com.skeleton.business.entity;

import java.io.Serializable;
import java.util.Objects;

public class Config implements Serializable {

  private static final long serialVersionUID = 6615511541532380908L;
  private String mensagem;;


  public Config() {}


  public String getMensagem() {
    return mensagem;
  }


  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }


  @Override
  public int hashCode() {
    return Objects.hash(mensagem);
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Config other = (Config) obj;
    return Objects.equals(mensagem, other.mensagem);
  }

}
