'use strict';

angular.module('Registration')

    .controller('RegController',
    ['$scope', '$rootScope', '$location', 'RegisterService',
        function ($scope, $rootScope, $location, RegisterService) {

            $scope.register = function () {
                $scope.dataLoading = true;
                RegisterService.Register($scope.username, $scope.password, $scope.firstName, $scope.lastName, $scope.patronymic, function (response) {
                    if (response.success) {
                        $location.path('/');
                    } else {
                        $scope.error = response.message;
                        $scope.dataLoading = false;
                    }
                });
            };
        }]);