package com.mini.project.service;

import java.util.List;

import com.mini.project.model.AthleteStyleModel;
import com.mini.project.model.AthletesModel;
import com.mini.project.model.DataModel;
import com.mini.project.model.DivisiModel;
import com.mini.project.model.FightingStyleModel;

public interface IAthletesService {
	
	int insert(AthletesModel model);
	List<AthletesModel> readAllData();	
	int insertstyle(FightingStyleModel model);
	List<AthletesModel> readDataathletes();
	List<FightingStyleModel> readDatastyle();
	int deleteAthlete(int id);
	int updateAthlete(Integer id, AthletesModel model);
	int deleteStyle(Integer id);
	int deleteDivisi(Integer id);
	int deleteAstyle(Integer id);
	int updateDivisi(Integer id, DivisiModel model);
	int updateStyle(Integer id, FightingStyleModel model);
	int updateAthleteStyle(Integer id, AthleteStyleModel model);
	int insertdivisi(DivisiModel model);
	int insertathletestyle(AthleteStyleModel model);
	List<DivisiModel> readDatadivisi();
	List<DataModel> readDataByStyle(String style);
	List<AthleteStyleModel> readAstyle();

}
