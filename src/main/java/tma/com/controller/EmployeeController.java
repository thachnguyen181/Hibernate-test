package tma.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tma.com.model.EmployeeDTO;
import tma.com.repository.Employee;
import tma.com.service.IEmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeServ;
	
	/* ---------------- GET ALL EMPLOYEE ------------------------ */
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeDTO>> getAll() {
		return new ResponseEntity<List<EmployeeDTO>>(employeeServ.findAll(), HttpStatus.OK);
	}
	
	/* ---------------- GET LOCATION BY ID ------------------------ */
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployeeById(@PathVariable int id) {
		Employee employee = employeeServ.findById(id).get();
		if (employee != null) {
			return new ResponseEntity<Object>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Not Found Location", HttpStatus.NO_CONTENT);
	}
}
