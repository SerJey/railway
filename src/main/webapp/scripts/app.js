'use strict';

// declare modules
angular.module('Authentication', []);
angular.module('Registration', []);
angular.module('Home', []);
angular.module('Main', [])

angular.module('BasicHttpAuthExample', [
    'Authentication',
    'Home',
    'Main',
    'Registration',
    'ngRoute',
    'ngCookies'
])

    .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {

        $httpProvider.responseInterceptors.push('httpInterceptor');

        $routeProvider
            .when('/register', {
                controller: 'RegController',
                templateUrl: 'modules/register/views/register.html',
                hideMenus: true
            })

            .when('/login', {
                controller: 'MainController',
                templateUrl: 'modules/authentication/views/login.html',
                hideMenus: true
            })

            .when('/', {
                controller: 'HomeController',
                templateUrl: 'modules/home/views/home.html'
            })

            .otherwise({redirectTo: '/register'});
    }])

    .run(['$rootScope', '$location', '$cookieStore', '$http', 'api',
        function ($rootScope, $location, $cookieStore, $http, api) {
            // keep user logged in after page refresh
            api.init();
            $rootScope.globals = $cookieStore.get('globals') || {};
            if ($rootScope.globals.currentUser) {
                $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
            }

/*            $rootScope.$on('$locationChangeStart', function (event, next, current) {
                // redirect to login page if not logged in
                if ($location.path() !== '/register' && !$rootScope.globals.currentUser) {
                    $location.path('/register');
                }
            });*/
        }]);

angular.module('Authentication').factory('httpInterceptor', function httpInterceptor ($q, $window, $location) {
    return function (promise) {
        var success = function (response) {
            return response;
        };

        var error = function (response) {
            if (response.status === 401) {
                $location.url('/login');
            }

            return $q.reject(response);
        };

        return promise.then(success, error);
    };
});

angular.module('Authentication').factory('api', function ($http, $cookies) {
    return {
        init: function (token) {
            $http.defaults.headers.common['X-Access-Token'] = token || $cookies.token;
        }
    };
});