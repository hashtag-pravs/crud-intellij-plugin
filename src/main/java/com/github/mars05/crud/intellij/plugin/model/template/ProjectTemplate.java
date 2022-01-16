package com.github.mars05.crud.intellij.plugin.model.template;

import lombok.Data;

import java.util.List;

/**
 * project template
 *
 * @author xiaoyu
 */
@Data
public class ProjectTemplate {

    /**
     * name
     */
    private String name;

    /**
     * fileTemplateList
     */
    private List<FileTemplate> fileTemplateList;

}
