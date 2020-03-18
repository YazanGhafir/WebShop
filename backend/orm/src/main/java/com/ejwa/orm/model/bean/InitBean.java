/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.bean;

import com.ejwa.orm.model.dao.CategoryDAO;
import com.ejwa.orm.model.dao.ClothingItemDAO;
import com.ejwa.orm.model.dao.SizeQuantityDAO;
import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.ClothingItem;
import com.ejwa.orm.model.entity.SizeQuantity;
import com.github.javafaker.Faker;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Startup
@Singleton
public class InitBean {

    @EJB
    private ClothingItemDAO clothingItemDao;

    @EJB
    private CategoryDAO categoryDao;

    @EJB
    private SizeQuantityDAO sizeQuantityDao;


    private Long id_1;
    private Long id_2;
    private Long id_3;
    private Long id_4;
    private Long id_5;
    private Long id_6;
    private Long id_7;

    private ClothingItem item1 = new ClothingItem("AIRMAN - Cargobyxor", 859.00, "Green cargo pants with pockets", "https://mosaic03.ztat.net/vgs/media/catalog_hd/AL/52/2E/00/FM/11/AL522E00F-M11@11.jpg", "dark oliv");
    private ClothingItem item2 = new ClothingItem("Pier One shirt", 379.00, "This is a shirt", "https://mosaic03.ztat.net/vgs/media/catalog_hd/PI/92/2D/07/BQ/11/PI922D07B-Q11@10.jpg", "black");
    private ClothingItem item3 = new ClothingItem("Pier One Sweatshirt", 199.00, "This is a Sweatshirt", "https://mosaic03.ztat.net/vgs/media/catalog_hd/PI/92/2S/A0/9G/12/PI922SA09-G12@14.1.jpg", "bordeaux melange");
    private ClothingItem item4 = new ClothingItem("SULTAN - Skjorta", 679.00, "This is a shirt", "https://mosaic03.ztat.net/vgs/media/catalog_hd/TW/C2/2D/01/KG/11/TWC22D01K-G11@4.jpg", "copper");
    private ClothingItem item5 = new ClothingItem("LINE FACE - Sweatshirt", 1296.00, "This is a sweatshirt", "https://mosaic03.ztat.net/vgs/media/catalog_hd/TP/82/2S/0E/TQ/11/TP822S0ET-Q11@10.jpg", "black");
    private ClothingItem item6 = new ClothingItem("AVIATION PANT COLUMBIA - Cargobyxor", 379.00, "This is a shirt", "https://mosaic03.ztat.net/vgs/media/catalog_hd/C1/42/2A/02/AM/13/C1422A02A-M13@23.1.jpg", "AVIATION PANT COLUMBIA - Cargobyxor");
    private ClothingItem item7 = new ClothingItem("BASIC JOGGERS - Träningsbyxor", 1379.00, "This is a shirt", "https://img01.ztat.net/article/VE/I2/2E/00/9Q/11/VEI22E009-Q11@6.jpg?imwidth=1800", "black");

    private Category cat1 = new Category("Pants");
    private Category cat2 = new Category("Shirts");
    private Category cat3 = new Category("Sweatshirts");

    private SizeQuantity sizeItem11 = new SizeQuantity("L", 5, item1);
    private SizeQuantity sizeItem12 = new SizeQuantity("S", 4, item1);
    private SizeQuantity sizeItem13 = new SizeQuantity("M", 6, item1);
    private SizeQuantity sizeItem21 = new SizeQuantity("S", 1, item2);
    private SizeQuantity sizeItem22 = new SizeQuantity("M", 6, item2);
    private SizeQuantity sizeItem23 = new SizeQuantity("L", 4, item2);
    private SizeQuantity sizeItem31 = new SizeQuantity("S", 1, item3);
    private SizeQuantity sizeItem32 = new SizeQuantity("M", 6, item3);
    private SizeQuantity sizeItem33 = new SizeQuantity("L", 4, item3);
    private SizeQuantity sizeItem41 = new SizeQuantity("S", 1, item4);
    private SizeQuantity sizeItem42 = new SizeQuantity("M", 6, item4);
    private SizeQuantity sizeItem43 = new SizeQuantity("L", 4, item3);
    private SizeQuantity sizeItem51 = new SizeQuantity("S", 1, item5);
    private SizeQuantity sizeItem52 = new SizeQuantity("M", 6, item5);
    private SizeQuantity sizeItem53 = new SizeQuantity("L", 4, item5);
    private SizeQuantity sizeItem61 = new SizeQuantity("S", 1, item6);
    private SizeQuantity sizeItem62 = new SizeQuantity("M", 6, item6);
    private SizeQuantity sizeItem63 = new SizeQuantity("L", 4, item6);
    private SizeQuantity sizeItem71 = new SizeQuantity("S", 1, item7);
    private SizeQuantity sizeItem72 = new SizeQuantity("M", 6, item7);
    private SizeQuantity sizeItem73 = new SizeQuantity("L", 4, item7);

    @PostConstruct
    private void init() {
            
            clothingItemDao.create(item1);
            clothingItemDao.create(item2);
            clothingItemDao.create(item3);
            clothingItemDao.create(item4);
            clothingItemDao.create(item5);
            clothingItemDao.create(item6);
            clothingItemDao.create(item7);
            
            item1.setClothingItem_id(id_1);
            item1.setClothingItem_id(id_2);
            item1.setClothingItem_id(id_3);
            item1.setClothingItem_id(id_4);
            item1.setClothingItem_id(id_5);
            item1.setClothingItem_id(id_6);
            item1.setClothingItem_id(id_7);
            
            categoryDao.create(cat1);
            categoryDao.create(cat2);
            categoryDao.create(cat3);
            
            item1.setCategory(cat1);
            item2.setCategory(cat2);
            item3.setCategory(cat3);
            item4.setCategory(cat2);
            item5.setCategory(cat3);
            item6.setCategory(cat1);
            item7.setCategory(cat1);
            
            sizeItem11.setClothingItem(item1);
            sizeItem12.setClothingItem(item1);
            sizeItem13.setClothingItem(item1);
            sizeItem21.setClothingItem(item2);
            sizeItem22.setClothingItem(item2);
            sizeItem23.setClothingItem(item2);
            sizeItem31.setClothingItem(item3);
            sizeItem32.setClothingItem(item3);
            sizeItem33.setClothingItem(item3);
            sizeItem41.setClothingItem(item4);
            sizeItem42.setClothingItem(item4);
            sizeItem43.setClothingItem(item4);
            sizeItem51.setClothingItem(item5);
            sizeItem52.setClothingItem(item5);
            sizeItem53.setClothingItem(item5);
            sizeItem61.setClothingItem(item6);
            sizeItem62.setClothingItem(item6);
            sizeItem63.setClothingItem(item6);
            sizeItem71.setClothingItem(item7);
            sizeItem72.setClothingItem(item7);
            sizeItem73.setClothingItem(item7);
            
            sizeQuantityDao.create(sizeItem11);
            sizeQuantityDao.create(sizeItem12);
            sizeQuantityDao.create(sizeItem13);
            sizeQuantityDao.create(sizeItem21);
            sizeQuantityDao.create(sizeItem22);
            sizeQuantityDao.create(sizeItem23);
            sizeQuantityDao.create(sizeItem31);
            sizeQuantityDao.create(sizeItem32);
            sizeQuantityDao.create(sizeItem33);
            sizeQuantityDao.create(sizeItem41);
            sizeQuantityDao.create(sizeItem42);
            sizeQuantityDao.create(sizeItem43);
            sizeQuantityDao.create(sizeItem51);
            sizeQuantityDao.create(sizeItem52);
            sizeQuantityDao.create(sizeItem53);
            sizeQuantityDao.create(sizeItem61);
            sizeQuantityDao.create(sizeItem62);
            sizeQuantityDao.create(sizeItem63);
            sizeQuantityDao.create(sizeItem71);
            sizeQuantityDao.create(sizeItem72);
            sizeQuantityDao.create(sizeItem73);
            
    }

}
