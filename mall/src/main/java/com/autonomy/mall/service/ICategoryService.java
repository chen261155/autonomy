package com.autonomy.mall.service;

import com.autonomy.mall.vo.CategoryVo;
import com.autonomy.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * Created by botong.chen on 7/6/2022 下午3:48
 */
public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
