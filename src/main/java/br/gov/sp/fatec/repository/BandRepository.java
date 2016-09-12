package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Band;
import br.gov.sp.fatec.model.Music;

public interface BandRepository extends CrudRepository<Band, Long>{
	
	public Band findByName(String nome);
	
	@Query("select m from Music m where m.band.id=?1")
	public List<Music> buscaBandMusic(Long id);
	
	
}
