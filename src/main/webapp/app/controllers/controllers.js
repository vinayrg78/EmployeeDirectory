/**
 * User: VinayG
 * Date: 7/16/13
 */

var SimpleController = function($scope, $location, simpleFactory){
    
    var init = function(){
        simpleFactory.getEmployees().then(
            function(dataObj){
                $scope.employees = dataObj.data;
            }
        );
    };

    $scope.addNewEmployee = function(){
        simpleFactory.addEmployee($scope.newEmployee).then(
            function(dataObj){
                $scope.employees = simpleFactory.getEmployeeCache();
            }        
        );
        
        $scope.newEmployee.name = '';
        $scope.newEmployee.project = '';
        $scope.newEmployee.motto = '';
    };

    $scope.deleteEmployee = function(employee){
        simpleFactory.deleteEmployee(employee).then(
            function(dataObj){
                $scope.employees = simpleFactory.getEmployeeCache();
            }        
        );
    };

    $scope.loadDetails = function(employee){
        $location.path("/view2/" + employee.id);
    };
    
    init();
}


var MoreDetailsController = function($scope, $routeParams, simpleFactory){

    var init = function(){
        if($routeParams.employeeId !== null){
            $scope.selectedEmployee = simpleFactory.getEmployee($routeParams.employeeId);
        }
    };
    
    init();
}


employeeDirectoryModule.controller('SimpleController', SimpleController);
employeeDirectoryModule.controller('MoreDetailsController', MoreDetailsController);
