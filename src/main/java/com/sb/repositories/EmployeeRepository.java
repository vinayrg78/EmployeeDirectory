package com.sb.repositories;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Repository;

import com.sb.domain.Employee;
 
/**
 * Repository for {@link Employee}s
 *
 */
@Repository
public class EmployeeRepository {
 
 
    @Autowired
    MongoTemplate mongoTemplate;
 
    public List<Employee> getAllEmployees() {
        return mongoTemplate.findAll(Employee.class);
    }
 
    public void insertEmployee(Employee emp) {
        mongoTemplate.insert(emp);
    }
    
    public Employee deleteEmployee(String id) {
        return mongoTemplate.findAndRemove(new Query(where("id").is(id)), Employee.class);
    }
    
    
    public List<Employee> findEmployeeByName(String name){
    	return mongoTemplate.find(new Query(where("name").is(name)), Employee.class);
    }
 

}