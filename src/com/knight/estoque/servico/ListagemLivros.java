package com.knight.estoque.servico;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.Endpoint;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.knight.estoque.dao.LivroDAO;
import com.knight.estoque.modelo.Livro;

@WebService
public class ListagemLivros {

	@WebResult(name = "livro")
	public List<Livro> listarLivros() {
		LivroDAO livroDAO = new LivroDAO();
		return livroDAO.listarLivros();
	}

	@RequestWrapper(className = "com.knight.estoque.servico.jaxws.ListarLivrosPaginacao", localName = "listarLivrosPaginacao")
	@ResponseWrapper(className = "com.knight.estoque.servico.jaxws.ListaLivrosPaginacaoResponse", localName = "listarLivrosPaginacaoResponse")
	@WebMethod(operationName = "listarLivrosPaginacao")
	@WebResult(name = "livro")
	public List<Livro> listarLivros(@XmlElement(name="numeroDaPagina")int numeroDaPagina, @XmlElement(name="tamanhoDaPagina")int tamanhoDaPagina) {
		LivroDAO livroDAO = new LivroDAO();
		return livroDAO.listarLivros(numeroDaPagina, tamanhoDaPagina);
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/livros", new ListagemLivros());
		System.out.println("Serviço inicializado");
	}
}
