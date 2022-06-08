package com.autonomy.mall.service.impl;

import com.autonomy.mall.dao.CategoryMapper;
import com.autonomy.mall.pojo.Category;
import com.autonomy.mall.service.ICategoryService;
import com.autonomy.mall.vo.CategoryVo;
import com.autonomy.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.autonomy.mall.constant.MallConstant.ROOT_PARENT_ID;

/**
 * Created by botong.chen on 7/6/2022 下午3:49
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 耗时：http(请求微信api) > 磁盘 > 内存
     * mysql(内网+磁盘)
     * @return
     */
    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {
        //查出所有目录数据
        List<Category> categories = categoryMapper.selectAll();

//        List<CategoryVo> categoryVoList = new ArrayList<>();
        //查出parent_id = 0
//        for (Category category : categories){
//            if (category.getParentId().equals(ROOT_PARENT_ID)){
//                CategoryVo categoryVo = new CategoryVo();
//                BeanUtils.copyProperties(category, categoryVo);
//                categoryVoList.add(categoryVo);
//            }
//        }
        //lambda + stream
        List<CategoryVo> categoryVoList = categories.stream()
                .filter(e -> e.getParentId().equals(ROOT_PARENT_ID))
                .map(e ->category2CategoryVo(e))
                .sorted(Comparator.comparing(CategoryVo::getSortOrder).reversed())
                .collect(Collectors.toList());

        //查询子目录
        findSubCategory(categoryVoList, categories);

        return ResponseVo.success(categoryVoList);
    }

    @Override
    public void findSubCategoryId(Integer id, Set<Integer> resultSet) {
        //查出所有目录数据
        List<Category> categories = categoryMapper.selectAll();
        findSubCategoryId(id, resultSet, categories);
    }

    private void findSubCategoryId(Integer id, Set<Integer> resultSet, List<Category> categories) {
        for (Category category : categories){
            if (category.getParentId().equals(id)){
                resultSet.add(category.getId());
                findSubCategoryId(category.getId(), resultSet, categories);
            }
        }
    }


        private void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories){
        for (CategoryVo categoryVo : categoryVoList){
            List<CategoryVo> subCategoryList = new ArrayList<>();
            for (Category category : categories){
                //如果查到内容，设置subCategory,继续往下查
                if (categoryVo.getId().equals(category.getParentId())){
                    CategoryVo subCategoryVo = category2CategoryVo(category);
                    subCategoryList.add(subCategoryVo);
                }

                //排序处理，默认排序是从小到大，reversed进行反转排序
                subCategoryList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());

                categoryVo.setSubCategories(subCategoryList);

                //继续遍历下一级的目录
                findSubCategory(subCategoryList, categories);
            }
        }
    }

    private CategoryVo category2CategoryVo(Category category){
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }
}
