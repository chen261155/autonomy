package com.autonomy.mall.service.impl;

import com.autonomy.mall.dao.ShippingMapper;
import com.autonomy.mall.enums.ResponseEnum;
import com.autonomy.mall.form.ShippingForm;
import com.autonomy.mall.pojo.Shipping;
import com.autonomy.mall.service.IShippingService;
import com.autonomy.mall.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by botong.chen on 8/6/2022 下午4:41
 */
@Service
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form, shipping);
        shipping.setUserId(uid);
        int row = shippingMapper.insertSelective(shipping);
        if (row == 0){
            return ResponseVo.error(ResponseEnum.CREATE_SHIPPING_FAIL);
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("shippingId", shipping.getId());
        return ResponseVo.successByDataAndMsg(map, ResponseEnum.CREATE_SHIPPING_SUCCESS.getDesc());
    }

    @Override
    public ResponseVo delete(Integer uid, Integer shippingId) {
        int row = shippingMapper.deleteByIdAndUid(uid, shippingId);
        if (row == 0){
            return ResponseVo.error(ResponseEnum.DELETE_SHIPPING_FAIL);
        }
        return ResponseVo.successByMsg(ResponseEnum.DELETE_SHIPPING_SUCCESS.getDesc());
    }

    @Override
    public ResponseVo update(Integer uid, Integer shippinId, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form, shipping);
        shipping.setUserId(uid);
        shipping.setId(shippinId);
        int row = shippingMapper.updateByPrimaryKeySelective(shipping);
        if (row == 0){
            return ResponseVo.error(ResponseEnum.UPDATE_SHIPPING_FAIL);
        }
        return ResponseVo.successByMsg(ResponseEnum.UPDATE_SHIPPING_SUCCESS.getDesc());
    }

    @Override
    public ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippings = shippingMapper.selectByUid(uid);
        PageInfo pageInfo = new PageInfo(shippings);
        return ResponseVo.success(pageInfo);
    }
}
