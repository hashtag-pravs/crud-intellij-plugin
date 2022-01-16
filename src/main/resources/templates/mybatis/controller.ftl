package ${package};

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
<#list imports as import>
    import ${import};
</#list>

<#assign model=service.dao.model />
<#list model.fields as field>
    <#if field.id>
/**
 * ${comment}
 */
@RestController
@RequestMapping("/${model.varName+'s'}")
@Api(tags = "${model.comment}")
public class ${simpleName} {
    @Autowired
    private ${service.simpleName} ${service.varName};

    @GetMapping("/{id}")
    @ApiOperation("find by id ${model.comment}")
    public ${model.simpleName} findById(@ApiParam("ID") @PathVariable("id") ${field.typeSimpleName} id) {
        return ${service.varName}.findById(id);
    }

    @GetMapping
    @ApiOperation("Paging query ${model.comment}")
    public PageInfo<${model.simpleName}> findByPage(@ApiParam("Page number") @RequestParam(defaultValue = "1") Integer pageNum,
                                                @ApiParam("Size per page") @RequestParam(defaultValue = "10") Integer pageSize) {
        return ${service.varName}.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation("Create ${model.comment}")
    public void insert(@RequestBody ${model.simpleName} ${model.varName}) {
        ${service.varName}.insert(${model.varName});
    }

    @PutMapping
    @ApiOperation("Update ${model.comment}")
    public void update(@RequestBody ${model.simpleName} ${model.varName}) {
        ${service.varName}.update(${model.varName});
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete by ID ${model.comment}")
    public void deleteById(@ApiParam("ID") @PathVariable("id") ${field.typeSimpleName} id) {
        ${service.varName}.deleteById(id);
    }
}
    </#if>
</#list>