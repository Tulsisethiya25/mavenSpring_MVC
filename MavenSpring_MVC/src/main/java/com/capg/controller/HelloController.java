package com.capg.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capg.model.Student;

@Controller
public class HelloController {
		
// @RequestMapping("/hello")
// public ModelAndView sayHello()
// {
//   ModelAndView mv = new ModelAndView();
//   mv.setViewName("welcome");
//   return mv;
// }
 @RequestMapping("/hello")
	public String display(HttpServletRequest request, Model m)
	{
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		if(pass.equals("admin"))
		{
			String msg = "Hello " + name;
			m.addAttribute("message",msg);
			return "viewpage";
		}
		else
		{
			String msg="Sorry" + name + ".You entered an incorrect password";
			m.addAttribute("message", msg);
			return "errorpage";
		}
		
	}


 @RequestMapping("/getStudentData")
	public ModelAndView getData()
	{
		ModelAndView mv = new ModelAndView();
		Student stu = new Student();
		stu.setStid(100);
		stu.setStname("brunda");
		
		mv.addObject("capg", stu);
		
		mv.setViewName("retrieve");	
		
		
		return mv;
	}
	
}
