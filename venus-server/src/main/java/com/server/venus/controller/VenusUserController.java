package com.server.venus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.server.venus.service.IVenusUserService;
import com.server.venus.vo.LoginUserVO;
import com.server.venus.vo.RegisterUserVO;
import com.server.venus.vo.ResultVO;
import com.server.venus.vo.VenusUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目名称：venus
 * 类名称：VenusUserController
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/10/24
 * 修改人：yingx
 * 修改时间： 2019/10/24
 * 修改备注：
 */
@RestController
@RequestMapping("/user")
public class VenusUserController {

    private static final Logger logger = LoggerFactory.getLogger(VenusUserController.class);

    @Autowired
    private IVenusUserService venusUserService;

    /**
     * 开放用户注册功能
     *
     * @param registerUserVO
     * @return com.server.venus.vo.ResultVO
     * @author yingx
     * @date 2019/10/25
     */
    @PostMapping("/register")
    public ResultVO register(RegisterUserVO registerUserVO) {

        try {
            venusUserService.addUser(registerUserVO);
            return ResultVO.createBySuccess();
        } catch (Exception e) {
            logger.error("VenusUserController register error!", e);
            return ResultVO.createByErrorMessage("注册失败");
        }
    }

    /**
     * 是用spring security自带的登录功能
     *
     * @param loginUserVO
     * @return com.server.venus.vo.ResultVO
     * @author yingx
     * @date 2019/10/25
     */
    @PostMapping("/login")
    public ResultVO login(LoginUserVO loginUserVO) {

        return null;
    }


    /**
     * 分页查询全部用户信息
     *
     * @param page
     * @param pageSize
     * @return com.server.venus.vo.ResultVO
     * @author yingx
     * @date 2019/10/24
     */
    @PostMapping("/getAllUser/{page}/{pageSize}")
    public ResultVO getAllUser(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {

        logger.info("VenusUserController getAllUser start ...page:{},pageSize:{}", page, pageSize);
        IPage<VenusUserVO> allUser = venusUserService.getAllUser(new VenusUserVO(), page, pageSize);
        List<VenusUserVO> records = allUser.getRecords();
        logger.info("VenusUserController getAllUser end ...result:{}", records);
        return ResultVO.createBySuccess(records);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return com.server.venus.vo.ResultVO
     * @author yingx
     * @date 2019/10/25
     */
    @PostMapping("getUser/name")
    public ResultVO getUserByName(@RequestParam String username) {

        logger.info("VenusUserController getUserByName start ...username:{}", username);
        VenusUserVO userByName = venusUserService.getUserByName(username);
        logger.info("VenusUserController getUserByName end ...result:{}", userByName);
        return ResultVO.createBySuccess(userByName);
    }
}
