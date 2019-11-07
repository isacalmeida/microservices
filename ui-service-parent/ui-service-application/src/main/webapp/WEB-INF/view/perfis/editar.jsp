<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://www.springframework.org/tags/form' prefix='form' %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title> Perfis </title>

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/header.jsp" />

</head>

<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/main.jsp" />

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/menu.jsp" />

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Perfis (${port})
                <small>Cadastro de Perfis</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="<c:url value='/menu' />" ><i class="fa fa-tachometer-alt"></i> Menu</a></li>
                <li><a href="<c:url value='/perfis' />" >Perfis</a></li>
                <li class="active">Editar</li>
            </ol>
        </section>
        <section class="content">
            <div class="box">
                <form:form method="post" action="/perfis/atualizar" modelAttribute="perfil">
                    <div class="box-header with-border">
                        <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/forms/cabecalho.jsp" />
                    </div>
                    <div class="box-body">
                    	<div class="box-solid">
                    		<div class="box-header with-border">
		                        <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
		                            <form:label path="descricao"> Descrição </form:label>
		                            <form:input cssClass="form-control" path="descricao" maxlength="50" />
		                        </div>
		                    </div>
		                    <div class="box-body">
								<div class="nav-tabs-custom">
									<ul class="nav nav-tabs">
										<c:set var="count" value="1" />
										<c:forEach var="tipoServico" items="${tipoServicos}">
											<c:if test="${count == 1}">
												<li class="active"><a href="#tab${tipoServico}" data-toggle="tab">${tipoServico.descricao}</a></li>
											</c:if>
											<c:if test="${count != 1}">
												<li><a href="#tab${tipoServico}" data-toggle="tab">${tipoServico.descricao}</a></li>
											</c:if>
											<c:set var="count" value="${count+1}" />
										</c:forEach>
									</ul>
									<div class="tab-content">
										<c:set var="count" value="1" />
										<c:set var="var" value="0" />
										<c:forEach var="tipoServico" items="${tipoServicos}">
											<div class="tab-pane ${count == 1 ? 'active' : '' }" id="tab${tipoServico}">
												<table id="tabela_principal" class="table table-bordered table-hover">
													<thead>
														<tr>
															<th>Programa</th>
															<th>Ler</th>
															<th>Criar</th>
															<th>Alterar</th>
															<th>Remover</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="programa" items="${programas}">
															<c:set var="mudou" value="0" />
															<c:forEach var="acesso" items="${perfil.acessos}">
																<c:if test="${programa.tipoServico == tipoServico && programa.id == acesso.programa.id}">
																	<tr>
																		<td>
																			<c:out value="${programa.descricao}" /> 
																			<input type="hidden" name="acessos[${var}].programa.id" value="${programa.id}" />
																			<input type="hidden" name="acessos[${var}].id" value="${acesso.id}" />
																		</td>
																		<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<input type="checkbox" name="acessos[${var}].ler" class="hidden" value="${acesso.ler}" ${acesso.ler ? 'checked="checked"' : ''} />
																		</span>
																	</td>
																	<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<input type="checkbox" name="acessos[${var}].criar" class="hidden" value="${acesso.criar}" ${acesso.criar ? 'checked="checked"' : ''} />
																		</span>
																	</td>
																	<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<input type="checkbox" name="acessos[${var}].alterar" class="hidden" value="${acesso.alterar}" ${acesso.alterar ? 'checked="checked"' : ''} />
																		</span>
																	</td>
																	<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<input type="checkbox" name="acessos[${var}].remover" class="hidden" value="${acesso.remover}" ${acesso.remover ? 'checked="checked"' : ''} />
																		</span>
																	</td>
																	</tr>
																	<c:set var="var" value="${var + 1}" />
																	<c:set var="mudou" value="1" />
																</c:if>
															</c:forEach>
															<c:if test="${mudou == 0 && programa.tipoServico == tipoServico}">
																<tr>
																	<td>
																		<c:out value="${programa.descricao}" /> 
																		<input type="hidden" name="acessos[${var}].programa.id" value="${programa.id}" />
																	</td>
																	<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<input type="checkbox" name="acessos[${var}].ler" class="hidden" value="false" />
																		</span>
																	</td>
																	<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<input type="checkbox" name="acessos[${var}].criar" class="hidden" value="false" />
																		</span>
																	</td>
																	<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<input type="checkbox" name="acessos[${var}].alterar" class="hidden" value="false" />
																		</span>
																	</td>
																	<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<input type="checkbox" name="acessos[${var}].remover" class="hidden" value="false" />
																		</span>
																	</td>
																</tr>
																<c:set var="var" value="${var + 1}" />
															</c:if>
														</c:forEach>
													</tbody>
												</table>
											</div>
											<c:set var="count" value="${count+1}" />
										</c:forEach>
									</div>
								</div>
							</div>
                       </div>
                    </div>
                    <div class="box-footer">
                        <div class="col-xs-12 col-sm-10 col-md-8 col-lg-8">
                            <button name="submit" type="submit" class="btn btn-success btn-flat"> Salvar </button>
                            <a href="<c:url value='/perfis' />"><button type="button" class="btn btn-default btn-flat"> Voltar </button></a>
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
                                    <a href="<c:url value='/perfis/${perfil.id }/excluir'/>" ><button type="button" class="btn btn-primary" id="delete"> Confirmar </button></a>
                                </div>
                            </div>
                        </div>
                	</div>
                </form:form>
            </div>
        </section>
    </div>

    <jsp:include page="${pageContext.request.contextPath}/static/fragmentos/footer.jsp" />

</div>

</body>
</html>
