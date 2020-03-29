package com.isystk.sample.domain.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-29T20:24:40.724+0900")
public class TStaffDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.isystk.sample.domain.dao.TStaffDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TStaffDao.class, "insert", com.isystk.sample.domain.entity.TStaff.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TStaffDao.class, "update", com.isystk.sample.domain.entity.TStaff.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TStaffDao.class, "delete", com.isystk.sample.domain.entity.TStaff.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TStaffDao.class, "selectAll", com.isystk.sample.domain.dto.TStaffCriteria.class, org.seasar.doma.jdbc.SelectOptions.class, java.util.stream.Collector.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TStaffDao.class, "selectById", java.lang.Integer.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TStaffDao.class, "selectByIdAndVersion", java.lang.Integer.class, java.lang.Long.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TStaffDao.class, "select", com.isystk.sample.domain.dto.TStaffCriteria.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public TStaffDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public int insert(com.isystk.sample.domain.entity.TStaff entity) {
        entering("com.isystk.sample.domain.dao.TStaffDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<com.isystk.sample.domain.entity.TStaff> __query = getQueryImplementors().createAutoInsertQuery(__method0, com.isystk.sample.domain.entity._TStaff.getSingletonInternal());
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TStaffDaoImpl");
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
            exiting("com.isystk.sample.domain.dao.TStaffDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TStaffDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(com.isystk.sample.domain.entity.TStaff entity) {
        entering("com.isystk.sample.domain.dao.TStaffDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoUpdateQuery<com.isystk.sample.domain.entity.TStaff> __query = getQueryImplementors().createAutoUpdateQuery(__method1, com.isystk.sample.domain.entity._TStaff.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TStaffDaoImpl");
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
            exiting("com.isystk.sample.domain.dao.TStaffDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TStaffDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(com.isystk.sample.domain.entity.TStaff entity) {
        entering("com.isystk.sample.domain.dao.TStaffDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoDeleteQuery<com.isystk.sample.domain.entity.TStaff> __query = getQueryImplementors().createAutoDeleteQuery(__method2, com.isystk.sample.domain.entity._TStaff.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TStaffDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = getCommandImplementors().createDeleteCommand(__method2, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TStaffDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TStaffDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public <R> R selectAll(com.isystk.sample.domain.dto.TStaffCriteria criteria, org.seasar.doma.jdbc.SelectOptions options, java.util.stream.Collector<com.isystk.sample.domain.entity.TStaff, ?, R> collector) {
        entering("com.isystk.sample.domain.dao.TStaffDaoImpl", "selectAll", criteria, options, collector);
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
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/TStaffDao/selectAll.sql");
            __query.setOptions(options);
            __query.setEntityType(com.isystk.sample.domain.entity._TStaff.getSingletonInternal());
            __query.addParameter("criteria", com.isystk.sample.domain.dto.TStaffCriteria.class, criteria);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TStaffDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<R> __command = getCommandImplementors().createSelectCommand(__method3, __query, new org.seasar.doma.internal.jdbc.command.EntityCollectorHandler<com.isystk.sample.domain.entity.TStaff, R>(com.isystk.sample.domain.entity._TStaff.getSingletonInternal(), collector));
            R __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TStaffDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TStaffDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Optional<com.isystk.sample.domain.entity.TStaff> selectById(java.lang.Integer staffId) {
        entering("com.isystk.sample.domain.dao.TStaffDaoImpl", "selectById", staffId);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method4);
            __query.setMethod(__method4);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/TStaffDao/selectById.sql");
            __query.setEntityType(com.isystk.sample.domain.entity._TStaff.getSingletonInternal());
            __query.addParameter("staffId", java.lang.Integer.class, staffId);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TStaffDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.Optional<com.isystk.sample.domain.entity.TStaff>> __command = getCommandImplementors().createSelectCommand(__method4, __query, new org.seasar.doma.internal.jdbc.command.OptionalEntitySingleResultHandler<com.isystk.sample.domain.entity.TStaff>(com.isystk.sample.domain.entity._TStaff.getSingletonInternal()));
            java.util.Optional<com.isystk.sample.domain.entity.TStaff> __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TStaffDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TStaffDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Optional<com.isystk.sample.domain.entity.TStaff> selectByIdAndVersion(java.lang.Integer staffId, java.lang.Long version) {
        entering("com.isystk.sample.domain.dao.TStaffDaoImpl", "selectByIdAndVersion", staffId, version);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method5);
            __query.setMethod(__method5);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/TStaffDao/selectByIdAndVersion.sql");
            __query.setEntityType(com.isystk.sample.domain.entity._TStaff.getSingletonInternal());
            __query.addParameter("staffId", java.lang.Integer.class, staffId);
            __query.addParameter("version", java.lang.Long.class, version);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TStaffDaoImpl");
            __query.setCallerMethodName("selectByIdAndVersion");
            __query.setResultEnsured(true);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.Optional<com.isystk.sample.domain.entity.TStaff>> __command = getCommandImplementors().createSelectCommand(__method5, __query, new org.seasar.doma.internal.jdbc.command.OptionalEntitySingleResultHandler<com.isystk.sample.domain.entity.TStaff>(com.isystk.sample.domain.entity._TStaff.getSingletonInternal()));
            java.util.Optional<com.isystk.sample.domain.entity.TStaff> __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TStaffDaoImpl", "selectByIdAndVersion", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TStaffDaoImpl", "selectByIdAndVersion", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Optional<com.isystk.sample.domain.entity.TStaff> select(com.isystk.sample.domain.dto.TStaffCriteria criteria) {
        entering("com.isystk.sample.domain.dao.TStaffDaoImpl", "select", criteria);
        try {
            if (criteria == null) {
                throw new org.seasar.doma.DomaNullPointerException("criteria");
            }
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method6);
            __query.setMethod(__method6);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/TStaffDao/select.sql");
            __query.setEntityType(com.isystk.sample.domain.entity._TStaff.getSingletonInternal());
            __query.addParameter("criteria", com.isystk.sample.domain.dto.TStaffCriteria.class, criteria);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TStaffDaoImpl");
            __query.setCallerMethodName("select");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.Optional<com.isystk.sample.domain.entity.TStaff>> __command = getCommandImplementors().createSelectCommand(__method6, __query, new org.seasar.doma.internal.jdbc.command.OptionalEntitySingleResultHandler<com.isystk.sample.domain.entity.TStaff>(com.isystk.sample.domain.entity._TStaff.getSingletonInternal()));
            java.util.Optional<com.isystk.sample.domain.entity.TStaff> __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TStaffDaoImpl", "select", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TStaffDaoImpl", "select", __e);
            throw __e;
        }
    }

}
