<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://www.springframework.org/tags/form' prefix='form' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title> Ceps </title>

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/header.jsp" />

</head>

<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/main.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/menu.jsp" />

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Ceps (${port})
                <small>Cadastro de Ceps</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="<c:url value='/menu' />" ><i class="fa fa-tachometer-alt"></i> Menu</a></li>
                <li><a href="<c:url value='/ceps' />" >Ceps</a></li>
                <li class="active">Novo</li>
            </ol>
        </section>
        <section class="content">
            <div class="box">
                <form:form method="post" action="/ceps/salvar" modelAttribute="cep">
                    <div class="box-header with-border">
                        <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/forms/cabecalho.jsp" />
                    </div>
                    <div class="box-body">
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12" id="divCampoCep">
                            <form:label path="cep"> Cep </form:label>
                            <form:input cssClass="form-control" path="cep" maxlength="9" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="cidade.id"> Cidade </form:label>
                            <form:select cssClass="form-control select2" path="cidade.id">
                                <form:option value="null" label="-- Selecione --" />
                                <form:options items="${cidades}" itemLabel="descricao" itemValue="id" />
                            </form:select>
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="logradouro"> Logradouro </form:label>
                            <form:input cssClass="form-control" path="logradouro" maxlength="100" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="bairro"> Bairro </form:label>
                            <form:input cssClass="form-control" path="bairro" maxlength="50" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="ibge"> Código IBGE </form:label>
                            <form:input cssClass="form-control" path="ibge" maxlength="10" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="ativo"> Ativo </form:label><br />
                            <form:checkbox cssClass="form-control bootstrapSwitch" id="ativo" path="ativo"
                                           data-on-color="success" data-off-color="danger" data-on-text="Sim" data-off-text="Não"  />
                        </div>
                    </div>
                    <div class="box-footer">
                        <div class="col-xs-12 col-sm-10 col-md-8 col-lg-8">
                            <button name="submit" type="submit" class="btn btn-success btn-flat"> Salvar </button>
                            <a href="<c:url value='/ceps' />"><button type="button" class="btn btn-default btn-flat"> Voltar </button></a>
                        </div>
                    </div>
                </form:form>
            </div>
        </section>
    </div>

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/footer.jsp" />

</div>

</body>
</html>
