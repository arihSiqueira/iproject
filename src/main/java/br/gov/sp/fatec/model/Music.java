package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Music {
	@Id
	@Column(name = "MUSIC_ID", updatable=false, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	@Column
	private String duration;
	
	@Column
	private String chords;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChords() {
		return chords;
	}
	public void setChords(String chords) {
		this.chords = chords;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "musician_id", nullable = true)
	private Musician musician;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "band_id", nullable = true)
	private Band band;
	
	@Column
	private boolean band_musician;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="album_id",nullable = true)
	private Album album;
	
	
	
	
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	public Band getBand() {
		return band;
	}
	public void setBand(Band band) {
		this.band = band;
	}
	public void setMusician(Musician musician) {
		this.musician = musician;
	}
	public Musician getMusician() {
		return musician;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public boolean isBand_musician() {
		return band_musician;
	}
	public void setBand_musician(boolean band_musician) {
		this.band_musician = band_musician;
	}
	
	
}
