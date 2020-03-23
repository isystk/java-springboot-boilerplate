package com.isystk.sample.domain.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-24T01:32:36.318+0900")
public final class _SysConfig extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.isystk.sample.domain.entity.SysConfig> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final _SysConfig __singleton = new _SysConfig();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    /** the variable */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<com.isystk.sample.domain.entity.SysConfig, java.lang.String, java.lang.String> $variable = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<>(com.isystk.sample.domain.entity.SysConfig.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "variable", "variable", __namingType, false);

    /** the value */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.SysConfig, java.lang.String, java.lang.String> $value = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.SysConfig.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "value", "value", __namingType, true, true, false);

    /** the setTime */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.SysConfig, java.sql.Timestamp, java.sql.Timestamp> $setTime = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.SysConfig.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.TimestampWrapper::new), "setTime", "set_time", __namingType, true, true, false);

    /** the setBy */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.SysConfig, java.lang.String, java.lang.String> $setBy = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.SysConfig.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "setBy", "set_by", __namingType, true, true, false);

    private final java.util.function.Supplier<com.isystk.sample.domain.entity.SysConfigListener> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.SysConfig, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.SysConfig, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.SysConfig, ?>> __entityPropertyTypeMap;

    private _SysConfig() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "SysConfig";
        __catalogName = "";
        __schemaName = "";
        __tableName = "sys_config";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.SysConfig, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.SysConfig, ?>> __list = new java.util.ArrayList<>(4);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.SysConfig, ?>> __map = new java.util.HashMap<>(4);
        __idList.add($variable);
        __list.add($variable);
        __map.put("variable", $variable);
        __list.add($value);
        __map.put("value", $value);
        __list.add($setTime);
        __map.put("setTime", $setTime);
        __list.add($setBy);
        __map.put("setBy", $setBy);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public boolean isImmutable() {
        return __immutable;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    public String getTableName() {
        return getTableName(org.seasar.doma.jdbc.Naming.DEFAULT::apply);
    }

    @Override
    public String getTableName(java.util.function.BiFunction<org.seasar.doma.jdbc.entity.NamingType, String, String> namingFunction) {
        if (__tableName.isEmpty()) {
            return namingFunction.apply(__namingType, __name);
        }
        return __tableName;
    }

    @Override
    public boolean isQuoteRequired() {
        return __isQuoteRequired;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preInsert(com.isystk.sample.domain.entity.SysConfig entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.isystk.sample.domain.entity.SysConfig> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.SysConfigListener.class;
        com.isystk.sample.domain.entity.SysConfigListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.isystk.sample.domain.entity.SysConfig entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.isystk.sample.domain.entity.SysConfig> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.SysConfigListener.class;
        com.isystk.sample.domain.entity.SysConfigListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.isystk.sample.domain.entity.SysConfig entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.isystk.sample.domain.entity.SysConfig> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.SysConfigListener.class;
        com.isystk.sample.domain.entity.SysConfigListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.isystk.sample.domain.entity.SysConfig entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.isystk.sample.domain.entity.SysConfig> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.SysConfigListener.class;
        com.isystk.sample.domain.entity.SysConfigListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.isystk.sample.domain.entity.SysConfig entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.isystk.sample.domain.entity.SysConfig> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.SysConfigListener.class;
        com.isystk.sample.domain.entity.SysConfigListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.isystk.sample.domain.entity.SysConfig entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.isystk.sample.domain.entity.SysConfig> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.SysConfigListener.class;
        com.isystk.sample.domain.entity.SysConfigListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.SysConfig, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.SysConfig, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.SysConfig, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<com.isystk.sample.domain.entity.SysConfig, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<com.isystk.sample.domain.entity.SysConfig, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<com.isystk.sample.domain.entity.SysConfig, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public com.isystk.sample.domain.entity.SysConfig newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.isystk.sample.domain.entity.SysConfig, ?>> __args) {
        com.isystk.sample.domain.entity.SysConfig entity = new com.isystk.sample.domain.entity.SysConfig();
        if (__args.get("variable") != null) __args.get("variable").save(entity);
        if (__args.get("value") != null) __args.get("value").save(entity);
        if (__args.get("setTime") != null) __args.get("setTime").save(entity);
        if (__args.get("setBy") != null) __args.get("setBy").save(entity);
        return entity;
    }

    @Override
    public Class<com.isystk.sample.domain.entity.SysConfig> getEntityClass() {
        return com.isystk.sample.domain.entity.SysConfig.class;
    }

    @Override
    public com.isystk.sample.domain.entity.SysConfig getOriginalStates(com.isystk.sample.domain.entity.SysConfig __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.isystk.sample.domain.entity.SysConfig __entity) {
    }

    /**
     * @return the singleton
     */
    public static _SysConfig getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _SysConfig newInstance() {
        return new _SysConfig();
    }

    private static class ListenerHolder {
        private static com.isystk.sample.domain.entity.SysConfigListener listener = new com.isystk.sample.domain.entity.SysConfigListener();
    }

}
