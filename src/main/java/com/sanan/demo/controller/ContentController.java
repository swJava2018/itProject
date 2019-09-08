package com.sanan.demo.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sanan.demo.data.entity.ContestFile;
import com.sanan.demo.data.repository.ContestFileRepository;

@Controller
public class ContentController {
	
	@Autowired
	ContestFileRepository contestFileRepo;
	
	@RequestMapping(value = {"contest_info"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String join(Model model) {
		
		Iterator<ContestFile> iter = contestFileRepo.findAll().iterator();
		while(iter.hasNext()) {
			ContestFile f = iter.next();
			System.out.println(f.getId() + ", " +f.getContest_id() 
								+ ", " +f.getType() + ", " + f.getUrl());
		}
		
		return "contest_info";
    }
}
