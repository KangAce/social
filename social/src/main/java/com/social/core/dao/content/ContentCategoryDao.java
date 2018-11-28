package com.social.core.dao.content;

import com.social.core.pojo.content.ContentCategory;
import com.social.core.pojo.content.ContentCategoryQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentCategoryDao {
    int countByExample(ContentCategoryQuery example);

    int deleteByExample(ContentCategoryQuery example);

    int insert(ContentCategory record);

    int insertSelective(ContentCategory record);

    List<ContentCategory> selectByExample(ContentCategoryQuery example);

    int updateByExampleSelective(@Param("record") ContentCategory record, @Param("example") ContentCategoryQuery example);

    int updateByExample(@Param("record") ContentCategory record, @Param("example") ContentCategoryQuery example);
}