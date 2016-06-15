<!DOCTYPE html>
<html  lang="en">
    <head>
        <meta  content="text/html; charset=utf-8"  http-equiv="content-type">
        <meta  http-equiv="X-UA-Compatible"  content="IE=edge">
        <meta  name="viewport"  content="width=device-width, initial-scale=1">
        <title>FinancialFlo</title>
        </head>
    <body  id="app-layout">
        <!-- Stylesheets -->
        <link rel="stylesheet" type="text/css" href="/public/css/company.css">
        <link rel="stylesheet" href="/public/css/home.css">
        <link rel="stylesheet" href="/public/jspkg-archive/jquery.dynatable.css">

        <!-- Scripts -->
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="/public/scripts/script.js"></script>
        <script src="/public/jspkg-archive/jquery.dynatable.js"></script>

        <div id='topbar'>
            <ul class="nav">
                <li><a href='/'>Home</a></li>
                <li><a href='#'>About</a></li>
                <li><a href='#'>Contact</a></li>
                <li id="search">
                    <form method="get" action="javascript:window.location.assign('/search/' + document.getElementById('search-text').value);">
                        <input type="text" name="search-text" id="search-text" placeholder="Search">
                        <input type="button" name="search-button" id="search-button" onclick="searchFunction();">
                    </form>
                </li>
            </ul>
        </div>
        
        <h2> Search Results </h2>
        <hr>
        <ul>
        <#list results as result>
            <li><a href="/company/${result}">${result}</a></li>
        </#list>
        </ul>
        </body>
    </html>

<script>
    function searchFunction() {
        window.location="/search/" + document.getElementById('search-text').value;
    }
</script>

