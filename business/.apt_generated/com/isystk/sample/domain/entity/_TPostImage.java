package com.isystk.sample.domain.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-26T11:18:57.942+0900")
public final class _TPostImage extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.isystk.sample.domain.entity.TPostImage> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final _TPostImage __singleton = new _TPostImage();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    /** the registTime */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TPostImage, java.time.LocalDateTime, java.time.LocalDateTime> $registTime = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TPostImage.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LocalDateTimeWrapper::new), "registTime", "", __namingType, true, true, false);

    /** the updateTime */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TPostImage, java.time.LocalDateTime, java.time.LocalDateTime> $updateTime = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TPostImage.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LocalDateTimeWrapper::new), "updateTime", "", __namingType, true, true, false);

    /** the deleteFlg */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TPostImage, java.lang.Boolean, java.lang.Boolean> $deleteFlg = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TPostImage.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.BooleanWrapper::new), "deleteFlg", "", __namingType, true, true, false);

    /** the version */
    public final org.seasar.doma.jdbc.entity.VersionPropertyType<com.isystk.sample.domain.entity.TPostImage, java.lang.Long, java.lang.Long> $version = new org.seasar.doma.jdbc.entity.VersionPropertyType<>(com.isystk.sample.domain.entity.TPostImage.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LongWrapper::new), "version", "version", __namingType, false);

    /** the postId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<com.isystk.sample.domain.entity.TPostImage, java.lang.Integer, java.lang.Integer> $postId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<>(com.isystk.sample.domain.entity.TPostImage.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.IntegerWrapper::new), "postId", "POST_ID", __namingType, false);

    /** the imageId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<com.isystk.sample.domain.entity.TPostImage, java.lang.Integer, java.lang.Integer> $imageId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<>(com.isystk.sample.domain.entity.TPostImage.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.IntegerWrapper::new), "imageId", "IMAGE_ID", __namingType, false);

    private final java.util.function.Supplier<com.isystk.sample.domain.dao.DefaultEntityListener<com.isystk.sample.domain.entity.TPostImage>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TPostImage, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TPostImage, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TPostImage, ?>> __entityPropertyTypeMap;

    private _TPostImage() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "TPostImage";
        __catalogName = "";
        __schemaName = "";
        __tableName = "t_post_image";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TPostImage, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TPostImage, ?>> __list = new java.util.ArrayList<>(6);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TPostImage, ?>> __map = new java.util.HashMap<>(6);
        __list.add($registTime);
        __map.put("registTime", $registTime);
        __list.add($updateTime);
        __map.put("updateTime", $updateTime);
        __list.add($deleteFlg);
        __map.put("deleteFlg", $deleteFlg);
        __list.add($version);
        __map.put("version", $version);
        __idList.add($postId);
        __list.add($postId);
        __map.put("postId", $postId);
        __idList.add($imageId);
        __list.add($imageId);
        __map.put("imageId", $imageId);
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
    public void preInsert(com.isystk.sample.domain.entity.TPostImage entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.isystk.sample.domain.entity.TPostImage> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.isystk.sample.domain.entity.TPostImage entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.isystk.sample.domain.entity.TPostImage> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.isystk.sample.domain.entity.TPostImage entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.isystk.sample.domain.entity.TPostImage> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.isystk.sample.domain.entity.TPostImage entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.isystk.sample.domain.entity.TPostImage> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.isystk.sample.domain.entity.TPostImage entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.isystk.sample.domain.entity.TPostImage> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.isystk.sample.domain.entity.TPostImage entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.isystk.sample.domain.entity.TPostImage> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TPostImage, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TPostImage, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TPostImage, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<com.isystk.sample.domain.entity.TPostImage, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<com.isystk.sample.domain.entity.TPostImage, ?, ?> getVersionPropertyType() {
        return $version;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<com.isystk.sample.domain.entity.TPostImage, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public com.isystk.sample.domain.entity.TPostImage newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.isystk.sample.domain.entity.TPostImage, ?>> __args) {
        com.isystk.sample.domain.entity.TPostImage entity = new com.isystk.sample.domain.entity.TPostImage();
        if (__args.get("registTime") != null) __args.get("registTime").save(entity);
        if (__args.get("updateTime") != null) __args.get("updateTime").save(entity);
        if (__args.get("deleteFlg") != null) __args.get("deleteFlg").save(entity);
        if (__args.get("version") != null) __args.get("version").save(entity);
        if (__args.get("postId") != null) __args.get("postId").save(entity);
        if (__args.get("imageId") != null) __args.get("imageId").save(entity);
        return entity;
    }

    @Override
    public Class<com.isystk.sample.domain.entity.TPostImage> getEntityClass() {
        return com.isystk.sample.domain.entity.TPostImage.class;
    }

    @Override
    public com.isystk.sample.domain.entity.TPostImage getOriginalStates(com.isystk.sample.domain.entity.TPostImage __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.isystk.sample.domain.entity.TPostImage __entity) {
    }

    /**
     * @return the singleton
     */
    public static _TPostImage getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _TPostImage newInstance() {
        return new _TPostImage();
    }

    private static class ListenerHolder {
        private static com.isystk.sample.domain.dao.DefaultEntityListener<com.isystk.sample.domain.entity.TPostImage> listener = new com.isystk.sample.domain.dao.DefaultEntityListener<>();
    }

}
