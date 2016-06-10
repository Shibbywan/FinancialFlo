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
                    <form action="" method="get">
                        <input type="text" name="search-text" id="search-text" placeholder="Search">
                        <input type="button" name="search-button" id="search-button">
                    </form>
                </li>
            </ul>
        </div>
        <div id="companyinfo">
            <div id="companyheader"> 
                <h1> ${companyName} </h1>
                <h3> ${symbol} - ${stockExchange} <span class="quote">${ask}</span> <span class="change">${change}</span> </h3>
             </div>
            <hr>
            <div id="company-chart">
                <table id="chart-1" class="table table-bordered">
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
            
            <div id="company-income-statement">
                <table id="chart-2" class="table table-bordered">
                    <h3> Income Statement </h3>
                    <thead>
                        <tr>
                            <th>Statistic</th>
                            <th>Value</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Revenue (ttm)</td>
                            <td>${revenue}</td>
                        </tr>
                        <tr>
                            <td>Revenue Per Share (ttm)</td>
                            <td>${revenuePerShare}</td>
                        </tr>
                        <tr>
                            <td>Quarterly Revenue Growth</td>
                            <td>${qtrlyRevenueGrowth}</td>
                        </tr>
                        <tr>
                            <td>Gross Profit (ttm)</td>
                            <td>${grossProfit}</td>
                        </tr>
                        <tr>
                            <td>EBITDA (ttm)</td>
                            <td>${EBITDA}</td>
                        </tr>
                        <tr>
                            <td>Net Income Avl to Common (ttm)</td>
                            <td>${netIncomeAvlToCommon}</td>
                        </tr>
                        <tr>
                            <td>Diluted EPS</td>
                            <td>${dilutedEPS}</td>
                        </tr>
                        <tr>
                            <td>Quarterly EarningsGrowth (yoy)</td>
                            <td>${qtrlyEarningsGrowth}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        
        <div id="company-balance-sheet">
                <table id="chart-3" class="table table-bordered">
                    <h3> Balance Sheet </h3>
                    <thead>
                        <tr>
                            <th>Statistic</th>
                            <th>Value</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Total Cash (mrq)</td>
                            <td>${totalCash}</td>
                        </tr>
                        <tr>
                            <td>Total Cash Per Share (mrq)</td>
                            <td>${totalCashPerShare}</td>
                        </tr>
                        <tr>
                            <td>Total Debt (mrq)</td>
                            <td>${totalDebt}</td>
                        </tr>
                        <tr>
                            <td>Total Debt/Equity (mrq)</td>
                            <td>${totalDebtEquity}</td>
                        </tr>
                        <tr>
                            <td>Current Ratio (mrq)</td>
                            <td>${currentRatio}</td>
                        </tr>
                        <tr>
                            <td>Book Value Per Share (mrq)</td>
                            <td>${bookValuePerShare}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        $('#chart-1').bind('dynatable:preinit', function(e, dynatable) {
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
            
            $('#chart-2').bind('dynatable:preinit', function(e, dynatable) {
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
            $('#chart-3').bind('dynatable:preinit', function(e, dynatable) {
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


