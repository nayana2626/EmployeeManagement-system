package com.employee.util;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;


public class EmployeeEntityDtoUtil {
	
	public static EmployeeDto entityToDto(Employee e) {
		return new EmployeeDto(e.getId(), e.getName(), e.getAddress(), e.getAge());
	}
	
	public static Employee dtoToEntity(EmployeeDto e) {
		return new Employee(e.getId(), e.getName(), e.getAddress(), e.getAge() );
	}

}