<#-- このテンプレートに対応するデータモデルのクラスは org.seasar.doma.extension.gen.EntityListenerDesc です -->
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

/**
 * 
<#if lib.author??>
 * @author ${lib.author}
</#if>
 */
public class ${simpleName}<#if superclassSimpleName??> extends ${superclassSimpleName}<${entityClassSimpleName}><#else> implements EntityListener<${entityClassSimpleName}></#if> {
<#if !superclassSimpleName??>

    @Override
    public void preInsert(${entityClassSimpleName} entity, PreInsertContext<${entityClassSimpleName}> context) {
    }

    @Override
    public void preUpdate(${entityClassSimpleName} entity, PreUpdateContext<${entityClassSimpleName}> context) {
    }

    @Override
    public void preDelete(${entityClassSimpleName} entity, PreDeleteContext<${entityClassSimpleName}> context) {
    }

    @Override
    public void postInsert(${entityClassSimpleName} entity, PostInsertContext<${entityClassSimpleName}> context) {
    }

    @Override
    public void postUpdate(${entityClassSimpleName} entity, PostUpdateContext<${entityClassSimpleName}> context) {
    }

    @Override
    public void postDelete(${entityClassSimpleName} entity, PostDeleteContext<${entityClassSimpleName}> context) {
    }
</#if>
}