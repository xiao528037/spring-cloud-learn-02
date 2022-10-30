package com.xiao.cloud.cloudcommon.api;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.entity.PhoneStock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-30 12:58:31
 * @description
 */
@FeignClient(path = "/stock")
public interface StockApi {

    @PostMapping("/add")
    public CommonResult<PhoneStock> add(PhoneStock phoneStock);

    @DeleteMapping("/delete")
    public CommonResult<PhoneStock> delete(Long id);
}
