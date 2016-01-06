<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bootstrap 3, from LayoutIt!</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>

</head>
<body>


<div class="container-fluid">

    <div class="row bg-primary" style="margin-top: 1%">
        <div class="col-md-8" align="center">
            <h2>
                Markdown TOC generator for GitHub .md file
            </h2>
        </div>
        <div class="col-md-4" align="center">
            <a href="https://github.com/YuraAAA/Markdown-Toc-Generator">
                <img src="https://assets-cdn.github.com/images/modules/logos_page/Octocat.png" width="100" height="100"
                     class="img-circle"/>
            </a>
        </div>
    </div>


    <div class="container-fluid" style="margin-top: 3%">
        <div class="row">
            <div class="col-md-12">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="alert alert-dismissable alert-success">
                    <strong>Success!</strong> Structure successfully created
                </div>
            </div>
        </div>


        <div class="row" style="margin-top: 1%">
            <div class="col-md-12">
            <#list data as d>
                <br>
            ${d}
            </#list>
            </div>
        </div>
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>