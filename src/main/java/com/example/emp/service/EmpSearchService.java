package com.example.emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.City;
import com.example.domain.Dept;
import com.example.domain.Emp;
import com.example.exception.NotFoundRuntimeException;
import com.example.mapper.DeptMapper;
import com.example.mapper.EmpMapper;
import com.example.util.Pagination;

@Service
public class EmpSearchService {
	@Autowired
	EmpMapper empmapper;
	
	public List<Emp> getListAll(){
		return getListAll(false);
	}
	public List<Emp> getListAll(boolean withDept){
		List<Emp> list =null;
		if(withDept)
			list = empmapper.selectAllWithDept();
		else
			list = empmapper.selectAll();
		return list;
	}
	public Emp getEmpByEmpno(int empno){
		return getEmpByEmpno(empno,false);
	}
	public Emp getEmpByEmpno(int empno, boolean withDept){
		Emp e = null;
		if(withDept)
			e=empmapper.selectByEmpnoWithDept(empno);
		else
			e = empmapper.selectByEmpno(empno);
		if(e == null)
			throw new NotFoundRuntimeException("Country가 없습니다.");
		return e;
	}
	public Map<String, Object> getPage(int pageNo){
		return getPage(pageNo,false);
	}
	public Map<String, Object> getPage(int pageNo, boolean withDept){
		Pagination paging = new Pagination();
		paging.setTotalItem(empmapper.empCount());
		paging.setPageNo(pageNo);
		
		List<Emp> list = null;
		if(withDept)
			list = empmapper.selectPageAll(paging);
		else
			list = empmapper.selectPageWithDept(paging);
		Map<String,Object> map =  new HashMap<>();
		map.put("dept", list);
		map.put("paging", paging);
		
		return map;
	}
}
