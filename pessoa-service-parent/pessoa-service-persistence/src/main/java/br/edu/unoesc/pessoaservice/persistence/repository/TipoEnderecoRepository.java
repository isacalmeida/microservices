package br.edu.unoesc.pessoaservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.TipoEndereco;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IIdentityRepository;

@Repository
public interface TipoEnderecoRepository extends IIdentityRepository<TipoEndereco, Long> {

}
