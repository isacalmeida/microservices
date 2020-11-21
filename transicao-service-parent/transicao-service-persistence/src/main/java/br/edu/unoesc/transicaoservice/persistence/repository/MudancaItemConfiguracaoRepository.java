package br.edu.unoesc.transicaoservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IDetailRepository;
import br.edu.unoesc.transicaoservice.common.model.Mudanca;
import br.edu.unoesc.transicaoservice.common.model.MudancaItemConfiguracao;

@Repository
public interface MudancaItemConfiguracaoRepository extends IDetailRepository<Mudanca, MudancaItemConfiguracao, Long> {
}
