package com.stefan.sell.sell.repository;

import com.stefan.sell.sell.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Stefan
 * Create Date 2017-12-02/16:07
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductIdIn(List<String> ids);
    List<ProductInfo> findByProductStatus(Integer stutus);
}
