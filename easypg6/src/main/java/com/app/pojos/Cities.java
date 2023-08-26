package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cities")
public class Cities extends BaseEntity {

	@Column
	private String name;
	@OneToMany(mappedBy ="myCity", cascade = CascadeType.ALL,orphanRemoval = true,fetch= FetchType.EAGER)
	private List<Properties> properties = new ArrayList<>();
	
	public Cities(Long id) {
		this.setId(id);
		
	}

	
}
