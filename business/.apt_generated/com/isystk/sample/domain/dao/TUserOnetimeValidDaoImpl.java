package com.isystk.sample.domain.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-26T00:53:30.451+0900")
public class TUserOnetimeValidDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.isystk.sample.domain.dao.TUserOnetimeValidDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TUserOnetimeValidDao.class, "selectById", java.lang.Integer.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TUserOnetimeValidDao.class, "insert", com.isystk.sample.domain.entity.TUserOnetimeValid.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TUserOnetimeValidDao.class, "update", com.isystk.sample.domain.entity.TUserOnetimeValid.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TUserOnetimeValidDao.class, "delete", com.isystk.sample.domain.entity.TUserOnetimeValid.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public TUserOnetimeValidDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public com.isystk.sample.domain.entity.TUserOnetimeValid selectById(java.lang.Integer userId) {
        entering("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "selectById", userId);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/TUserOnetimeValidDao/selectById.sql");
            __query.setEntityType(com.isystk.sample.domain.entity._TUserOnetimeValid.getSingletonInternal());
            __query.addParameter("userId", java.lang.Integer.class, userId);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<com.isystk.sample.domain.entity.TUserOnetimeValid> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<com.isystk.sample.domain.entity.TUserOnetimeValid>(com.isystk.sample.domain.entity._TUserOnetimeValid.getSingletonInternal()));
            com.isystk.sample.domain.entity.TUserOnetimeValid __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int insert(com.isystk.sample.domain.entity.TUserOnetimeValid entity) {
        entering("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<com.isystk.sample.domain.entity.TUserOnetimeValid> __query = getQueryImplementors().createAutoInsertQuery(__method1, com.isystk.sample.domain.entity._TUserOnetimeValid.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = getCommandImplementors().createInsertCommand(__method1, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(com.isystk.sample.domain.entity.TUserOnetimeValid entity) {
        entering("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoUpdateQuery<com.isystk.sample.domain.entity.TUserOnetimeValid> __query = getQueryImplementors().createAutoUpdateQuery(__method2, com.isystk.sample.domain.entity._TUserOnetimeValid.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl");
            __query.setCallerMethodName("update");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.UpdateCommand __command = getCommandImplementors().createUpdateCommand(__method2, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(com.isystk.sample.domain.entity.TUserOnetimeValid entity) {
        entering("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoDeleteQuery<com.isystk.sample.domain.entity.TUserOnetimeValid> __query = getQueryImplementors().createAutoDeleteQuery(__method3, com.isystk.sample.domain.entity._TUserOnetimeValid.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = getCommandImplementors().createDeleteCommand(__method3, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TUserOnetimeValidDaoImpl", "delete", __e);
            throw __e;
        }
    }

}
