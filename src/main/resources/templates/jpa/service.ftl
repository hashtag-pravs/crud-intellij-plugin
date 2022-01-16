package ${package};

import org.springframework.data.domain.Page;
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
     *  Find by ID ${model.comment}
     *
     * @param id ID
     * @return {@link ${model.simpleName}}
     */
     ${model.simpleName} findById(${field.typeSimpleName} id);

    /**
     * Paging query ${model.comment}
     *
     * @param pageNum   页号
     * @param pageSize 每页大小
     * @return {@link ${model.simpleName}}
     */
     Page<${model.simpleName}> findByPage(int pageNum, int pageSize);

    /**
     * New ${model.comment}
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
     * Delet by Id ${model.comment}
     *
     * @param id ID
     */
    void deleteById(${field.typeSimpleName} id);
    </#if>
</#list>

}