package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin extends BaseEntity 
{
@Column( name= "admin_Name" ,length = 20)
 private String adminName;
@Column( name= "email" ,unique = true)
 private String email;
@Column( name= "password" , nullable = false)
 private String password;
 @OneToMany(mappedBy = "admin1",cascade = CascadeType.ALL,orphanRemoval = true)
 private List<HomeOwner> homeowner;
 @OneToMany (mappedBy = "admin2",cascade = CascadeType.ALL,orphanRemoval = true)
 private List<Tenants> tenants;
 @OneToMany(mappedBy = "admin3",cascade = CascadeType.ALL,orphanRemoval = true)
 private List<Properties> properties;
 
}
