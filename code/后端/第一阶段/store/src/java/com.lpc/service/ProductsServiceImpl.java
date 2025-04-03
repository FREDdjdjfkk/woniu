package com.lpc.Service;

import com.lpc.mapper.ProductsMapper;
import com.lpc.pojo.Products;
import com.lpc.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProductsServiceImpl {
    SqlSession sqlSession = MyBatisUtils.getsqlsession();
    ProductsMapper productsMapper = sqlSession.getMapper(ProductsMapper.class);

    public List<Products> showAllproducts() {
        return productsMapper.showAllproducts();
    }

    public Products selectBydescription(String des) {
        return productsMapper.selectBydescription(des);
    }

    public Products findByid(String product_id) {
        return productsMapper.findByid(product_id);
    }

    public int updateStock(Integer product_id, int num) {
        int result = productsMapper.updateStock(product_id, num);
        sqlSession.commit();
        return result;
    }
}

