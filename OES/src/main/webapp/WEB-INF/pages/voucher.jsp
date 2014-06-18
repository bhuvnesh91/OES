<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voucher</title>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.1.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form action="validate" name="Voucher">
			<span class="error" style="color: red; font-size: 20px">${error}</span>
			<label for="voucher">Enter Voucher Number</label> <input type="text"
				name="value" required="required" />
			<button type="submit">Enter</button>
		</form>
	</div>
</body>
</html>