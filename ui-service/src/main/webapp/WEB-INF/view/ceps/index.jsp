<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%-- <%@ page import="br.edu.unoesc.util.Constants" %> --%>
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
                <li><a href="<c:url value='/' />" ><i class="fa fa-tachometer-alt"></i> Início</a></li>
                <li class="active">Ceps</li>
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
                        <a href="<c:url value='/ceps/novo'/>" ><button type="button" class="btn btn-primary btn-flat">Novo</button></a>
                        <a href="<c:url value='/' />"><button type="button" class="btn btn-info btn-flat">Voltar</button></a>
                    </div>
                </div>
                <div class="box-body">
                    <table id="tabela_principal" class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Cep</th>
                            <th>Logradouro</th>
                            <th>Bairro</th>
                            <th>Cidade</th>
                            <th>Data de Cadastro</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cep" items="${ceps }">
                            <c:if test="${!empty(cep)}">
                                <tr>
                                    <td>${cep.id }</td>
                                    <td><a href="<c:url value='/cep/${cep.id }/editar' />"  >${cep.cep }</a></td>
                                    <td>${cep.logradouro }</td>
                                    <td>${cep.bairro}</td>
                                    <td>${cep.cidade}</td>
                                    <td>${cep.dataCriacao }</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        </tbody>
                        <c:if test="${empty(ceps)}">
                            <tfoot>
                                <tr>
                                    <td colspan="6">Nenhum registro localizado!</td>
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
