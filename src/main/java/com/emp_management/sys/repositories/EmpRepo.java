package com.emp_management.sys.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emp_management.sys.entities.Emp;
import com.emp_management.sys.payloads.EmpDto;

public interface EmpRepo extends JpaRepository<Emp, Long>{

	//List<EmpDto> findByNameContaining(String name);
//  @Query("select e from emp_manage_sys where e.name like : key")
//	List<Emp> searchByName(@Param("key")String keyword);
}
