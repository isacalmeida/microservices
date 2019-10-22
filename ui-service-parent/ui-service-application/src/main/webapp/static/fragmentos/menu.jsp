<%@ page contentType='text/html;charset=UTF-8' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

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
            <ul class="sidebar-menu tree" data-widget="tree">
                <li class="header">MENU PRINCIPAL</li>
                <li id="menu-menu">
                    <a href="<c:url value='/menu' />">
                        <i class="fa fa-folder-plus"></i>
                        <span>Menu</span>
                    </a>
                </li>
                <li id="menu-dashboard">
                    <a href="<c:url value='/' />">
                        <i class="fa fa-tachometer-alt"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li id="menu-acesso">
                    <a href="<c:url value='/menu/acesso' />">
                        <i class="fa fa-cogs"></i>
                        <span>Acesso</span>
                    </a>
                </li>
                <li id="menu-pessoa">
                    <a href="<c:url value='/menu/pessoa' />">
                        <i class="fa fa-users"></i>
                        <span>Pessoa</span>
                    </a>
                </li>
            </ul>
        </section>
    </aside>
