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
        <link rel="stylesheet" href="/public/jspkg-archive/jquery.dynatable.css">

        <!-- Scripts -->
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="/public/scripts/script.js"></script>
        <script src="/public/jspkg-archive/jquery.dynatable.js"></script>
        
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
                <h3> ${symbol} - ${stockExchange} <span class="quote">${ask}</span> <span class="change">${change}</span> </h3>
             </div>
            <hr>
            <div id="company-chart">
                <table id="chart" class="table table-bordered">
                    <h3> Valuation Measures </h3>
                    <thead>
                        <tr>
                            <th>Statistic</th>
                            <th>Value</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Market Cap</td>
                            <td>${marketCap}</td>
                        </tr>
                        <tr>
                            <td>Enterprise Value</td>
                            <td>${enterpriseValue}</td>
                        </tr>
                        <tr>
                            <td>Trailing P/E</td>
                            <td>${trailingPE}</td>
                        </tr>
                        <tr>
                            <td>Forward P/E</td>
                            <td>${forwardPE}</td>
                        </tr>
                        <tr>
                            <td>PEG Ratio</td>
                            <td>${pegRatio}</td>
                        </tr>
                        <tr>
                            <td>Price/Sales</td>
                            <td>${priceSales}</td>
                        </tr>
                        <tr>
                            <td>Price/Book</td>
                            <td>${priceBook}</td>
                        </tr>
                        <tr>
                            <td>Enterprise Value/Revenue</td>
                            <td>${enterpriseValueRevenue}</td>
                        </tr>
                        <tr>
                            <td>Enterprise Value/EBITDA</td>
                            <td>${enterpriseValueEBIDTA}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        $('#chart').bind('dynatable:preinit', function(e, dynatable) {
            dynatable.utility.textTransform.myNewStyle = function(text) {
                return text
                            .replace(/\s+/, '_')
                            .replace(/[A-Z]/, function($1){ return $1 + $1 });
           };
        }).dynatable({
                    table: {
                        defaultColumnIdStyle: 'myNewStyle'
                            },
                            features: {
                                paginate: false,
                                search: false,
                                recordCount: false,
                                perPageSelect: false
                             }
        });
    </script>
</html>


