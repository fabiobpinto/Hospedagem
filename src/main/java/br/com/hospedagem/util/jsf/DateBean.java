package br.com.hospedagem.util.jsf;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;

/**Classe responsavel por configurar o Calendar do
	cadastro de hospedes.
*/
@ManagedBean
public class DateBean implements Serializable {

	private static final long serialVersionUID = 8560850792259282381L;

    public Date getMaxdate() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, -18);
        
        return now.getTime();
    }
}
