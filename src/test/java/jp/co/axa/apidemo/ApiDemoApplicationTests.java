package jp.co.axa.apidemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ApiDemoApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static final String ROOT_URL = "/api/v1/employees";
	private static final int STATUS_SUCCESS = 200;

	private Long createEmployeeId() {
		Employee employee = new Employee();
		employee.setName("AXA TARO");
		employee.setDepartment("Sales");
		employee.setSalary(10000);
		Employee result = employeeRepository.save(employee);
		return result.getId();
	}

	private static String requestBody = "{\n" +
			"  \"department\": \"sales\",\n" +
			"  \"id\": \"9999\",\n" +
			"  \"name\": \"AXA TARO\",\n" +
			"  \"salary\": \"20000\" \n}";

	@Test
	public void contextLoads() {
	}

	@Test
	public void getEmployeesTest() {
		RestAssured.given()
				.when().get(ROOT_URL)
				.then().assertThat().statusCode(STATUS_SUCCESS);
	}

	@Test
	public void getEmployeeTest() {
		RestAssured.given()
				.when().get(ROOT_URL + "/" + createEmployeeId())
				.then().assertThat().statusCode(STATUS_SUCCESS);
	}

	@Test
	public void saveEmployeeTest() {
		RestAssured.given()
				.body(requestBody).header("Content-Type", "application/json")
				.when().post(ROOT_URL)
				.then().assertThat().statusCode(STATUS_SUCCESS);
	}

	@Test
	public void deleteEmployeeTest() {
		RestAssured.given()
				.when().delete(ROOT_URL + "/" + createEmployeeId())
				.then().assertThat().statusCode(STATUS_SUCCESS);
	}

	@Test
	public void updateEmployeeTest() {
		RestAssured.given()
				.body(requestBody).header("Content-Type", "application/json")
				.when().put(ROOT_URL + "/" + createEmployeeId())
				.then().assertThat().statusCode(STATUS_SUCCESS);
	}
}
