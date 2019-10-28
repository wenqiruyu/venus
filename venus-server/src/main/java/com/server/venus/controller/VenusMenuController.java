package com.server.venus.controller;

import com.server.venus.entity.Menu;
import com.server.venus.service.IVenusMenuService;
import com.server.venus.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目名称：venus
 * 类名称：VenusMenuController
 * 类描述：菜单控制器类
 * 创建人：yingx
 * 创建时间： 2019/10/28
 * 修改人：yingx
 * 修改时间： 2019/10/28
 * 修改备注：
 */
@RestController
@RequestMapping("/menu")
public class VenusMenuController {

    private static final Logger logger = LoggerFactory.getLogger(VenusUserController.class);

    @Autowired
    private IVenusMenuService venusMenuService;

    /**
     * 获取系统的全部菜单列表
     *
     * @param
     * @return com.server.venus.vo.ResultVO
     * @author yingx
     * @date 2019/10/28
     */
    @PostMapping("/getAllMenu")
    public ResultVO getAllMenu() {

        logger.info("VenusMenuController getAllMenu start ...");
        List<Menu> allMenu = null;
        try {
            allMenu = venusMenuService.getAllMenu();
        } catch (Exception e) {
            logger.error("VenusMenuController getAllMenu error ...！", e);
            ResultVO.createByErrorMessage("系统错误！");
        }
        logger.info("VenusMenuController getAllMenu end ...");
        return ResultVO.createBySuccess(allMenu);
    }
}
