package com.social.core.dao.category;

import com.social.core.pojo.category.Specification;
import com.social.core.pojo.category.SpecificationQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SpecificationDao {
    int countByExample(SpecificationQuery example);

    int deleteByExample(SpecificationQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Specification record);

    int insertSelective(Specification record);

    List<Specification> selectByExample(SpecificationQuery example);

    Specification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Specification record, @Param("example") SpecificationQuery example);

    int updateByExample(@Param("record") Specification record, @Param("example") SpecificationQuery example);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}