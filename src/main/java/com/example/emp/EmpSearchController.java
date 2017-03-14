package com.example.emp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Emp;
import com.example.emp.service.EmpSearchService;
import com.example.exception.NotFoundRuntimeException;

@Controller
@RequestMapping("/emp")
public class EmpSearchController {
	@Autowired
	EmpSearchService empSearchService;
	
	@GetMapping("/list")
	public String getList(Model model){
		List<Emp> list = empSearchService.getListAll();
		model.addAttribute("list",list);
		
		return "/emp/list";
	}
	
	@GetMapping("/item/{empno}")
	public String getItem(@PathVariable int empno, Model model){
		try{
			Emp emp = empSearchService.getEmpByEmpno(empno);
			model.addAttribute("emp" , emp);
		}catch(NotFoundRuntimeException e){
			model.addAttribute("error", e.getMessage());
		}
		
		return "/emp/item";
	}
	@GetMapping("/page/{pageNo}")
	public String getPage(@PathVariable int pageNo,Model model){
		Map<String, Object> page = empSearchService.getPage(pageNo);
		model.addAttribute("page",page);
		
		return "/emp/page";
		
	}
}
