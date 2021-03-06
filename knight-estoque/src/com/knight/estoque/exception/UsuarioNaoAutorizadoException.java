package com.knight.estoque.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.ws.WebFault;

@WebFault(targetNamespace = "http://servicos.estoque.knight.com/excecoes", name = "UsuarioNaoAutorizado")
public class UsuarioNaoAutorizadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoAutorizadoException(String message) {
		super(message);
	}
	
	public UsuarioFaultInfo getFaultInfo(){
		return new UsuarioFaultInfo(getMessage());
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class UsuarioFaultInfo {

		@XmlAttribute
		private String mensagem;

		public UsuarioFaultInfo(String mensagem) {
			this.mensagem = mensagem;
		}

		public UsuarioFaultInfo() {
			
		}
	}

}
