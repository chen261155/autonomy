package com.autonomy.mall.controller;

import com.autonomy.mall.service.ICategoryService;
import com.autonomy.mall.vo.CategoryVo;
import com.autonomy.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by botong.chen on 7/6/2022 下午4:42
 */
@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseVo<List<CategoryVo>> selectAll(){
        return categoryService.selectAll();
    }
}
