package com.buy.dao.product;

import com.buy.entity.EasybuyProduct;
import com.buy.entity.EasybuyProductCategory;
import com.buy.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryImpl implements IProductCategory {
    @Override
    public List<EasybuyProductCategory> queryAllProductCategory(String parentId) {
        List<EasybuyProductCategory> productCategories = new ArrayList<EasybuyProductCategory>();

        try {
            StringBuffer sql=new StringBuffer();
            sql.append("SELECT * FROM `easybuy_product_category` WHERE 1=1");
            //判断parentID的值，如果为0，显示的一级分类
            if ((!"".equals(parentId)|| parentId!=null)) {
                sql.append(" and parentId=?");
            }
            //获取连接
            Connection conn = DataSourceUtil.getConn();
            PreparedStatement pstmt=conn.prepareStatement(sql.toString());
            if(!"".equals(parentId)&&null!=parentId){
                pstmt.setObject(1,parentId);
            }
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()) {
                EasybuyProductCategory productCategory=new EasybuyProductCategory();
                productCategory.setId(rs.getInt(1));
                productCategory.setName(rs.getString(2));
                productCategory.setParentid(rs.getInt(3));
                productCategory.setType(rs.getInt(4));
                productCategory.setIconclass(rs.getString(5));
                productCategories.add(productCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productCategories;
    }
}
