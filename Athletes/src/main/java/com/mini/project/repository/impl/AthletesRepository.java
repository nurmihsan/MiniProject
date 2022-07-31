package com.mini.project.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mini.project.model.AthleteStyleModel;
import com.mini.project.model.AthletesModel;
import com.mini.project.model.DataModel;
import com.mini.project.model.DivisiModel;
import com.mini.project.model.FightingStyleModel;
import com.mini.project.repository.IAthletesRepository;

@Repository
public class AthletesRepository implements IAthletesRepository {
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public int insert(AthletesModel model) {
		var query = "insert into athletes"
				+ "(nama,arena,divisi,title) "
				+"values "
				+"(?,?,?,?);";
		return jdbc.update(query,new Object[] { model.getNama(), model.getArena(), model.getDivisi(), model.getTitle() });
	}
	
	@Override
	public int insertstyle(FightingStyleModel model) {
		var query = "insert into style"
				+ "(beladiri) "
				+"values "
				+"(?);";
		return jdbc.update(query,new Object[] { model.getBeladiri() });
	}
	
	
	@Override
	public int insertdivisi(DivisiModel model) {
		var query = "insert into divisi"
				+ "(nama) "
				+"values "
				+"(?);";
		return jdbc.update(query,new Object[] { model.getNama() });
	}
	
	@Override
	public int insertathletestyle(AthleteStyleModel model) {
		var query = "insert into athletestyle"
				+ "(athlete_id,style_id) "
				+"values "
				+"(?,?);";
		return jdbc.update(query,new Object[] { model.getAthlete_id(), model.getStyle_id() });
	}
	
	
	@Override
	public List<AthletesModel> readDataathletes() {
		var query = "SELECT * FROM athletes; ";
		var result = jdbc.query(query, new BeanPropertyRowMapper<AthletesModel>(AthletesModel.class));
		return result;
	}
	
	
	@Override
	public List<FightingStyleModel> readDatastyle() {
		var query = "SELECT * FROM style; ";
		var result = jdbc.query(query, new BeanPropertyRowMapper<FightingStyleModel>(FightingStyleModel.class));
		return result;
	}
	
	
	@Override
	public List<DivisiModel> readDatadivisi() {
		var query = "SELECT * FROM divisi; ";
		var result = jdbc.query(query, new BeanPropertyRowMapper<DivisiModel>(DivisiModel.class));
		return result;
	}
	
	
	@Override
	public List<AthleteStyleModel> readAstyle() {
		var query = "SELECT * FROM athletestyle; ";
		var result = jdbc.query(query, new BeanPropertyRowMapper<AthleteStyleModel>(AthleteStyleModel.class));
		return result;
	}
	
	@Override
	public List<AthletesModel> readAllData() {
		var query = "select * from (select athletes.id as id, athletes.nama, athletes.arena,\r\n"
				+ " divisi.nama as divisi, athletes.title from athletes\r\n"
				+ " join divisi on athletes.id_divisi = divisi.id\r\n"
				+ " group by athletes.nama ) as tb";
		var result = jdbc.query(query, new BeanPropertyRowMapper<AthletesModel>(AthletesModel.class));
		return result;
	}
	
	
	@Override
	public List<FightingStyleModel> readAllData2(int id){
		var query = "select b.* from athletestyle a\r\n"
				+ " join style b on a.style_id = b.style_id\r\n"
				+ " where a.athlete_id = ?";
		return jdbc.query(query, new BeanPropertyRowMapper<FightingStyleModel>(FightingStyleModel.class),new Object[] {id});
	}
	
	
	@Override
	public List<DataModel> readDataByStyle(String style) {
		var query = "select athletes.id,\r\n"
				+ "athletes.nama, athletes.arena, divisi.nama as divisi, \r\n"
				+ "athletes.title, style.beladiri\r\n"
				+ "from athletestyle\r\n"
				+ "join athletes  on athletestyle.athlete_id = athletes.id \r\n"
				+ "join style on athletestyle.style_id = style.style_id \r\n"
				+ "join divisi on athletes.id_divisi = divisi.id"
				+ "	where style.beladiri like '%"+style+"%';";
		var result = jdbc.query(query, new BeanPropertyRowMapper<DataModel>(DataModel.class));
		return result;
	}
	
	
	@Override
	public int deleteAthlete(Integer id) {
		var query= "DELETE FROM athletes"
				+ " WHERE id = " + id;
		return jdbc.update(query);
	}
	
	
	@Override
	public int deleteStyle(Integer id) {
		var query= "DELETE FROM style"
				+ " WHERE id = " + id;
		return jdbc.update(query);
	}
	
	
	@Override
	public int deleteDivisi(Integer id) {
		var query= "DELETE FROM divisi"
				+ " WHERE id = " + id;
		return jdbc.update(query);
	}
	
	
	@Override
	public int deleteAstyle(Integer id) {
		var query= "DELETE FROM athletestyle"
				+ " WHERE id = " + id;
		return jdbc.update(query);
	}
	
	@Override
	public int updateAthlete(Integer id, AthletesModel model) {
		var query= "UPDATE athletes"
				+ " SET  nama = ?, title = ?, arena = ?, divisi = ? WHERE id = "+id;
		return jdbc.update(query,new Object[] { model.getNama(), model.getTitle(), model.getArena(), model.getDivisi() });
	}
	
	
	@Override
	public int updateDivisi(Integer id, DivisiModel model) {
		var query= "UPDATE athletes"
				+ " SET nama = ? where id = "+id;
		return jdbc.update(query,new Object[] { model.getId(), model.getNama() });
	}
	
	@Override
	public int updateStyle(Integer id, FightingStyleModel model) {
		var query= "UPDATE style"
				+ " SET style_id = ?, beladiri = ? where id = "+id;
		return jdbc.update(query,new Object[] { model.getStyle_id(), model.getBeladiri() });
	}
	
	@Override
	public int updateAthleteStyle(Integer id, AthleteStyleModel model) {
		var query= "UPDATE athletestyle"
				+ " SET athlete_id = ?, style_id = ? where id = "+id;
		return jdbc.update(query,new Object[] { model.getAthlete_id(), model.getStyle_id() });
	}


}
