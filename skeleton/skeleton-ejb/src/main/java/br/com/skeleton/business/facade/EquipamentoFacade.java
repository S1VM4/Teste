package br.com.skeleton.business.facade;

import br.com.skeleton.business.entity.Equipamento;
import java.util.List;
import jakarta.ejb.Local;

/**
 * Interface local para operações de gerenciamento de equipamentos.
 * Define os métodos para criar, atualizar, deletar e buscar equipamentos.
 */
@Local
public interface EquipamentoFacade {

    /**
     * Cria um novo equipamento no banco de dados.
     * @param equipamento O equipamento a ser criado.
     */
    void create(Equipamento equipamento);

    /**
     * Atualiza um equipamento existente no banco de dados.
     * @param equipamento O equipamento com as atualizações.
     */
    void update(Equipamento equipamento);

    /**
     * Remove um equipamento do banco de dados pelo ID.
     * @param id O ID do equipamento a ser removido.
     */
    void delete(Long id);

    /**
     * Encontra um equipamento pelo ID.
     * @param id O ID do equipamento a ser encontrado.
     * @return O equipamento encontrado, ou null se não encontrado.
     */
    Equipamento findById(Long id);

    /**
     * Retorna uma lista de todos os equipamentos no banco de dados.
     * @return Uma lista de equipamentos.
     */
    List<Equipamento> findAll();
}
