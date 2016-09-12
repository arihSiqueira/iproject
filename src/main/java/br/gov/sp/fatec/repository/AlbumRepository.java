package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Album;


public interface AlbumRepository extends CrudRepository<Album, Long>{

}