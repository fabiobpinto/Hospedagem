package br.com.hospedagem.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hospedagem.dao.ApartamentoDAO;
import br.com.hospedagem.dao.HospedeDAO;
import br.com.hospedagem.modelo.Apartamento;
import br.com.hospedagem.modelo.Hospede;
import br.com.hospedagem.modelo.Reserva;
import br.com.hospedagem.service.CadastroReservaService;
import br.com.hospedagem.util.jsf.FacesUtil;


@Named
@ViewScoped
public class CadastroReservaBean implements Serializable {


	private static final long serialVersionUID = 4796765557970306737L;

	private Reserva reserva;
	
	private List<Apartamento> apartamentos;
	
	private List<Hospede> hospedes;
	
	@Inject
	private CadastroReservaService cadastroReserva;
	@Inject
	private ApartamentoDAO apartamentosDAO;
	@Inject
	private HospedeDAO hospedesDAO;
	
	public void salvar() {
		try {
			this.cadastroReserva.salvar(reserva);
			FacesUtil.addSuccessMessage("Reserva cadastrada com Sucesso.");
			this.limpar();
		} catch (Exception e) {
			FacesUtil.addErrorMessage("A reserva "
					+ reserva.getId()
					+ " não pode ser cadastrada.");
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
		this.apartamentos = this.apartamentosDAO.buscarTodos();
		this.hospedes = this.hospedesDAO.buscarTodos();
	}

	private void limpar() {
		this.reserva = new Reserva();
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public List<Hospede> getHospedes() {
		return hospedes;
	}
	

}
