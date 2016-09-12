package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Band;
import br.gov.sp.fatec.repository.BandRepository;
import br.gov.sp.fatec.model.Music;
import br.gov.sp.fatec.repository.MusicRepository;
import br.gov.sp.fatec.model.Musician;
import br.gov.sp.fatec.repository.MusicianRepository;
import br.gov.sp.fatec.model.Album;
import br.gov.sp.fatec.repository.AlbumRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements SegurancaService {
	
	@Autowired
	private AlbumRepository albumRepo;
	
	@Autowired
	private MusicRepository musicRepo;
	
	public AlbumRepository getAlbumRepo() {
		return albumRepo;
	}

	public void setAlbumRepo(AlbumRepository albumRepo) {
		this.albumRepo = albumRepo;
	}

	public MusicRepository getMusicRepo() {
		return musicRepo;
	}

	public void setMusicRepo(MusicRepository musicRepo) {
		this.musicRepo = musicRepo;
	}

	public MusicianRepository getMusicianRepo() {
		return musicianRepo;
	}

	public void setMusicianRepo(MusicianRepository musicianRepo) {
		this.musicianRepo = musicianRepo;
	}

	@Autowired
	private MusicianRepository musicianRepo;
	
	@Autowired
	private BandRepository bandRepo;
	
	public BandRepository getBandRepo() {
		return bandRepo;
	}

	public void setBandRepo(BandRepository bandRepo) {
		this.bandRepo = bandRepo;
	}
	
	@Transactional
	public void exemploTransacao() {
		// Cria musico
		Musician musician1 = new Musician();
		musician1.setAge(22);
		musician1.setBio("Começou quando tinha 15 anos");
		musician1.setName("Teste1");
		musician1.setRole("Guittar");
		
		
		Musician musician2 = new Musician();
		musician2.setAge(19);
		musician2.setBio("Largou faculdade de direito");
		musician2.setName("Teste2");
		musician2.setRole("Singer");
		
		Musician musician3 = new Musician();
		musician3.setAge(19);
		musician3.setBio("Curte skate");
		musician3.setName("Teste3");
		musician3.setRole("Drums");
		
		Musician musician4 = new Musician();
		musician4.setAge(29);
		musician4.setBio("Também faz filmes");
		musician4.setName("Teste4");
		musician4.setRole("Singer");
		
		
		musicianRepo.save(musician1);
		musicianRepo.save(musician2);
		musicianRepo.save(musician3);
		musicianRepo.save(musician4);
		
		List<Musician> musicians = new ArrayList<Musician>();
		musicians.add(musician1);
		musicians.add(musician2);
		musicians.add(musician3);
		
		Band band1 = new Band();
		band1.setName("avangerTopiford");
		band1.setMembers(musicians);
		
		bandRepo.save(band1);
		
		Album album1 = new Album();
		album1.setName("Work man");
		album1.setYear(2016);
		
		Album album2 = new Album();
		album2.setName("All for one");
		album2.setYear(2016);
		
		albumRepo.save(album1);
		albumRepo.save(album2);
		
		Music music1 = new Music();
		music1.setBand_musician(false);
		music1.setMusician(musician4);
		music1.setName("if I were me");
		music1.setDuration("3:00");
		music1.setChords("D G Bm D");
		music1.setAlbum(album1);
		
		Music music2 = new Music();
		music2.setBand_musician(false);
		music2.setMusician(musician4);
		music2.setName("No dia que meu irmão saiu de casa");
		music2.setDuration("3:00");
		music2.setChords("Cm D G Bm");
		music2.setAlbum(album1);
		
		
		Music music3 = new Music();
		music3.setBand_musician(true);
		music3.setBand(band1);
		music3.setName("Another wall in the brick");
		music3.setDuration("7:00");
		music3.setChords("Cm D G F");
		music3.setAlbum(album2);
		
		Music music4 = new Music();
		music4.setBand_musician(true);
		music4.setBand(band1);
		music4.setName("Can't touch that");
		music4.setDuration("4:00");
		music4.setChords("G");
		music4.setAlbum(album2);
	
		musicRepo.save(music1);
		musicRepo.save(music2);
		musicRepo.save(music3);
		musicRepo.save(music4);
		
		
		List<Music> musics1 = new ArrayList<Music>();
		musics1.add(music1);
		musics1.add(music2);
	
		
		List<Music> musics2 = new ArrayList<Music>();
		musics2.add(music3);
		musics2.add(music4);
		
		
	}
	
	@Transactional
	public void updateBand(String bio, Long id) {
		Band band = bandRepo.findOne(id);
		band.setBio(bio);
		bandRepo.save(band);
	}
	
	

}