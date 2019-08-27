<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Início</title>

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/header.jsp" />

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/main.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/menu.jsp" />

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Dashboard
                <small>Painel de Controle</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="<c:url value='/' />" ><i class="fa fa-tachometer-alt"></i> Início</a></li>
                <li class="active">Dashboard</li>
            </ol>
        </section>
        <section class="content">
            <div class="box">
                <div class="box-body">
                    <h2 class="box-title">Bem vindo!</h2>
                    <h5>${mensagem}</h5>
                </div>
            </div>
        </section>
    </div>

</div>

<jsp:include page="${pageContext.request.contextPath}/static/fragmentos/footer.jsp" />

</body>
</html>
