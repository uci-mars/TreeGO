package com.mmm.treego;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    private int TreeID;
    private float x, y;
    private String name;
    private String description;
    private List<String> treeData;

    public Tree ()
    {
        treeData = new ArrayList<>();
    }

    public int getTreeID ()
    {
        return TreeID;
    }

    public float getX ()
    {
        return x;
    }

    public float getY ()
    {
        return y;
    }

    public String getName ()
    {
        return name;
    }

    public String getDesc ()
    {
        return description;
    }

    public List<String> getTreeData ()
    {
        return treeData;
    }

    public void setTreeID (int TreeID)
    {
        this.TreeID = TreeID;
    }

    public void setX (float x)
    {
        this.x = x;
    }

    public void setY (float y)
    {
        this.y = y;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public void setDesc (String description)
    {
        this.description = description;
    }

    public void addData (String data)
    {
        this.treeData.add(data);
    }
}
