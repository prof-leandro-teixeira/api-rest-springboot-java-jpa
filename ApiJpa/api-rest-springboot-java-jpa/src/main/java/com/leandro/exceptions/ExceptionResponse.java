package com.leandro.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Date horario;
	private String mensagem;
	private String detalhes;
	
	public ExceptionResponse(Date horario, String mensagem, String detalhes) {
		this.horario = horario;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}

	public Date getHorario() {
		return horario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getDetalhes() {
		return detalhes;
	}
}
