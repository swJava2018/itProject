package com.sanan.demo;

import java.time.LocalDate;

import com.sanan.demo.data.entity.Contest;
import com.sanan.demo.data.repository.ContestRepository;

public class PtContestDump {
	public static void insertContestDump(ContestRepository contestRepo) {

		for(int i=0; i<50; i++)
		{
			Contest obj = new Contest();
			obj.setName("제 " + i + "회 대회");
			obj.setIntro("대회 소개..");
			
			obj.setField("Algorithm");
			obj.setDepartment("대학부");
			
			obj.setOrganizationName("한국정보통신부");
			obj.setOrganizationArea("서울");
			
			obj.setOnStart(LocalDate.parse("2019-11-11"));
			obj.setOnEnd(LocalDate.parse("2019-11-11"));
			obj.setPreStart(LocalDate.parse("2019-11-11"));
			obj.setPreStart(LocalDate.parse("2019-11-11"));
			obj.setSubStart(LocalDate.parse("2019-11-11"));
			obj.setSubStart(LocalDate.parse("2019-11-11"));
			
			obj.setHomepageURL("http://www.naver.com");
			obj.setImageURL("sample.jpg");
			obj.setAttachedFileURL("attack.pdf");
			contestRepo.save(obj);
		}
	}
}
