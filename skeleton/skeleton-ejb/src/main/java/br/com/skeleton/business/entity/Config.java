package br.com.skeleton.business.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * A classe Config representa configurações genéricas no sistema.
 * Implementa Serializable para permitir a persistência e transferência de objetos.
 */
public class Config implements Serializable {

  private static final long serialVersionUID = 6615511541532380908L;

  private String mensagem;

  // Construtor padrão
  public Config() {}

  /**
   * Obtém a mensagem de configuração.
   * @return a mensagem de configuração
   */
  public String getMensagem() {
    return mensagem;
  }

  /**
   * Define a mensagem de configuração.
   * @param mensagem a nova mensagem de configuração
   */
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
