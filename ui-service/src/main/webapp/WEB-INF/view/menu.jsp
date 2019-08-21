<%@ page contentType='text/html;charset=ISO-8859-1' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title> Menu </title>
</head>
<body>

<aside class="main-sidebar">
    <section class="sidebar">
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group ui-widget">
                <label for="busca"></label>
                <input type="text" id="busca" name="q" class="form-control" placeholder="Pesquisar ..." autocomplete="off" />
                <span class="input-group-btn">
					<button type="submit" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
				</span>
            </div>
        </form>
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MENU PRINCIPAL</li>
            <li class="treeview menu-open">
                <a href="<c:url value='/' />" >
                    <i class="fa fa-folder"></i>
                    <span>Início</span>
                    <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
                </a>
                <ul class="treeview-menu" style="display: block;">
                    <li><a href="<c:url value='/' />" ><i class="fa fa-tachometer-alt"></i> Dashboard</a></li>
                    <li><a href="<c:url value='/pessoas' />" ><i class="fa fa-users"></i> Pessoas</a></li>
                    <li><a href="<c:url value='/estados' />" ><i class="fa fa-landmark"></i> Estados</a></li>
                    <li><a href="<c:url value='/cidades' />" ><i class="fa fa-money-bill"></i> Cidades</a></li>
                    <li><a href="<c:url value='/ceps' />" ><i class="fa fa-money-bill"></i> CEPs</a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>

</body>
</html>
