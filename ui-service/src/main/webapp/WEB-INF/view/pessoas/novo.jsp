<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://www.springframework.org/tags/form' prefix='form' %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Pessoas</title>

	<jsp:include page="../header.jsp" />

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

	<jsp:include page="../main.jsp" />

	<jsp:include page="../menu.jsp" />

	<div class="content-wrapper">
		<section class="content-header">
			<h1>
				Pessoas
				<small>Cadastro de Pessoas</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="<c:url value='/' />" ><i class="fa fa-dashboard"></i> Início</a></li>
				<li><a href="<c:url value='/pessoas' />" >Pessoas</a></li>
				<li class="active">Novo</li>
			</ol>
		</section>
		<section class="content">
			<div class="box">
				<form:form method="post" action="/pessoas" modelAttribute="pessoa">
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
						</div>
					</div>
				</form:form>
			</div>
		</section>
	</div>

</div>

<jsp:include page="../footer.jsp" />

</body>
</html>
