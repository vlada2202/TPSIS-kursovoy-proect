<!DOCTYPE html>
<html lang=en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/st.css">
    <title> SHOP </title>
</head>
    <h1>Авторизация</h1>
<div class="auto">
    <form action="/autorisation " method="post">
        <div class="form-group">
            <label for="email">Электронная почта</label>
            <input type="email" class="form-control <#if RequestParameters.error??>is-invalid</#if>" id="email" name="username">
            <div id="email" class="invalid-feedback">
                Неверная электронная почта
            </div>
        </div>
        <div class="form-group">
            <label for="password">Пароль</label>
            <input type="password" class="form-control <#if RequestParameters.error??>is-invalid</#if>" id="password" name="password">
            <div id="password" class="invalid-feedback">
                Неверный пароль
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="ttt">
            <button type="submit" style="width: 100%" class="btn btn-dark">Войти</button>
        </div>
    </form>
</div>
<h5 style="text-align: center">Нет аккаунта? <a href="/registration" style="color:#61605E ">Зарегистрируйся!</a></h5>
</html>
