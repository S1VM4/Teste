package br.com.skeleton.web.bean;

import br.com.skeleton.business.entity.Equipamento;
import br.com.skeleton.business.facade.EquipamentoFacade;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class EquipamentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EquipamentoFacade equipamentoFacade;

    private Equipamento equipamento;
    private Long equipamentoId;
    private Equipamento equipamentoParaAtualizar;
    private List<Equipamento> equipamentos;

    @PostConstruct
    public void init() {
        equipamentos = equipamentoFacade.findAll(); // Inicializa a lista de equipamentos
        equipamento = new Equipamento(); // Cria uma nova instância para adição
        equipamentoParaAtualizar = new Equipamento(); // Cria uma nova instância para atualização
    }

    // Método para criar um novo equipamento
    public void create() {
        try {
            validateDates(equipamento.getDataAquisicao(), equipamento.getValidade()); // Valida datas
            equipamentoFacade.create(equipamento); // Salva o equipamento
            equipamentos.add(equipamento); // Adiciona à lista
            equipamento = new Equipamento(); // Reseta o equipamento
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Equipamento salvo com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar o equipamento!", e.getMessage()));
        }
    }

    // Método para atualizar um equipamento existente
    public void update() {
        try {
            validateDates(equipamentoParaAtualizar.getDataAquisicao(), equipamentoParaAtualizar.getValidade()); // Valida datas
            equipamentoFacade.update(equipamentoParaAtualizar); // Atualiza o equipamento
            int index = equipamentos.indexOf(equipamentoParaAtualizar);
            if (index != -1) {
                equipamentos.set(index, equipamentoParaAtualizar); // Atualiza na lista
            }
            equipamentoParaAtualizar = new Equipamento(); // Reseta o equipamento para atualização
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Equipamento atualizado com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar o equipamento!", e.getMessage()));
        }
    }

    // Método para deletar um equipamento pelo ID
    public void delete(Long id) {
        try {
            equipamentoFacade.delete(id); // Deleta o equipamento
            equipamentos.removeIf(e -> e.getId().equals(id)); // Remove da lista
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Equipamento deletado com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao deletar o equipamento!", e.getMessage()));
        }
    }

    // Método para buscar um equipamento pelo ID
    public void buscarEquipamento() {
        if (equipamentoId != null) {
            try {
                equipamentoParaAtualizar = equipamentoFacade.findById(equipamentoId); // Busca o equipamento
                if (equipamentoParaAtualizar == null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Equipamento não encontrado!", "Não foi encontrado um equipamento com o ID fornecido."));
                }
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao buscar o equipamento!", e.getMessage()));
            }
        }
    }

    // Valida se as datas são válidas
    private void validateDates(Date dataAquisicao, Date validade) throws ParseException {
        if (dataAquisicao.after(validade)) {
            throw new ParseException("A data de aquisição não pode ser posterior à validade.", 0);
        }
    }

    // Formata a data para o formato "dd/MM/yyyy"
    public String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return date != null ? sdf.format(date) : "";
    }

    // Getters e Setters
    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Long getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public Equipamento getEquipamentoParaAtualizar() {
        return equipamentoParaAtualizar;
    }

    public void setEquipamentoParaAtualizar(Equipamento equipamentoParaAtualizar) {
        this.equipamentoParaAtualizar = equipamentoParaAtualizar;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }
}
