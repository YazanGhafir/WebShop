package service;

/*
import com.ejwa.orm.model.dao.CustomerOrderDAO;
import com.ejwa.orm.model.dao.ProductDAO;
import com.ejwa.orm.model.entity.CustomerOrder;
import com.ejwa.orm.model.entity.Product;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SessionScoped
public class SessionBeanTest implements Serializable {

    @EJB
    private ProductDAO productDAO;
    
    @EJB
    private CustomerOrderDAO customerOrderDAO;

    @Getter
    Product viewedProduct;

    @Getter
    List<Product> shoppingCart;

    @Getter
    String customerInfo;

    @PostConstruct
    private void init() {
        shoppingCart = new ArrayList<Product>();
    }

    public void determinViewedProduct(Long pID) {
        viewedProduct = productDAO.findProductMatchingID(pID);
    }

    public void addCustomerInfoAfterLogin(String customerInfo) {
        this.customerInfo = customerInfo;
    }
    
    public void removeCustomerInfoAfterLogout() {
        this.customerInfo = "A Great Person :D";
    }

    public void addToShoppingCart(Long pID) {
        shoppingCart.add(productDAO.findProductMatchingID(pID));
    }
    
    public void deleteFromShoppingCart(Long pID) {
        shoppingCart.remove(productDAO.findProductMatchingID(pID));
    }

    public String createOrder() {
        LocalDateTime test_date = LocalDateTime.of(2014, Month.SEPTEMBER, 11, 16, 15, 15);;
        CustomerOrder order = new CustomerOrder(test_date);
        //TODO: add product from the shopping cart to the order
        customerOrderDAO.create(order);
        return "Order Created";
    }
}
*/
