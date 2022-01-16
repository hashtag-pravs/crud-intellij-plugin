package com.github.mars05.crud.intellij.plugin.service;

import com.github.mars05.crud.intellij.plugin.model.template.ProjectTemplate;

import java.util.List;

/**
 * ProjectTemplateService
 *
 * @author xiaoyu
 */
public interface ProjectTemplateService {

    /**
     * Query all project template names
     *
     * @return List of project template names
     */
    List<String> findAllName();

    /**
     * Get project template by name
     *
     * @param name project template name
     * @return project template
     */
    ProjectTemplate getByName(String name);

}
