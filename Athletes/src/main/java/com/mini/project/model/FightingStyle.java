package com.mini.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="fighting_style")
public class FightingStyle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fightingsyle_id;
	private String nama_beladiri;
}
