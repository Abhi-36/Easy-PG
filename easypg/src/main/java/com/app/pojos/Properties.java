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
@Table(name="properties")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Properties extends BaseEntity
{
 private RoomType roomtype;
 @Column( name= "address" ,length = 20)
 private String address;
 @Column( name= "prize" ,length = 20)
 private double prize;
 @Column( name= "rules" ,length = 20)
 private String rules;
 @JoinColumn(name="home")
 @ManyToOne
 private HomeOwner home;// related to HomeOwner
 @OneToMany(mappedBy = "props",cascade = CascadeType.ALL,orphanRemoval = true)
 private List<Tenants> ten;
 @ManyToOne
 @JoinColumn(name="admin")
 private Admin admin3;
 
}
