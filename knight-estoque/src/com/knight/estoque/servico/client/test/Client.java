package com.knight.estoque.servico.client.test;

import java.util.List;

import com.knight.estoque.servico.client.ListagemLivros;
import com.knight.estoque.servico.client.ListagemLivrosService;
import com.knight.estoque.servico.client.Livro;

public class Client {
	
	public static void main(String[] args) {
		
		//Inicia a f�brica de proxies
		ListagemLivrosService listagemLivrosFactory = new ListagemLivrosService();
		
		//Obt�m um proxy
		ListagemLivros listagemLivros = listagemLivrosFactory.getListagemLivrosPort();
		
		//Executa o m�todo remoto
		List<Livro> livros = listagemLivros.listarLivros();
		
		for (Livro livro : livros) {
			System.out.println("Nome do livro: " + livro.getNome());
		}
		
		//Executa o m�todo remoto paginado
		List<Livro> livrosPaginados = listagemLivros.listarLivrosPaginacao(1, 5);
		
		for (Livro livro : livrosPaginados) {
			System.out.println("Nome do livro paginado: " + livro.getNome());
		}
	}
}
