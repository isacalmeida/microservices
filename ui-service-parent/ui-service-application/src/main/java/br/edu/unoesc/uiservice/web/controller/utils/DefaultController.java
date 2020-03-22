package br.edu.unoesc.uiservice.web.controller.utils;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.unoesc.sistemautils.arquitetura.common.ICrudController;

public abstract class DefaultController<T, R> extends EnumController implements ICrudController<T> {

    // == fields ==
    @Autowired
    protected R proxy;
}
