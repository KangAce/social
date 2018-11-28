package com.social.core.dao.user;

import com.social.core.pojo.user.UserRoleLinkKey;
import com.social.core.pojo.user.UserRoleLinkQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleLinkDao {
    int countByExample(UserRoleLinkQuery example);

    int deleteByExample(UserRoleLinkQuery example);

    int deleteByPrimaryKey(UserRoleLinkKey key);

    int insert(UserRoleLinkKey record);

    int insertSelective(UserRoleLinkKey record);

    List<UserRoleLinkKey> selectByExample(UserRoleLinkQuery example);

    int updateByExampleSelective(@Param("record") UserRoleLinkKey record, @Param("example") UserRoleLinkQuery example);

    int updateByExample(@Param("record") UserRoleLinkKey record, @Param("example") UserRoleLinkQuery example);
}