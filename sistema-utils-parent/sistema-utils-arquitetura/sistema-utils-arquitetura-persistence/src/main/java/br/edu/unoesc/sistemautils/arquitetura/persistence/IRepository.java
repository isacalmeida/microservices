package br.edu.unoesc.sistemautils.arquitetura.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository<E, ID> extends JpaRepository<E, ID> {

	//E findFetch();

	//StringBuilder fetchFields();
}
