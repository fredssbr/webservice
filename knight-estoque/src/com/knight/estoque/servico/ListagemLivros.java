package com.knight.estoque.servico;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Endpoint;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.knight.estoque.dao.LivroDAO;
import com.knight.estoque.exception.UsuarioNaoAutorizadoException;
import com.knight.estoque.modelo.Livro;
import com.knight.estoque.modelo.Usuario;

@WebService
public class ListagemLivros {
	
	private LivroDAO obterLivroDao(){
		return new LivroDAO();
	}
	@WebResult(name = "livro")
	public List<Livro> listarLivros() {
		return obterLivroDao().listarLivros();
	}
	
	@RequestWrapper(className = "com.knight.estoque.servico.jaxws.ListarLivrosPaginacao", localName = "listarLivrosPaginacao")
	@ResponseWrapper(className = "com.knight.estoque.servico.jaxws.ListaLivrosPaginacaoResponse", localName = "listarLivrosPaginacaoResponse")
	@WebMethod(operationName = "listarLivrosPaginacao")
	@WebResult(name = "livro")
	public List<Livro> listarLivros(@XmlElement(name="numeroDaPagina")int numeroDaPagina, @XmlElement(name="tamanhoDaPagina")int tamanhoDaPagina) {
		return obterLivroDao().listarLivros(numeroDaPagina, tamanhoDaPagina);
	}
	
	public void criarLivro(@WebParam(name="livro")Livro livro,@WebParam(name="usuario",header=true)Usuario usuario) throws UsuarioNaoAutorizadoException, SOAPException{
		if(usuario.getLogin().equals("soa") && usuario.getSenha().equals("soa")){
			obterLivroDao().criarLivro(livro);
		}else{
			throw new UsuarioNaoAutorizadoException("Não autorizado");
		}
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/livros", new ListagemLivros());
		System.out.println("Serviço inicializado");
	}
}
