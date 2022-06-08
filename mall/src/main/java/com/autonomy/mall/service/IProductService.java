package com.autonomy.mall.service;

import com.autonomy.mall.vo.ProductVo;
import com.autonomy.mall.vo.ProductsDetailVo;
import com.autonomy.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by botong.chen on 7/6/2022 下午5:11
 */
public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductsDetailVo> detail(Integer productId);
}
