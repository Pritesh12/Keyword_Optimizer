<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Search Keyword</title>

    <asset:stylesheet src="grails_stylesheet.css"/>
    <link rel="stylesheet" href="css/grails_stylesheet.css" type="text/css" />
</head>
<body class="login">
<!-- header starts here -->
<div id="grails-Bar">
    <div id="grails-Frame">
        <div id="logo" title="Go to GrailsBrains home"><a href="http://www.grailsbrains.com">GrailsBrains.com</a></div>
    </div>
</div>
<!-- header ends here -->
<br><br><br>
<div class="Searchbox" align="center">
    <h2 style="color:#141823; text-align:center;">Search Keyword</h2>
    <div class="Searchboxinner">
        <div class="Searchheader">
        </div>
        <!--loginheader-->
        <div class="keyword_search">
            <form id="login" action="/searchKeyword" method="get">

                <p>
                    <input type="search" id="search" name="search" placeholder="Search by Phrase, Website or Category" />
                </p>
                <p>
                    <button class="radius title" name="search_button" >Search</button>
                </p>
            </form>
        </div>
    </div>
</div>
<div class="footer">

</div>
</body>
</html>