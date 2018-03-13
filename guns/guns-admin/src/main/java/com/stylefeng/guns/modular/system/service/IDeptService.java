package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.core.node.TreeViewNode;

import java.util.List;

/**
 * 部门服务
 *
 * @author fengshuonan
 * @date 2017-04-27 17:00
 */
public interface IDeptService {

    /**
     * 删除部门
     *
     * @author stylefeng
     * @Date 2017/7/11 22:30
     */
   void deleteDept(Integer deptId);

    /**
     * 根据Pid向下递归获取所有子节点
     * @param deptId
     */
   public List<TreeViewNode> getAllDeptsByPid(Integer deptId);
}
