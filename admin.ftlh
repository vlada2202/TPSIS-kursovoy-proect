<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title> Beauty </title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/cc/cc.css">
</head>
<body>
<h4>Панель администратора</h4>
<table class="table table-hover" border="1">
    <tr>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Роли</th>
        <th>Бан</th>
        <th>Редактирование</th>
        <th>Подробная информация</th>
        <th>Удалить</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th>${user.phoneNumber}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role><{${role}}></#list> </th>
            <th>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" >
                    <input type="submit" value="Бан">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}" style="color: #61605E;">Редактирование</a></th>
            <th><a href="/user/${user.id}" style="color: #61605E;">Подробная информация</a></th>
            <th>
                <form action="/admin/user/delete/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button class="btn btn-primary" type="submit" style="background-color: #61605E; border-color: #61605E;">Удалить</button>
                </form>
            </th>
        <#else >
        <h3>Пользователей нет</h3>
    </#list>
</table>
<hr>
<div class="knop">
    <form action="/product/create" method="get" style="display: inline-block; margin-left: 10px; margin-bottom: 10px;">
        <button class="btn btn-primary" type="submit">Добавить новый автомобиль</button>
    </form>
    <div class="fg" style="display: inline-block; margin-left: 10px;">
        <form action="/adddiler" method="get" style="margin-bottom: 10px;">
            <button class="btn btn-primary" type="submit">Добавить нового дилера</button>
        </form>
    </div>
</div>
</body>
</html>
