<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Pessoas</title>

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/header.jsp" />

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/main.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/menu.jsp" />

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Pessoas
                <small>Cadastro de Pessoas</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="<c:url value='/menu' />" ><i class="fa fa-tachometer-alt"></i> Menu</a></li>
                <li><a href="<c:url value='/pessoas' />" >Pessoas</a></li>
                <li class="active">Editar</li>
            </ol>
        </section>
        <section class="content">
            <div class="box">
                <form:form method="post" action="/pessoas/atualizar" modelAttribute="pessoa">
                    <div class="box-header with-border">
                        <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/forms/cabecalho.jsp" />
                    </div>
                    <div class="box-body">
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="nomeCompleto"> Nome Completo </form:label>
                            <form:input path="nomeCompleto" class="form-control" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="cpf"> CPF </form:label>
                            <form:input path="cpf" class="form-control" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="setor"> Setor </form:label>
                            <form:input path="setor" class="form-control" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="cargo"> Cargo </form:label>
                            <form:input path="cargo" class="form-control" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="dataDeAdmissao"> Data de Admissão </form:label>
                            <div class="input-group date datepicker" data-provide="datepicker">
							<span class="input-group-btn">
								<button class="btn btn-default btn-flat" type="button">
									<span class="fa fa-calendar"></span>
								</button>
							</span>
                                <form:input path="dataAdmissao" class="form-control" />
                            </div>
                        </div>
                    </div>
                    <div class="box-footer">
                        <div class="col-xs-12 col-sm-10 col-md-8 col-lg-8">
                            <button name="submit" type="submit" class="btn btn-success btn-flat"> Salvar </button>
                            <a href="<c:url value='/pessoas' />"><button type="button" class="btn btn-default btn-flat"> Voltar </button></a>
                            <button type="button" class="btn btn-danger btn-flat" data-toggle="modal" data-target="#confirm">Excluir</button>
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
                                    <button type="button" data-dismiss="modal" class="btn btn-default pull-left"> Voltar </button>
                                    <a href="<c:url value='/funcionario/${pessoa.id }/excluir'/>" ><button type="button" class="btn btn-primary" id="delete"> Confirmar </button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </section>
    </div>

</div>

<jsp:include page="${pageContext.request.contextPath}/static/fragmentos/footer.jsp" />

</body>
</html>
