package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Band {
	
	@Id
	@Column(name = "BAND_ID", updatable=false, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	@Column
	private String style;
	@Column
	private String bio;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "band_musician", 
    	joinColumns = { @JoinColumn(name = "band_id") }, 
    	inverseJoinColumns = { @JoinColumn(name = "musician_id") })
	private List<Musician> members;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStyle() {
		return style;
	}


	public void setStyle(String style) {
		this.style = style;
	}


	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}


	public List<Musician> getMembers() {
		return members;
	}


	public void setMembers(List<Musician> members) {
		this.members = members;
	}
	
	
	
}
