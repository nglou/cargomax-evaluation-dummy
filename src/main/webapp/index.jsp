<!DOCTYPE html>
<html>
<head>
<script src='angular.min.js'></script>
<script src='consume-rest.js'></script>
<style type="text/css">
/*Style for Table*/
table, th, td {
	border: 1px solid grey;
	border-collapse: collapse;
	padding: 4px;
	font-family: arial;
}
/*Style for Table Header*/
th {
	background: darkblue;
	color: white;
	text-align: left;
}
/*Style for Alternate Rows*/
table tr:nth-child(odd) {
	background-color: #C2EBC3;
}

table tr:nth-child(even) {
	background-color: #FFFFFF;
}
</style>
</head>
<body ng-app='consumeRestApp'>
	<h3>Evaluation Requests</h3>
	<table ng-controller='EvaluationRequestsCtrl'>
		<tr>
			<th>id</th>
			<th>seqNo</th>
			<th>awbNum</th>
			<th>bookingId</th>
			<th>requestTime</th>
			<th>details</th>
		</tr>
		<tr ng-repeat="evaluationRequest in evaluationRequests">
			<td>{{ evaluationRequest.id }}</td>
			<td>{{ evaluationRequest.seqNo }}</td>
			<td>{{ evaluationRequest.awbNum }}</td>
			<td>{{ evaluationRequest.bookingId }}</td>
			<td>{{ evaluationRequest.requestTime }}</td>
			<td>{{ evaluationRequest.details }}</td>
		</tr>
	</table>
	<input type="button" value="Clear All" onClick="clearEvaluationRequests()" />
	<br>
	<br>
	<h3>Evaluation Responses</h3>
	<table ng-controller='EvaluationResponsesCtrl'>
		<tr>
			<th>id</th>
			<th>seqNo</th>
			<th>awbNum</th>
			<th>bookingId</th>
			<th>responseTime</th>
			<th>details</th>
		</tr>
		<tr ng-repeat="evaluationResponse in evaluationResponses">
			<td>{{ evaluationResponse.id }}</td>
			<td>{{ evaluationResponse.seqNo }}</td>
			<td>{{ evaluationResponse.awbNum }}</td>
			<td>{{ evaluationResponse.bookingId }}</td>
			<td>{{ evaluationResponse.responseTime }}</td>
			<td>{{ evaluationResponse.details }}</td>
		</tr>
	</table>
	<input type="button" value="Clear All" onClick="clearEvaluationResponses()" />
	<br>
	<br>
	<h3>Default Response Status:</h3>
	<div ng-controller='DefaultStatusCtrl'>
		<form>
			Current: <b>{{ defaultStatus }}</b><br>
			Change to:
			<select name="newDefaultStatus">
				<option>EVC</option>
				<option>ERY</option>
				<option>ERN</option>
				<option>ARY</option>
				<option>ARN</option>
				<option>APP</option>
				<option>ADR</option>
			</select>
			<br/>
			<input type="button" value="Submit" onClick="submitDefaultStatus(this.form)" />
		</form>
	</div>
	<br>
	<br>
	<h3>Review Requests</h3>
	<table ng-controller='ReviewRequestsCtrl'>
		<tr>
			<th>id</th>
			<th>seqNo</th>
			<th>awbNum</th>
			<th>bookingId</th>
			<th>requestTime</th>
			<th>comment</th>
		</tr>
		<tr ng-repeat="reviewRequest in reviewRequests">
			<td>{{ reviewRequest.id }}</td>
			<td>{{ reviewRequest.seqNo }}</td>
			<td>{{ reviewRequest.awbNum }}</td>
			<td>{{ reviewRequest.bookingId }}</td>
			<td>{{ reviewRequest.requestTime }}</td>
			<td>{{ reviewRequest.comment }}</td>
		</tr>
	</table>
	<input type="button" value="Clear All" onClick="clearReviewRequests()" />
	<br>
	<br>
	<h3>Review Responses</h3>
	<table ng-controller='ReviewResponsesCtrl'>
		<tr>
			<th>id</th>
			<th>responseTime</th>
			<th>details</th>
		</tr>
		<tr ng-repeat="reviewResponse in reviewResponses">
			<td>{{ reviewResponse.id }}</td>
			<td>{{ reviewResponse.responseTime }}</td>
			<td>{{ reviewResponse.details }}</td>
		</tr>
	</table>
	<input type="button" value="Clear All" onClick="clearReviewResponses()" />
</body>
</html>