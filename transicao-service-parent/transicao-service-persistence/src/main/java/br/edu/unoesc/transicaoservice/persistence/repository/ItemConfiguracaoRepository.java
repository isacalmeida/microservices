package br.edu.unoesc.transicaoservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.ICrudRepository;
import br.edu.unoesc.transicaoservice.common.model.ItemConfiguracao;

@Repository
public interface ItemConfiguracaoRepository extends ICrudRepository<ItemConfiguracao, Long> {
}
