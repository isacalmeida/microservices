<%@ page contentType='text/html;charset=ISO-8859-1' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%-- <%@ page import="br.edu.unoesc.util.Constants" %> --%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title> Pessoas </title>

    <jsp:include page="../header.jsp" />

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="../main.jsp" />

    <jsp:include page="../menu.jsp" />

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Pessoas (${port})
                <small>Cadastro de Pessoas</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="<c:url value='/' />" ><i class="fa fa-tachometer-alt"></i> Início</a></li>
                <li class="active">Pessoas</li>
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
                        <a href="<c:url value='/pessoas/novo'/>" ><button type="button" class="btn btn-primary btn-flat">Novo</button></a>
                        <a href="<c:url value='/' />"><button type="button" class="btn btn-info btn-flat">Voltar</button></a>
                    </div>
                </div>
                <div class="box-body">
                    <table id="tabela_principal" class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>Setor</th>
                            <th>Cargo</th>
                            <th>Data de Admissão</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="pessoa" items="${pessoas }">
                            <c:if test="${!empty(pessoa)}">
                                <tr>
                                    <td>${pessoa.id }</td>
                                    <td><a href="<c:url value='/pessoas/${pessoa.id }/editar' />"  >${pessoa.nomeCompleto }</a></td>
                                    <td>${pessoa.cpf }</td>
                                    <td>${pessoa.setor }</td>
                                    <td>${pessoa.cargo }</td>
                                    <td>${pessoa.dataAdmissao }</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        </tbody>
                        <c:if test="${empty(pessoas)}">
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

<jsp:include page="../footer.jsp" />

</body>
</html>
