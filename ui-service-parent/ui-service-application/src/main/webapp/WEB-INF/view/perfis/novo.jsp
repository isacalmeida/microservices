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
                <li class="active">Novo</li>
            </ol>
        </section>
        <section class="content">
            <div class="box">
                <form:form method="post" action="/perfis/salvar" modelAttribute="perfil">
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
															<c:if test="${programa.tipoServico == tipoServico}">
																<tr>
																	<td>
																		<c:out value="${programa.descricao}" /> 
																		<form:hidden path="acessos[${var}].programa.id" name="acessos[${var}].programa.id" value="${programa.id}" />
																	</td>
																	<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<form:checkbox path="acessos[${var}].ler" name="acessos[${var}].ler" cssClass="hidden" />
																		</span>
																	</td>
																	<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<form:checkbox path="acessos[${var}].criar" name="acessos[${var}].criar" cssClass="hidden" />
																		</span>
																	</td>
																	<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<form:checkbox path="acessos[${var}].alterar" name="acessos[${var}].alterar" cssClass="hidden" />
																		</span>
																	</td>
																	<td>
																		<span class="button-checkbox">
																			<button type="button" class="btn btn-lg" data-color="primary"></button>
																			<form:checkbox path="acessos[${var}].remover" name="acessos[${var}].remover" cssClass="hidden" />
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
