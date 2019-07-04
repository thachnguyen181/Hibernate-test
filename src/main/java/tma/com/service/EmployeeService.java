package tma.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import tma.com.model.EmployeeDTO;
import tma.com.repository.Employee;
import tma.com.repository.IEmployeeRepository;

public class EmployeeService implements IEmployeeService{

	@Autowired
	private IEmployeeRepository employeeRepo;
	
	@Override
	public List<EmployeeDTO> findAll() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepo.findAll();
		if (employees.isEmpty()) {	
			return null;
		}
		List<EmployeeDTO> result = new ArrayList();
		for (Employee employee : employees) {
			EmployeeDTO emp = new EmployeeDTO();
			emp.setId(employee.getId());
			emp.setName(employee.getName());
			emp.setEmail(employee.getEmail());
			result.add(emp);
		}
		return result;
		
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id);
	}
	
}
