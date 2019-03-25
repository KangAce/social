package com.social.core.controller.material;

import com.social.core.pojo.category.Category;
import com.social.core.pojo.entity.Result;
import com.social.core.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 返回分类
     * @return
     */
    @RequestMapping("queryCategoryByParentID")
    public List<Category> queryCategoryByParentID(Long parentID){
        List<Category> categories=null;

        try {
            categories = categoryService.queryCategoryByParentID(parentID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
    /**
         * 返回分类
         * @return
         */
        @RequestMapping("queryCategoryByID")
        public Category queryCategoryByID(Long ID){
            Category category=null;

            try {
                category = categoryService.queryCategoryByID(ID);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return category;
        }

    @RequestMapping("deleteCategory")
    @Secured("ROLE_ADMIN")
    public Result deleteCategory(Integer categoryID){

        try {
            int i = categoryService.deleteCategoryByID(categoryID);
            if (i==0){
                return new Result(false,"删除失败：没有数据被删除");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败："+e.getMessage());
        }
        return new Result(true,"删除成功");
    }

    @RequestMapping("addCategroy")
    public Result addCategroy(Category entity){

        try {
            if (categoryService.addCategory(entity)==0){
                return new Result(false,"添加分类失败:没有数据变化");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加分类错误："+e.getMessage());
        }
        return new Result(true,"添加成功");
    }

    @RequestMapping("saveCategroy")
    public Result saveCategroy(Category entity){

        try {
            if (categoryService.saveCategory(entity)==0) {
                return new Result(false,"更新分类失败:没有数据变化");
            };
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新分类失败："+e.getMessage());
        }

        return new Result(true,"更新分类成功");
    }

}
