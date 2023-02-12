### What I did
- EmployeeController.java
  - Added check for deleteEmployee and updateEmployee that only when employeeId exists will perform deletion/update.
- Employee.java
  - Move @Getter and @Setter to class level.
- EmployeeNotFoundException.java
  - Newly added for dealing with the situation when the employeeId does not exist.
- EmployeeService.java
  - Changed the return type of method getEmployee from Employee to <Optional> Employee so that it is easier to know there is a risk of getting null wehn calling the method.
- EmployeeServiceImpl.java
  - Added @Override to take advantage from compiler checking.
  - Added the logic for method of getEmployee that only fetching the employeeId when it exists and when the employeeId requested does not exist inside the database, throw error. 
- ApiDemoApplicationTests.java
  - Added the tests for every method inside the EmployeeController.java.

### What I would have done if having more time

- Add logic to deal with token
- Add access limit by integrating with Spring Security
- Add swagger annotations
- Try the new version of Swagger 3(OpenAPI 3)


#### My experience in Java

- I have been using Java for many years mainly with Android development and just began to learn Spring Boot.
