<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <style>
        h1 {
            text-align: center;
        }
        body {
            background-color: black;
            color: white;
        }
    </style>

</head>
<body>

<h1 style="text-align: center">Изменить документ</h1>
<hr>
<form action="/api/v1/addDoc" method="post">
    @csrf
    <div class="form-group">
        <label for="docName">Название</label>
        <input type="text" required class="form-control"
               id="docName" name="name" value="${document.name}">
    </div>
    <div class="form-group">
        <label for="docNumber">Номер</label>
        <input type="number" required class="form-control" id="docNumber" name="number" value="${document.number}">
    </div>

    <div class="form-group">
        <label for="docType">Тип</label>
        <input type="text" required class="form-control"
               id="docType" name="type" value="${document.type}">
    </div><br>
    <br>

    <div class="form-group">
        <label for="docText">Содержимое</label>
        <textarea type="description" id ="docText" name = "documentText" >${document.documentText}</textarea>
    </div>



    <input type="hidden" name="id" value="${document.id}">


    <button type="submit" style="width: 100%" class="btn btn-dark">изменить</button>
</form>

</body>
</html>