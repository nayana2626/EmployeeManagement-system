package com.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.employee.util.EmployeeEntityDtoUtil;
import com.employee.dto.EmployeeDto;
import com.employee.exceptioncase.EmployeeNotFound;
import com.employee.repository.EmployeeRepository;

@Component
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<EmployeeDto> getAll() {
		return employeeRepository.findAll().stream().map(EmployeeEntityDtoUtil::entityToDto).collect(Collectors.toList());
	}
	
	public EmployeeDto getById(Long id) {
		//return employeeRepository.findById(id).map(EmployeeEntityDtoUtil::entityToDto).orElse(null);
		Optional<EmployeeDto> optionalEmployee = Optional.ofNullable(employeeRepository.findById(id).map(EmployeeEntityDtoUtil::entityToDto).orElse(null));	
		
		return optionalEmployee.orElseThrow();
	}
	
	public void deleteById(Long id) {
		//employeeRepository.deleteById(id);
		employeeRepository.findById(id).orElseThrow(
				() ->new EmployeeNotFound("Check the input" +id));
		employeeRepository.deleteById(id);
		
	
	}
	
	public EmployeeDto save(EmployeeDto e) {
		return EmployeeEntityDtoUtil.entityToDto(employeeRepository.save(EmployeeEntityDtoUtil.dtoToEntity(e)));
	}
	
	 public EmployeeDto updateEmployee(EmployeeDto newEmployee, Long empId) {
	        //return employeeRepository.save(employee) ;
	        //return employeeService.findByEmployeeId(id)
	        return employeeRepository.findById(empId)
	                .map(employees -> {
	                    employees.setId(newEmployee.getId());
	                    employees.setName(newEmployee.getName());
	                    employees.setAddress(newEmployee.getAddress());
	                    employees.setAge(newEmployee.getAge());
	                  return employeeRepository.save(employees);
	                })
	                .orElseGet(() -> {
	                    newEmployee.setId(empId);
	                    return employeeRepository.save(EmployeeEntityDtoUtil.dtoToEntity(newEmployee));
	                });
	    }

}
