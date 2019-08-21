<%@ page contentType='text/html;charset=ISO-8859-1' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://www.springframework.org/tags/form' prefix='form' %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title> Estados </title>

    <jsp:include page="../header.jsp" />

</head>

<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="../main.jsp" />

    <jsp:include page="../menu.jsp" />

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Estados (${port})
                <small>Cadastro de Estados</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="<c:url value='/' />" ><i class="fa fa-tachometer-alt"></i> Início</a></li>
                <li class="active">Estados</li>
            </ol>
        </section>
        <section class="content">
            <div class="box">
                <form:form method="post" action="/estados" modelAttribute="estado">
                    <div class="box-header with-border">
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="id"> Id </form:label>
                            <form:input path="id" class="form-control" readonly="true" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6">
                            <form:label path="dataCriacao"> Data de Criação </form:label>
                            <form:input path="dataCriacao" class="form-control" readonly="true" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6">
                            <form:label path="dataAlteracao"> Data de Alteração </form:label>
                            <form:input path="dataAlteracao" class="form-control" readonly="true" />
                        </div>
                    </div>
                    <div class="box-body">
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="descricao"> Descrição </form:label>
                            <form:input path="descricao" class="form-control" size="50" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="sigla"> Sigla </form:label>
                            <form:input path="sigla" class="form-control" size="2" />
                        </div>
                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form:label path="ativo"> Ativo </form:label>
                            <form:checkbox path="ativo" class="form-control bootstrap-switch" />
                        </div>
                    </div>
                    <div class="box-footer">
                        <div class="col-xs-12 col-sm-10 col-md-8 col-lg-8">
                            <button name="submit" type="submit" class="btn btn-success btn-flat"> Salvar </button>
                            <a href="<c:url value='/estados' />"><button type="button" class="btn btn-default btn-flat"> Voltar </button></a>
                        </div>
                    </div>
                </form:form>
            </div>
        </section>
    </div>

    <jsp:include page="../footer.jsp" />

</div>

</body>
</html>
