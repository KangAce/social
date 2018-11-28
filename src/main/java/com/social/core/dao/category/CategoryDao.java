package com.social.core.dao.category;

import com.social.core.pojo.category.Category;
import com.social.core.pojo.category.CategoryQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryDao {
    int countByExample(CategoryQuery example);

    int deleteByExample(CategoryQuery example);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryQuery example);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryQuery example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryQuery example);
}