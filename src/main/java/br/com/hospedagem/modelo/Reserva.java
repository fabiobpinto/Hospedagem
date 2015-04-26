package br.com.hospedagem.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {

	private static final long serialVersionUID = -7783075710935834617L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrada;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSaida;
	private double valor;
	private String status;
	private String observacao;
	private int quantidadeAdultos;
	private int quantidadeCriancas;
	@ManyToOne
	@JoinColumn(name="codigo_apartamento", nullable= false)
	private Apartamento apartamento;
	
	@ManyToOne
	@JoinColumn(name="codigo_hospede", nullable = false)
	private Hospede hospede;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public int getQuantidadeAdultos() {
		return quantidadeAdultos;
	}
	public void setQuantidadeAdultos(int quantidadeAdultos) {
		this.quantidadeAdultos = quantidadeAdultos;
	}
	public int getQuantidadeCriancas() {
		return quantidadeCriancas;
	}
	public void setQuantidadeCriancas(int quantidadeCriancas) {
		this.quantidadeCriancas = quantidadeCriancas;
	}
	
	public Hospede getHospede() {
		return hospede;
	}
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	
	public Apartamento getApartamento() {
		return apartamento;
	}
	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apartamento == null) ? 0 : apartamento.hashCode());
		result = prime * result
				+ ((dataEntrada == null) ? 0 : dataEntrada.hashCode());
		result = prime * result
				+ ((dataSaida == null) ? 0 : dataSaida.hashCode());
		result = prime * result + ((hospede == null) ? 0 : hospede.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + quantidadeAdultos;
		result = prime * result + quantidadeCriancas;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (apartamento == null) {
			if (other.apartamento != null)
				return false;
		} else if (!apartamento.equals(other.apartamento))
			return false;
		if (dataEntrada == null) {
			if (other.dataEntrada != null)
				return false;
		} else if (!dataEntrada.equals(other.dataEntrada))
			return false;
		if (dataSaida == null) {
			if (other.dataSaida != null)
				return false;
		} else if (!dataSaida.equals(other.dataSaida))
			return false;
		if (hospede == null) {
			if (other.hospede != null)
				return false;
		} else if (!hospede.equals(other.hospede))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (quantidadeAdultos != other.quantidadeAdultos)
			return false;
		if (quantidadeCriancas != other.quantidadeCriancas)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	

	
	
	

	
	
	
	
}
