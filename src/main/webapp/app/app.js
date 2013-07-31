/**
 * Created with JetBrains WebStorm.
 * User: VinayG
 * Date: 7/18/13
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */


var employeeDirectoryModule = angular.module('employeeDirectoryModule', []);

employeeDirectoryModule.config(function($routeProvider){
    $routeProvider
        .when('/view1', {
            controller  : 'SimpleController',
            templateUrl : '/EmployeeDirectory/app/partials/view1.html'
        })
        .when('/view2/:employeeId', {
            controller  : 'MoreDetailsController',
            templateUrl : '/EmployeeDirectory/app/partials/view2.html'
        })
        .otherwise({ redirectTo: '/view1/'});
});