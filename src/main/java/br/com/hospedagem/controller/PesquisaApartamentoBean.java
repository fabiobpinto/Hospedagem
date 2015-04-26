package br.com.hospedagem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hospedagem.dao.ApartamentoDAO;
import br.com.hospedagem.modelo.Apartamento;
import br.com.hospedagem.service.NegocioException;
import br.com.hospedagem.util.jsf.FacesUtil;


@Named
@ViewScoped
public class PesquisaApartamentoBean implements Serializable{

	private static final long serialVersionUID = -5984881393015807203L;

	@Inject
	ApartamentoDAO apartamentoDAO;
	
	private List<Apartamento> apartamentos = new ArrayList<>();
	
	private Apartamento apartamentoSelecionado;
	
	public List<Apartamento> getApartamentos(){
		return apartamentos;
	}
	
	
	public void excluir(){
		try{
			apartamentoDAO.excluir(apartamentoSelecionado);
			this.apartamentos.remove(apartamentoSelecionado);
			FacesUtil.addSuccessMessage("Apartamento " + apartamentoSelecionado.getNumero() + " excluido com sucesso!");
			
		}catch(NegocioException e){
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Apartamento getApartamentoSelecionado() {
		return apartamentoSelecionado;
	}

	public void setApartamentoSelecionado(Apartamento apartamentoSelecionado) {
		this.apartamentoSelecionado = apartamentoSelecionado;
	}
	
	@PostConstruct
	public void inicializar(){
		apartamentos = apartamentoDAO.buscarTodos();
	}
	
}
