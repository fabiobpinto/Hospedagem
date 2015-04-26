package br.com.hospedagem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hospedagem.dao.ReservaDAO;
import br.com.hospedagem.modelo.Reserva;
import br.com.hospedagem.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Reserva.class )
public class ReservaConverter  implements Converter{
	
	private ReservaDAO reservaDAO;
	
	public ReservaConverter(){
		this.reservaDAO = CDIServiceLocator.getBean(ReservaDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Reserva retorno = null;
		if(value != null){
			retorno = this.reservaDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Reserva)value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return "";
	}
	
	

}
