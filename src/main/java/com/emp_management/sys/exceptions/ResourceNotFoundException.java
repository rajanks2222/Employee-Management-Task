package com.emp_management.sys.exceptions;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	String resourceName;
	String  fieldName;
	long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, long empId) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,empId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = empId;
	}
	
}
