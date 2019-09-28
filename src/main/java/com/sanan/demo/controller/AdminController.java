package com.sanan.demo.controller;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sanan.demo.data.entity.Contest;
import com.sanan.demo.data.repository.ContestRepository;
import com.sanan.demo.model.ContestReg;
import com.sanan.demo.model.ResponseMsg;

@RestController
public class AdminController {
	
	@Autowired
	ContestRepository contestRepo;
	
	@RequestMapping(value = {"/contest_reg"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMsg contest_reg(ContestReg contest) {
		
		Contest obj = new Contest();
		{
			obj.setName(contest.getName());
			obj.setIntro(contest.getIntro());
			
			obj.setField(contest.getField());
			obj.setDepartment(contest.getDepartment());
			
			obj.setOrganizationName(contest.getOrganizationName());
			obj.setOrganizationArea(contest.getOrganizationArea());
			
			obj.setOnStart(LocalDate.parse(contest.getOnStart()));
			obj.setOnEnd(LocalDate.parse(contest.getOnStart()));
			obj.setPreStart(LocalDate.parse(contest.getPreStart()));
			obj.setPreStart(LocalDate.parse(contest.getPreStart()));
			obj.setSubStart(LocalDate.parse(contest.getSubStart()));
			obj.setSubStart(LocalDate.parse(contest.getSubStart()));
			
			obj.setHomepageURL(contest.getHomepageURL());
			obj.setImageURL(contest.getImageURL());
			obj.setAttachedFileURL(contest.getAttachedFileURL());
		}
		
		Contest c = contestRepo.save(obj);
		if(c != null) {
			ResponseMsg res = new ResponseMsg();
			res.setResCode(100);
			res.setResMsg("Success");
			System.out.println("contest registration success.");
			return res;
		} else {
			ResponseMsg res = new ResponseMsg();
			res.setResCode(200);
			res.setResMsg("Fail");
			System.out.println("contest registration fail.");
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
