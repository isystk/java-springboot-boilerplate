package com.isystk.sample.domain.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-26T19:25:45.167+0900")
public class MMailTemplateDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.isystk.sample.domain.dao.MMailTemplateDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.MMailTemplateDao.class, "selectById", java.lang.Integer.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.MMailTemplateDao.class, "selectByIdAndVersion", java.lang.Integer.class, java.lang.Long.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.MMailTemplateDao.class, "insert", com.isystk.sample.domain.entity.MMailTemplate.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.MMailTemplateDao.class, "update", com.isystk.sample.domain.entity.MMailTemplate.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.isystk.sample.domain.dao.MMailTemplateDao.class, "delete", com.isystk.sample.domain.entity.MMailTemplate.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public MMailTemplateDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public com.isystk.sample.domain.entity.MMailTemplate selectById(java.lang.Integer mailTemplateId) {
        entering("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "selectById", mailTemplateId);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/MMailTemplateDao/selectById.sql");
            __query.setEntityType(com.isystk.sample.domain.entity._MMailTemplate.getSingletonInternal());
            __query.addParameter("mailTemplateId", java.lang.Integer.class, mailTemplateId);
            __query.setCallerClassName("com.isystk.sample.domain.dao.MMailTemplateDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<com.isystk.sample.domain.entity.MMailTemplate> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<com.isystk.sample.domain.entity.MMailTemplate>(com.isystk.sample.domain.entity._MMailTemplate.getSingletonInternal()));
            com.isystk.sample.domain.entity.MMailTemplate __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public com.isystk.sample.domain.entity.MMailTemplate selectByIdAndVersion(java.lang.Integer mailTemplateId, java.lang.Long version) {
        entering("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "selectByIdAndVersion", mailTemplateId, version);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/isystk/sample/domain/dao/MMailTemplateDao/selectByIdAndVersion.sql");
            __query.setEntityType(com.isystk.sample.domain.entity._MMailTemplate.getSingletonInternal());
            __query.addParameter("mailTemplateId", java.lang.Integer.class, mailTemplateId);
            __query.addParameter("version", java.lang.Long.class, version);
            __query.setCallerClassName("com.isystk.sample.domain.dao.MMailTemplateDaoImpl");
            __query.setCallerMethodName("selectByIdAndVersion");
            __query.setResultEnsured(true);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<com.isystk.sample.domain.entity.MMailTemplate> __command = getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<com.isystk.sample.domain.entity.MMailTemplate>(com.isystk.sample.domain.entity._MMailTemplate.getSingletonInternal()));
            com.isystk.sample.domain.entity.MMailTemplate __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "selectByIdAndVersion", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "selectByIdAndVersion", __e);
            throw __e;
        }
    }

    @Override
    public int insert(com.isystk.sample.domain.entity.MMailTemplate entity) {
        entering("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<com.isystk.sample.domain.entity.MMailTemplate> __query = getQueryImplementors().createAutoInsertQuery(__method2, com.isystk.sample.domain.entity._MMailTemplate.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.MMailTemplateDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = getCommandImplementors().createInsertCommand(__method2, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(com.isystk.sample.domain.entity.MMailTemplate entity) {
        entering("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoUpdateQuery<com.isystk.sample.domain.entity.MMailTemplate> __query = getQueryImplementors().createAutoUpdateQuery(__method3, com.isystk.sample.domain.entity._MMailTemplate.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.MMailTemplateDaoImpl");
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
            org.seasar.doma.jdbc.command.UpdateCommand __command = getCommandImplementors().createUpdateCommand(__method3, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(com.isystk.sample.domain.entity.MMailTemplate entity) {
        entering("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoDeleteQuery<com.isystk.sample.domain.entity.MMailTemplate> __query = getQueryImplementors().createAutoDeleteQuery(__method4, com.isystk.sample.domain.entity._MMailTemplate.getSingletonInternal());
            __query.setMethod(__method4);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.isystk.sample.domain.dao.MMailTemplateDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = getCommandImplementors().createDeleteCommand(__method4, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.isystk.sample.domain.dao.MMailTemplateDaoImpl", "delete", __e);
            throw __e;
        }
    }

}
