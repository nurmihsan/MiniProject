package com.mini.project.repository;

import java.util.List;

import com.mini.project.model.AthleteStyleModel;
import com.mini.project.model.AthletesModel;
import com.mini.project.model.DataModel;
import com.mini.project.model.DivisiModel;
import com.mini.project.model.FightingStyleModel;


public interface IAthletesRepository {

	public int insert(AthletesModel model);

	public List<AthletesModel> readAllData();

	int updateAthlete(Integer id, AthletesModel model);

	public int insertstyle(FightingStyleModel model);
 
	List<AthletesModel> readDataathletes();

	List<FightingStyleModel> readDatastyle();

	int insertdivisi(DivisiModel model);

	int insertathletestyle(AthleteStyleModel model);

	List<DivisiModel> readDatadivisi();

	List<DataModel> readDataByStyle(String style);

	int deleteAthlete(Integer id);

	int deleteStyle(Integer id);

	int deleteDivisi(Integer id);

	int deleteAstyle(Integer id);

	int updateDivisi(Integer id, DivisiModel model);

	int updateStyle(Integer id, FightingStyleModel model);

	int updateAthleteStyle(Integer id, AthleteStyleModel model);

	List<AthleteStyleModel> readAstyle();

	List<FightingStyleModel> readAllData2(int id);
	


}
