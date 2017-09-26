package com.hwq.ssh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwq.ssh.entity.Person;
import com.hwq.ssh.service.PersonService;
@Controller
@RequestMapping(value="/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	/**
	 * 登录请求，失败返回error.jsp页面
	 * @return
	 */
	@RequestMapping(value="/login")
	public String dologin(String username,String password,Map<Object,Object> map) {
		if(username.equals("admin") && password.equals("admin")) {
			map.put("username", username);
			return "frame";
		}
		return "error";
	}
	
	/**
	 * 查询所有人员信息
	 * @return
	 */
	@RequestMapping(value="/main")
	public String getPerson(Map<String,Object> map){
		map.put("personlist", personService.getPerson());
		return "main";
	}
	
	/**
	 * 跳转到更新页面，回显数据
	 * editpage.jsp
	 * @param id
	 * @param model 使用的Model保存回显数据
	 * @return
	 */
	@RequestMapping(value = "/doupdate")
	public String doupdate(@RequestParam(value = "id") String id, Model model) {
		model.addAttribute("person", personService.getPersonById(id));
		return "editpage";
	}
	
	/**
	 * 保存添加的数据
	 * @param person
	 */
	@RequestMapping(value="/savePerson")
	public String addPerson(Person person) {
		personService.addPerson(person);
		return "redirect:main";
	}
	
	/**
	 * 更新数据
	 * @param person
	 */
	@RequestMapping(value="/updatePerson")
	public void updatePerson(Person person) {
		personService.updatePerson(person);
	}
	
	/**
	 * 删除一条数据
	 * @param id
	 */
	@RequestMapping(value="/deletePersonById")
	public String deletePersonById(@RequestParam(value="id") String id) {
		personService.deletePerson(id);
		return "redirect:main";
	}
	
	/**
	 * 跳转到一个添加页面
	 */
	@RequestMapping(value="/addPerson")
	public String addPerson() {
		return "savepage";
	}
	
}
