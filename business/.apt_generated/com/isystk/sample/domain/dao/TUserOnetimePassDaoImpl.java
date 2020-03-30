package com.isystk.sample.domain.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-30T15:00:09.214+0900")
public class TUserOnetimePassDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.isystk.sample.domain.dao.TUserOnetimePassDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TUserOnetimePassDao.class, "insert", com.isystk.sample.domain.entity.TUserOnetimePass.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TUserOnetimePassDao.class, "update", com.isystk.sample.domain.entity.TUserOnetimePass.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TUserOnetimePassDao.class, "delete", com.isystk.sample.domain.entity.TUserOnetimePass.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TUserOnetimePassDao.class, "selectAll", com.isystk.sample.domain.dto.TUserOnetimePassCriteria.class, org.seasar.doma.jdbc.SelectOptions.class, java.util.stream.Collector.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TUserOnetimePassDao.class, "selectById", java.lang.Integer.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TUserOnetimePassDao.class, "select", com.isystk.sample.domain.dto.TUserOnetimePassCriteria.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public TUserOnetimePassDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public int insert(com.isystk.sample.domain.entity.TUserOnetimePass entity) {
        entering("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<com.isystk.sample.domain.entity.TUserOnetimePass> __query = getQueryImplementors().createAutoInsertQuery(__method0, com.isystk.sample.domain.entity._TUserOnetimePass.getSingletonInternal());
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = getCommandImplementors().createInsertCommand(__method0, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(com.isystk.sample.domain.entity.TUserOnetimePass entity) {
        entering("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoUpdateQuery<com.isystk.sample.domain.entity.TUserOnetimePass> __query = getQueryImplementors().createAutoUpdateQuery(__method1, com.isystk.sample.domain.entity._TUserOnetimePass.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl");
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
            org.seasar.doma.jdbc.command.UpdateCommand __command = getCommandImplementors().createUpdateCommand(__method1, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(com.isystk.sample.domain.entity.TUserOnetimePass entity) {
        entering("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoDeleteQuery<com.isystk.sample.domain.entity.TUserOnetimePass> __query = getQueryImplementors().createAutoDeleteQuery(__method2, com.isystk.sample.domain.entity._TUserOnetimePass.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = getCommandImplementors().createDeleteCommand(__method2, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public <R> R selectAll(com.isystk.sample.domain.dto.TUserOnetimePassCriteria criteria, org.seasar.doma.jdbc.SelectOptions options, java.util.stream.Collector<com.isystk.sample.domain.entity.TUserOnetimePass, ?, R> collector) {
        entering("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "selectAll", criteria, options, collector);
        try {
            if (criteria == null) {
                throw new org.seasar.doma.DomaNullPointerException("criteria");
            }
            if (options == null) {
                throw new org.seasar.doma.DomaNullPointerException("options");
            }
            if (collector == null) {
                throw new org.seasar.doma.DomaNullPointerException("collector");
            }
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method3);
            __query.setMethod(__method3);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/TUserOnetimePassDao/selectAll.sql");
            __query.setOptions(options);
            __query.setEntityType(com.isystk.sample.domain.entity._TUserOnetimePass.getSingletonInternal());
            __query.addParameter("criteria", com.isystk.sample.domain.dto.TUserOnetimePassCriteria.class, criteria);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<R> __command = getCommandImplementors().createSelectCommand(__method3, __query, new org.seasar.doma.internal.jdbc.command.EntityCollectorHandler<com.isystk.sample.domain.entity.TUserOnetimePass, R>(com.isystk.sample.domain.entity._TUserOnetimePass.getSingletonInternal(), collector));
            R __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Optional<com.isystk.sample.domain.entity.TUserOnetimePass> selectById(java.lang.Integer userId) {
        entering("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "selectById", userId);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method4);
            __query.setMethod(__method4);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/TUserOnetimePassDao/selectById.sql");
            __query.setEntityType(com.isystk.sample.domain.entity._TUserOnetimePass.getSingletonInternal());
            __query.addParameter("userId", java.lang.Integer.class, userId);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.Optional<com.isystk.sample.domain.entity.TUserOnetimePass>> __command = getCommandImplementors().createSelectCommand(__method4, __query, new org.seasar.doma.internal.jdbc.command.OptionalEntitySingleResultHandler<com.isystk.sample.domain.entity.TUserOnetimePass>(com.isystk.sample.domain.entity._TUserOnetimePass.getSingletonInternal()));
            java.util.Optional<com.isystk.sample.domain.entity.TUserOnetimePass> __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Optional<com.isystk.sample.domain.entity.TUserOnetimePass> select(com.isystk.sample.domain.dto.TUserOnetimePassCriteria criteria) {
        entering("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "select", criteria);
        try {
            if (criteria == null) {
                throw new org.seasar.doma.DomaNullPointerException("criteria");
            }
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method5);
            __query.setMethod(__method5);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/TUserOnetimePassDao/select.sql");
            __query.setEntityType(com.isystk.sample.domain.entity._TUserOnetimePass.getSingletonInternal());
            __query.addParameter("criteria", com.isystk.sample.domain.dto.TUserOnetimePassCriteria.class, criteria);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl");
            __query.setCallerMethodName("select");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.Optional<com.isystk.sample.domain.entity.TUserOnetimePass>> __command = getCommandImplementors().createSelectCommand(__method5, __query, new org.seasar.doma.internal.jdbc.command.OptionalEntitySingleResultHandler<com.isystk.sample.domain.entity.TUserOnetimePass>(com.isystk.sample.domain.entity._TUserOnetimePass.getSingletonInternal()));
            java.util.Optional<com.isystk.sample.domain.entity.TUserOnetimePass> __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "select", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TUserOnetimePassDaoImpl", "select", __e);
            throw __e;
        }
    }

}
