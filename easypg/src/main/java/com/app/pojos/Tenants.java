package com.app.pojos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tenants")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tenants extends BaseEntity
{
  private String name;
  private String email;
  private String password;
  private String contactNumber;
  private String gender;
  private int infoCount;
  
  @JoinColumn(name="home")
  @OneToOne
  private HomeOwner homeOwn;
  @JoinColumn(name="props")
  @OneToOne
  private Properties props;
  @ManyToOne
  @JoinColumn(name="admin")
  private Admin admin2;
   
  
}
