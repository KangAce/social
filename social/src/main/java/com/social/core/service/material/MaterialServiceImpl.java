package com.social.core.service.material;

import com.social.core.pojo.entity.PageResult;
import com.social.core.pojo.material.MaterialEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kang
 */
@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {
    /**
     * 新增一条素材
     *
     * @param materialEntity
     * @return
     * @throws Exception
     */
    @Override
    public int add(MaterialEntity materialEntity) throws Exception {
        return 0;
    }

    /**
     * 更新一条素材（ID不为空）
     *
     * @param materialEntity 要更新的素材（ID不为空）
     * @return
     * @throws Exception
     */
    @Override
    public int update(MaterialEntity materialEntity) throws Exception {
        return 0;
    }

    /**
     * 根据ID删除一条素材信息(逻辑删除)
     *
     * @param id 需要删除的素材ID
     * @return 返回删除的数量
     * @throws Exception
     */
    @Override
    public int deleteByID(Integer id) throws Exception {
        return 0;
    }

    /**
     * 根据IDS字符串删除素材 （英文逗号隔开）
     *
     * @param ids 英文逗号隔开
     * @return 返回删除的数量
     * @throws Exception
     */
    @Override
    public int deleteByIDs(String ids) throws Exception {
        return 0;
    }

    /**
     * 根据ID查询商品详情
     *
     * @param id 素材ID
     * @return 返回MaterialEntity对象（关于素材的所有信息）
     * @throws Exception
     */
    @Override
    public MaterialEntity queryOneByID(Integer id) throws Exception {
        return null;
    }

    /**
     * 分页查询素材
     *
     * @param pageNum  第几页
     * @param pageSize 每页显示几条数据
     * @return PageResult分页结果
     * @throws Exception
     */

    @Override
    public PageResult queryAllByPage(Integer pageNum, Integer pageSize) throws Exception {
        return null;
    }
}
