
package remotecommand;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "rcb")
public class RemoteCommandBean {
    
    public void display(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Llamada", "Usted a usado el comando remoto"));
    }
}    
