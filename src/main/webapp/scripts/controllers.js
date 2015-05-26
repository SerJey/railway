'use strict';

angular.module('Main')

    .controller('MainController',
    ['$scope', '$rootScope', '$location', 'dataService', 'AuthenticationService',
        function MainController($scope, $rootScope, $location, dataService, AuthenticationService) {
            $rootScope.authed = false;
            $scope.isActive = function (viewLocation) {
                return viewLocation === $location.path();
            };
            //$scope.$watch(function () {return dataService.getAuth()}, function(newValue){$scope.authed=newValue;});
            //$scope.$watch(function () {return dataService.getProperty();         }, function (value) {
            //    $scope.name = value;
            //});

            $scope.login = function () {
                $scope.dataLoading = true;
                AuthenticationService.Login($scope.username, $scope.password, function (response) {
                    if (response) {
                        //dataService.setProperty(response.username);
                        $rootScope.name = response.username;
                        dataService.setAuth(true);
                        $rootScope.authed = true;
                        //AuthenticationService.SetCredentials($scope.username, $scope.password, response, api);
                        //$location.path('/');
                        $scope.dataLoading = false;
                    } else {
                        //dataService.setAuth(false);
                        $rootScope.authed = false;
                        $scope.error = response.message;
                        $scope.dataLoading = false;
                    }
                });
            };
        }])

    .service('dataService', function () {
        var property = 'Qwerty';
        var auth = false;
        return {
            getProperty: function () {
                return property;
            },
            setProperty: function(value) {
                property = value;
            },
            getAuth: function () {
                return auth;
            },
            setAuth: function (value) {
                auth = value;
            }
        };
    });