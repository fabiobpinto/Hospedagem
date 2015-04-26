package br.com.hospedagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.hospedagem.modelo.Reserva;
import br.com.hospedagem.service.NegocioException;
import br.com.hospedagem.util.jpa.Transactional;


public class ReservaDAO implements Serializable {

	private static final long serialVersionUID = 6887793589077992976L;

	@Inject
	private EntityManager em;

	public void salvar(Reserva reserva) {
		em.merge(reserva);
	}

	public List<Reserva> buscarTodos() {
		return em.createQuery("from Reserva", Reserva.class)
				.getResultList();
	}

	@Transactional
	public void excluir(Reserva reserva) throws NegocioException {
		Reserva reservaTemp = em.find(Reserva.class, reserva.getId());
		try{
			em.remove(reservaTemp);
			em.flush();
		}catch(PersistenceException e){
			throw new NegocioException("Esta Reserva não pode ser excluída");
		}
			
	}
	
	public Reserva buscarPeloCodigo(Long codigo){
		return em.find(Reserva.class, codigo);
	}
}
