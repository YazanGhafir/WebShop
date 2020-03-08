package service;


import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@SessionScoped
public class SessionBeanTest implements Serializable{
    String test_text;
    
    @PostConstruct
    private void init(){
        
    }
    
    public String tested(){
        return "hej";
    }

}
