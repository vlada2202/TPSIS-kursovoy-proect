<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>SHOP</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/8.css">
</head>
<body>
<div class="image-container">
    <div class="container">
        <h1 class="mt-4">Авто.бу</h1>
        <hr>
        <h4>Подробная информация об автомобиле</h4>
        <div class="row">
            <div class="col-md-12">
                <div class="image-container">
                    <#list images as img>
                        <img src="/images/${img.id}" class="img-thumbnail">
                    </#list>
                </div>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-md-12">
                <div class="product-info">
                    <b>Марка автомобиля:</b> ${product.title}<br>
                    <b>Описание:</b> ${product.description}<br>
                    <b>Цена:</b> ${product.price}<br>
                    <b>Дилер:</b> ${product.diler}<br>
                    <#if user.isAdmin()>
                        <div class="but">
                            <form name="myForm" action="/edit/${product.id}" method="get">
                                <button class="btn btn-secondary mt-3" type="submit">Редактировать услугу</button>
                            </form>
                        </div>
                        <div class="buttonr">
                    <form action="/product/delete/${product.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <button type="submit" class="btn btn-danger mt-3">Удалить</button>
                    </form>
                        </div>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Подключение файлов скриптов Bootstrap -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
