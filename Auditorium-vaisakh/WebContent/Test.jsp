<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Test</title>
</head>

<body>
<f:view>
	<h:form>
		<h:selectManyCheckbox value="#{}">
			<f:selectItem itemValue="1" itemLabel="A01"/>
			<f:selectItem itemValue="2" itemLabel="A02"/>
		</h:selectManyCheckbox>
		<h:commandButton action="#{TestBean.testMethod}" value="submit"></h:commandButton>
	</h:form>
</f:view>
</body>
</html>