package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.persistence.dao.DeptMapper;
import com.stylefeng.guns.common.persistence.model.Dept;
import com.stylefeng.guns.core.node.TreeViewNode;
import com.stylefeng.guns.modular.system.dao.DeptDao;
import com.stylefeng.guns.modular.system.service.IDeptService;
import com.stylefeng.guns.modular.system.warpper.AjaxWarpper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements IDeptService {

    @Resource
    DeptMapper deptMapper;

    @Resource
    DeptDao deptDao;

    @Override
    public void deleteDept(Integer deptId) {

        Dept dept = deptMapper.selectById(deptId);

        Wrapper<Dept> wrapper = new EntityWrapper<>();
        wrapper = wrapper.like("pids", "%[" + dept.getId() + "]%");
        List<Dept> subDepts = deptMapper.selectList(wrapper);
        for (Dept temp : subDepts) {
            temp.deleteById();
        }

        dept.deleteById();
    }

    public List<TreeViewNode> getAllDeptsByPid(Integer pid){
        List<Dept> queryResult = new ArrayList<Dept>();
        List<TreeViewNode> treeViewNodes = new ArrayList<TreeViewNode>();
        if(pid == null){
            return null;
        }
        queryResult = this.deptDao.getDptByPid(pid);
        if(queryResult.size() == 0){
            return null;
        }
        for(Dept current : queryResult){
            TreeViewNode currentNode = new TreeViewNode();
            List<TreeViewNode> sons = getAllDeptsByPid(current.getId());
            currentNode.setDataId(Long.valueOf(current.getId()));
            currentNode.setText(current.getSimplename());
            if(sons == null) {
                treeViewNodes.add(currentNode);
                continue;
            }else {
                currentNode.setNodes(sons);
                treeViewNodes.add(currentNode);
            }
        }
        return treeViewNodes;
    }
}
