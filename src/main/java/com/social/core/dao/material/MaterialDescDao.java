package com.social.core.dao.material;

import com.social.core.pojo.material.MaterialDesc;
import com.social.core.pojo.material.MaterialDescQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialDescDao {
    int countByExample(MaterialDescQuery example);

    int deleteByExample(MaterialDescQuery example);

    int insert(MaterialDesc record);

    int insertSelective(MaterialDesc record);

    List<MaterialDesc> selectByExample(MaterialDescQuery example);

    int updateByExampleSelective(@Param("record") MaterialDesc record, @Param("example") MaterialDescQuery example);

    int updateByExample(@Param("record") MaterialDesc record, @Param("example") MaterialDescQuery example);
}