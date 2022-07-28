package com.mini.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="athletestyle")
public class AthleteStyle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int athlete_id;
	private int style_id;
		
}
