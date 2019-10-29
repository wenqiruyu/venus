package com.server.venus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.server.venus.service.IVenusUserService;
import com.server.venus.vo.LoginUserVO;
import com.server.venus.vo.RegisterUserVO;
import com.server.venus.vo.ResultVO;
import com.server.venus.vo.VenusUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "[1]用户模块", position = 1)
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
    @ApiOperation(value = "用户注册", notes = "开放用户注册功能", position = 2)
    public ResultVO register(RegisterUserVO registerUserVO) {

        try {
            venusUserService.addUser(registerUserVO);
            return ResultVO.success();
        } catch (Exception e) {
            logger.error("VenusUserController register error!", e);
            return ResultVO.fail("注册失败");
        }
    }

    /**
     * 使用spring security自带的登录功能
     *
     * @param loginUserVO
     * @return com.server.venus.vo.ResultVO
     * @author yingx
     * @date 2019/10/25
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "使用spring security自带的登录功能", position = 2)
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
    @ApiOperation(value = "获取全部户用信息", notes = "分页查询全部用户信息", position = 2)
    public ResultVO getAllUser(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {

        logger.info("VenusUserController getAllUser start ...page:{},pageSize:{}", page, pageSize);
        List<VenusUserVO> records = null;
        try {
            IPage<VenusUserVO> allUser = venusUserService.getAllUser(new VenusUserVO(), page, pageSize);
            records = allUser.getRecords();
        } catch (Exception e) {
            logger.error("VenusUserController getAllUser error ...", e);
            return ResultVO.fail("系统错误！");
        }
        logger.info("VenusUserController getAllUser end ...result:{}", records);
        return ResultVO.success(records);
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
    @ApiOperation(value = "查询用户信息（用户名）", notes = "根据用户名查询用户信息", position = 2)
    public ResultVO getUserByName(@RequestParam String username) {

        logger.info("VenusUserController getUserByName start ...username:{}", username);
        VenusUserVO userByName = null;
        try {
            userByName = venusUserService.getUserByName(username);
        } catch (Exception e) {
            logger.error("VenusUserController getUserByName error ...", e);
            return ResultVO.fail("系统错误！");
        }
        logger.info("VenusUserController getUserByName end ...result:{}", userByName);
        return ResultVO.success(userByName);
    }
}
