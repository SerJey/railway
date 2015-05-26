'use strict';

angular.module('Authentication')

    .controller('LoginController',
    ['$scope', '$rootScope', '$location', 'AuthenticationService', 'api', 'dataService',
        function ($scope, $rootScope, $location, AuthenticationService, api, dataService) {
            // reset login status
            AuthenticationService.ClearCredentials();

/*            $scope.login = function () {
                $scope.dataLoading = true;
                AuthenticationService.Login($scope.username, $scope.password, function (response) {
                    if (response) {
                        $scope.name = response.username;
                        dataService.setProperty($scope.name);
                        $scope.authed = true;
                        //AuthenticationService.SetCredentials($scope.username, $scope.password, response, api);
                        //$location.path('/');
                    } else {
                        $scope.authed = false;
                        $scope.error = response.message;
                        $scope.dataLoading = false;
                    }
                });
            };*/
        }]);

