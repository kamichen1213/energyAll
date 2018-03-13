package com.stylefeng.guns.core.node;

import java.util.List;

public class TreeViewNode {

    private int nodeId;    //树的节点Id，区别于数据库中保存的数据Id。若要存储数据库数据的Id，添加新的Id属性；若想为节点设置路径，类中添加Path属性

    private Long dataId;

    private String text;   //节点名称

    private List<TreeViewNode> nodes;    //子节点，可以用递归的方法读取

    public TreeViewNode() { }

    public TreeViewNode(Long dataId, String str, List<TreeViewNode> node)
    {
        this.dataId = dataId;
        text = str;
        nodes = node;
    }

    public TreeViewNode(Long dataId, String str)
    {
        this.dataId = dataId;
        text = str;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TreeViewNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeViewNode> nodes) {
        this.nodes = nodes;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }
}
