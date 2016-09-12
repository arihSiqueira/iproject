package br.gov.sp.fatec;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Band;
import br.gov.sp.fatec.model.Music;
import br.gov.sp.fatec.model.Musician;
import br.gov.sp.fatec.repository.AlbumRepository;
import br.gov.sp.fatec.repository.BandRepository;
import br.gov.sp.fatec.repository.MusicRepository;
import br.gov.sp.fatec.repository.MusicianRepository;
import br.gov.sp.fatec.service.SegurancaService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
 
    	// Recupera os repositorios
    	MusicRepository musicRepo = (MusicRepository) context.getBean("musicRepository");
		MusicianRepository musicianRepo = (MusicianRepository) context.getBean("musicianRepository");
		AlbumRepository albumRepo = (AlbumRepository) context.getBean("albumRepository");
		BandRepository bandRepo = (BandRepository) context.getBean("bandRepository");
		
				
		SegurancaService seg = (SegurancaService)context.getBean("segurancaService");
		
		try {
			
			//seg.exemploTransacao();
			//seg.updateBand("Primeira banda a tocar banjo", new Long(1));
			
			for (Music m : bandRepo.buscaBandMusic(new Long(1))){
				System.out.println("Name "+m.getName());
				System.out.println("Chords: "+m.getChords()+'\n');
			}
			
			Band band = bandRepo.findByName("avangerTopiford");
			System.out.println("Banda: "+band.getName());
			System.out.println("Biografia: "+band.getBio());
			System.out.println("Membros:");
			for (Musician m : band.getMembers()){
				System.out.println("    -"+m.getName()+','+m.getRole());
			}
		}
		catch(Exception e) {
			//System.out.println("Erro esperado! Rollback realizado!");
			System.out.println("Deu ruim");
			e.printStackTrace();
		}
		
//		// Exclui usuario
//		usuarioRepo.delete(usuario);
//		// Exclui autorizacoes
//		autorizacaoRepo.delete(autorizacao1);
//		autorizacaoRepo.delete(autorizacao2);

    }
}
