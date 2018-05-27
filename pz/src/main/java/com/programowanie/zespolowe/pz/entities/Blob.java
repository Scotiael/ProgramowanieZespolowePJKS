package com.programowanie.zespolowe.pz.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the blobs database table.
 * 
 */
@Entity
@Table(name="blobs")
public class Blob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int blobid;

	@Lob
	private byte[] blob;

	private String name;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Blob() {
	}

	public int getBlobid() {
		return this.blobid;
	}

	public void setBlobid(int blobid) {
		this.blobid = blobid;
	}

	public byte[] getBlob() {
		return this.blob;
	}

	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}