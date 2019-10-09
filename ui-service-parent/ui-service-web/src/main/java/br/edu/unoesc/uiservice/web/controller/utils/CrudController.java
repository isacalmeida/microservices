package br.edu.unoesc.uiservice.web.controller.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

public interface CrudController<T> {

    @GetMapping
    ModelAndView home();

    @GetMapping("/novo")
    ModelAndView novo();

    @GetMapping("/{id}/editar")
    ModelAndView getOne(@PathVariable Long id);

    @GetMapping("/{id}/excluir")
    ModelAndView excluir(@PathVariable Long id);

    @PostMapping("/salvar")
    ModelAndView salvar(@ModelAttribute T entidade);

    @PostMapping("/atualizar")
    ModelAndView atualizar(@ModelAttribute T entidade);
}
