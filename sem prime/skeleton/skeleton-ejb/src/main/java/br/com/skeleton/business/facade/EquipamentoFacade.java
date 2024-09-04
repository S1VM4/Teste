package br.com.skeleton.business.facade;

import br.com.skeleton.business.entity.Equipamento;
import java.util.List;

public interface EquipamentoFacade {

    void create(Equipamento equipamento);

    Equipamento read(Long id);

    void update(Equipamento equipamento);

    void delete(Long id);

    List<Equipamento> findAll();

    Equipamento findById(Long id); // Adicione esta linha
}
