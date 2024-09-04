package br.com.skeleton.business.facade;

import br.com.skeleton.business.entity.Equipamento;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EquipamentoFacadeImpl implements EquipamentoFacade {

    @PersistenceContext(unitName = "EquipamentoPU")
    private EntityManager em;

    @Override
    public void create(Equipamento equipamento) {
        em.persist(equipamento);
    }

    @Override
    public Equipamento read(Long id) {
        return em.find(Equipamento.class, id);
    }

    @Override
    public void update(Equipamento equipamento) {
        if (em.find(Equipamento.class, equipamento.getId()) != null) {
            em.merge(equipamento);
        }
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        Equipamento equipamento = em.find(Equipamento.class, id);
        if (equipamento != null) {
            em.remove(equipamento);
        } else {
            // Lidar com o caso em que o equipamento não foi encontrado
            throw new IllegalArgumentException("No equipment found with ID: " + id);
        }
    }

    @Override
    public List<Equipamento> findAll() {
        return em.createQuery("SELECT e FROM Equipamento e", Equipamento.class).getResultList();
    }

    @Override
    public Equipamento findById(Long id) {
        return em.find(Equipamento.class, id); // Adicione esta linha
    }
}
