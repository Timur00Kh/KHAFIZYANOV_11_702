<html>
<head>
    <title>addSubj</title>
    <#include "import.ftl">

    <script src="http://localhost/js/addSubj.js"></script>

</head>
<body>
<#include "header.ftl">


<div class="container mt-5">
    <div class="row justify-content-center mb-5">
        <div class="col-md-8">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page"><h3>Добавить новый sbj</h3></li>
                </ol>
            </nav>
        </div>
        <div class="col-md-8">
            <form action="/addSubj" method="POST" accept-charset="utf-8">
                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="title">
                </div>
                <div class="form-group">
                    <label for="type">Type</label>
                    <input type="text" class="form-control" id="type" name="type" placeholder="type">
                </div>
                <div class="form-group">
                    <label for="genre">Genre</label>
                    <input type="text" class="form-control" id="genre" name="genre" placeholder="genre">
                </div>
                <div class="form-group">
                    <label for="duration">Duration</label>
                    <input type="text" class="form-control" id="duration" name="duration" placeholder="duration">
                </div>
                <div class="form-group">
                    <label for="release_date">Release</label>
                    <input type="text" class="form-control" id="release_date" name="release_date" placeholder="release_date">
                </div>
                <div class="form-group">
                    <label for="release_year">Release</label>
                    <input type="text" class="form-control" id="release_year" name="release_year" placeholder="release_year">
                </div>
                <div class="form-group">
                    <label for="status">Status</label>
                    <input type="text" class="form-control" id="status" name="status" placeholder="status">
                </div>
                <div class="form-group">
                    <label for="poster_url">Poster_url</label>
                    <input type="text" class="form-control" id="poster_url" name="poster_url" placeholder="poster_url">
                </div>
                <div class="form-group">
                    <label for="desc">Description</label>
                    <input type="text-area" class="form-control" id="desc" name="desc" placeholder="desc">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <div class="alert alert-danger mt-1 mx-0" style="display: none" id="errAlert" role="alert">
                <i class="fas fa-exclamation-triangle"></i> <span>123</span>
            </div>
            <div class="alert alert-success mt-1 mx-0" style="display: none" id="alertSuccess" role="alert">
                <i class="fa fa-check" aria-hidden="true"></i> <span>123</span> <a href='/addSubj'>Добавить еще</a>
            </div>
        </div>

    </div>
</div>

</body>
</html>
