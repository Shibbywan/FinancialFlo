/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var BASE_URI = 'http://query.yahooapis.com/v1/yql';
var yql_results ="";
var yql_query = "SELECT * FROM yahoo.finance.balancesheet WHERE symbol='KMB'";


function handler(rsp) {
    if(rsp.data) {
        yql_results = rsp.data; 
    }
    console.log(rsp.data.toString());
}




