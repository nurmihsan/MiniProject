package com.mini.project.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mini.project.model.AthletesModel;
import com.mini.project.repository.IAthletesRepository;

@Repository
public class AthletesRepository implements IAthletesRepository {
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public int insert(AthletesModel model) {
		var query = "insert into athletes"
				+ "(id,nama,title,arena_id,divisi_id,fightingstyle_id) "
				+"values "
				+"(?,?,?,?,?,?);";
		return jdbc.update(query,new Object[] { model.getId(), model.getNama(), model.getTitle(), model.getArena_id(), model.getDivisi_id(), model.getFightingstyle_id() });
	}

	@Override
	public List<AthletesModel> readAllData() {
		var query = "select*from athletes;";
		var result = jdbc.query(query, new BeanPropertyRowMapper<AthletesModel>(AthletesModel.class));
		return result;
	}
	
	@Override
	public int deleteById(Integer id) {
		var query= "DELETE FROM athletes"
				+ " WHERE id = " + id;
		return jdbc.update(query);
	}

	@Override
	public int gantidata(Integer id, String data) {
		var query= "UPDATE athletes"
				+ " SET data = "+ data
				+ " WHERE id = "+id;
		return jdbc.update(query);
	}

	
}
