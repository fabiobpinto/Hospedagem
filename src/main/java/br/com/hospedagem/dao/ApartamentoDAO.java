package br.com.hospedagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.hospedagem.modelo.Apartamento;
import br.com.hospedagem.service.NegocioException;
import br.com.hospedagem.util.jpa.Transactional;


public class ApartamentoDAO implements Serializable {

	private static final long serialVersionUID = 6887793589077992976L;

	@Inject
	private EntityManager em;

	public void salvar(Apartamento apartamento) {
		em.merge(apartamento);
	}

	public List<Apartamento> buscarTodos() {
		return em.createQuery("from Apartamento order by numero", Apartamento.class)
				.getResultList();
	}

	@Transactional
	public void excluir(Apartamento apartamento) throws NegocioException {
		Apartamento apartamentoTemp = em.find(Apartamento.class, apartamento.getId());
		try{
			em.remove(apartamentoTemp);
			em.flush();
		}catch(PersistenceException e){
			throw new NegocioException("Este Apartamento não pode ser excluído");
		}
			
	}
	
	public Apartamento buscarPeloCodigo(Long codigo){
		return em.find(Apartamento.class, codigo);
	}
}
