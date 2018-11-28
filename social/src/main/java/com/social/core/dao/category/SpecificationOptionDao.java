package com.social.core.dao.category;

import com.social.core.pojo.category.SpecificationOption;
import com.social.core.pojo.category.SpecificationOptionQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificationOptionDao {
    int countByExample(SpecificationOptionQuery example);

    int deleteByExample(SpecificationOptionQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(SpecificationOption record);

    int insertSelective(SpecificationOption record);

    List<SpecificationOption> selectByExample(SpecificationOptionQuery example);

    SpecificationOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpecificationOption record, @Param("example") SpecificationOptionQuery example);

    int updateByExample(@Param("record") SpecificationOption record, @Param("example") SpecificationOptionQuery example);

    int updateByPrimaryKeySelective(SpecificationOption record);

    int updateByPrimaryKey(SpecificationOption record);
}