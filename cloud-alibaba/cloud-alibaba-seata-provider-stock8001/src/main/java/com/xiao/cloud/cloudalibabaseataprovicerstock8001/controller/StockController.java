package com.xiao.cloud.cloudalibabaseataprovicerstock8001.controller;

import com.xiao.cloud.cloudalibabaseataprovicerstock8001.service.MyService;
import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.entity.PhoneStock;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-29 20:48:22
 * @description
 */

@RestController
@RequestMapping("/stock")
@Slf4j
public class StockController {





    //》》》》
    private final MyService myService;

    public StockController(MyService myService) {
        this.myService = myService;
    }

    @PostMapping("/add")
    @GlobalTransactional(rollbackFor = Exception.class)
    public CommonResult<PhoneStock> add(PhoneStock phoneStock) {
        boolean save = myService.save(phoneStock);
//        int i = 1 / 0;
        return new CommonResult<>(0x00001L, "看状态", phoneStock);
    }

    @DeleteMapping("/delete")
    @GlobalTransactional(rollbackFor = Exception.class)
    public CommonResult<PhoneStock> delete(Long id) {
        PhoneStock phoneStock = myService.getById(id);
        boolean b = myService.removeById(id);
        if (b){
            return new CommonResult<>(0x00001L, "删除成功", phoneStock);
        }
        return new CommonResult<>(0x00002L, "删除失败", phoneStock);
    }

}
