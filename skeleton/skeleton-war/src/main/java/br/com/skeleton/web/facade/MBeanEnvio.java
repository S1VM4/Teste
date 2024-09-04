package br.com.skeleton.web.facade;

import java.io.Serializable;
import br.com.skeleton.business.entity.Config;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class MBeanEnvio implements Serializable {

  private static final long serialVersionUID = 1L;

  private Config config;

  @PostConstruct
  public void init() {
    config = new Config();
  }

  // Método para enviar dados para algum serviço ou backend
  public void enviarDados() {
    try {
      // Implementação do envio de dados
      System.out.println("Dados enviados com sucesso: " + config);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Getters e Setters
  public Config getConfig() {
    return config;
  }

  public void setConfig(Config config) {
    this.config = config;
  }
}
