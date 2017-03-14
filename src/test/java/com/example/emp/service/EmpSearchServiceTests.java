package com.example.emp.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpSearchServiceTests {
	@Autowired
	EmpSearchService service;
	
	@Test
	public void test01_getListAll(){
		List<Emp> list = service.getListAll();
		for(Emp e : list){
			System.out.println(e);
		}
	}
	@Test
	public void test01_getListAllWithDept(){
		List<Emp> list = service.getListAll(true);
		for(Emp e : list){
			System.out.println(e);
		}
	}
	@Test
	public void test02_getListByEmpno(){
		Emp emp = service.getEmpByEmpno(7902);
		System.out.println(emp);
	}
	@Test
	public void test02_getListByEmpnoWithDept(){
		Emp emp = service.getEmpByEmpno(7844,true);
		System.out.println(emp);
	}
	@Test
	public void test03_getPage(){
		Map<String,Object> map = service.getPage(1);
		System.out.println(map.get("dept"));
		System.out.println(map.get("paging"));
	}
	@Test
	public void test03_getPagewithDept(){
		Map<String,Object> map = service.getPage(1,true);
		System.out.println(map.get("dept"));
		System.out.println(map.get("paging"));
	}
	@Test
	public void test03_getPageWithDept(){
		Emp emp = service.getEmpByEmpno(7844,true);
		System.out.println(emp);
	}
}
