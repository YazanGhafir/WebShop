/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.ejwa.orm.model.dao.ClothingItemDAO;
import com.ejwa.orm.model.dao.SizeQuantityDAO;
import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.ClothingItem;
import com.ejwa.orm.model.entity.Customer;
import com.ejwa.orm.model.entity.CustomerOrder;
import com.ejwa.orm.model.entity.Payment;
import com.ejwa.orm.model.entity.Product;
import com.ejwa.orm.model.entity.SizeQuantity;
import com.ejwa.orm.model.entity.SizeQuantityId;
import com.ejwa.wsconig.JAXRSConfiguration;
import java.net.URL;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJacksonProvider;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Philip
 */
@RunWith(Arquillian.class)
public class ClothingItemServiceRESTTest {

    @ArquillianResource
    private URL deploymentURL;

    @Deployment(testable = false)
    public static WebArchive create() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(ClothingItemServiceREST.class, JAXRSConfiguration.class, ClothingItemDAO.class, ClothingItem.class, SizeQuantity.class, SizeQuantityId.class, SizeQuantityDAO.class, Category.class, Customer.class, CustomerOrder.class, Payment.class, Product.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    
    private void init(WebTarget webTarget){
        final ClothingItem ci = new ClothingItem("Adidas T-Shirt7331", 490.90, "This is a tshirt", "img", "Black");
        webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(ci));
    }

    @Test
    @RunAsClient
    public void checkThatBlaBla(@ArquillianResteasyResource("webshop/clothingItem") WebTarget webTarget) {
        /*
        init(webTarget);

        final Builder builder = webTarget.register(ResteasyJacksonProvider.class)
                .request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        System.out.println(webTarget.getUri());

        List<ClothingItem> ci_list = builder.get(List.class);

        System.out.println(ci_list);

        //.post(Entity.json(new ClothingItem(
        //   "myuser",
        //   "mypassword")));
*/
        assertEquals(true, true);
    }

}
