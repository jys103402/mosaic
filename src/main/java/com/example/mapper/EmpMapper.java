package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Emp;
import com.example.util.Pagination;

@Mapper
public interface EmpMapper {
	@Select("select count(*) from emp")
	int empCount();
	
	@Select("select * from emp")
	List<Emp> selectAll(); 
	List<Emp> selectAllWithDept();
	
	@Select({"select *",
			"from emp",
			"order by empno",
			"offset #{firstItem}-1 rows",
			"fetch next #{itemsPerPage} rows only"
	})
	List<Emp> selectPageAll(Pagination paging);
	List<Emp> selectPageWithDept(Pagination paging);
	
	@Select("select * from emp where empno=#{empno}")
	Emp selectByEmpno(int empno);
	Emp selectByEmpnoWithDept(int empno);
	
	int insert(Emp emp);
	
	@Delete("delete from emp where empno=#{empno}")
	int deleteByEmpno(int empno);
}
