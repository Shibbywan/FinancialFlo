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
        <link rel="stylesheet" href="/public/css/styles.css">

        <!-- Scripts -->
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="/public/scripts/script.js"></script>
        <div id='cssmenu'>
            <ul>
                <li><a href='/'>Home</a></li>
                <li><a href='#'>About</a></li>
                <li><a href='#'>Contact</a></li>
            </ul>
        </div>
        <div id="companyinfo">
            <div id="companyheader"> 
                <h1> ${companyName} </h1>
                <h2> ${symbol} </h2>
             </div>
            <hr>
            <p> Average Volume (3 month): ${avgVol1} </p>
            <p> Average Volume (10 day): ${avgVol2} </p>
            <p> Beta: ${beta} </p>
        </div>
    </body>
</html>
