package com.lyq.controller;

import com.lyq.model.AccTotal;
import com.lyq.service.AccTotalService;
import com.lyq.utils.AjaxJson;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户余额对外接口
 * Created by 云强 on 2017/11/12.
 */
@RestController
public class AccTotalRestController {

    @Autowired
    AccTotalService accTotalService;

    /**
     * 查询用户余额
     * @param userId
     * @return
     */
    @RequestMapping("/accTotal/find/{userId}")
    public AccTotal findByUserId(@PathVariable("userId") Long userId) {
        return accTotalService.findByUserId(userId);
    }

    /**
     * 修改账户余额
     * 给指定账户添加余额，如需要减少，则传入负数
     * @param userId 用户id
     * @param money 修改余额
     * @return
     */
    @RequestMapping("/accTotal/update/{userId}")
    public AjaxJson updateAccTotal(@PathVariable("userId") Long userId,Double money) {
        AjaxJson j = new AjaxJson();
        try{
            // 获取余额
            AccTotal accTotal = accTotalService.findByUserId(userId);
            // 修改余额
            accTotal.setAccTotal(accTotal.getAccTotal()+money);
            // 更新余额
            accTotalService.updateTotal(accTotal);
            j.setObj(accTotal);
        } catch (Exception e) {
            j.setSuccess(false);
            j.setMsg(e.getMessage());
        }
        return j;
    }


}
