<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${name}">

    <resultMap id="${model.varName}Map" type="${model.name}">
        <#list model.fields as field>
        <#if field.id>
        <id property="${field.name}" column="${field.columnName}"/>
        <#else>
        <result property="${field.name}" column="${field.columnName}"/>
        </#if>
        </#list>
    </resultMap>

    <!--Find by ID ${model.comment}-->
    <select id="findById" resultMap="${model.varName}Map">
        SELECT <#list model.fields as field><#if field_index!=0>,</#if>${field.columnName}</#list> FROM ${model.tableName}
        WHERE <#list model.fields as field><#if field.id>${field.columnName}</#if></#list>=<#noparse>#{id}</#noparse>
    </select>

    <!--Paging query ${model.comment}-->
    <select id="findByPage" resultMap="${model.varName}Map">
        SELECT <#list model.fields as field><#if field_index!=0>,</#if>${field.columnName}</#list> FROM ${model.tableName}
    </select>

    <!--Insert ${model.comment}-->
    <insert id="insert">
        INSERT INTO ${model.tableName}(<#list model.fields as field><#if field_index!=0>,</#if>${field.columnName}</#list>)
        VALUES (<#list model.fields as field><#if field_index!=0>,</#if><#noparse>#{</#noparse>${field.name}}</#list>)
    </insert>

    <!--Update ${model.comment}-->
    <update id="update">
        UPDATE ${model.tableName} SET <#list model.fields as field><#if !field.id><#if model.fields[0].id&&field_index!=1>,</#if>${field.columnName}=<#noparse>#{</#noparse>${field.name}}</#if></#list>
        WHERE <#list model.fields as field><#if field.id>${field.columnName}=<#noparse>#{</#noparse>${field.name}}</#if></#list>
    </update>

    <!--Delete by id ${model.comment}-->
    <delete id="deleteById">
        DELETE FROM ${model.tableName}
        WHERE <#list model.fields as field><#if field.id>${field.columnName}</#if></#list>=<#noparse>#{id}</#noparse>
    </delete>

</mapper>