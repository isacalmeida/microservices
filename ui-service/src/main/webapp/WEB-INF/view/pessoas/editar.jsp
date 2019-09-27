<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                <li class="active">Editar</li>
            </ol>
        </section>
        <section class="content">
            <div class="box">
                <form:form method="post" action="/pessoas/atualizar" modelAttribute="pessoa">
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
													<c:set var="count" value="0" />
													<c:forEach items="${pessoa.contatos}" var="contato">
														<div id="linhaContato">
															<div id="colunaContato${count}">
														    	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding-left: 5px; padding-right: 5px;">
														        	<hr style="margin-top: 5px; margin-bottom: 5px; border-top-color: #d2d6de;" />
														        </div>
															    <div class="form-group col-xs-12 col-sm-4 col-md-2 col-lg-2">
															    	<form:label path="contatos[${count}].id">Id</form:label>
															        <form:input id="contatos[${count}].id" path="contatos[${count}].id" value="${contato.id}" cssClass="form-control" readonly="true" />
															    </div>
															    <div class="form-group col-xs-12 col-sm-8 col-md-3 col-lg-3">
															        <label for="tipoDescricao${count}">Tipo</label>
															        <input id="contatos[${count}].tipo" name="contatos[${count}].tipo" value="${contato.tipo}" type="hidden" />
															        <input id="tipoDescricao${count}" name="tipoDescricao${count}" value="${contato.tipo.descricao}" class="form-control" readonly="readonly" />
															    </div>
															    <div class="form-group col-xs-12 col-sm-10 col-md-5 col-lg-5">
														        	<form:label path="contatos[${count}].descricao">Descrição</form:label>
														        	<form:input id="contatos[${count}].descricao" path="contatos[${count}].descricao" value="${contato.descricao}" cssClass="form-control" />
														        </div>
														        <div class="form-group col-xs-12 col-sm-2 col-md-2 col-lg-2">
														        	<label for="removerContato${count}">Ação</label><br />
														        	<input id="removerContato${count}" type="button" class="btn btn-danger btn-flat form-control" value="Remover" onclick="removerColuna(colunaContato${count})" />
														        </div>
															</div>
														</div>
														<c:set var="count" value="${count+1}" />
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="tab-pane" id="tabEndereco">
											<div class="row">
												<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<input id="adicionarEndereco" type="button" class="btn btn-success btn-flat" value="Adicionar" />
												</div>
												<div id="tableEndereco" >
													<c:set var="count" value="0" />
													<c:forEach items="${pessoa.enderecos}" var="endereco">
														<div id="linhaEndereco">
															<div id="colunaEndereco${count}">
																<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding-left: 5px; padding-right: 5px;">
																	<hr style="margin-top: 5px; margin-bottom: 5px; border-top-color: #d2d6de;" />
																</div>
																<div class="form-group col-xs-12 col-sm-6 col-md-3 col-lg-3">
															    	<form:label path="enderecos[${count}].id">Id</form:label>
															    	<form:input id="enderecos[${count}].id" path="enderecos[${count}].id" value="${endereco.id}" cssClass="form-control" readonly="true" />
															    </div>
															    <div class="form-group col-xs-12 col-sm-6 col-md-3 col-lg-3">
															    	<label for="enderecos[${count}].tipo">Tipo</label>
															    	<input id="enderecos[${count}].tipo" name="enderecos[${count}].tipo" value="${endereco.tipo}" type="hidden" />
															    	<input id="tipoEndereco${count}" name="tipoEndereco${count}" value="${endereco.tipo.descricao}" class="form-control" readonly="readonly" />
															    </div>
															    <div class="form-group col-xs-12 col-sm-6 col-md-3 col-lg-3">
															    	<form:label path="enderecos[${count}].cep.cep">Cep</form:label>
															    	<input id="enderecos[${count}].cep.id" name="enderecos[${count}].cep.id" value="${endereco.cep.id}" type="hidden" />
															    	<form:input id="enderecos[${count}].cep.cep" path="enderecos[${count}].cep.cep" value="${endereco.cep.cep}" cssClass="form-control" autocomplete="no" />
															    </div>
															    <div class="form-group col-xs-12 col-sm-6 col-md-3 col-lg-3">
															    	<form:label path="enderecos[${count}].numero">Número</form:label>
															    	<form:input id="enderecos[${count}].numero" path="enderecos[${count}].numero" value="${endereco.numero}" cssClass="form-control" />
															    </div>
															    <div class="form-group col-xs-12 col-sm-6 col-md-3 col-lg-3">
															    	<form:label path="enderecos[${count}].cep.bairro">Bairro</form:label>
															    	<form:input id="enderecos[${count}].cep.bairro" path="enderecos[${count}].cep.bairro" value="${endereco.cep.bairro}" cssClass="form-control" readonly="true" />
															    </div>
															    <div class="form-group col-xs-12 col-sm-6 col-md-3 col-lg-3">
															    	<form:label path="enderecos[${count}].cep.cidade.descricao">Cidade - UF</form:label>
															    	<form:input id="enderecos[${count}].cep.cidade.descricao" path="enderecos[${count}].cep.cidade.descricao" value="${endereco.cep.cidade.descricao} - ${endereco.cep.cidade.estado.sigla}" cssClass="form-control" readonly="true" />
															    </div>
															    <div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-6">
															    	<form:label path="enderecos[${count}].cep.logradouro">Logradouro</form:label>
															    	<form:input id="enderecos[${count}].cep.logradouro" path="enderecos[${count}].cep.logradouro" value="${endereco.cep.logradouro}" cssClass="form-control" readonly="true" />
															    </div>
															    <div class="form-group col-xs-12 col-sm-6 col-md-3 col-lg-3">
															    	<form:label path="enderecos[${count}].complemento">Complemento</form:label>
															    	<form:input id="enderecos[${count}].complemento" path="enderecos[${count}].complemento" value="${endereco.complemento}" cssClass="form-control" />
															    </div>
															    <div class="form-group col-xs-12 col-sm-7 col-md-7 col-lg-7">
															    	<form:label path="enderecos[${count}].observacao">Observação</form:label>
															    	<form:input id="enderecos[${count}].observacao" path="enderecos[${count}].observacao" value="${endereco.observacao}" cssClass="form-control" />
															    </div>
															    <div class="form-group col-xs-12 col-sm-5 col-md-2 col-lg-2">
															    	<label for="removerEndereco${count}">Ação</label><br />
															    	<input id="removerEndereco${count}" type="button" class="btn btn-danger btn-flat form-control" value="Remover" onclick="removerColuna(colunaEndereco${count})" />
															    </div>
															</div>
														</div>
														<c:set var="count" value="${count+1}" />
													</c:forEach>
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
                            <button type="button" class="btn btn-danger btn-flat" data-toggle="modal" data-target="#confirm">Excluir</button>
                        </div>
                    </div>
                    <div class="modal fade" id="confirm">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">Confirmação</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Tem certeza que deseja excluir?</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" data-dismiss="modal" class="btn btn-default pull-left"> Voltar </button>
                                    <a href="<c:url value='/funcionario/${pessoa.id }/excluir'/>" ><button type="button" class="btn btn-primary" id="delete"> Confirmar </button></a>
                                </div>
                            </div>
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
