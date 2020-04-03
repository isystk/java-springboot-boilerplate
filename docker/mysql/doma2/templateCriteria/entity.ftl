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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ${simpleName}Criteria {

<#list ownEntityPropertyDescs as property>

<#if property.name == "version">
<#elseif 0 lt property.name?index_of("Flg") >
    <#if !useAccessor>public </#if>boolean ${property.name}True;
    <#if !useAccessor>public </#if>boolean ${property.name}False;
<#else>
    <#if !useAccessor>public </#if>${property.propertyClassSimpleName} ${property.name}Equal;
    <#if !useAccessor>public </#if>${property.propertyClassSimpleName} ${property.name}NotEqual;
    <#if !useAccessor>public </#if>boolean ${property.name}IsNull;
    <#if !useAccessor>public </#if>boolean ${property.name}IsNotNull;
<#if (property.date || property.timestamp)>
<#elseif property.number>
    <#if !useAccessor>public </#if>List<${property.propertyClassSimpleName}> ${property.name}In;
    <#if !useAccessor>public </#if>List<${property.propertyClassSimpleName}> ${property.name}NotIn;
<#else>
    <#if !useAccessor>public </#if>${property.propertyClassSimpleName} ${property.name}Like;
</#if>
</#if>
</#list>
}