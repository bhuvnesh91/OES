<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Logandev:Login</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<link rel="stylesheet" media="all" type="text/css"
	href="<c:url value='/css/login.css'/>" />
</head>
<body onload='document.f.j_username.focus();'>
	<header>
		<div class="container" id="header">
			<div style="float: left;">
				<a href="#"><img class="mixLogo"
					src="<c:url value='/images/logo.png'/>"></a>
			</div>
		</div>
	</header>
	<section>
		<div class="container">
			<c:if test="${not empty error}">
				<div class="errorblock">
					Your login attempt was not successful, try again.<br /> Caused :
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</div>
			</c:if>
			<div class="form-bg">
				<form name='f' autocomplete="off"
					action="<c:url value='j_spring_security_check' />" method="post">
					<h2>
						<span style="float: left;"> <img src="images/ico_login.png"
							style="padding: 4px 6px; border-right: 1px solid #ddd;" />
						</span> <span style="padding-left: 6px;">Login</span>
					</h2>
					<p>
						<label for="login"><i class="icon-user"><img
								src="images/username_icon.png"></i>Username</label> <input type='text'
							name='j_username' value='' placeholder="Username" required=""></input>
					</p>

					<p>
						<label for="password"><i class="icon-lock"><img
								src="images/password.png"></i>Password</label> <input type='password'
							name='j_password' placeholder="Password" required=""></input>
					</p>
					<br />
					<!--label for="remember">
                         <input type="checkbox" id="remember" value="remember" />
                         <span>Remember me</span>
                       </label-->
					<button type="submit"></button>
				</form>
			</div>
			<p class="forgot">All rights reserverd. &copy; copyright bebo
				Technologies.</p>
		</div>
	</section>
</body>
</html>
