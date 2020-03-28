package com.isystk.sample.domain.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-29T02:21:41.152+0900")
public final class _TUserOnetimeValid extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.isystk.sample.domain.entity.TUserOnetimeValid> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final _TUserOnetimeValid __singleton = new _TUserOnetimeValid();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    /** the deleteFlg */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, java.lang.Boolean, java.lang.Boolean> $deleteFlg = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUserOnetimeValid.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.BooleanWrapper::new), "deleteFlg", "", __namingType, true, true, false);

    /** the registTime */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, java.time.LocalDateTime, java.time.LocalDateTime> $registTime = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUserOnetimeValid.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LocalDateTimeWrapper::new), "registTime", "", __namingType, true, true, false);

    /** the updateTime */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, java.time.LocalDateTime, java.time.LocalDateTime> $updateTime = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUserOnetimeValid.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LocalDateTimeWrapper::new), "updateTime", "", __namingType, true, true, false);

    /** the version */
    public final org.seasar.doma.jdbc.entity.VersionPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, java.lang.Long, java.lang.Long> $version = new org.seasar.doma.jdbc.entity.VersionPropertyType<>(com.isystk.sample.domain.entity.TUserOnetimeValid.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LongWrapper::new), "version", "version", __namingType, false);

    /** the userId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, java.lang.Integer, java.lang.Integer> $userId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<>(com.isystk.sample.domain.entity.TUserOnetimeValid.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.IntegerWrapper::new), "userId", "USER_ID", __namingType, false);

    /** the onetimeKey */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, java.lang.String, java.lang.String> $onetimeKey = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUserOnetimeValid.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "onetimeKey", "ONETIME_KEY", __namingType, true, true, false);

    /** the onetimeValidTime */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, java.time.LocalDateTime, java.time.LocalDateTime> $onetimeValidTime = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUserOnetimeValid.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LocalDateTimeWrapper::new), "onetimeValidTime", "ONETIME_VALID_TIME", __namingType, true, true, false);

    private final java.util.function.Supplier<com.isystk.sample.domain.dao.DefaultEntityListener<com.isystk.sample.domain.entity.TUserOnetimeValid>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?>> __entityPropertyTypeMap;

    private _TUserOnetimeValid() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "TUserOnetimeValid";
        __catalogName = "";
        __schemaName = "";
        __tableName = "t_user_onetime_valid";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?>> __list = new java.util.ArrayList<>(7);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?>> __map = new java.util.HashMap<>(7);
        __list.add($deleteFlg);
        __map.put("deleteFlg", $deleteFlg);
        __list.add($registTime);
        __map.put("registTime", $registTime);
        __list.add($updateTime);
        __map.put("updateTime", $updateTime);
        __list.add($version);
        __map.put("version", $version);
        __idList.add($userId);
        __list.add($userId);
        __map.put("userId", $userId);
        __list.add($onetimeKey);
        __map.put("onetimeKey", $onetimeKey);
        __list.add($onetimeValidTime);
        __map.put("onetimeValidTime", $onetimeValidTime);
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
    public void preInsert(com.isystk.sample.domain.entity.TUserOnetimeValid entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.isystk.sample.domain.entity.TUserOnetimeValid> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.isystk.sample.domain.entity.TUserOnetimeValid entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.isystk.sample.domain.entity.TUserOnetimeValid> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.isystk.sample.domain.entity.TUserOnetimeValid entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.isystk.sample.domain.entity.TUserOnetimeValid> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.isystk.sample.domain.entity.TUserOnetimeValid entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.isystk.sample.domain.entity.TUserOnetimeValid> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.isystk.sample.domain.entity.TUserOnetimeValid entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.isystk.sample.domain.entity.TUserOnetimeValid> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.isystk.sample.domain.entity.TUserOnetimeValid entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.isystk.sample.domain.entity.TUserOnetimeValid> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?, ?> getVersionPropertyType() {
        return $version;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<com.isystk.sample.domain.entity.TUserOnetimeValid, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public com.isystk.sample.domain.entity.TUserOnetimeValid newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.isystk.sample.domain.entity.TUserOnetimeValid, ?>> __args) {
        com.isystk.sample.domain.entity.TUserOnetimeValid entity = new com.isystk.sample.domain.entity.TUserOnetimeValid();
        if (__args.get("deleteFlg") != null) __args.get("deleteFlg").save(entity);
        if (__args.get("registTime") != null) __args.get("registTime").save(entity);
        if (__args.get("updateTime") != null) __args.get("updateTime").save(entity);
        if (__args.get("version") != null) __args.get("version").save(entity);
        if (__args.get("userId") != null) __args.get("userId").save(entity);
        if (__args.get("onetimeKey") != null) __args.get("onetimeKey").save(entity);
        if (__args.get("onetimeValidTime") != null) __args.get("onetimeValidTime").save(entity);
        return entity;
    }

    @Override
    public Class<com.isystk.sample.domain.entity.TUserOnetimeValid> getEntityClass() {
        return com.isystk.sample.domain.entity.TUserOnetimeValid.class;
    }

    @Override
    public com.isystk.sample.domain.entity.TUserOnetimeValid getOriginalStates(com.isystk.sample.domain.entity.TUserOnetimeValid __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.isystk.sample.domain.entity.TUserOnetimeValid __entity) {
    }

    /**
     * @return the singleton
     */
    public static _TUserOnetimeValid getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _TUserOnetimeValid newInstance() {
        return new _TUserOnetimeValid();
    }

    private static class ListenerHolder {
        private static com.isystk.sample.domain.dao.DefaultEntityListener<com.isystk.sample.domain.entity.TUserOnetimeValid> listener = new com.isystk.sample.domain.dao.DefaultEntityListener<>();
    }

}
