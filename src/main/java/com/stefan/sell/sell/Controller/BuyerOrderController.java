package com.stefan.sell.sell.Controller;

import com.stefan.sell.sell.VO.ResultVO;
import com.stefan.sell.sell.converter.OrderForm2OrderDTOConverter;
import com.stefan.sell.sell.dto.OrderDTO;
import com.stefan.sell.sell.enums.ResultEnum;
import com.stefan.sell.sell.exception.SellException;
import com.stefan.sell.sell.form.OrderForm;
import com.stefan.sell.sell.service.BuyerService;
import com.stefan.sell.sell.service.OrderService;
import com.stefan.sell.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stefan
 * Create Date 2017-12-05/14:00
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm ,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);

        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);

    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(
            @RequestParam("openid")String openid,
            @RequestParam(value="page",defaultValue = "0")Integer page,
            @RequestParam(value = "size",defaultValue = "10") Integer size
    )
    {
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest=new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage=orderService.findList(openid,pageRequest);
        return ResultVOUtil.success(orderDTOPage);
    }

    //查看订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,@RequestParam("orderId") String oderid){
        return ResultVOUtil.success(buyerService.findOrderOne(openid, oderid));
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,@RequestParam("orderId") String oderid){
        buyerService.cancelOrder(openid, oderid);
        return ResultVOUtil.success();
    }
}
