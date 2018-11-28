package com.social.core.dao.material;

import com.social.core.pojo.material.Material;
import com.social.core.pojo.material.MaterialQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialDao {
    int countByExample(MaterialQuery example);

    int deleteByExample(MaterialQuery example);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialQuery example);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialQuery example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialQuery example);
}