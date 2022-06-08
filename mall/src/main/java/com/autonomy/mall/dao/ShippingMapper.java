package com.autonomy.mall.dao;

import com.autonomy.mall.pojo.Shipping;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    int deleteByIdAndUid(@Param("uid") Integer uid, @Param("shippingId") Integer shippingId);

    List<Shipping> selectByUid(Integer uid);
}