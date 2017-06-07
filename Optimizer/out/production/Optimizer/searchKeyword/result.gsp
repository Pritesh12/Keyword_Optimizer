<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Keyword Planner</title>
    <asset:stylesheet src="grails_stylesheet.css"/>
    <link rel="stylesheet" href="css/grails_stylesheet.css" type="text/css" />
</head>
<body>
<div id="grails-Bar">
    <div id="grails-Frame">
        <div id="logo" title="Go to GrailsBrains home"><a href="http://www.grailsbrains.com">GrailsBrains.com</a></div>
    </div>
</div>
<div>
    <table width="100%" align="center"
           style="border:0.6px solid #000000;">

        <tr style="background-color:lightgrey;width: 100%" >
            <td align="center"><b>Search terms</b></td>
            <td align="center"><b>Keywords(by relevance)</b></td>
            <td align="center"><b>Number of clicks</b></td>
            <td align="center"><b>Average Position</b></td>
            <td align="center"><b>CPC</b></td>

        </tr>
        <tr style="background-color:#ffffff;width: 100%">
            <td align="center"><%= searchKeyword %></td>
            <td align="center"><%= keyword %></td>
            <td align="center"><%= meanClicks %></td>
            <td align="center"><%= meanAveragePosition %></td>
            <td align="center"><%= meanAverageCpc %></td>

        </tr>

      %{--<g:fieldValue field="search" bean="searchKeyword"></g:fieldValue>--}%

        <!-- <tr>
            <td colspan=4 align="center"
                style="background-color:#eeffee"><b>No Record Found..</b></td>
        </tr> -->
        </table>
</div>
<div class="plannerbox">
    <div class="plannerboxinner">
        <div class="plannerheader">
        </div>
        <!--loginheader-->
        <div class="plannerform">
            <h2 style="color:#141823; text-align:center;">Plan Your Keywords</h2>
            <form id="login" action="" method="post">
                <p>
                    By Number of Hits &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="email" name="email" placeholder="Enter No of Hits" />
                </p>
                <p>
                    By Amount of Cost  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" id="password" name="login[password]" placeholder="Enter Cost"/>
                </p>
                <p>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="radius title" name="login" >Submit</button>
                </p>
            </form>
        </div>
    </div>
</div>

<div class="footer">

</div>

</body>
</html>