package com.server.venus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.server.venus.entity.UserDetailsImpl;

/**
 * 项目名称：venus
 * 类名称：IVenusUserService
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/10/24
 * 修改人：yingx
 * 修改时间： 2019/10/24
 * 修改备注：
 */
public interface IVenusUserService {

    IPage<UserDetailsImpl> getAllUser(UserDetailsImpl userDetails, int page, int pageSize);
}
