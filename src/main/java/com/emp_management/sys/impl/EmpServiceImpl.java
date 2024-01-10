package com.emp_management.sys.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.emp_management.sys.entities.Emp;
import com.emp_management.sys.exceptions.ResourceNotFoundException;
import com.emp_management.sys.payloads.EmpDto;
import com.emp_management.sys.payloads.EmpPageResp;
import com.emp_management.sys.repositories.EmpRepo;
import com.emp_management.sys.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
  @Autowired
  private EmpRepo empRepo;
private Object modelMapper;

  @Override
  public EmpDto createEmp(EmpDto empDto) {

    Emp emp = this.dtoToEmp(empDto);
    Emp savedEmp = this.empRepo.save(emp);
    return this.empToDto(savedEmp);
  }

  public EmpDto updateEmp(EmpDto empDto, long empId) {

    Emp emp = this.empRepo.findById(empId).orElseThrow();

    emp.setName(empDto.getName());
    emp.setPosition(empDto.getPosition());
    emp.setDepartment(empDto.getDepartment());
    emp.setSalary(empDto.getSalary());

    Emp updateEmp = this.empRepo.save(emp);
    EmpDto empDto1 = this.empToDto(updateEmp);
    return empDto1;
  }

  public EmpDto getEmpById(Long empId) {
    Emp emp = this.empRepo.findById(empId)
      .orElseThrow(() -> new ResourceNotFoundException("Emp", " Id ", empId));

    return this.empToDto(emp);
  }
  @Override
  //public List<EmpDto> getAllEmp(Integer pageNumber ,Integer pageSize) {
  public EmpPageResp getAllEmp(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

    Sort sort = null;
    if (sortDir.equalsIgnoreCase("asc")) {
      sort = Sort.by(sortBy).ascending();
    } else {
      sort = Sort.by(sortBy).descending();
    }

    PageRequest p = PageRequest.of(pageNumber, pageSize, sort);

    Page < Emp > empsPage = this.empRepo.findAll(p);

    List < Emp > allEmps = empsPage.getContent();

    List < EmpDto > empDtos = empsPage.stream().map(emp -> this.empToDto(emp)).collect(Collectors.toList());

    EmpPageResp emppageResp = new EmpPageResp();

    emppageResp.setContent(empDtos);
    emppageResp.setPageNumber(empsPage.getNumber());
    emppageResp.setPageSize(empsPage.getSize());
    emppageResp.setTotalElements(empsPage.getTotalElements());
    emppageResp.setTotalPages(empsPage.getTotalPages());
    emppageResp.setLastPage(empsPage.isLast());

    return emppageResp;
  }

  public void deleteEmp(Long empId) {

    Emp emp = this.empRepo.findById(empId).orElseThrow();
    this.empRepo.delete(emp);
  }

  private Emp dtoToEmp(EmpDto empDto) {
    Emp emp = new Emp();
    emp.setId(empDto.getId());
    emp.setName(empDto.getName());
    emp.setPosition(empDto.getPosition());
    emp.setDepartment(empDto.getDepartment());
    emp.setSalary(empDto.getSalary());
    return emp;
  }

  public EmpDto empToDto(Emp emp) {
    EmpDto empDto = new EmpDto();
    empDto.setId(emp.getId());
    empDto.setName(emp.getName());
    empDto.setPosition(emp.getPosition());
    empDto.setDepartment(emp.getDepartment());
    empDto.setSalary(emp.getSalary());

    return empDto;
  }

@Override
public List<EmpDto> searchEmps(String keyword) {
	// TODO Auto-generated method stub
	return null;
}
  
  //Search
  //@Override
  //public List<EmpDto> searchEmps(String keyword){  //ok
	//List<Emp> empse = this.empRepo.searchByName("%"+keyword+"%");//ok
	//List<EmpDto> empsearch = emps.stream().map((name)->this.modelMapper(name, EmpDto.class)).collect(Collectors.toList());
	
	//List<EmpDto> empDto = emps.stream().map((emp)->this.modelMapper.map(emp, EmpDto.class)).collect(Collectors.toList());
	//  return empsearch;
 // }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

}