package com.server.venus.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.server.venus.entity.UserDetailsImpl;

import java.util.List;

/**
 * 项目名称：venus
 * 类名称：IVenusUserMapper
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/10/24
 * 修改人：yingx
 * 修改时间： 2019/10/24
 * 修改备注：
 */
public interface IVenusUserMapper {

    List<UserDetailsImpl> getPageUser(Page<UserDetailsImpl> userDetailsPage, UserDetailsImpl userDetails);
}
