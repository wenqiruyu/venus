package com.server.venus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.server.venus.entity.UserDetailsImpl;
import com.server.venus.service.IVenusUserService;
import com.server.venus.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private IVenusUserService venusUserService;

    /**
     * 分页查询全部用户信息
     *
     * @param page
     * @param pageSize
     * @return com.server.venus.vo.ResultVO
     * @author yingx
     * @date 2019/10/24
     */
    @GetMapping("/getAllUser/{page}/{pageSize}")
    public ResultVO getAllUser(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {

        IPage<UserDetailsImpl> allUser = venusUserService.getAllUser(new UserDetailsImpl(), page, pageSize);
        List<UserDetailsImpl> records = allUser.getRecords();
        return ResultVO.createBySuccess(records);
    }
}
