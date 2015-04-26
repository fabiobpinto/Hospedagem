package br.com.hospedagem.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.hospedagem.dao.ReservaDAO;
import br.com.hospedagem.modelo.Reserva;
import br.com.hospedagem.util.jpa.Transactional;



public class CadastroReservaService implements Serializable {

	private static final long serialVersionUID = -1968484565736205993L;
	
	@Inject
	private ReservaDAO reservaDAO;
	@Transactional
	public void salvar(Reserva reserva) throws NegocioException{
		if(reserva.getApartamento().getId() == null){
			throw new NegocioException("O apartamento é Obrigatório");
		}
		if(reserva.getValor() == 0){
			
			throw new NegocioException("O Apartamento precisa ter um valor.");
		}
		this.reservaDAO.salvar(reserva);
	}

}
