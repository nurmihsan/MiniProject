package com.mini.project.service;

import java.util.List;

import com.mini.project.model.AthletesModel;
import com.mini.project.model.FightingStyle;

public interface IAthletesService {
	
	int insert(AthletesModel model);
	List<AthletesModel> readAllData();
	int deleteById(int id);
	int gantidata(Integer id, String data);

}
