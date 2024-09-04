package br.com.skeleton.web.facade;

import java.io.Serializable;

import br.com.skeleton.business.entity.Config;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class MBeanEnvio implements Serializable {

  private static final long serialVersionUID = -1526686423522311531L;

  private Config config;

  public MBeanEnvio() {
    config = new Config();
  }

  public Config getConfig() {
    return config;
  }

  public void setConfig(Config config) {
    this.config = config;
  }

  private String mensagemRetorno;

  @PostConstruct
  public void init() {
    // config.setPropriedadeUsuario("Teste");
  }

  public void enviar() {
    setMensagemRetorno(config.getMensagem());
  }

  public String getMensagemRetorno() {
    return mensagemRetorno;
  }

  public void setMensagemRetorno(String mensagemRetorno) {
    this.mensagemRetorno = mensagemRetorno;
  }
}
