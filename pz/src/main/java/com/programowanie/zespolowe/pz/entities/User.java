package com.programowanie.zespolowe.pz.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;

	private String email;

	private String name;

	private String password;

	private String surname;

	//bi-directional many-to-one association to Blob
	@OneToMany(mappedBy="user")
	private List<Blob> blobs;

	//bi-directional many-to-one association to Device
	@OneToMany(mappedBy="user")
	@JsonBackReference
	private List<Device> devices;

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

	public List<Blob> getBlobs() {
		return this.blobs;
	}

	public void setBlobs(List<Blob> blobs) {
		this.blobs = blobs;
	}

	public Blob addBlob(Blob blob) {
		getBlobs().add(blob);
		blob.setUser(this);

		return blob;
	}

	public Blob removeBlob(Blob blob) {
		getBlobs().remove(blob);
		blob.setUser(null);

		return blob;
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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}