/**
 * User: VinayG
 * Date: 7/16/13
 * Time: 4:16 PM
 */

employeeDirectoryModule.factory('simpleFactory', function($http){

    var factory = {};
    
    factory.getEmployees = function(){
        return $http.get('/EmployeeDirectory/rest/loadEmployees')
        .success(
            function(data, status, headers, config){
                console.log("success." );
            }
        ).error(
            function(data, status, headers, config){
                console.log("error." );
            }    
        );
    };

    factory.addEmployee = function(employee){
        return $http({
            url:"/EmployeeDirectory/rest/loadEmployees",
            method: "POST",
            data: {name:employee.name, project:employee.project, motto:employee.motto}
        }).success(
            function(data, status, headers, config){
                console.log("success." );
            }    
        ).error(
            function(data, status, headers, config){
                console.log('error');
            }        
        );
    };

    factory.deleteEmployee = function(employeeId){
        return $http({
            url:"/EmployeeDirectory/rest/loadEmployees/" + employeeId,
            method: "DELETE"
        }).success(
            function(data, status, headers, config){
                console.log("success." );
            }    
        ).error(
            function(data, status, headers, config){
                console.log('error');
            }        
        ); 
    };

    factory.updateEmployee = function(employee){
        return $http({
            url:"/EmployeeDirectory/rest/updateEmployees",
            method: "POST",
            data: employee
        }).success(
            function(data, status, headers, config){
                console.log('success');
            }
        ).error(
            function(data, status, headers, config){
                console.log('error');
            }
        );
    };

    factory.getEmployee = function(employeeId){
        return $http.get('/EmployeeDirectory/rest/loadEmployees/getById/' + employeeId)
        .success(
            function(data, status, headers, config){
                console.log('success');
            }
        ).error(
            function(data, status, headers, config){
                console.log('error');
            }
        );
    };


    return factory;
});