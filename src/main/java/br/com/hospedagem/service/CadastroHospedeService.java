package br.com.hospedagem.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.hospedagem.dao.HospedeDAO;
import br.com.hospedagem.modelo.Hospede;
import br.com.hospedagem.util.jpa.Transactional;


public class CadastroHospedeService implements Serializable {


	private static final long serialVersionUID = -8240280185865221989L;
	
	@Inject
	private HospedeDAO hospedeDAO;
	
	@Transactional
	public void salvar(Hospede hospede) throws NegocioException{
		if(hospede.getNome() == null || hospede.getNome().trim().equals("")){
			throw new NegocioException("O Hospede deve conter um nome!");
		}
		hospedeDAO.salvar(hospede);
	}

}
