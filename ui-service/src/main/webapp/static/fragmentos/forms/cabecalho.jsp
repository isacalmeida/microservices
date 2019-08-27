<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://www.springframework.org/tags/form' prefix='form' %>

<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <form:label path="id"> Id </form:label>
    <form:input cssClass="form-control" path="id" readonly="true" />
</div>
<div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6">
    <form:label path="dataCriacao"> Data de Criação </form:label>
    <form:input cssClass="form-control" path="dataCriacao" readonly="true" />
</div>
<div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6">
    <form:label path="dataAlteracao"> Data de Alteração </form:label>
    <form:input cssClass="form-control" path="dataAlteracao" readonly="true" />
</div>
