var app = angular.module('consumeRestApp', []);

app.controller("EvaluationRequestsCtrl", function($scope, $http) {
	$http.get("./rest/evaluations/requests").then(function(res) {
		$scope.evaluationRequests = res.data;
	});
});

app.controller("EvaluationResponsesCtrl", function($scope, $http) {
	$http.get("./rest/evaluations/responses").then(function(res) {
		$scope.evaluationResponses = res.data;
	});
});

app.controller("DefaultStatusCtrl", function($scope, $http) {
	$http.get("./rest/evaluations/defaultstatus").then(function(res) {   
        $scope.defaultStatus = res.data;
    });                     
});

app.controller("ReviewRequestsCtrl", function($scope, $http) {
	$http.get("./rest/reviews/requests").then(function(res) {
		$scope.reviewRequests = res.data;
	});
});

app.controller("ReviewResponsesCtrl", function($scope, $http) {
	$http.get("./rest/reviews/responses").then(function(res) {
		$scope.reviewResponses = res.data;
	});
});

function submitDefaultStatus(form) {
	var path = './rest/evaluations/defaultstatus';
	var params = 'newDefaultStatus=' + form.newDefaultStatus.value;
	submitForm(path, params);
}

function clearEvaluationRequests() {
	var path = './rest/evaluations/requests/clear';
	var params = '';
	submitForm(path, params);
}

function clearEvaluationResponses() {
	var path = './rest/evaluations/responses/clear';
	var params = '';
	submitForm(path, params);
}

function clearReviewRequests() {
	var path = './rest/reviews/requests/clear';
	var params = '';
	submitForm(path, params);
}

function clearReviewResponses() {
	var path = './rest/reviews/responses/clear';
	var params = '';
	submitForm(path, params);
}

function submitForm(path, params) {
    var http = new XMLHttpRequest();
    http.open("POST", path, true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send(params);
    http.onload = function() {
        //alert(http.responseText);
    	window.location.reload();
    }
}