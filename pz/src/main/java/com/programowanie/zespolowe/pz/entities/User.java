package com.programowanie.zespolowe.pz.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;

	private String email;

	private String name;

	private String password;

	private String surname;

	//bi-directional many-to-one association to Device
	@OneToMany(mappedBy="user")
	private List<Device> devices;

	//bi-directional many-to-one association to Package
	@OneToMany(mappedBy="user")
	private List<Package> packages;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	public User() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device addDevice(Device device) {
		getDevices().add(device);
		device.setUser(this);

		return device;
	}

	public Device removeDevice(Device device) {
		getDevices().remove(device);
		device.setUser(null);

		return device;
	}

	public List<Package> getPackages() {
		return this.packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

//	public Package addPackage(Package package) {
//		getPackages().add(package);
//		package.setUser(this);
//
//		return package;
//	}
//
//	public Package removePackage(Package package) {
//		getPackages().remove(package);
//		package.setUser(null);
//
//		return package;
//	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}