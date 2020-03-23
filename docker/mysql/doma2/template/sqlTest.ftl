<#-- このテンプレートに対応するデータモデルのクラスは org.seasar.doma.extension.gen.SqlTestDesc です -->
<#import "/lib.ftl" as lib>
<#if lib.copyright??>
${lib.copyright}
</#if>
<#if packageName??>
package ${packageName};
</#if>

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

import junit.framework.TestCase;

import org.seasar.doma.jdbc.NoCacheSqlFileRepository;
import org.seasar.doma.jdbc.SqlFile;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;

/**
 * 
<#if lib.author??>
 * @author ${lib.author}
</#if>
 */
public<#if abstrct> abstract</#if> class ${simpleName} extends TestCase {

    /** */
    protected SqlFileRepository repository;

    /** */
    protected Dialect dialect;

    /** */
    protected Driver driver;

    /** */
    protected String url;

    /** */
    protected String user;

    /** */
    protected String password;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        repository = new NoCacheSqlFileRepository();
        dialect = new ${dialectClassName}();
        @SuppressWarnings("unchecked")
        Class<Driver> driverClass = (Class<Driver>) Class.forName("${driverClassName}");
        driver = driverClass.newInstance();
        DriverManager.registerDriver(driver);
        url = "${url}";
        user = "${user}";
        password = "${password}";
    }

    @Override
    protected void tearDown() throws Exception {
        DriverManager.deregisterDriver(driver);
        super.tearDown();
    }

    /**
     * 
     * @param sqlFile
     * @throws Exception
     */
    protected void execute(SqlFile sqlFile) throws Exception {
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            try {
                statement.execute(sqlFile.getSql());
            } finally {
                statement.close();
            }
        } finally {
            try {
                connection.rollback();
            } finally {
                connection.close();
            }
        }
    }

    /**
     * 
     * @return
     * @throws Exception
     */
    protected Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }
<#list sqlFilePaths as path>

    /**
     * 
     * @throws Exception
     */
    public void test${path_index}() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("${path}", dialect);
        execute(sqlFile);
    }
</#list>

}