<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Login for Adwords Optimizer</title>

    <asset:stylesheet src="grails_stylesheet.css"/>

</head>

<body class="login">
<!-- header starts here -->
<div id="grails-Bar">
    <div id="grails-Frame">
        <div id="logo" title="Go to GrailsBrains home"><a href="http://www.grailsbrains.com">GrailsBrains.com</a></div>
    </div>
</div>
<!-- header ends here -->
<div class="loginbox">
    <h2 style="color:#141823; text-align:center;">Log in to Adwords Optimizer</h2>
    <div class="loginboxinner">
        <div class="loginheader">
        </div>
        <!--loginheader-->
        <div class="loginform">
            <form id="login" action="/login/authenticate" method="post">
                <input type='hidden' name='spring-security-redirect'
                       value='/secure' />
                <p>
                    <input type="text" id="email" name="username" placeholder="Enter Email" />
                </p>
                <p>
                    <input type="password" id="password" name="password" placeholder="Enter Password"/>
                    <!-- To show password -->
                <div class="hide-show">
                    <span>Show</span>
                </div>
                <!-- create a password vision eye -->
            </p>
                <p>
                    <button class="radius title" name="login" >Log in</button>
                </p>
            </form>
            <br>
        %{--link to another page using create link --}%
            <a href="">Forget Password?</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="">Sign up for adwords optimizer</a>
        </div>
    </div>
</div>
<div class="footer">

</div>
</body>
</html>