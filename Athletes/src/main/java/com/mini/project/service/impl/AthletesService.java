package com.mini.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mini.project.model.AthletesModel;
import com.mini.project.model.FightingStyle;
import com.mini.project.repository.IAthletesRepository;
import com.mini.project.service.IAthletesService;

@Service
public class AthletesService implements IAthletesService {
	
	@Autowired
	IAthletesRepository athletesrepository;

	
	@Override
	public int insert(AthletesModel model) {
		var result = athletesrepository.insert(model);
		return result;
	}
	
	@Override
	public List<AthletesModel> readAllData() {
		var result = athletesrepository.readAllData();
		System.out.println("select success");
		return result;
	}

	@Override
	public int deleteById(int id) {
		return athletesrepository.deleteById(id);
	}
	
	
	@Override
	public int gantidata(Integer id, AthletesModel model) {
		return athletesrepository.gantidata(id,model);
	}
	
}
