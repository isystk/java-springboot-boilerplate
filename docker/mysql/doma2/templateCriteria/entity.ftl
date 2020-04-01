<#-- このテンプレートに対応するデータモデルのクラスは org.seasar.doma.extension.gen.EntityDesc です -->
<#import "/lib.ftl" as lib>
<#if lib.copyright??>
${lib.copyright}
</#if>
<#if packageName??>
package ${packageName};
</#if>

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.isystk.sample.domain.entity.${simpleName};

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ${simpleName}Criteria extends ${simpleName} {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

<#list ownEntityPropertyDescs as property>

    <#if !useAccessor>public </#if>${property.propertyClassSimpleName} ${property.name}Equal;
    <#if !useAccessor>public </#if>${property.propertyClassSimpleName} ${property.name}NotEqual;
    <#if !useAccessor>public </#if>boolean ${property.name}IsNull;
    <#if !useAccessor>public </#if>boolean ${property.name}IsNotNull;
    <#if !useAccessor>public </#if>List<${property.propertyClassSimpleName}> ${property.name}In;
    <#if !useAccessor>public </#if>List<${property.propertyClassSimpleName}> ${property.name}NotIn;
    <#if !useAccessor>public </#if>${property.propertyClassSimpleName} ${property.name}Like;
</#list>
}