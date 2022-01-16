package ${package};

import com.github.pagehelper.Page;
<#list imports as import>
    import ${import};
</#list>

/**
 * ${comment}
 */
public interface ${simpleName} {

<#list model.fields as field>
    <#if field.id>
    /**
     * Find  by ID ${model.comment}
     *
     * @param id ID
     * @return {@link ${model.simpleName}}
     */
     ${model.simpleName} findById(${field.typeSimpleName} id);

    /**
     * Paging query ${model.comment}
     *
     * @return {@link ${model.simpleName}}
     */
     Page<${model.simpleName}> findByPage();

    /**
     * Add ${model.comment}
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
     * Delete by Id ${model.comment}
     *
     * @param id ID
     */
    void deleteById(${field.typeSimpleName} id);
    </#if>
</#list>

}