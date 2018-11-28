package com.social.core.dao.category;

import com.social.core.pojo.category.MaterialTypeTemplate;
import com.social.core.pojo.category.MaterialTypeTemplateQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialTypeTemplateDao {
    int countByExample(MaterialTypeTemplateQuery example);

    int deleteByExample(MaterialTypeTemplateQuery example);

    int insert(MaterialTypeTemplate record);

    int insertSelective(MaterialTypeTemplate record);

    List<MaterialTypeTemplate> selectByExample(MaterialTypeTemplateQuery example);

    int updateByExampleSelective(@Param("record") MaterialTypeTemplate record, @Param("example") MaterialTypeTemplateQuery example);

    int updateByExample(@Param("record") MaterialTypeTemplate record, @Param("example") MaterialTypeTemplateQuery example);
}