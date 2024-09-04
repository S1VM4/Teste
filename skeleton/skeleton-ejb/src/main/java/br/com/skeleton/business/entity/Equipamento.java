package br.com.skeleton.business.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * A entidade Equipamento representa um equipamento no sistema.
 * Mapeia a tabela 'equipamentos' no banco de dados.
 */
@Entity
@Table(name = "equipamentos")
public class Equipamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_aquisicao")
    private Date dataAquisicao;

    @Column(name = "validade")
    private Date validade;

    @Column(name = "valor")
    private Double valor;

    // Getters and setters

    /**
     * Obtém o ID do equipamento.
     * @return o ID do equipamento
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do equipamento.
     * @param id o novo ID do equipamento
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do equipamento.
     * @return o nome do equipamento
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do equipamento.
     * @param nome o novo nome do equipamento
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a descrição do equipamento.
     * @return a descrição do equipamento
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do equipamento.
     * @param descricao a nova descrição do equipamento
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém a data de aquisição do equipamento.
     * @return a data de aquisição
     */
    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    /**
     * Define a data de aquisição do equipamento.
     * @param dataAquisicao a nova data de aquisição
     */
    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    /**
     * Obtém a data de validade do equipamento.
     * @return a data de validade
     */
    public Date getValidade() {
        return validade;
    }

    /**
     * Define a data de validade do equipamento.
     * @param validade a nova data de validade
     */
    public void setValidade(Date validade) {
        this.validade = validade;
    }

    /**
     * Obtém o valor do equipamento.
     * @return o valor do equipamento
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Define o valor do equipamento.
     * @param valor o novo valor do equipamento
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }
}
