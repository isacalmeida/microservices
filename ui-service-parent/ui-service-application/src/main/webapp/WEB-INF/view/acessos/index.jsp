<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt' %>
<%-- <%@ page import="br.edu.unoesc.util.Constants" %> --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title> Acessos </title>

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/header.jsp" />

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/main.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/menu.jsp" />

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Acessos (${port})
                <small>Cadastro de Acessos</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="<c:url value='/menu' />" ><i class="fa fa-tachometer-alt"></i> Menu</a></li>
                <li class="active">Acessos</li>
            </ol>
        </section>
        <section class="content">
            <%-- <c:if test="${status != null }">
                <div class="box">
                    <div class="box-header">
                        <i class="fa fa-bullhorn"></i>
                        <h3 class="box-title">Alertas</h3>
                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                        </div>
                    </div>
                    <div class="box-body">
                        <c:if test="${status == Constants.FALHA }">
                            <div class="callout callout-danger">
                                <h4><i class="icon fa fa-ban"></i> Ops</h4>
                                <p>${message }</p>
                            </div>
                        </c:if>
                        <c:if test="${status == Constants.SUCESSO }">
                            <div class="callout callout-success">
                                <h4><i class="icon fa fa-check"></i> Sucesso</h4>
                                <p>${message }</p>
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:if> --%>
            <div class="box">
                <div class="box-header with-border">
                    <div class="col-xs-10 col-sm-6 col-md-4 col-lg-4">
                        <!-- <a href="<c:url value='/acessos/novo'/>" ><button type="button" class="btn btn-primary btn-flat">Novo</button></a> -->
                        <a href="<c:url value='/menu/acesso' />"><button type="button" class="btn btn-info btn-flat">Voltar</button></a>
                    </div>
                </div>
                <div class="box-body">
                    <table id="tabela_principal" class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Programa</th>
                            <th>Ler</th>
                            <th>Criar</th>
                            <th>Alterar</th>
                            <th>Remover</th>
                            <th>Perfil</th>
                            <th>Data de Cadastro</th>
                            <th>Última Alteração</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="acesso" items="${acessos }">
                            <c:if test="${!empty(acesso)}">
                                <tr>
                                    <td>${acesso.id }</td>
                                    <td><a href="<c:url value='/acessos/${acesso.id }/editar' />"  >${acesso.programa.descricao }</a></td>
                                    <td>${acesso.ler }</td>
                                    <td>${acesso.criar}</td>
                                    <td>${acesso.alterar}</td>
                                    <td>${acesso.remover}</td>
                                    <td>${acesso.perfil.descricao}</td>
                                    <td><fmt:formatDate value="${acesso.dataCriacao }" pattern="dd-MM-yyyy HH:mm:ss" /></td>
                                    <td><fmt:formatDate value="${acesso.dataAlteracao }" pattern="dd-MM-yyyy HH:mm:ss" /></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        </tbody>
                        <c:if test="${empty(acessos)}">
                            <tfoot>
                                <tr>
                                    <td colspan="7">Nenhum registro localizado!</td>
                                </tr>
                            </tfoot>
                        </c:if>
                    </table>
                </div>
            </div>
        </section>
    </div>

</div>

<jsp:include page="${pageContext.request.contextPath}/static/fragmentos/footer.jsp" />

</body>
</html>
