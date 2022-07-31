package com.mini.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini.project.model.AthleteStyleModel;
import com.mini.project.model.AthletesModel;
import com.mini.project.model.DataModel;
import com.mini.project.model.DivisiModel;
import com.mini.project.model.FightingStyleModel;
import com.mini.project.repository.IAthletesRepository;
import com.mini.project.service.IAthletesService;

@Service
public class AthletesService implements IAthletesService {
	
	@Autowired
	IAthletesRepository athletesrepository;

	
	@Override
	public int insert(AthletesModel model) {
		var result = athletesrepository.insert(model);
		System.out.println("insert success");
		return result;
	}
	
	
	@Override
	public int insertstyle(FightingStyleModel model) {
		var result = athletesrepository.insertstyle(model);
		System.out.println("insert success");
		return result; 
		
	}
	
	
	@Override
	public int insertdivisi(DivisiModel model) {
		var result = athletesrepository.insertdivisi(model);
		System.out.println("insert success");
		return result; 
	}
	
	
	@Override
	public int insertathletestyle(AthleteStyleModel model) {
		var result = athletesrepository.insertathletestyle(model);
		System.out.println("insert success");
		return result; 
	}
	
	@Override
	public List<AthletesModel> readDataathletes() {
		var result = athletesrepository.readDataathletes();
		return result;
	}
	
	
	@Override
	public List<FightingStyleModel> readDatastyle() {
		var result = athletesrepository.readDatastyle();
		return result;
	}
	
	
	@Override
	public List<DivisiModel> readDatadivisi() {
		var result = athletesrepository.readDatadivisi();
		return result;
	}
	
	@Override
	public List<AthleteStyleModel> readAstyle() {
		var result = athletesrepository.readAstyle();
		return result;
	}
	
	@Override
	public List<DataModel> readDataByStyle(String style) {
		var result = athletesrepository.readDataByStyle(style);
		return result;
	}
	
	@Override
	public List<AthletesModel> readAllData() {
		var result = athletesrepository.readAllData();
		
		for(var row : result) {
			var style = athletesrepository.readAllData2(row.getId());
			List<String> styles = new ArrayList<String>();
			
			for(var itemStyle: style)
			{
				styles.add(itemStyle.getBeladiri());
			}
			
			row.setStyle(styles);
		}
		return result;
	}

	@Override
	public int deleteAthlete(int id) {
		var result = athletesrepository.deleteAthlete(id);
		System.out.println("delete success");
		return result;
	}
	
	
	@Override
	public int deleteStyle(Integer id) {
		var result = athletesrepository.deleteStyle(id);
		System.out.println("delete success");
		return result;
	}
	
	
	@Override
	public int deleteDivisi(Integer id) {
		var result = athletesrepository.deleteDivisi(id);
		System.out.println("delete success");
		return result;
	}
	
	
	@Override
	public int deleteAstyle(Integer id) {
		var result = athletesrepository.deleteAstyle(id);
		System.out.println("delete success");
		return result;
	}
	
	@Override
	public int updateAthlete(Integer id, AthletesModel model) {
		var result = athletesrepository.updateAthlete(id, model);
		System.out.println("update success");
		return result;
	}
	
	
	@Override
	public int updateDivisi(Integer id, DivisiModel model) {
		var result = athletesrepository.updateDivisi(id, model);
		System.out.println("update success");
		return result;
	}
	
	
	@Override
	public int updateStyle(Integer id, FightingStyleModel model) {
		var result = athletesrepository.updateStyle(id, model);
		System.out.println("update success");
		return result;
	}
	
	
	@Override
	public int updateAthleteStyle(Integer id, AthleteStyleModel model) {
		var result = athletesrepository.updateAthleteStyle(id, model);
		System.out.println("update success");
		return result;
	}
	
}
