package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Emp;
import com.example.util.Pagination;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmpMapperTests {
	@Autowired
	EmpMapper empMapper;
	
	
	@Test
	public void test01_confirmTest(){
		System.out.println("empMapper = " + empMapper);
	}
	@Test
	public void test_selectAll(){
		List<Emp> emps = empMapper.selectAll();
		for(Emp e : emps){
			System.out.println(e);
		}
		
	}
	@Test
	public void test_selectAllWithDept(){
		List<Emp> emps = empMapper.selectAllWithDept();
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	@Test
	public void test_selectAllPage(){
		Pagination paging = new Pagination();
		paging.setTotalItem(empMapper.empCount());
		paging.setPageNo(1);
		
		List<Emp> emps = empMapper.selectPageAll(paging);
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	@Test
	public void test_insert(){
		Emp emp = new Emp();
		emp.setEname("xxx");
		int cnt = empMapper.insert(emp);
		System.out.println(empMapper.selectByEmpno(emp.getEmpno()));
		
		
	}
	
}
