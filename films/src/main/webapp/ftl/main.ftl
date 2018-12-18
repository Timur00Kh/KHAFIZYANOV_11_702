<html>
<head>
    <title>Films</title>
    <#include "/ftl/import.ftl"  parse=true>
    <script src="http://localhost/js/main.js"></script>

</head>
<body>
<#include "header.ftl"  parse=true >

<div class="container my-5">
    <div class="row">
        <div class="col-12">
            <h2>Поиск:</h2>
            <input id="bigSearch" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        </div>
        <div class="mt-4 w-100"></div>
        <div class="col-12 text-center" id="loading">
            <i class="fas fa-spinner fa-2x fa-spin"></i>
        </div>
    </div>
    <div class="row" id="subj_container" style="min-height: 400px">



    </div>
</div>


</body>
</html>
