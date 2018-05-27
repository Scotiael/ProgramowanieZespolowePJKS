package com.programowanie.zespolowe.pz.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the group database table.
 * 
 */
@Entity
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int groupid;

	@Column(name="gr_name")
	private String grName;

	//bi-directional many-to-many association to Device
	@ManyToMany
	@JoinTable(
		name="device_has_group"
		, joinColumns={
			@JoinColumn(name="group_groupid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="device_deviceid")
			}
		)
	private List<Device> devices;

	public Group() {
	}

	public int getGroupid() {
		return this.groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public String getGrName() {
		return this.grName;
	}

	public void setGrName(String grName) {
		this.grName = grName;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

}