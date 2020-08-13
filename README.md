# spring-security-cloud-hotelmanag
Eureka server configured on port 8080 
config server configured on port 8081

git repository for services : https://github.com/faizankhan030/spring-config-server-master


 

End Points of Application: 

Manager Service
  - manager/employees
  - manager/addemployee(Post)
  - manager/updateemployee(PUT)
  - manager/deleteemployee(DELETE)
  
  
Employee Service
End Points: 
  - employee/employees
  - employee/addemployee(Post)
  - employee/updateemployee(PUT)
  - employee/deleteemployee(DELETE)
  
  employee details needed to be passed:
  
    {
    "Id": ,//Long value
    "firstName":"",
    "lastName":"",
    "department":"",//String
    "contactNumber", //Long Value
    }
    
    
    
 -In this application an inmemory user is used
 - Basic Auth is used for Authorization
 
