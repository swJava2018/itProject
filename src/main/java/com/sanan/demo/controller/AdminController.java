package com.sanan.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sanan.demo.data.entity.Contest;
import com.sanan.demo.data.repository.ContestRepository;
import com.sanan.demo.model.ResponseMsg;

@RestController
public class AdminController {
	
	@Autowired
	ContestRepository contestRepo;
	
	@RequestMapping(value = {"contest_reg"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMsg contest_reg(@RequestBody Contest contest) {
		
		Contest c = contestRepo.save(contest);
		if(c != null) {
			ResponseMsg res = new ResponseMsg();
			res.setResCode(100);
			res.setResMsg("Success");
			return res;
		} else {
			ResponseMsg res = new ResponseMsg();
			res.setResCode(200);
			res.setResMsg("Fail");
			return res;
		}
	}
	
	@RequestMapping(value = {"contest_alt"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String contest_alt(Model model) {
		
		return null;
    }
	
	@RequestMapping(value = {"contest_list"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMsg contest_list() {
		
		Iterator<Contest> iter = contestRepo.findAll().iterator();
		if(iter != null) {
			ArrayList<Contest> list = new ArrayList<Contest>();
			
			while(iter.hasNext()) {
				Contest f = iter.next();
				list.add(f);
			}
			
			ResponseMsg res = new ResponseMsg();
			res.setResCode(100);
			res.setResMsg("Success");
			res.setResult(list);
			return res;
		} else {
			ResponseMsg res = new ResponseMsg();
			res.setResCode(200);
			res.setResMsg("Fail");
			return res;
		}
    }
}
