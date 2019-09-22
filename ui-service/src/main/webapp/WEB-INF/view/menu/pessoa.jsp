<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Pessoa</title>

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/header.jsp" />

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/main.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/menu.jsp" />

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Pessoa
                <small>Programas do Serviço de Pessoa</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="<c:url value='/' />" ><i class="fa fa-tachometer-alt"></i> Início</a></li>
                <li><a href="<c:url value='/menu' />" >Menu</a></li>
                <li class="active">Pessoa</li>
            </ol>
        </section>
        <section class="content">
            <div class="box">
                <div class="box-body">
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                            <a href="<c:url value='/pessoas' />" class="small-box bg-green">
                                <div class="inner">
                                    <h3>Pessoas</h3>
                                    <p>Manutenção de Pessoas</p>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-user"></i>
                                </div>
                            </a>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                            <a href="<c:url value='/ceps' />" class="small-box bg-green">
                                <div class="inner">
                                    <h3>Ceps</h3>
                                    <p>Manutenção de Ceps</p>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-sitemap"></i>
                                </div>
                            </a>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                            <a href="<c:url value='/cidades' />" class="small-box bg-green">
                                <div class="inner">
                                    <h3>Cidades</h3>
                                    <p>Manutenção de Cidades</p>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-building"></i>
                                </div>
                            </a>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                            <a href="<c:url value='/estados' />" class="small-box bg-green">
                                <div class="inner">
                                    <h3>Estados</h3>
                                    <p>Manutenção de Estados</p>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-university"></i>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

</div>

<jsp:include page="${pageContext.request.contextPath}/static/fragmentos/footer.jsp" />

</body>
</html>
