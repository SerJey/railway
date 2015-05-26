'use strict';

angular.module('Registration')

    .factory('RegisterService',
    ['$http',
        function ($http) {
            var service = {};

            service.Register = function (username, password, firstName, lastName, patronymic, callback) {

                $http.post('/railway-1.0-SNAPSHOT/rest/register/user', {
                    username: username, password: password,
                    firstName: firstName, lastName: lastName, patronymic: patronymic
                })
                    .success(function (response) {
                        callback(response);
                    }).error(function (response) {
                        callback(response)
                    });

            };


            return service;
        }])


    /* jshint ignore:end */
;