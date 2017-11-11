package com.lyq.controller;

import com.lyq.model.AccTotal;
import com.lyq.service.AccTotalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账户余额界面控制层
 * Created by 云强 on 2017/11/8.
 */
@Controller
public class AccTotalController {

    @Resource
    AccTotalService accTotalService;

    @RequestMapping("/accTotal")
    public String index() {
        return "redirect:/accTotal/list";
    }


    @RequestMapping("/accTotal/list")
    public String list(Model model) {
        List<AccTotal> accTotals = accTotalService.findAll();
        model.addAttribute("accTotals", accTotals);
        return "accTotal/list";
    }

    @RequestMapping("/accTotal/toAdd")
    public String toAdd() {
        return "accTotal/accTotalAdd";
    }

    @RequestMapping("/accTotal/add")
    public String add(AccTotal accTotal) {
        accTotalService.addTotal(accTotal);
        return "redirect:/accTotal/list";
    }

    @RequestMapping("/accTotal/toEdit")
    public String toEdit(Model model, Long userId) {
        AccTotal accTotal = accTotalService.findByUserId(userId);
        model.addAttribute("accTotal", accTotal);
        return "accTotal/accTotalEdit";
    }

    @RequestMapping("/accTotal/edit")
    public String edit(AccTotal accTotal) {
        accTotalService.updateTotal(accTotal);
        return "redirect:/accTotal/list";
    }


    @RequestMapping("/accTotal/delete")
    public String delete(Long userId) {
        accTotalService.deleteByUserId(userId);
        return "redirect:/accTotal/list";
    }

}
