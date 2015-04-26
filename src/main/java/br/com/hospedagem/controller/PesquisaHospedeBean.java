package br.com.hospedagem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hospedagem.dao.HospedeDAO;
import br.com.hospedagem.modelo.Hospede;
import br.com.hospedagem.service.NegocioException;
import br.com.hospedagem.util.jsf.FacesUtil;


@Named
@ViewScoped
public class PesquisaHospedeBean implements Serializable{


	private static final long serialVersionUID = 2040754220722478297L;

	@Inject
	HospedeDAO hospedeDAO;
	
	private List<Hospede> hospedes = new ArrayList<>();
	
	private Hospede hospedeSelecionado;
	
	public List<Hospede> getHospedes() {
		return hospedes;
	}

	public void excluir(){
		try{
			hospedeDAO.excluir(hospedeSelecionado);
			this.hospedes.remove(hospedeSelecionado);
			FacesUtil.addSuccessMessage("Hospede " + hospedeSelecionado.getNome() + " excluido com sucesso!");
			
		}catch(NegocioException e){
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	
	public Hospede getHospedeSelecionado() {
		return hospedeSelecionado;
	}


	public void setHospedeSelecionado(Hospede hospedeSelecionado) {
		this.hospedeSelecionado = hospedeSelecionado;
	}


	@PostConstruct
	public void inicializar(){
		hospedes = hospedeDAO.buscarTodos();
	}
	
}
