<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://www.springframework.org/tags/form' prefix='form' %>
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
                <li class="active">Editar</li>
            </ol>
        </section>
        <section class="content">
            <div class="box">
                <form:form method="post" action="/ceps/atualizar" modelAttribute="cep">
                    <div class="box-header with-border">
                        <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/forms/cabecalho.jsp" />
                    </div>
                    <div class="box-body">
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="cep"> Cep </form:label>
                            <form:input cssClass="form-control" path="cep" maxlength="9" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="cidade.id"> Cidade </form:label>
                            <form:select cssClass="form-control select2" path="cidade.id">
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
                            <input type="submit" value="Salvar" class="btn btn-success btn-flat" />
                            <a href="<c:url value='/ceps' />"><input type="button" value="Voltar" class="btn btn-default btn-flat" /></a>
                            <input type="button" value="Excluir" class="btn btn-danger btn-flat" data-toggle="modal" data-target="#confirm" />
                        </div>
                    </div>
                    <div class="modal fade" id="confirm">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">Confirmação</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Tem certeza que deseja excluir?</p>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" value="Voltar" data-dismiss="modal" class="btn btn-default pull-left" />
                                    <a href="<c:url value='/ceps/${cep.id }/excluir'/>" ><input type="button" value="Confirmar" class="btn btn-primary" /></a>
                                </div>
                            </div>
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
