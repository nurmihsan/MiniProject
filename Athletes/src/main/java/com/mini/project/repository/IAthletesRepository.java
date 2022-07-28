package com.mini.project.repository;

import java.util.List;

import com.mini.project.model.AthletesModel;

public interface IAthletesRepository {

	public int insert(AthletesModel model);

	public List<AthletesModel> readAllData();

	public int deleteById(Integer id);

	int gantidata(Integer id, AthletesModel model);


}
