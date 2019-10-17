<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://www.springframework.org/tags/form' prefix='form' %>
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
				<li class="active">Novo</li>
			</ol>
		</section>
		<section class="content">
			<div class="box">
				<form:form method="post" action="/pessoas/salvar" modelAttribute="pessoa">
					<div class="box-header with-border">
                        <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/forms/cabecalho.jsp" />
					</div>
					<div class="box-body">
						<div class="box-solid">
							<div class="box-header with-border">
								<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<form:label path="tipo"> Tipo </form:label>
									<form:select path="tipo" cssClass="form-control select2" >
										<form:options items="${tiposPessoa}" itemLabel="descricao" />
									</form:select>
								</div>
							</div>
							<div class="box-body">
								<div class="nav-tabs-custom">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#tabBasico" data-toggle="tab">Básico</a></li>
										<li><a href="#tabAdicional" data-toggle="tab">Adicional</a></li>
										<li><a href="#tabContato" data-toggle="tab">Contato</a></li>
										<li><a href="#tabEndereco" data-toggle="tab">Endereço</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane active" id="tabBasico">
											<div class="row" id="rowPessoaFisicaBasico">
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form:label path="cpf"> CPF </form:label>
													<form:input path="cpf" cssClass="form-control" />
												</div>
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form:label path="nomeCompleto"> Nome Completo </form:label>
													<form:input path="nomeCompleto" cssClass="form-control" />
												</div>
											</div>
											<div class="row" id="rowPessoaJuridicaBasico">
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form:label path="cnpj"> CNPJ </form:label>
													<form:input path="cnpj" cssClass="form-control" />
												</div>
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form:label path="razaoSocial"> Razão Social </form:label>
													<form:input path="razaoSocial" cssClass="form-control" />
												</div>
											</div>
										</div>
										<div class="tab-pane" id="tabAdicional">
											<div class="row" id="rowPessoaFisicaAdicional">
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form:label path="dataNascimento"> Data de Nascimento </form:label>
													<div class="input-group date datepicker" data-provide="datepicker">
														<span class="input-group-btn">
															<button class="btn btn-default btn-flat" type="button">
																<span class="fa fa-calendar"></span>
															</button>
														</span>
														<form:input path="dataNascimento" cssClass="form-control maskData" />
													</div>
												</div>
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form:label path="genero"> Gênero </form:label>
													<form:select path="genero" cssClass="form-control select2" >
														<form:option value="null" label="-- Selecione --" />
														<form:options items="${generos}" itemLabel="descricao" />
													</form:select>
												</div>
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form:label path="setor"> Setor </form:label>
													<form:input path="setor" cssClass="form-control" />
												</div>
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form:label path="cargo"> Cargo </form:label>
													<form:input path="cargo" cssClass="form-control" />
												</div>
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form:label path="dataAdmissao"> Data de Admissão </form:label>
													<div class="input-group date datepicker" data-provide="datepicker">
														<span class="input-group-btn">
															<button class="btn btn-default btn-flat" type="button">
																<span class="fa fa-calendar"></span>
															</button>
														</span>
														<form:input path="dataAdmissao" cssClass="form-control maskData" />
													</div>
												</div>
											</div>
											<div class="row" id="rowPessoaJuridicaAdicional">
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form:label path="nomeFantasia"> Nome Fantasia </form:label>
													<form:input path="nomeFantasia" cssClass="form-control" />
												</div>
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form:label path="dataFundacao"> Data de Fundação </form:label>
													<div class="input-group date datepicker" data-provide="datepicker">
														<span class="input-group-btn">
															<button class="btn btn-default btn-flat" type="button">
																<span class="fa fa-calendar"></span>
															</button>
														</span>
														<form:input path="dataFundacao" cssClass="form-control maskData" />
													</div>
												</div>
											</div>
										</div>
										<div class="tab-pane" id="tabContato">
											<div class="row">
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<input id="adicionarContato" type="button" class="btn btn-success btn-flat" value="Adicionar" />
												</div>
												<div id="tableContato">
												</div>
											</div>
										</div>
										<div class="tab-pane" id="tabEndereco">
											<div class="row">
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<input id="adicionarEndereco" type="button" class="btn btn-success btn-flat" value="Adicionar" />
												</div>
												<div id="tableEndereco">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="box-footer">
								<div class="form-group col-xs-12 col-sm-4 col-md-4 col-lg-4">
									<form:label path="cliente"> Cliente </form:label><br />
									<form:checkbox cssClass="form-control bootstrapSwitch" id="cliente" path="cliente"
												   data-on-color="success" data-off-color="danger" data-on-text="Sim" data-off-text="Não"  />
								</div>
								<div class="form-group col-xs-12 col-sm-4 col-md-4 col-lg-4">
									<form:label path="fornecedor"> Fornecedor </form:label><br />
									<form:checkbox cssClass="form-control bootstrapSwitch" id="fornecedor" path="fornecedor"
												   data-on-color="success" data-off-color="danger" data-on-text="Sim" data-off-text="Não"  />
								</div>
								<div class="form-group col-xs-12 col-sm-4 col-md-4 col-lg-4">
									<form:label path="ativo"> Ativo </form:label><br />
									<form:checkbox cssClass="form-control bootstrapSwitch" id="ativo" path="ativo"
												   data-on-color="success" data-off-color="danger" data-on-text="Sim" data-off-text="Não"  />
								</div>
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

<jsp:include page="${pageContext.request.contextPath}/static/fragmentos/footer.jsp" />

</body>
</html>
