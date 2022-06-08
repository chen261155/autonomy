package com.autonomy.mall.service;

import com.autonomy.mall.form.ShippingForm;
import com.autonomy.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * Created by botong.chen on 8/6/2022 下午4:36
 */
public interface IShippingService {

    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form);

    ResponseVo delete(Integer uid, Integer shippingId);

    ResponseVo update(Integer uid, Integer shippinId, ShippingForm form);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);
}
