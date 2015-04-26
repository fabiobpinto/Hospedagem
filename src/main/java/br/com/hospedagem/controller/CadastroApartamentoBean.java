package br.com.hospedagem.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hospedagem.modelo.Apartamento;
import br.com.hospedagem.service.CadastroApartamentoService;
import br.com.hospedagem.util.jsf.FacesUtil;


@Named
@ViewScoped
public class CadastroApartamentoBean implements Serializable {


	private static final long serialVersionUID = 128693217316488528L;

	@Inject
	private CadastroApartamentoService cadastroApartamento;

	private Apartamento apartamento;

	public void salvar() {
		try {
			this.cadastroApartamento.salvar(apartamento);
			FacesUtil.addSuccessMessage("Apartamento "
					+ apartamento.getNumero()
					+ " cadastrado com Sucesso.");
			this.limpar();
		} catch (Exception e) {
			FacesUtil.addErrorMessage("O apartamento "
					+ apartamento.getNumero()
					+ " não pode ser cadastrado.");
			
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}

	private void limpar() {
		apartamento = new Apartamento();

	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

}
