package br.edu.unoesc.uiservice.web.controller.utils;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class DefaultController<T, R> extends EnumController implements CrudController<T> {

    // == fields ==
    @Autowired
    protected R proxy;
}
