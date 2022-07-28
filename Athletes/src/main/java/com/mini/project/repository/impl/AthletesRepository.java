package com.mini.project.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mini.project.model.AthletesModel;
import com.mini.project.model.FightingStyle;
import com.mini.project.repository.IAthletesRepository;

@Repository
public class AthletesRepository implements IAthletesRepository {
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public int insert(AthletesModel model) {
		var query = "insert into athletes"
				+ "(id,nama,title,arena,divisi) "
				+"values "
				+"(?,?,?,?,?);";
		return jdbc.update(query,new Object[] { model.getId(), model.getNama(), model.getTitle(), model.getArena(), model.getDivisi() });
	}
	
	public int insert(FightingStyle model) {
		var query = "insert into fighting_style"
				+ "(fightingstyle_id,nama_beladiri) "
				+"values "
				+"(?,?);";
		return jdbc.update(query,new Object[] { model.getFightingsyle_id(), model.getNama_beladiri() });
	}

	@Override
	public List<AthletesModel> readAllData() {
		var query = "select athletes.id, fighting_style.fightingsyle_id,\r\n"
				+ " athletes.nama, athletes.arena, athletes.divisi, \r\n"
				+ " athletes.title, fighting_style.nama_beladiri\r\n"
				+ " from athletes\r\n"
				+ " join athletestyle on athletes.id = athletestyle.id\r\n"
				+ " join fighting_style on fighting_style.fightingsyle_id = athletestyle.style_id;";
		var result = jdbc.query(query, new BeanPropertyRowMapper<AthletesModel>(AthletesModel.class));
		return result;
	}
	
	@Override
	public int deleteById(Integer id) {
		var query= "DELETE FROM athletes"
				+ " WHERE id = " + id;
		return jdbc.update(query);
	}

	
	public int gantidata(Integer id, AthletesModel model) {
		var query= "UPDATE athletes"
				+ " SET id = ?, nama = ?, title = ?, arena = ?, divisi = ? WHERE id = "+id;
		return jdbc.update(query,new Object[] { model.getId(), model.getNama(), model.getTitle(), model.getArena(), model.getDivisi() });
	}

	
}
