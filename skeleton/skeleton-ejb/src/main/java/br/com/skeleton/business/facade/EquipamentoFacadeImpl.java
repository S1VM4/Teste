package br.com.skeleton.business.facade;

import br.com.skeleton.business.entity.Equipamento;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementação da interface EquipamentoFacade.
 * Fornece a implementação dos métodos para gerenciar equipamentos no banco de dados.
 */
@Stateless
public class EquipamentoFacadeImpl implements EquipamentoFacade {

    @PersistenceContext(unitName = "EquipamentoPU")
    private EntityManager em;

    /**
     * Cria um novo equipamento no banco de dados.
     * @param equipamento O equipamento a ser criado.
     */
    @Override
    public void create(Equipamento equipamento) {
        em.persist(equipamento);
    }

    /**
     * Atualiza um equipamento existente no banco de dados.
     * @param equipamento O equipamento com as atualizações.
     */
    @Override
    public void update(Equipamento equipamento) {
        em.merge(equipamento);
    }

    /**
     * Remove um equipamento do banco de dados pelo ID.
     * @param id O ID do equipamento a ser removido.
     */
    @Override
    public void delete(Long id) {
        Equipamento equipamento = em.find(Equipamento.class, id);
        if (equipamento != null) {
            em.remove(equipamento);
        }
    }

    /**
     * Encontra um equipamento pelo ID.
     * @param id O ID do equipamento a ser encontrado.
     * @return O equipamento encontrado, ou null se não encontrado.
     */
    @Override
    public Equipamento findById(Long id) {
        return em.find(Equipamento.class, id);
    }

    /**
     * Retorna uma lista de todos os equipamentos no banco de dados.
     * @return Uma lista de equipamentos.
     */
    @Override
    public List<Equipamento> findAll() {
        return em.createQuery("SELECT e FROM Equipamento e", Equipamento.class).getResultList();
    }
}
