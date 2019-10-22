package br.edu.unoesc.acessoservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.acessoservice.common.model.Acesso;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {

}
