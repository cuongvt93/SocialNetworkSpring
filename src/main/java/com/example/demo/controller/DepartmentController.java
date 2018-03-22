package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/department")
	public String index(Model model){
		model.addAttribute("departments",departmentService.findAll());
		return "list";
	}
	
	@GetMapping("/department/create")
	public String create(Model model) {
		model.addAttribute("department", new Department());
		return "form";
	}
	
	@GetMapping("/department/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("department", departmentService.findOne(id));
		return "form";
	}
	
	@PostMapping("/department/save")
	public String save(@Valid Department department, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		departmentService.saveDepartment(department);
		redirect.addFlashAttribute("success", "Saved department successfully!");
		return "redirect:/department";
	}
	
	@GetMapping("/department/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/department";
		}

		model.addAttribute("departments", departmentService.search(s));
		return "list";
	}
	
	@GetMapping("/department/{id}/delete")
	public String delete(@PathVariable Long id, RedirectAttributes redirect) {
		departmentService.deleteDepartment(id);;
		redirect.addFlashAttribute("success", "Deleted department successfully!");
		return "redirect:/department";
	}


}
