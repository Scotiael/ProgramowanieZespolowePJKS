package com.programowanie.zespolowe.pz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the history database table.
 * 
 */
@Entity
@Table(name="history")
public class History implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic
	@Column(name = "historyid")
	private int historyid;

	@ManyToOne
	@Basic
	@JoinColumn(name = "deviceid", referencedColumnName = "deviceid", nullable = false)
	@JsonIgnoreProperties("histories")
	private Device device;

	@ManyToOne
	@Basic
	@JoinColumn(name = "blobid", referencedColumnName = "blobid", nullable = false)
	@JsonIgnoreProperties("histories")
	private Blob blob;

	@ManyToOne
	@Basic
	@JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
	@JsonIgnoreProperties("histories")
	@JsonIgnore
	private User user;

	public History() {
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getHistoryid() {
		return historyid;
	}

	public void setHistoryid(int historyid) {
		this.historyid = historyid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Blob getBlob() {
		return blob;
	}

	public void setBlob(Blob blob) {
		this.blob = blob;
	}
}