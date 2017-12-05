package com.stefan.sell.sell.Controller;

import com.stefan.sell.sell.VO.ProductInfoVO;
import com.stefan.sell.sell.VO.ProductVO;
import com.stefan.sell.sell.VO.ResultVO;
import com.stefan.sell.sell.pojo.ProductCategory;
import com.stefan.sell.sell.pojo.ProductInfo;
import com.stefan.sell.sell.service.CategoryService;
import com.stefan.sell.sell.service.ProductService;
import com.stefan.sell.sell.service.impl.CategoryServiceImpl;
import com.stefan.sell.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Stefan
 * Create Date 2017-12-02/19:39
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping("/list")
    @ResponseBody
    public ResultVO list(){
        //查询所有的上架商品
        List<ProductInfo> productInfoList=productService.findUpAll();
        //查询类目
        List<Integer> categoryTypeList= productInfoList.stream().
                map(e ->e.getCategoryType()).
                collect(Collectors.toList());
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);
        //数据拼接
       List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(productCategory, productVO);
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType() == productCategory.getCategoryType()) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);

    }

}
