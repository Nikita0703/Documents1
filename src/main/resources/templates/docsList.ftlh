<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car List</title>
    <style>
        h1 {
            text-align: center;
        }
        body {
            background-color: black;
            color: white;
        }
        td {
            padding: 10px 20px;
        }
    </style>
</head>
<body>
<h1>Список документов</h1>
<form action="/api/v1/searchDoc" method="GET">
    <label for="name">Поиск по названию:</label><br>
    <input type="text" id="name" name="name"><br><br>
    <input type="submit" value="Поиск">
</form>
<hr>
<table>
    <tr>
        <th>Название</th>
        <th>Номер</th>
        <th>Дата</th>
        <th>Тип</th>
        <th>Текст документа</th>
    </tr>
    <#list documents as document>
        <tr>
            <td>${document.name}</td>
            <td>${document.number}</td>
            <td>${document.createdDate}</td>
            <td>${document.type}</td>
            <td>${document.documentText}</td>
            <td>
                <a href="/api/v1/edit/${document.id}">Изменить</a> <!-- Ссылка для изменения автомобиля -->
            </td>
        </tr>
    </#list>
</table>
<hr>
<a href="/api/v1/add">Добавить новый документ</a>
</body>
</html>
