package com.lyq.service;

import com.lyq.model.AccTotal;
import com.lyq.utils.AjaxJson;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 调用接口类
 * Created by 云强 on 2017/11/10.
 */
@FeignClient(value = "service-demo")
public interface AccTotalService {

    /**
     * 查询用户余额
     *
     * @param userId
     * @return
     */
    @RequestMapping("/accTotal/find/{userId}")
    public AccTotal findByUserId(@PathVariable("userId") Long userId);

    /**
     * 修改账户余额
     * 给指定账户添加余额，如需要减少，则传入负数
     *
     * @param userId 用户id
     * @param money  修改余额
     * @return
     */
    @RequestMapping("/accTotal/update/{userId}")
    public AjaxJson updateAccTotal(@PathVariable("userId") Long userId,@RequestParam(value = "money")  Double money);

}
