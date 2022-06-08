package com.autonomy.mall.service.impl;

import com.autonomy.mall.dao.OrderMapper;
import com.autonomy.mall.dao.ProductMapper;
import com.autonomy.mall.dao.ShippingMapper;
import com.autonomy.mall.enums.ResponseEnum;
import com.autonomy.mall.pojo.Cart;
import com.autonomy.mall.pojo.Order;
import com.autonomy.mall.pojo.Product;
import com.autonomy.mall.pojo.Shipping;
import com.autonomy.mall.service.ICartService;
import com.autonomy.mall.service.IOrderService;
import com.autonomy.mall.vo.OrderVo;
import com.autonomy.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by botong.chen on 7/6/2022 上午10:16
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ShippingMapper shippingMapper;

    @Autowired
    private ICartService cartService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseVo<OrderVo> create(Integer uid, Integer shippingId) {
        //收货地址校验（总之都要查出来的）
        Shipping shipping = shippingMapper.selectByUidAndShippingId(uid, shippingId);
        if (shipping == null) {
            return ResponseVo.error(ResponseEnum.SHIPPING_NOT_EXIST);
        }
        //获取购物车，校验（是否有商品、库存）
        List<Cart> cartList = cartService.listForCart(uid).stream()
                .filter(Cart::getProductSelected)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(cartList)) {
            return ResponseVo.error(ResponseEnum.CART_SELECTED_IS_EMPTY);
        }

        //获取CartList里的productIds
        Set<Integer> productSet = cartList.stream().map(Cart::getProductId).collect(Collectors.toSet());
        //根据所有productId查询数据库，使用mysql里的in
        List<Product> productsList = productMapper.selectByProductIdSet(productSet);
        //list数据转化成map数据
        Map<Integer, Product> map = productsList.stream().collect(Collectors.toMap(Product::getId, product -> product));
        for (Cart cart : cartList) {
            Product product = map.get(cart.getProductId());
            if (product == null){
                return ResponseVo.error(ResponseEnum.PARAM_ERROR, "商品不存在.productId = " + cart.getProductId());
            }
            if (product.getStock() < cart.getQuantity()){
                return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR,"库存不正确. " + product.getName());
            }
        }
        //获取
        return null;
    }
}
