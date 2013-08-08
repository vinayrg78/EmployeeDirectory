/**
 * User: VinayG
 * Date: 7/16/13
 */

var SimpleController = function($scope, $location, simpleFactory){

    $scope.sortorder='name';
    $scope.searchBy='';

    var init = function(){
        $scope.getEmployees();
    };

    $scope.getEmployees = function(){
        simpleFactory.getEmployees().then(
            function(dataObj){
                $scope.employees = dataObj.data;
            }
        );
    }

    $scope.addNewEmployee = function(){
        simpleFactory.addEmployee($scope.newEmployee).then(
            function(dataObj){
                $scope.getEmployees();
            }        
        );
        
        $scope.newEmployee.name = '';
        $scope.newEmployee.project = '';
        $scope.newEmployee.motto = '';
    };

    $scope.deleteEmployee = function(employeeId){
        simpleFactory.deleteEmployee(employeeId).then(
            function(dataObj){
                $scope.getEmployees();
            }        
        );
    };

    $scope.loadDetails = function(employeeId){
        $location.path("/view2/" + employeeId);
    };
    
    init();
}


var MoreDetailsController = function($scope, $routeParams, simpleFactory){

    var init = function(){
        if($routeParams.employee !== null){

            simpleFactory.getEmployee($routeParams.employeeId).then(
                function(dataObj){
                    debugger;
                    $scope.selectedEmployee = dataObj.data;
                }
            );

            $scope.updated = false;
        }
    };

    $scope.updateEmployee = function(employee){

        simpleFactory.updateEmployee(employee).then(
          function(dataObj){
              $scope.updated = true;
          }
        );

    }

    init();
}


employeeDirectoryModule.controller('SimpleController', SimpleController);
employeeDirectoryModule.controller('MoreDetailsController', MoreDetailsController);
