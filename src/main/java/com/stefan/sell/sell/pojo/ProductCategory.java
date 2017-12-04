package com.stefan.sell.sell.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * Created by Stefan
 * Create Date 2017-12-02/15:48
 */
@Entity
@Data
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer categoryId;//类目id
    private String categoryName;//类目名称
    private Integer categoryType;// 类目编号
    private Date createTime;
    private Date updateTime;

}
