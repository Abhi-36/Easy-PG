package com.app.pojos;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Reviews")
public class Reviews extends BaseEntity {

	@Column
	private String content;

	@ManyToOne
	@JoinColumn(name = "property_id")
	private Properties property;

	@ManyToOne
	@JoinColumn(name = "User_id")
	private User user;

	public Reviews(Long id) {
		super();
		setId(id);
	}

	
}
