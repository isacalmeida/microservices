package br.edu.unoesc.sistemautils.arquitetura.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractEntity;

public interface ICrudController<E extends AbstractEntity> {

	@GetMapping
    ModelAndView home();

    @GetMapping("/novo")
    ModelAndView novo();

    @GetMapping("/{id}/editar")
    ModelAndView getOne(@PathVariable Long id);

    @GetMapping("/{id}/excluir")
    ModelAndView excluir(@PathVariable Long id);

    @PostMapping("/salvar")
    ModelAndView salvar(@ModelAttribute E entity);

    @PostMapping("/atualizar")
    ModelAndView atualizar(@ModelAttribute E entity);
}
