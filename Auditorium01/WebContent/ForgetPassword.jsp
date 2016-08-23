<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CHANGE PASSWORD</title>
<style>
table.center {
    margin: 0px auto;
	margin-top: 33%;
}
body {
	color: white;
	background-image: url("Auditor.jpg");
	background-position:cover;
	text-align: center;
}
</style>
</head>
<f:view>
	<h:form>
			<table class="center">
			<tr><td><h:outputText value="USERNAME "></h:outputText></td>
			<td><h:inputText value="#{LoginBean.userName}" required="true"></h:inputText></td></tr>
			<tr><td><h:outputText value="NEWPASSWORD "></h:outputText></td>
			<td><h:inputText value="#{LoginBean.passWord}" required="true"></h:inputText></td></tr>
			<tr><td><h:outputText value="CONFORM PASSWORD"></h:outputText></td>
			<td><h:inputText value="#{LoginBean.confirmPassword}" required="true"></h:inputText><td></tr>
			<tr><td></td><td><h:commandButton action="#{LoginBean.forgotPassword}"
				value="CHANGE PASSWORD"></h:commandButton></td></tr>
			</table>
	</h:form>
</f:view>
</body>
</html>