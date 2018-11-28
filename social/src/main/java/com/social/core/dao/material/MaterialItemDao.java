package com.social.core.dao.material;

import com.social.core.pojo.material.MaterialItem;
import com.social.core.pojo.material.MaterialItemQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialItemDao {
    int countByExample(MaterialItemQuery example);

    int deleteByExample(MaterialItemQuery example);

    int insert(MaterialItem record);

    int insertSelective(MaterialItem record);

    List<MaterialItem> selectByExample(MaterialItemQuery example);

    int updateByExampleSelective(@Param("record") MaterialItem record, @Param("example") MaterialItemQuery example);

    int updateByExample(@Param("record") MaterialItem record, @Param("example") MaterialItemQuery example);
}