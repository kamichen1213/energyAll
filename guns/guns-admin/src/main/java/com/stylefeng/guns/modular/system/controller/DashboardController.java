package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.common.persistence.dao.UserMapper;
import com.stylefeng.guns.config.properties.GunsProperties;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.system.dao.UserMgrDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/dashboard")
public class DashboardController extends BaseController {

    private static String PREFIX = "/system/dashboard/";

    @Resource
    private GunsProperties gunsProperties;

    @Resource
    private UserMgrDao managerDao;

    @Resource
    private UserMapper userMapper;

    /**
     * 跳转到查看管理员列表的页面
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "index.html";
    }

}
