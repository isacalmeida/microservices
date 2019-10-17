<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://www.springframework.org/tags/form' prefix='form' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <title>Login</title>

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/header.jsp" />

</head>
<body class="hold-transition login-page">

<div class="login-box">
	<div class="login-logo">
		<span class="logo-lg"><b>Sistema </b> Isac</span>
	</div>
	<div class="login-box-body">
		<p class="login-box-msg">Faça seu login para acessar o sistema</p>
		<form:form method="post" action="/login" modelAttribute="usuario">
			<div class="form-group has-feedback">
				<form:label path="email"> Email </form:label>
				<form:input cssClass="form-control" path="email" minlength="10" maxlength="100" />
				<span class="fa fa-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<form:label path="senha"> Senha </form:label>
				<form:password cssClass="form-control" path="senha" />
				<span class="fa fa-lock form-control-feedback"></span>
			</div>
			<div class="row">
				<div class="form-group col-xs-8">
					<div class="checkbox icheck">
						<input type="checkbox" class="iCheck" /><span id="spanLembrarMe">Lembrar Me</span>
					</div>
				</div>
				<div class="form-group col-xs-4">
					<button type="submit" class="btn btn-primary btn-block btn-flat">Entrar</button>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${param.error}">
						<div class="alert alert-danger">
							E-mail e senha estão incorretos!<br />Não foi possível fazer login.
						</div>
					</c:if>
				</div>
			</div>
		</form:form>
	</div>
</div>

<jsp:include page="${pageContext.request.contextPath}/static/fragmentos/footer.jsp" />

</body>
</html>