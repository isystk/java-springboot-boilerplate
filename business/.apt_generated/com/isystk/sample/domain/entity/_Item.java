package com.isystk.sample.domain.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-24T00:21:30.103+0900")
public final class _Item extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.isystk.sample.domain.entity.Item> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final _Item __singleton = new _Item();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    /** the id */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<com.isystk.sample.domain.entity.Item, java.lang.Long, java.lang.Long> $id = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<>(com.isystk.sample.domain.entity.Item.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LongWrapper::new), "id", "id", __namingType, false, __idGenerator);

    /** the name */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.Item, java.lang.String, java.lang.String> $name = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.Item.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "name", "name", __namingType, true, true, false);

    /** the price */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.Item, java.lang.Double, java.lang.Double> $price = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.Item.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.DoubleWrapper::new), "price", "price", __namingType, true, true, false);

    /** the vendor */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.Item, java.lang.String, java.lang.String> $vendor = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.Item.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "vendor", "vendor", __namingType, true, true, false);

    private final java.util.function.Supplier<com.isystk.sample.domain.entity.ItemListener> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.Item, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.Item, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.Item, ?>> __entityPropertyTypeMap;

    private _Item() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "Item";
        __catalogName = "";
        __schemaName = "";
        __tableName = "item";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.Item, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.Item, ?>> __list = new java.util.ArrayList<>(4);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.Item, ?>> __map = new java.util.HashMap<>(4);
        __idList.add($id);
        __list.add($id);
        __map.put("id", $id);
        __list.add($name);
        __map.put("name", $name);
        __list.add($price);
        __map.put("price", $price);
        __list.add($vendor);
        __map.put("vendor", $vendor);
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
    public void preInsert(com.isystk.sample.domain.entity.Item entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.isystk.sample.domain.entity.Item> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.ItemListener.class;
        com.isystk.sample.domain.entity.ItemListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.isystk.sample.domain.entity.Item entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.isystk.sample.domain.entity.Item> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.ItemListener.class;
        com.isystk.sample.domain.entity.ItemListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.isystk.sample.domain.entity.Item entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.isystk.sample.domain.entity.Item> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.ItemListener.class;
        com.isystk.sample.domain.entity.ItemListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.isystk.sample.domain.entity.Item entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.isystk.sample.domain.entity.Item> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.ItemListener.class;
        com.isystk.sample.domain.entity.ItemListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.isystk.sample.domain.entity.Item entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.isystk.sample.domain.entity.Item> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.ItemListener.class;
        com.isystk.sample.domain.entity.ItemListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.isystk.sample.domain.entity.Item entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.isystk.sample.domain.entity.Item> context) {
        Class __listenerClass = com.isystk.sample.domain.entity.ItemListener.class;
        com.isystk.sample.domain.entity.ItemListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.Item, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.Item, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.Item, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<com.isystk.sample.domain.entity.Item, ?, ?> getGeneratedIdPropertyType() {
        return $id;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<com.isystk.sample.domain.entity.Item, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<com.isystk.sample.domain.entity.Item, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public com.isystk.sample.domain.entity.Item newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.isystk.sample.domain.entity.Item, ?>> __args) {
        com.isystk.sample.domain.entity.Item entity = new com.isystk.sample.domain.entity.Item();
        if (__args.get("id") != null) __args.get("id").save(entity);
        if (__args.get("name") != null) __args.get("name").save(entity);
        if (__args.get("price") != null) __args.get("price").save(entity);
        if (__args.get("vendor") != null) __args.get("vendor").save(entity);
        return entity;
    }

    @Override
    public Class<com.isystk.sample.domain.entity.Item> getEntityClass() {
        return com.isystk.sample.domain.entity.Item.class;
    }

    @Override
    public com.isystk.sample.domain.entity.Item getOriginalStates(com.isystk.sample.domain.entity.Item __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.isystk.sample.domain.entity.Item __entity) {
    }

    /**
     * @return the singleton
     */
    public static _Item getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _Item newInstance() {
        return new _Item();
    }

    private static class ListenerHolder {
        private static com.isystk.sample.domain.entity.ItemListener listener = new com.isystk.sample.domain.entity.ItemListener();
    }

}
