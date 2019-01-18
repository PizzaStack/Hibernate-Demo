package com.revature;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="findAlbumByTitle",
				query="from Album where title = :titleVar")
})
@Entity
@Table(name = "album")
public class Album {
	@Id
	@Column(name = "albumid")
	private int albumid;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "artistid")
	private Artist artistid;

	public int getAlbumid() {
		return albumid;
	}

	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}

	public String getName() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
	}

	public Artist getArtistid() {
		return artistid;
	}

	public void setArtistid(Artist artistid) {
		this.artistid = artistid;
	}

	public Album(int albumid, String name, Artist artistid) {
		super();
		this.albumid = albumid;
		this.title = name;
		this.artistid = artistid;
	}

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Album [albumid=" + albumid + ", name=" + title + ", artistid=" + artistid + "]";
	}

}
