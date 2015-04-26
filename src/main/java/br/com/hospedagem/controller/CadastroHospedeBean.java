package br.com.hospedagem.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hospedagem.modelo.Hospede;
import br.com.hospedagem.service.CadastroHospedeService;
import br.com.hospedagem.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroHospedeBean implements Serializable {

	private static final long serialVersionUID = -4572775863171471066L;

	@Inject
	private CadastroHospedeService cadastroHospede;

	private Hospede hospede;

	public void salvar() {
		try {
			this.cadastroHospede.salvar(hospede);
			FacesUtil.addSuccessMessage("Hospede "
					+ hospede.getNome()
					+ " cadastrado com Sucesso.");
			this.limpar();
		} catch (Exception e) {
			FacesUtil.addErrorMessage("O hospede "
					+ hospede.getNome()
					+ " não pode ser cadastrado.");
			
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}

	private void limpar() {
		hospede = new Hospede();

	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

}
