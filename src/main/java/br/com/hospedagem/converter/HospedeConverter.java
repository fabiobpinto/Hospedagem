package br.com.hospedagem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hospedagem.dao.HospedeDAO;
import br.com.hospedagem.modelo.Hospede;
import br.com.hospedagem.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Hospede.class )
public class HospedeConverter  implements Converter{
	
	private HospedeDAO hospedeDAO;
	
	public HospedeConverter(){
		this.hospedeDAO = CDIServiceLocator.getBean(HospedeDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Hospede retorno = null;
		if(value != null){
			retorno = this.hospedeDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Hospede)value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return "";
	}
	
	

}
