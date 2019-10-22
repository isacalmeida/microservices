<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Acesso</title>

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/header.jsp" />

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/main.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/menu.jsp" />

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Acesso
                <small>Programas do Serviço de Acesso</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="<c:url value='/' />" ><i class="fa fa-tachometer-alt"></i> Início</a></li>
                <li><a href="<c:url value='/menu' />" >Menu</a></li>
                <li class="active">Acesso</li>
            </ol>
        </section>
        <section class="content">
            <div class="box">
                <div class="box-body">
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                            <a href="<c:url value='/acessos' />" class="small-box bg-green">
                                <div class="inner">
                                    <h3>Acessos</h3>
                                    <p>Manutenção de Acessos</p>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-cogs"></i>
                                </div>
                            </a>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                            <a href="<c:url value='/perfis' />" class="small-box bg-green">
                                <div class="inner">
                                    <h3>Perfis</h3>
                                    <p>Manutenção de Perfis</p>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-user-lock"></i>
                                </div>
                            </a>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                            <a href="<c:url value='/programas' />" class="small-box bg-green">
                                <div class="inner">
                                    <h3>Programas</h3>
                                    <p>Manutenção de Programas</p>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-tasks"></i>
                                </div>
                            </a>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                            <a href="<c:url value='/usuarios' />" class="small-box bg-green">
                                <div class="inner">
                                    <h3>Usuários</h3>
                                    <p>Manutenção de Usuários</p>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-user-cog"></i>
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
