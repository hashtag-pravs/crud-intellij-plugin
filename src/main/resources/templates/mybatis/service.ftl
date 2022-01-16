package ${package};

import com.github.pagehelper.PageInfo;
<#list imports as import>
    import ${import};
</#list>

/**
 * ${comment}
 */
public interface ${simpleName} {

<#assign model=dao.model />
<#list model.fields as field>
    <#if field.id>
    /**
     * Find by ID ${model.comment}
     *
     * @param id ID
     * @return {@link ${model.simpleName}}
     */
     ${model.simpleName} findById(${field.typeSimpleName} id);

    /**
     * Paging query ${model.comment}
     *
     * @param pageNum   Page number
     * @param pageSize Size per page
     * @return {@link ${model.simpleName}}
     */
     PageInfo<${model.simpleName}> findByPage(int pageNum, int pageSize);

    /**
     * Insert ${model.comment}
     *
     * @param ${model.varName} ${model.comment}
     */
    void insert(${model.simpleName} ${model.varName});

    /**
     * Update ${model.comment}
     *
     * @param ${model.varName} ${model.comment}
     */
    void update(${model.simpleName} ${model.varName});

    /**
     * Delete by ID ${model.comment}
     *
     * @param id ID
     */
    void deleteById(${field.typeSimpleName} id);
    </#if>
</#list>

}