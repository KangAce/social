package com.social.core.controller.material;

import com.social.core.pojo.category.MaterialTypeTemplate;
import com.social.core.pojo.entity.PageResult;
import com.social.core.pojo.entity.Result;
import com.social.core.service.category.MaterialTypeTemplateSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kang
 */
@RestController
@RequestMapping("materialTypeTemplate")
public class MaterialTypeTemplateController {


    @Autowired
    MaterialTypeTemplateSrevice materialTypeTemplateSrevice;
    @RequestMapping("queryAllByPage")
    public PageResult queryAllByPage(Integer pageNum, Integer pageSize) {
        PageResult pageResult = null;

        try {
            pageResult = materialTypeTemplateSrevice.queryAllByPage(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pageResult;
    }
    @RequestMapping("add")
    public Result add(MaterialTypeTemplate materialTypeTemplate) {

        try {
            if(materialTypeTemplateSrevice.add(materialTypeTemplate)==0){
                    return new Result(false,"添加模板数据失败:添加数量为0");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加模板数据出现异常，添加失败");
        }

        return new Result(false,"添加模板数据出现异常，添加失败");
    }
    @RequestMapping("queryOne")
    public MaterialTypeTemplate queryOne(Long id) {
        MaterialTypeTemplate materialTypeTemplate =null;
        try {
            materialTypeTemplate = materialTypeTemplateSrevice.queryByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return materialTypeTemplate;
    }

}
