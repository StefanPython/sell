package com.stefan.sell.sell.service.impl;

import com.stefan.sell.sell.dto.CartDTO;
import com.stefan.sell.sell.enums.ProductStatusEnum;
import com.stefan.sell.sell.enums.ResultEnum;
import com.stefan.sell.sell.exception.SellException;
import com.stefan.sell.sell.pojo.ProductInfo;
import com.stefan.sell.sell.repository.ProductInfoRepository;
import com.stefan.sell.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Stefan
 * Create Date 2017-12-02/19:02
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductInfoRepository repository;
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=repository.findOne(cartDTO.getProductId());
            if (productInfo==null){
                throw new SellException(ResultEnum.ORDER_NOT_EXIST);
            }
            Integer result=productInfo.getProductStock()-cartDTO.getProductQuantity();
            if (result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }

    }
}
