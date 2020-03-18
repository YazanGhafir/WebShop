/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.ClothingItem;
import com.github.javafaker.Faker;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
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
public class ClothingItemInitBean {

    @EJB
    private ClothingItemDAO clothingItemDao;

    @EJB
    private CategoryDAO categoryDao;

    @PostConstruct
    private void init() {
        clothingItemDao.removeAllClothingItems();
        for (int i = 20; i < 70; i++) {
            clothingItemDao.create(
                    new ClothingItem(
                            new Faker().commerce().productName(),
                            Double.valueOf(new Faker().commerce().price(0, 100)).doubleValue(),
                            new Faker().commerce().material(),
                            "https://images.pexels.com/photos/2673" + i + "/pexels-photo-2673" + i + ".jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                             new Faker().commerce().color()
                    )
            );
        }

        categoryDao.removeAllCategories();
        String[] categories = new String[]{"Nytt", "Skor", "Sport", "Accessoarer", "Beauty", "Designers", "Märken", "Outlet"};
        for (int i = 0; i < categories.length; i++) {
            categoryDao.create(new Category(categories[i]));
        }

    }
}
