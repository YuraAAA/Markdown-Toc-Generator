<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bootstrap 3, from LayoutIt!</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>

</head>


<#if ! error??>
    <#assign error=""/>
</#if>
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


<#if error !="">
<div class="container-fluid" style="margin-top: 3%">
    <div class="row">
        <div class="col-md-12">
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="alert alert-dismissable alert-danger">
                <strong>Warning!</strong> ${error}
            </div>
        </div>
    </div>
</#if>


    <div class="row" style="margin-top: 1%">
        <div class="col-md-12">
            <form class="form-horizontal" method="post" action="/parse" enctype="multipart/form-data" name="model"
                  id="model">
                <fieldset>


                    <!-- change col-sm-N to reflect how you would like your column spacing (http://getbootstrap.com/css/#forms-control-sizes) -->


                    <!-- Form Name -->
                    <legend>Select file and options</legend>

                    <!-- File Button http://getbootstrap.com/css/#forms -->
                    <div class="form-group">
                        <label for="file" class="control-label col-sm-2">Select readme.md file</label>

                        <div class="col-sm-10">
                            <input type="file" id="file" name="file" required="">

                        </div>
                    </div>
                    <!-- Fuel UX Checkboxes http://getfuelux.com/javascript.html#checkbox -->
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="h1" id="h1"/> Skip alternative header H1
                                </label>
                            </div>
                        </div>
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="h2" id="h2"/> Skip alternative header H2
                                </label>
                            </div>
                        </div>

                    </div>
                    <!-- Spinbox http://getfuelux.com/javascript.html#spinbox -->
                    <div class="form-group">
                        <label for="depth" class="control-label col-sm-2">Depth Level (1 - 6)</label>

                        <div class="col-sm-10">
                            <div class="spinbox" data-initialize="spinbox" id="depth">
                                <input id="depth" name="depth" type="text" class="form-control input-mini spinbox-input"
                                       value="4" required="" min="1" max="6"/>
                            </div>

                        </div>
                    </div>
                    <!-- Button http://getbootstrap.com/css/#buttons -->
                    <div class="form-group" align="left">
                        <div class="text-center col-sm-4">
                            <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-primary"
                                    aria-label="Parse">Parse
                            </button>

                        </div>
                    </div>


                </fieldset>
            </form>
        </div>
    </div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>