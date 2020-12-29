<#-- このテンプレートに対応するデータモデルのクラスは org.seasar.doma.extension.gen.EntityDesc です -->
<#import "/lib.ftl" as lib>
<#if lib.copyright??>
${lib.copyright}
</#if>
<#if packageName??>
package ${packageName};
</#if>

<#list importNames as importName>
import ${importName};
</#list>
import com.isystk.sample.domain.dto.common.DomaDtoImpl;

import lombok.Getter;
import lombok.Setter;

/**
<#if showDbComment && comment??>
 * ${comment}
</#if>
 *
 * 自動生成のため原則修正禁止!!
 *
<#if lib.author??>
 * @author ${lib.author}
</#if>
 */
@Entity<#if useListener || namingType != "NONE">(</#if><#if useListener>listener = ${listenerClassSimpleName}.class</#if><#if namingType != "NONE"><#if useListener>, </#if>naming = ${namingType.referenceName}</#if><#if useListener || namingType != "NONE">)</#if>
<#if showCatalogName && catalogName?? || showSchemaName && schemaName?? || showTableName && tableName??>
@Table(<#if showCatalogName && catalogName??>catalog = "${catalogName}"</#if><#if showSchemaName && schemaName??><#if showCatalogName && catalogName??>, </#if>schema = "${schemaName}"</#if><#if showTableName><#if showCatalogName && catalogName?? || showSchemaName && schemaName??>, </#if>name = "${tableName}"</#if>)
</#if>
@Getter
@Setter
public class ${simpleName} extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

<#list ownEntityPropertyDescs as property>

  <#if showDbComment && property.comment??>
    /** ${property.comment} */
  <#else>
    /** */
  </#if>
  <#if property.id>
    @Id
    <#if property.generationType??>
    @GeneratedValue(strategy = ${property.generationType.referenceName})
      <#if property.generationType == "SEQUENCE">
    @SequenceGenerator(sequence = "${tableName}_${property.columnName}"<#if property.initialValue??>, initialValue = ${property.initialValue}</#if><#if property.allocationSize??>, allocationSize = ${property.allocationSize}</#if>)
      <#elseif property.generationType == "TABLE">
    @TableGenerator(pkColumnValue = "${tableName}_${property.columnName}"<#if property.initialValue??>, initialValue = ${property.initialValue}</#if><#if property.allocationSize??>, allocationSize = ${property.allocationSize}</#if>)
      </#if>
    </#if>
  </#if>
  <#if property.version>
    @Version
  </#if>
  <#if property.showColumnName && property.columnName??>
    @Column(name = "${property.columnName}")
  </#if>
    <#if !useAccessor>public </#if>${property.propertyClassSimpleName} ${property.name};
</#list>
<#if originalStatesPropertyName??>

    /** */
    @OriginalStates
    ${simpleName} ${originalStatesPropertyName};
</#if>
}