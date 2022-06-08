package com.autonomy.mall.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by botong.chen on 7/6/2022 下午3:46
 */
@Data
public class CategoryVo {
    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
}
