package spring_mvc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc2.dao.EmployeeDao;
import spring_mvc2.dto.Employee;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;

	@RequestMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		System.out.println(employee);
		ModelAndView view = new ModelAndView();
		try {
			dao.saveEmployee(employee);
			view.setViewName("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			view.setViewName("register.jsp");
		}
		return view;
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String email, @RequestParam String psw) {
		ModelAndView view = new ModelAndView();
		System.out.println(email + psw);
		try {
			Employee db = dao.fetchbyEmail(email);
			if (db.getPwd().equals(psw)) {

				List<Employee> list = dao.fetchAll();
				view.addObject("list", list);

				view.setViewName("home.jsp");
			} else {
				// for pop up msg in browser
				view.addObject("msg", "Incorrect password");

				view.setViewName("login.jsp");
				System.out.println("pwd is wrg");

			}
		} catch (Exception e) {
			e.printStackTrace();
			// for pop up msg in browser
			view.addObject("msg", "Incorrect email");

			view.setViewName("login.jsp");
			System.out.println("email is wrg");
		}
		return view;

	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		Employee db = dao.deleteEmployee(id);
		ModelAndView view = new ModelAndView();

		if (db != null) {
			List<Employee> list = dao.fetchAll();
			view.addObject("list", list);
			view.setViewName("home.jsp");

		}

		return view;
	}
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam int id) {
		ModelAndView view = new ModelAndView();

		Employee db = dao.fetchEmployeeByID(id);
		if (db != null) {
			view.addObject("db", db);
			view.setViewName("edit.jsp");

		}
		return view;
		
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(@ModelAttribute Employee employee) {
		ModelAndView view = new ModelAndView();

		Employee db = dao.updateEmployee(employee);
		if (db != null) {
			List<Employee> list = dao.fetchAll();
			view.addObject("list", list);
			view.setViewName("home.jsp");

			
		}
		return view;
		
	}

}
