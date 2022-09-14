package dropdown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mb")
@ViewScoped
public class MobileBean {

    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
    private String brand;
    private String model;
    private Map<String, String> allbrands;
    private Map<String, String> allmodels;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Map<String, String> getAllbrands() {
        return allbrands;
    }

    public void setAllbrands(Map<String, String> allbrands) {
        this.allbrands = allbrands;
    }

    public Map<String, String> getAllmodels() {
        return allmodels;
    }

    public void setAllmodels(Map<String, String> allmodels) {
        this.allmodels = allmodels;
    }

    @PostConstruct
    public void init() {
        allbrands = new HashMap<String, String>();
        allbrands.put("Samsung", "Samsung");
        allbrands.put("Oppo", "Oppo");
        allbrands.put("Sony", "Sony");

        Map<String, String> map = new HashMap<String, String>();
        map.put("Samsung M30", "Samsung M30");
        map.put("Samsung M31", "Samsung M31");
        map.put("Samsung A50", "Samsung A50");
        data.put("Samsung", map);

        map = new HashMap<String, String>();
        map.put("Oppo A1", "Oppo A1");
        map.put("Oppo A7", "Oppo A7");
        map.put("Oppo F15", "Oppo F15");
        data.put("Oppo", map);

        map = new HashMap<String, String>();
        map.put("Sony Xperia XZ Premiun", "Sony Xperia XZ Premiun");
        map.put("Sony Xperia Miro", "Sony Xperia Miro");
        map.put("Sony Xperia L4", "Sony Xperia L4");
        data.put("Sony", map);
    }    
     
    public Map<String, Map<String, String>> getData() {
        return data;
    }
    
    public void onBrandChange() {
        if(brand !=null && !brand.equals(""))
            allmodels = data.get(brand);
        else
            allmodels = new HashMap<String, String>();
    }
 
    public void displayModel () {
        FacesMessage msg;
        if(model !=null && brand != null)
            msg = new FacesMessage("Seleccionaste : ", model + " de la marca " + brand);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalido","No seleccionaste ningún modelo" );
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }        
}

        