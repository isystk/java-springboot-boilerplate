package com.isystk.sample.domain;

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
 */
public class SqlTest extends TestCase {

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
        dialect = new org.seasar.doma.jdbc.dialect.MysqlDialect();
        @SuppressWarnings("unchecked")
        Class<Driver> driverClass = (Class<Driver>) Class.forName("com.mysql.cj.jdbc.Driver");
        driver = driverClass.newInstance();
        DriverManager.registerDriver(driver);
        url = "jdbc:mysql://127.0.0.1:3306/sample";
        user = "root";
        password = "password";
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

    /**
     * 
     * @throws Exception
     */
    public void test0() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/ItemDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test1() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/MMailTemplateDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test2() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/MMailTemplateDao/selectByIdAndVersion.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test3() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/MPostTagDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test4() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/StaffDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test5() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/SysConfigDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test6() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/TImageDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test7() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/TPostDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test8() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/TPostDao/selectByIdAndVersion.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test9() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/TPostImageDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test10() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/TPostTagDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test11() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/TStaffDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test12() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/TStaffDao/selectByIdAndVersion.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test13() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/TUserDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test14() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/TUserDao/selectByIdAndVersion.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test15() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/TUserOnetimePassDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     * 
     * @throws Exception
     */
    public void test16() throws Exception {
        SqlFile sqlFile = repository.getSqlFile("META-INF/com/isystk/sample/domain/dao/TUserOnetimeValidDao/selectById.sql", dialect);
        execute(sqlFile);
    }

}