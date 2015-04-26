package br.com.hospedagem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hospedagem.dao.ReservaDAO;
import br.com.hospedagem.modelo.Reserva;
import br.com.hospedagem.service.NegocioException;
import br.com.hospedagem.util.jsf.FacesUtil;


@Named
@ViewScoped
public class PesquisaReservaBean implements Serializable{


	private static final long serialVersionUID = -7438874916678997382L;

	@Inject
	ReservaDAO reservaDAO;
	
	private List<Reserva> reservas = new ArrayList<>();
	
	private Reserva reservaSelecionada;
	
	public void excluir(){
		try{
			reservaDAO.excluir(reservaSelecionada);
			this.reservas.remove(reservaSelecionada);
			FacesUtil.addSuccessMessage("Reserva " + reservaSelecionada.getId() + " excluida com sucesso!");
			
		}catch(NegocioException e){
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	
	
	@PostConstruct
	public void inicializar(){
		reservas = reservaDAO.buscarTodos();
	}

	public List<Reserva> getReservas() {
		return reservas;
	}



	public Reserva getReservaSelecionada() {
		return reservaSelecionada;
	}



	public void setReservaSelecionada(Reserva reservaSelecionada) {
		this.reservaSelecionada = reservaSelecionada;
	}

	
	
}
