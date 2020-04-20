package com.example.demo.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liucy
 * @title: ${Name}
 * @projectName demo
 * @description: TODO
 * @date 2019/3/3010:11
 */
public class IndexController {

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/deduct_stock")
    public String deductStock() {
        int stock = Integer.parseInt(template.opsForValue().get("stock"));
        if (stock > 0) {
            int realStock = stock - 1;
            template.opsForValue().set("stock", realStock + "");
            System.out.println("扣减成功");
        } else {
            System.out.println("减少失败");
        }
        return "end";
    }

}
