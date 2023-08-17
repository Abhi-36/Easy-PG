package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="homeowner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HomeOwner extends BaseEntity
{
  @Column( name= "homeOwner_Name" ,length = 20)
  private String homeOwnerName;
  @Column( name= "email" ,unique = true)
  private String email;
  @Column( name= "mobile_Number" , length = 20)
  private String mobileNumber;
  @OneToMany(mappedBy = "home",cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Properties> prop;// prop related to properties
  @OneToMany(mappedBy = "homeOwn",cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Tenants> tenants;
  @ManyToOne
  @JoinColumn(name="admin")
  private Admin admin1;
}
