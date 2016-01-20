package com.knight.estoque.dao;

import java.util.ArrayList;
import java.util.List;

import com.knight.estoque.modelo.Livro;

public class LivroDAO {

	public List<Livro> listarLivros() {
		
		List<Livro> retorno = new ArrayList<Livro>();
		
		Livro livro1 = new Livro();
		livro1.setNome("Beowulf");
		livro1.setAnoDePublicacao(2008);
		livro1.setEditora("Northern Sea");
		livro1.setResumo("An adventure throughout the most famous Nordic hero.");
		List<String> autores1 = new ArrayList<String>();
		autores1.add("Seamus Heaney");
		autores1.add("John D. Niles");
		livro1.setAutores(autores1);

		Livro livro2 = new Livro();
		livro2.setNome("O piano");
		livro2.setAnoDePublicacao(2007);
		livro2.setEditora("Sextante");
		livro2.setResumo("Compositores e intérpretes do piano");
		List<String> autores2 = new ArrayList<String>();
		autores2.add("Sylvio Lago");
		livro2.setAutores(autores1);
		
		retorno.add(livro1);
		retorno.add(livro2);

		return retorno;
	}
	
	public List<Livro> listarLivros(int numeroDaPagina, int tamanhoDaPagina){
		Livro livro1 = new Livro();
		livro1.setNome("O princípe");
		livro1.setAnoDePublicacao(1710);
		livro1.setEditora("Florença");
		livro1.setResumo("Os fins justificam os meios.");
		List<String> autores1 = new ArrayList<String>();
		autores1.add("Nicollo Machiavelli");
		autores1.add("Arnold Schwarzenneger(ou algo assim)");
		livro1.setAutores(autores1);
		
		List<Livro> retorno = this.listarLivros();
		retorno.add(livro1);
		
		return retorno;
	}
	
	public void criarLivro(Livro livro){
		this.listarLivros(0, 0).add(livro);
	}

}
