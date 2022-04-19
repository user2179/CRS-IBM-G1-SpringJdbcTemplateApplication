package com.ibm.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bean.Employee;
import com.ibm.dao.EmployeeDAO;

@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDao;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET,value = "/listemployees")
	@ResponseBody
	public List<Employee> getEmployee() {	
		return employeeDao.listEmployees();
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method= RequestMethod.POST, value="/post/employees")
	@ResponseBody
	public ResponseEntity create(@RequestBody String name, Integer age,Integer id) {
		employeeDao.create(name,age,id);
		return new ResponseEntity(name,HttpStatus.OK);
		//return (ResponseEntity) employeeDao.listEmployees();
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT, value = "/put/employees/{id}")
	@ResponseBody
	@PutMapping("/put/customers/{id}")
	public void update(@PathVariable Integer id, @RequestBody Integer age) {
		employeeDao.update(id,age);

	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE, value = "/delete/employees/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {

		employeeDao.delete(id);

	}


    

}
