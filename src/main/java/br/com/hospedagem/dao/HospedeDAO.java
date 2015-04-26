package br.com.hospedagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.hospedagem.modelo.Hospede;
import br.com.hospedagem.service.NegocioException;
import br.com.hospedagem.util.jpa.Transactional;

public class HospedeDAO implements Serializable {

	private static final long serialVersionUID = 6077319112955438350L;
	
	@Inject
	private EntityManager em;

	public void salvar(Hospede hospede) {
		if(hospede.getPermissao() == "" || hospede.getPermissao() == null){
		hospede.setPermissao("ROLE_USER");
		}
		em.merge(hospede);
	}

	public List<Hospede> buscarTodos() {
		return em.createQuery("from Hospede", Hospede.class).getResultList();
	}

	@Transactional
	public void excluir(Hospede hospede) throws NegocioException {
		Hospede hospedeTemp = em.find(Hospede.class, hospede.getId());
		try{
			em.remove(hospedeTemp);
			em.flush();
		}catch(PersistenceException e){
			throw new NegocioException("Este hospede não pode ser excluído");
		}
	}
	
	public Hospede buscarPeloCodigo(Long codigo){
		return em.find(Hospede.class, codigo);
	}
}