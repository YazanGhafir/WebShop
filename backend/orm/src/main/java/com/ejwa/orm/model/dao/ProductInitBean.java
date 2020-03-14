/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.Product;
import com.github.javafaker.Faker;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Startup
@Singleton
public class ProductInitBean {
    
    @EJB
    private ProductDAO pdao;
    
    @EJB
    private CategoryDAO cdao;

    
    @PostConstruct
    private void init() {
        pdao.removeAllProduct();
        for(int i = 20; i < 70; i++)
            pdao.create(
                 new Product(
                         new Faker().commerce().productName().toString(),
                         Double.valueOf(new Faker().commerce().price(0, 100)),
                         "https://images.pexels.com/photos/2673"+i+"/pexels-photo-2673"+i+".jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                 )
            );
        
        cdao.removeAllCategories();
        for(int i = 0; i < 10; i++)
            cdao.create(new Category(new Faker().commerce().material()));
        
    }
}
