package com.social.core.dao.subscription;

import com.social.core.pojo.subscription.SubscriptionEmail;
import com.social.core.pojo.subscription.SubscriptionEmailQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionEmailDao {
    int countByExample(SubscriptionEmailQuery example);

    int deleteByExample(SubscriptionEmailQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubscriptionEmail record);

    int insertSelective(SubscriptionEmail record);

    List<SubscriptionEmail> selectByExample(SubscriptionEmailQuery example);

    SubscriptionEmail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubscriptionEmail record, @Param("example") SubscriptionEmailQuery example);

    int updateByExample(@Param("record") SubscriptionEmail record, @Param("example") SubscriptionEmailQuery example);

    int updateByPrimaryKeySelective(SubscriptionEmail record);

    int updateByPrimaryKey(SubscriptionEmail record);
}