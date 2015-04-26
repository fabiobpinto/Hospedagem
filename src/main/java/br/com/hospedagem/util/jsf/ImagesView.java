package br.com.hospedagem.util.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 

/** Classe responsavel por mostrar as imagens na tela inicial
com o carrosel do primefaces.
*/
@ManagedBean
public class ImagesView {
     
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            images.add("imagem" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
    
    
    
}
