package br.com.hospedagem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hospedagem.dao.ApartamentoDAO;
import br.com.hospedagem.modelo.Apartamento;
import br.com.hospedagem.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Apartamento.class )
public class ApartamentoConverter  implements Converter{
	
	private ApartamentoDAO apartamentoDAO;
	
	public ApartamentoConverter(){
		this.apartamentoDAO = CDIServiceLocator.getBean(ApartamentoDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Apartamento retorno = null;
		if(value != null){
			retorno = this.apartamentoDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Apartamento)value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return "";
	}
	
	

}
