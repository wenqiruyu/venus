package com.server.venus.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 项目名称：venus
 * 类名称：VenusUserVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/10/25
 * 修改人：yingx
 * 修改时间： 2019/10/25
 * 修改备注：
 */
public class VenusUserVO {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;

    /**
     * 家庭座机
     */
    @ApiModelProperty(value = "家庭座机", required = true)
    private String telePhone;

    /**
     * 家庭住址
     */
    @ApiModelProperty(value = "家庭住址", required = true)
    private String address;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像", required = true)
    private String userFace;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", required = true)
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "VenusUserVO{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", telePhone='" + telePhone + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", userFace='" + userFace + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
