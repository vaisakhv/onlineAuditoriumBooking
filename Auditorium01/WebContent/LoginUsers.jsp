<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LOGIN</title>
<style>
table.center {
    margin: 0px auto;
	margin-top: 33%;
}
div {
    margin: 0px auto;
	margin-top: 3%;
}
body {
	color: white;
	background-image: url("Auditor.jpg");
	background-position: cover;
	text-align: center;
}
</style>
</head>
<body>
	<f:view>
		<h:form>
		<table class="center">
		<tr><td><h:outputText value="USERNAME "></h:outputText></td>
			<td><h:inputText value="#{LoginBean.userName}" required="true"></h:inputText></td></tr>
			<tr><td><h:outputText value="PASSWORD "></h:outputText></td>
			<td><h:inputSecret value="#{LoginBean.passWord}" required="true"></h:inputSecret></td></tr>
			<tr><td></td><td><h:commandButton action="#{LoginBean.login}" value="LOGIN"></h:commandButton></td></tr>
		</table>
			<div>
			<a href="http://localhost:8082/LoginForAuditorium/ForgetPassword.ust">FORGET PASSWORD</a>
			</div>
		</h:form>
	</f:view>
</body>
</html>