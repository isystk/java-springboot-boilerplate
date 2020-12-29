<#-- このテンプレートに対応するデータモデルのクラスは org.seasar.doma.extension.gen.DaoDelegateDesc です -->
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
<#if lib.author??>
 * @author ${lib.author}
</#if>
 */
public class ${simpleName} {

    private final Config config;

    private final ${daoDesc.simpleName} dao;

    /**
     * @param config the config
     * @param dao the Dao
     */
    public ${simpleName}(Config config, ${daoDesc.simpleName} dao) {
        if (config == null) {
            throw new NullPointerException("config");
        }
        if (dao == null) {
            throw new NullPointerException("dao");
        }
        this.config = config;
        this.dao = dao;
    }

    /**
     * @param entity
     * @return affected rows
     */
    public int insert(${daoDesc.entityDesc.simpleName} entity) {
        return -1;
    }

    /**
     * @param entity
     * @return affected rows
     */
    public int update(${daoDesc.entityDesc.simpleName} entity) {
        return -1;
    }

    /**
     * @param entity
     * @return affected rows
     */
    public int delete(${daoDesc.entityDesc.simpleName} entity) {
        return -1;
    }
}