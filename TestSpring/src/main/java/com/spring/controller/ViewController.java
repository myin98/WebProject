package com.spring.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dao.ViewDaoImp;
import com.spring.dto.TempDTO;
import com.spring.service.ViewService;
import com.spring.service.ViewServicelmp;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewController {


	
	private final ViewService viewService;
	
	
	
	@Autowired
	private ViewServicelmp vi;
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("dto", viewService.test(TempDTO.builder().no(1).build()));
		return "test";
	}
	
	@GetMapping("/list")
	public String list(Model model, HttpServletRequest req) {
		vi.findAll(model, req);
		return "list";
	}

	
	
	
	@GetMapping("/detail")
	public String detail(Model model, HttpServletRequest req) {

		if(vi.findOne(req, model)) {
			
			return"detail";
		} else {
			return "redirect:/list";
		}
	}
	 @RequestMapping("/edit")
	  public String edit(HttpServletRequest req) {
	    TempDTO dto = vi.edit(req);
	    if(dto != null) {
	      return "redirect:/detail?no=" + dto.getNo();
	    } else {
	      return "redirect:/list";
	    }
	  }

	  @PostMapping("/save")
	  public String save(HttpServletRequest req) {
	    TempDTO dto = vi.save(req);
	    if(dto != null) {
	      return "redirect:/detail?no=" + dto.getNo();
	    } else {
	      return "redirect:/new";
	    }
	  }
	
	
	
	@GetMapping("/new")
	public String input(Model model, HttpServletRequest request) {	
		
		return "new";
	}

}