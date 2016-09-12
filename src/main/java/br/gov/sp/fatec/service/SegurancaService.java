package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.model.Music;


public interface SegurancaService {
	public void exemploTransacao();
	public void updateBand(String bio, Long id);
}