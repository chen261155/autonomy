package com.autonomy.mall.service.impl;

import com.autonomy.mall.dao.ProductMapper;
import com.autonomy.mall.enums.ResponseEnum;
import com.autonomy.mall.pojo.Product;
import com.autonomy.mall.service.ICategoryService;
import com.autonomy.mall.service.IProductService;
import com.autonomy.mall.vo.ProductVo;
import com.autonomy.mall.vo.ProductsDetailVo;
import com.autonomy.mall.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.autonomy.mall.enums.ProductStatusEnum.OFF_SALE;
import static com.autonomy.mall.enums.ProductStatusEnum.ON_SALE;

/**
 * Created by botong.chen on 7/6/2022 下午5:12
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ICategoryService categoryService;

    @Override
    public ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();
        if (categoryId != null){
            categoryService.findSubCategoryId(categoryId, categoryIdSet);
            categoryIdSet.add(categoryId);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.selectByCategoryIdSet(categoryIdSet);
        List<ProductVo> productVoList = productList
                .stream().map(e -> {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e, productVo);
                    return productVo;
                })
                .collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo<>(productList);
        pageInfo.setList(productVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<ProductsDetailVo> detail(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);

        //只对确定性的条件进行判断
        if (product.getStatus().equals(ON_SALE)
            || product.getStatus().equals(OFF_SALE)){
            ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }
        ProductsDetailVo productsDetailVo = new ProductsDetailVo();
        BeanUtils.copyProperties(product, productsDetailVo);

        //敏感数据处理
        productsDetailVo.setStock(product.getStock() > 100 ? 100 : product.getStock());
        return ResponseVo.success(productsDetailVo);
    }
}
