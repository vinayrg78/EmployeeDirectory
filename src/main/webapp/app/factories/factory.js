/**
 * User: VinayG
 * Date: 7/16/13
 * Time: 4:16 PM
 */

employeeDirectoryModule.factory('simpleFactory', function($http){

    var employeeCache = [];

    var factory = {};
    
    factory.getEmployees = function(){
        return $http.get('/EmployeeDirectory/rest/loadEmployees').success(
            function(data, status, headers, config){
                employeeCache = data;
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
                employeeCache.push({name:config.data.name, project:config.data.project, motto:config.data.motto});
            }    
        ).error(
            function(data, status, headers, config){
                console.log('error');
            }        
        );
    };

    factory.deleteEmployee = function(employee){
        return $http({
            url:"/EmployeeDirectory/rest/loadEmployees/" + employee.id,
            method: "DELETE"
        }).success(
            function(data, status, headers, config){
                var index = factory.getEmployeeIndex(data.id);
                employeeCache.splice(index, 1);
            }    
        ).error(
            function(data, status, headers, config){
                console.log('error');
            }        
        ); 
    };
    
    //operates on the cache
    factory.getEmployee = function(employeeId){
        var index = factory.getEmployeeIndex(employeeId);
        return employeeCache[index];
    };

    //operates on the cache
    factory.getEmployeeIndex = function(employeeId){
        var i;
        for(i = 0; i < employeeCache.length; i++){
            if(employeeCache[i].id === employeeId){
                break;
            }
        }
        return i;
    };

    factory.setEmployeeCache = function(employeeArray){
        employeeCache = employeeArray;
    };
    
    factory.getEmployeeCache = function(){
        return employeeCache;
    };
    
    return factory;
});