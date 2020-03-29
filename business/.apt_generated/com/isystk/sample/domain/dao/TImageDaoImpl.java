package com.isystk.sample.domain.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-29T20:24:42.224+0900")
public class TImageDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.isystk.sample.domain.dao.TImageDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TImageDao.class, "insert", com.isystk.sample.domain.entity.TImage.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TImageDao.class, "update", com.isystk.sample.domain.entity.TImage.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TImageDao.class, "delete", com.isystk.sample.domain.entity.TImage.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TImageDao.class, "selectAll", com.isystk.sample.domain.dto.TImageCriteria.class, org.seasar.doma.jdbc.SelectOptions.class, java.util.stream.Collector.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TImageDao.class, "selectById", java.lang.Integer.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.TImageDao.class, "select", com.isystk.sample.domain.dto.TImageCriteria.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public TImageDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public int insert(com.isystk.sample.domain.entity.TImage entity) {
        entering("com.isystk.sample.domain.dao.TImageDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<com.isystk.sample.domain.entity.TImage> __query = getQueryImplementors().createAutoInsertQuery(__method0, com.isystk.sample.domain.entity._TImage.getSingletonInternal());
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TImageDaoImpl");
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
            exiting("com.isystk.sample.domain.dao.TImageDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TImageDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(com.isystk.sample.domain.entity.TImage entity) {
        entering("com.isystk.sample.domain.dao.TImageDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoUpdateQuery<com.isystk.sample.domain.entity.TImage> __query = getQueryImplementors().createAutoUpdateQuery(__method1, com.isystk.sample.domain.entity._TImage.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TImageDaoImpl");
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
            exiting("com.isystk.sample.domain.dao.TImageDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TImageDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(com.isystk.sample.domain.entity.TImage entity) {
        entering("com.isystk.sample.domain.dao.TImageDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoDeleteQuery<com.isystk.sample.domain.entity.TImage> __query = getQueryImplementors().createAutoDeleteQuery(__method2, com.isystk.sample.domain.entity._TImage.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TImageDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = getCommandImplementors().createDeleteCommand(__method2, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TImageDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TImageDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public <R> R selectAll(com.isystk.sample.domain.dto.TImageCriteria criteria, org.seasar.doma.jdbc.SelectOptions options, java.util.stream.Collector<com.isystk.sample.domain.entity.TImage, ?, R> collector) {
        entering("com.isystk.sample.domain.dao.TImageDaoImpl", "selectAll", criteria, options, collector);
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
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/TImageDao/selectAll.sql");
            __query.setOptions(options);
            __query.setEntityType(com.isystk.sample.domain.entity._TImage.getSingletonInternal());
            __query.addParameter("criteria", com.isystk.sample.domain.dto.TImageCriteria.class, criteria);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TImageDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<R> __command = getCommandImplementors().createSelectCommand(__method3, __query, new org.seasar.doma.internal.jdbc.command.EntityCollectorHandler<com.isystk.sample.domain.entity.TImage, R>(com.isystk.sample.domain.entity._TImage.getSingletonInternal(), collector));
            R __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TImageDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TImageDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Optional<com.isystk.sample.domain.entity.TImage> selectById(java.lang.Integer imageId) {
        entering("com.isystk.sample.domain.dao.TImageDaoImpl", "selectById", imageId);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method4);
            __query.setMethod(__method4);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/TImageDao/selectById.sql");
            __query.setEntityType(com.isystk.sample.domain.entity._TImage.getSingletonInternal());
            __query.addParameter("imageId", java.lang.Integer.class, imageId);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TImageDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.Optional<com.isystk.sample.domain.entity.TImage>> __command = getCommandImplementors().createSelectCommand(__method4, __query, new org.seasar.doma.internal.jdbc.command.OptionalEntitySingleResultHandler<com.isystk.sample.domain.entity.TImage>(com.isystk.sample.domain.entity._TImage.getSingletonInternal()));
            java.util.Optional<com.isystk.sample.domain.entity.TImage> __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TImageDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TImageDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public java.util.Optional<com.isystk.sample.domain.entity.TImage> select(com.isystk.sample.domain.dto.TImageCriteria criteria) {
        entering("com.isystk.sample.domain.dao.TImageDaoImpl", "select", criteria);
        try {
            if (criteria == null) {
                throw new org.seasar.doma.DomaNullPointerException("criteria");
            }
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method5);
            __query.setMethod(__method5);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/TImageDao/select.sql");
            __query.setEntityType(com.isystk.sample.domain.entity._TImage.getSingletonInternal());
            __query.addParameter("criteria", com.isystk.sample.domain.dto.TImageCriteria.class, criteria);
            __query.setCallerClassName("com.isystk.sample.domain.dao.TImageDaoImpl");
            __query.setCallerMethodName("select");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.Optional<com.isystk.sample.domain.entity.TImage>> __command = getCommandImplementors().createSelectCommand(__method5, __query, new org.seasar.doma.internal.jdbc.command.OptionalEntitySingleResultHandler<com.isystk.sample.domain.entity.TImage>(com.isystk.sample.domain.entity._TImage.getSingletonInternal()));
            java.util.Optional<com.isystk.sample.domain.entity.TImage> __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.TImageDaoImpl", "select", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.TImageDaoImpl", "select", __e);
            throw __e;
        }
    }

}
