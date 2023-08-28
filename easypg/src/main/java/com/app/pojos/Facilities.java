package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Facilities")
public class Facilities extends BaseEntity {
	@Column(length=20)
	private String name;
	@Column(length = 200)
	private String  type;
//	@Lob
//	@Column
//	private String icon;
	
	@ManyToMany(mappedBy = "facilities" ,fetch = FetchType.EAGER)
	private  List<Properties> properties=new ArrayList<Properties>();
	
	public void addProperties(Properties p) {
		this.properties.add(p);
		p.getFacilities().add(this);
	}
}
