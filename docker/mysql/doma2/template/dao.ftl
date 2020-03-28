<#-- このテンプレートに対応するデータモデルのクラスは org.seasar.doma.extension.gen.DaoDesc です -->
<#import "/lib.ftl" as lib>
<#if lib.copyright??>
${lib.copyright}
</#if>
<#if packageName??>
package ${packageName};
</#if>

<#list lib.annotationHash?values as annotationImportName>
import ${annotationImportName};
</#list>

import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

<#list importNames as importName>
import ${importName};
</#list>
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.${entityDesc.simpleName}Criteria;

/**
<#if lib.author??>
 * @author ${lib.author}
</#if>
 */
 <#list lib.annotationHash?keys as annotation>
@${annotation}
</#list>
@Dao<#if configClassSimpleName??>(config = ${configClassSimpleName}.class)</#if>
public interface ${simpleName} {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(${entityDesc.simpleName} entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(${entityDesc.simpleName} entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(${entityDesc.simpleName} entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R selectAll(final ${entityDesc.simpleName}Criteria criteria, final SelectOptions options, final Collector<${entityDesc.simpleName}, ?, R> collector);

<#if entityDesc.idEntityPropertyDescs?size gt 0>
    /**
<#list entityDesc.idEntityPropertyDescs as property>
     * @param ${property.name}
</#list>
     * @return the ${entityDesc.simpleName} entity
     */
    @Select
    Optional<${entityDesc.simpleName}> selectById(<#list entityDesc.idEntityPropertyDescs as property>${property.propertyClassSimpleName} ${property.name}<#if property_has_next>, </#if></#list>);

</#if>
<#if entityDesc.idEntityPropertyDescs?size gt 0 && entityDesc.versionEntityPropertyDesc??>
    /**
<#list entityDesc.idEntityPropertyDescs as property>
     * @param ${property.name}
</#list>
     * @param ${entityDesc.versionEntityPropertyDesc.name}
     * @return the ${entityDesc.simpleName} entity
     */
    @Select(ensureResult = true)
    Optional<${entityDesc.simpleName}> selectByIdAndVersion(<#list entityDesc.idEntityPropertyDescs as property>${property.propertyClassSimpleName} ${property.name}, </#list>${entityDesc.versionEntityPropertyDesc.propertyClassSimpleName} ${entityDesc.versionEntityPropertyDesc.name});

</#if>

    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<${entityDesc.simpleName}> select(${entityDesc.simpleName}Criteria criteria);

}