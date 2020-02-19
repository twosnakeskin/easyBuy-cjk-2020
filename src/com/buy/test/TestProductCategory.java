package com.buy.test;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCategoryImpl;
import com.buy.entity.EasybuyProductCategory;

import java.util.List;

public class TestProductCategory {
    public static void main(String[] args) {
        IProductCategory productCategory=new ProductCategoryImpl();
        List<EasybuyProductCategory> productCategories=productCategory.queryAllProductCategory("");
        for (EasybuyProductCategory category : productCategories) {
            System.out.println(category.getName());
        }
    }
}
