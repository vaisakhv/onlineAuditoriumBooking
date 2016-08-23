<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Events</title>
<style type="text/css">
.datepickerdemoBasicUsage {
  /** Demo styles for mdCalendar. */ }
  .datepickerdemoBasicUsage md-content {
    padding-bottom: 200px; }
  .datepickerdemoBasicUsage .validation-messages {
    font-size: 12px;
    color: #dd2c00;
    margin-left: 15px; }


/*
Copyright 2016 Google Inc. All Rights Reserved. 
Use of this source code is governed by an MIT-style license that can be foundin the LICENSE file at http://material.angularjs.org/HEAD/license.
*/
</style>
<script src="angular.min.js"></script>
<script src="angular-datepicker.js">
angular.module('MyApp',['ngMaterial', 'ngMessages', 'material.svgAssetsCache']).controller('AppCtrl', function($scope) {
	  $scope.myDate = new Date();

	  $scope.minDate = new Date(
	      $scope.myDate.getFullYear(),
	      $scope.myDate.getMonth() - 2,
	      $scope.myDate.getDate());

	  $scope.maxDate = new Date(
	      $scope.myDate.getFullYear(),
	      $scope.myDate.getMonth() + 2,
	      $scope.myDate.getDate());

	  $scope.onlyWeekendsPredicate = function(date) {
	    var day = date.getDay();
	    return day === 0 || day === 6;
	  };
	});
</script>
</head>
<body ng-app="MyApp">
<f:view>
	<h:form>
		<h:panelGrid>
		<div ng-controller="AppCtrl" ng-cloak="" class="datepickerdemoBasicUsage" >
			<h:outputText value="date"></h:outputText>
			<h:inputText ng-model="myDate"></h:inputText>
		</div>
		</h:panelGrid>
	</h:form>
</f:view>
</body>
</html>