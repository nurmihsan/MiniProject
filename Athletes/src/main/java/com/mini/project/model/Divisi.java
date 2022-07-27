package com.mini.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="divisi")
public class Divisi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int divisi_id;
	private String name;
}
