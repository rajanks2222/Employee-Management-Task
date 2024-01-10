package com.emp_management.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp_management.sys.entities.Emp;
import com.emp_management.sys.payloads.EmpDto;
import com.emp_management.sys.payloads.EmpPageResp;
@Service

public interface EmpService {
  EmpDto createEmp(EmpDto emp);
  EmpDto updateEmp(EmpDto emp, long empId);
  EmpDto getEmpById(Long empId);
  //	List<EmpDto> getAllEmp(Integer pageNumber ,Integer pageSize);
  EmpPageResp getAllEmp(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
  void deleteEmp(Long empId);
  
  
  
List<EmpDto> searchEmps(String keyword);

  //Search 
 // List<EmpDto> searchEmps(String keyword);
 // List<Emp> findByNameContaining(String name);
  
  
  
}