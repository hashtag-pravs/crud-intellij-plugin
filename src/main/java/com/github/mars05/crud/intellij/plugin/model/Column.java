package com.github.mars05.crud.intellij.plugin.model;

/**
 * @author xiaoyu
 */
public class Column {
    private String comment;
    private String name;
    private int type;
    private boolean id;

    /**
     * @param comment column comment
     * @param name    column name
     * @param type    type
     */
    public Column(String comment, String name, int type) {
        this.comment = comment;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public boolean isId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setId(boolean id) {
        this.id = id;
    }
}
