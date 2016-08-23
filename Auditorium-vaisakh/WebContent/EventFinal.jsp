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
	<!-- 
SQL> desc allevents;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 EVENTID                                   NOT NULL VARCHAR2(20)
 EVENTNAME                                 NOT NULL VARCHAR2(30)
 EVENTDATE                                 NOT NULL DATE
 EVENTCATEGORY                             NOT NULL VARCHAR2(20)
 TICKETPRICE                                        NUMBER(10,2)
 SEATSTATUS                                         NUMBER
 ALLSEATS                                           VARCHAR2(50)
	 -->
		<h:outputText value="Event ID"></h:outputText>
		<h:inputText value="#{EventBean.eventId }"></h:inputText>
		<h:outputText value="Event Name"></h:outputText>
		<h:inputText value="#{EventBean.eventName }"></h:inputText>
		<h:outputText value="Category"></h:outputText>
		<h:inputText value="#{EventBean.eventCategory }"></h:inputText>
		<h:outputText value="Date(mm-dd-yyyy)"></h:outputText>
		<h:inputText value="#{EventBean.eventDate }"></h:inputText>
		<h:outputText value="Select seats"></h:outputText>
		<h:selectManyCheckbox value="#{EventBean.selectedSeats}">
			<f:selectItem itemValue="0" itemLabel="A01"/>
			<f:selectItem itemValue="1" itemLabel="A02"/>
			<f:selectItem itemValue="2" itemLabel="A03"/>
		</h:selectManyCheckbox>
		<h:commandButton action="#{EventBean.bookATicket }" value="Book"></h:commandButton>
	</h:form>
</f:view>
</body>
</html>