Imports MaasOne.Base
Imports MaasOne.Finance.YahooFinance
Imports MaasOne.Finance

Imports System
Imports System.Net
Imports System.IO


Public Class GUI

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Download()
    End Sub
    Public Sub Download()
        'Parameters'
        Dim ids As IEnumerable(Of String) = New String() {"MSFT", "GOOG", "YHOO"}

        'Download'
        Dim dl As New CompanyStatisticsDownload
        dl.Settings.ID = "YHOO"
        Dim resp As Response(Of CompanyStatisticsResult) = dl.Download()

        'Response/Result'
        If resp.Connection.State = ConnectionState.Success Then
            Dim gg = resp.Result.Item.FinancialHighlights.CurrentRatio
        End If
    End Sub
    Private Function RequestWebData(ByVal pstrURL As String) As String
        Dim objWReq As WebRequest
        Dim objWResp As WebResponse
        Dim strBuffer As String
        objWReq = HttpWebRequest.Create(pstrURL)
        objWResp = objWReq.GetResponse()
        Dim objSR As StreamReader
        objSR = New StreamReader(objWResp.GetResponseStream)
        strBuffer = objSR.ReadToEnd
        objSR.Close()
        objWResp.Close()
        Return strBuffer
    End Function

    Public Function GetQuoteLatest(ByVal pstrSymbol As String) As String
        Dim strURL As String
        Dim strBuffer As String
        'Creates the request URL for Yahoo
        strURL = "http://quote.yahoo.com/d/quotes.csv?" & _
                 "s=" & pstrSymbol & _
                 "&d=t" & _
                 "&f=sl1d1t1c1ohgvj1pp2wern"

        strBuffer = RequestWebData(strURL)

        'Loop through the lines returned and transform it to a XML string
        Dim strReturn As New System.Text.StringBuilder
        strReturn.Append("" & Environment.NewLine)
        For Each strLine As String In strBuffer.Split(ControlChars.Lf)
            If strLine.Length > 0 Then
                strReturn.Append(TransformLatestLine(strLine) & Environment.NewLine)
            End If
        Next
        strReturn.Append("" & Environment.NewLine)

        Return strReturn.ToString
    End Function

    Private Function TransformLatestLine(ByVal pstrLine As String) As String
        Dim arrLine() As String
        Dim strXML As New System.Text.StringBuilder

        arrLine = pstrLine.Split(","c)

        strXML.Append("")
        strXML.Append("" & arrLine(0).Replace(Chr(34), "") & "")
        strXML.Append("" & arrLine(1) & "")
        strXML.Append("" & arrLine(2).Replace(Chr(34), "") & "")
        strXML.Append("" & arrLine(3).Replace(Chr(34), "") & "")
        strXML.Append("" & arrLine(4) & "")
        strXML.Append("" & arrLine(5) & "")
        strXML.Append("" & arrLine(6) & "")
        strXML.Append("" & arrLine(7) & "")
        strXML.Append("" & arrLine(8) & "")
        strXML.Append("" & arrLine(9) & "")
        strXML.Append("" & arrLine(10) & "")
        strXML.Append("" & arrLine(11).Replace(Chr(34), "") & "")
        strXML.Append("" & arrLine(12).Replace(Chr(34), "") & "")
        strXML.Append("" & arrLine(13) & "")
        strXML.Append("" & arrLine(14) & "")
        strXML.Append("" & arrLine(15).Replace(Chr(34), "") & "")
        strXML.Append("")
        Return strXML.ToString
    End Function
End Class
