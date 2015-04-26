package br.com.hospedagem.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.hospedagem.dao.ApartamentoDAO;
import br.com.hospedagem.modelo.Apartamento;
import br.com.hospedagem.util.jpa.Transactional;



public class CadastroApartamentoService implements Serializable {

	private static final long serialVersionUID = -1968484565736205993L;
	
	@Inject
	private ApartamentoDAO apartamentoDAO;
	@Transactional
	public void salvar(Apartamento apartamento) throws NegocioException{
		if(apartamento.getNumero() == null || apartamento.getNumero().trim().equals("")){
			throw new NegocioException("O Apartamento deve conter um numero e um valor!");
		}
		if(apartamento.getValor() == 0){
			throw new NegocioException("O Apartamento precisa ter um valor.");
		}
		apartamentoDAO.salvar(apartamento);
	}

}
