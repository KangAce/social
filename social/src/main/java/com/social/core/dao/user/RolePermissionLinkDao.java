package com.social.core.dao.user;

import com.social.core.pojo.user.RolePermissionLink;
import com.social.core.pojo.user.RolePermissionLinkKey;
import com.social.core.pojo.user.RolePermissionLinkQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionLinkDao {
    int countByExample(RolePermissionLinkQuery example);

    int deleteByExample(RolePermissionLinkQuery example);

    int deleteByPrimaryKey(RolePermissionLinkKey key);

    int insert(RolePermissionLink record);

    int insertSelective(RolePermissionLink record);

    List<RolePermissionLink> selectByExample(RolePermissionLinkQuery example);

    RolePermissionLink selectByPrimaryKey(RolePermissionLinkKey key);

    int updateByExampleSelective(@Param("record") RolePermissionLink record, @Param("example") RolePermissionLinkQuery example);

    int updateByExample(@Param("record") RolePermissionLink record, @Param("example") RolePermissionLinkQuery example);

    int updateByPrimaryKeySelective(RolePermissionLink record);

    int updateByPrimaryKey(RolePermissionLink record);
}