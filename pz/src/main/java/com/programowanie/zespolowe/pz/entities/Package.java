package com.programowanie.zespolowe.pz.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the package database table.
 * 
 */
@Entity
//@NamedQuery(name="Package.findAll", query="SELECT p FROM Package p")
public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int packageid;

	private String name;

	@Lob
	@Column(name="package")
	private byte[] package_;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Package() {
	}

	public int getPackageid() {
		return this.packageid;
	}

	public void setPackageid(int packageid) {
		this.packageid = packageid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPackage_() {
		return this.package_;
	}

	public void setPackage_(byte[] package_) {
		this.package_ = package_;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}