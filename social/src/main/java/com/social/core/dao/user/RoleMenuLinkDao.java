package com.social.core.dao.user;

import com.social.core.pojo.user.RoleMenuLink;
import com.social.core.pojo.user.RoleMenuLinkKey;
import com.social.core.pojo.user.RoleMenuLinkQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuLinkDao {
    int countByExample(RoleMenuLinkQuery example);

    int deleteByExample(RoleMenuLinkQuery example);

    int deleteByPrimaryKey(RoleMenuLinkKey key);

    int insert(RoleMenuLink record);

    int insertSelective(RoleMenuLink record);

    List<RoleMenuLink> selectByExample(RoleMenuLinkQuery example);

    RoleMenuLink selectByPrimaryKey(RoleMenuLinkKey key);

    int updateByExampleSelective(@Param("record") RoleMenuLink record, @Param("example") RoleMenuLinkQuery example);

    int updateByExample(@Param("record") RoleMenuLink record, @Param("example") RoleMenuLinkQuery example);

    int updateByPrimaryKeySelective(RoleMenuLink record);

    int updateByPrimaryKey(RoleMenuLink record);
}