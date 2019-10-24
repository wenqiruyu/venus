package com.server.venus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.server.venus.entity.UserDetailsImpl;
import com.server.venus.mapper.IVenusUserMapper;
import com.server.venus.service.IVenusUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目名称：venus
 * 类名称：VenusUserServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/10/24
 * 修改人：yingx
 * 修改时间： 2019/10/24
 * 修改备注：
 */
@Service
public class VenusUserServiceImpl implements IVenusUserService {

    @Autowired
    private IVenusUserMapper venusUserMapper;

    @Override
    public IPage<UserDetailsImpl> getAllUser(UserDetailsImpl userDetails, int page, int pageSize) {

        Page<UserDetailsImpl> userDetailsPage = new Page<>(page, pageSize);
        userDetailsPage.setRecords(venusUserMapper.getPageUser(userDetailsPage, userDetails));
        return userDetailsPage;
    }
}
