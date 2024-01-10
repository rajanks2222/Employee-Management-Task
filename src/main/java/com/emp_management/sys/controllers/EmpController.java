package com.emp_management.sys.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp_management.sys.payloads.ApiResponse;
import com.emp_management.sys.payloads.EmpDto;
import com.emp_management.sys.payloads.EmpPageResp;
import com.emp_management.sys.service.EmpService;

@RestController
@RequestMapping("api/emp")
public class EmpController {
  @Autowired
  private EmpService empService;

  //Post - create user
  @PostMapping("/")
  public ResponseEntity < EmpDto > createEmp(@RequestBody EmpDto empDto) {
    EmpDto createEmpDto = this.empService.createEmp(empDto);
    return new ResponseEntity < > (createEmpDto, HttpStatus.CREATED);
  }

  //PUT - update 	user
  @PutMapping("/{empId}")
  public ResponseEntity < EmpDto > updateEmp(@RequestBody EmpDto empDto, @PathVariable("empId") Long eid) {
    EmpDto updatedEmp = this.empService.updateEmp(empDto, eid);
    return ResponseEntity.ok(updatedEmp);
  }

  //DELETE - delete user

  @DeleteMapping("/{empId}")
  public ResponseEntity < ApiResponse > deleteEmp(@PathVariable("empId") Long eid) {
    this.empService.deleteEmp(eid);
    return new ResponseEntity < ApiResponse > (new ApiResponse("Emp deleted Successfully", true), HttpStatus.OK);
  }
  //GET -user get
  @GetMapping("/")
  public ResponseEntity < EmpPageResp > getAllEmp(
    @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
    @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
    @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
    @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir

  ) {
    EmpPageResp emppageResp = this.empService.getAllEmp(pageNumber, pageSize, sortBy, sortDir);

    //return ResponseEntity.ok(this.empService.getAllEmp(pageNumber , pageSize));
    return new ResponseEntity < EmpPageResp > (emppageResp, HttpStatus.OK);
  }

  //GET -user get single user
  @GetMapping("/{empId}")
  public ResponseEntity < EmpDto > getSingleEmp(@PathVariable Long empId) {
    return ResponseEntity.ok(this.empService.getEmpById(empId));

  }
  
  // Search 
  
  @GetMapping("/emps/search/{keywords}")
  public ResponseEntity<List<EmpDto>> searchEmpByName(@PathVariable("keywords")String keywords){
		  List<EmpDto> result = this.empService.searchEmps(keywords);
	  return new ResponseEntity<List<EmpDto>>(result,HttpStatus.OK);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

}