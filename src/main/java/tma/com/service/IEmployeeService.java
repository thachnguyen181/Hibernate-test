package tma.com.service;

import java.util.List;
import java.util.Optional;

import tma.com.model.EmployeeDTO;
import tma.com.repository.Employee;

public interface IEmployeeService {
	public List<EmployeeDTO> findAll();
	public Optional<Employee> findById(long id);
}
