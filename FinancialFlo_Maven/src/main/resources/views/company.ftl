<!DOCTYPE html>
<html lang="en">
    <head>
        <meta  content="text/html; charset=utf-8"  http-equiv="content-type">
        <meta  http-equiv="X-UA-Compatible"  content="IE=edge">
        <meta  name="viewport"  content="width=device-width, initial-scale=1">
        <title>FinancialFlo</title>
        </head>
    <body id="app-layout">
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
                    <form action="javascript:window.location.assign('/search/' + document.getElementById('search-text').value);" method="get">
                        <input type="text" name="search-text" id="search-text" placeholder="Search">
                        <input type="button" name="search-button" id="search-button">
                        </form>
                    </li>
                </ul>
            </div>
        <div id="companyinfo">
            <div id="companyheader">
                <#list companies as company>
                    <h1> ${company.companyName} </h1>
                    <h3> ${company.symbol} - ${company.stockExchange} <span class="quote">${company.ask}</span> <span class="change">${company.change}</span> </h3>
                </#list>
                </div>
            <div id="competitors">
                <h3>Competitors</h3>
                <#list competitors as comp>
                    <p><a href="/company/${comp}">${comp}</a><p>
                </#list>
            </div>
            <hr>
            <div id="company-body">
                <div id="company-chart">
                    <table id="chart-1" class="table table-bordered">
                        <caption> Valuation Measures </caption>
                        <thead>
                            <tr>
                                <th>Statistic</th>
                            <#list companies as company>
                                <th>${company.symbol}</th>
                            </#list>
                                </tr>
                            </thead>
                        <tbody>
                            <tr>
                                <td>Market Cap</td>
                            <#list companies as company>
                                <td>${company.marketCap}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Enterprise Value</td>
                            <#list companies as company>
                                <td>${company.enterpriseValue}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Trailing P/E</td>
                            <#list companies as company>
                                <td>${company.trailingPE}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Forward P/E</td>
                            <#list companies as company>
                                <td>${company.forwardPE}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Price/Sales</td>
                            <#list companies as company>
                                <td>${company.priceSales}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Price/Book</td>
                            <#list companies as company>
                                <td>${company.priceBook}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Enterprise Value/Revenue</td>
                            <#list companies as company>
                                <td>${company.enterpriseValueRevenue}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Enterprise Value/EBITDA</td>
                            <#list companies as company>
                                <td>${company.enterpriseValueEBIDTA}</td>
                            </#list>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                <div id="company-income-statement">
                    <table id="chart-2" class="table table-bordered">
                        <caption> Income Statement </caption>
                        <thead>
                            <tr>
                                <th>Statistic</th>
                            <#list companies as company>
                                <th>${company.symbol}</th>
                            </#list>
                                </tr>
                            </thead>
                        <tbody>
                            <tr>
                                <td>Revenue (ttm)</td>
                            <#list companies as company>
                                <td>${company.revenue}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Revenue Per Share (ttm)</td>
                            <#list companies as company>
                                <td>${company.revenuePerShare}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Quarterly Revenue Growth</td>
                            <#list companies as company>
                                <td>${company.qtrlyRevenueGrowth}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Gross Profit (ttm)</td>
                            <#list companies as company>
                                <td>${company.grossProfit}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>EBITDA (ttm)</td>
                            <#list companies as company>
                                <td>${company.EBITDA}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Net Income Avl to Common (ttm)</td>
                            <#list companies as company>
                                <td>${company.netIncomeAvlToCommon}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Diluted EPS</td>
                            <#list companies as company>
                                <td>${company.dilutedEPS}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Quarterly EarningsGrowth (yoy)</td>
                            <#list companies as company>
                                <td>${company.qtrlyEarningsGrowth}</td>
                            </#list>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                <div id="company-balance-sheet">
                    <table id="chart-3" class="table table-bordered">
                        <caption> Balance Sheet </caption>
                        <thead>
                            <tr>
                                <th>Statistic</th>
                            <#list companies as company>
                                <th>${company.symbol}</th>
                            </#list>
                                </tr>
                            </thead>
                        <tbody>
                            <tr>
                                <td>Total Cash (mrq)</td>
                            <#list companies as company>
                                <td>${company.totalCash}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Total Cash Per Share (mrq)</td>
                            <#list companies as company>
                                <td>${company.totalCashPerShare}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Total Debt (mrq)</td>
                            <#list companies as company>
                                <td>${company.totalDebt}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Total Debt/Equity (mrq)</td>
                            <#list companies as company>
                                <td>${company.totalDebtEquity}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Current Ratio (mrq)</td>
                            <#list companies as company>
                                <td>${company.currentRatio}</td>
                            </#list>
                                </tr>
                            <tr>
                                <td>Book Value Per Share (mrq)</td>
                            <#list companies as company>
                                <td>${company.bookValuePerShare}</td>
                            </#list>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
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


