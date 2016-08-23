<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<f:view>
	<h:form>
		<h:outputText value="Event ID"></h:outputText>
		<h:inputText value="#{EventBean.eventId }"></h:inputText>
		<h:outputText value="Event Name"></h:outputText>
		<h:inputText value="#{EventBean.eventName }"></h:inputText>
		<h:outputText value="Event Category"></h:outputText>
		<h:inputText value="#{EventBean.eventCategory }"></h:inputText>
		<h:outputText value="Event Date"></h:outputText>
		<h:inputText value="#{EventBean.eventDate }"></h:inputText>
		<h:outputText value="Ticket Price"></h:outputText>
		<h:inputText value="#{EventBean.ticketPrice }"></h:inputText>
		<h:outputText value="Seats Available"></h:outputText>
		<h:inputText value="#{EventBean.allSeats }"></h:inputText>
		<h:outputText value="Enter seat Status"></h:outputText>
		<h:inputText value="#{EventBean.seatStatus }"></h:inputText>
		<h:commandButton action="#{EventBean.createEvent }" value="Create"></h:commandButton>
	</h:form>
</f:view>
</body>
</html>