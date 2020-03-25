package com.isystk.sample.domain.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-26T00:53:22.369+0900")
public final class _TUser extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.isystk.sample.domain.entity.TUser> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final _TUser __singleton = new _TUser();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    /** the userId */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.Integer, java.lang.Integer> $userId = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.IntegerWrapper::new), "userId", "USER_ID", __namingType, false, __idGenerator);

    /** the email */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.String, java.lang.String> $email = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "email", "EMAIL", __namingType, true, true, false);

    /** the password */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.String, java.lang.String> $password = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "password", "PASSWORD", __namingType, true, true, false);

    /** the familyName */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.String, java.lang.String> $familyName = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "familyName", "FAMILY_NAME", __namingType, true, true, false);

    /** the name */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.String, java.lang.String> $name = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "name", "NAME", __namingType, true, true, false);

    /** the familyNameKana */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.String, java.lang.String> $familyNameKana = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "familyNameKana", "FAMILY_NAME_KANA", __namingType, true, true, false);

    /** the nameKana */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.String, java.lang.String> $nameKana = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "nameKana", "NAME_KANA", __namingType, true, true, false);

    /** the zip */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.String, java.lang.String> $zip = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "zip", "ZIP", __namingType, true, true, false);

    /** the prefectureId */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.Integer, java.lang.Integer> $prefectureId = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.IntegerWrapper::new), "prefectureId", "PREFECTURE_ID", __namingType, true, true, false);

    /** the area */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.String, java.lang.String> $area = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "area", "AREA", __namingType, true, true, false);

    /** the address */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.String, java.lang.String> $address = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "address", "ADDRESS", __namingType, true, true, false);

    /** the building */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.String, java.lang.String> $building = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "building", "BUILDING", __namingType, true, true, false);

    /** the tel */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.String, java.lang.String> $tel = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "tel", "TEL", __namingType, true, true, false);

    /** the sex */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.Integer, java.lang.Integer> $sex = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.IntegerWrapper::new), "sex", "SEX", __namingType, true, true, false);

    /** the birthday */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.time.LocalDate, java.time.LocalDate> $birthday = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LocalDateWrapper::new), "birthday", "BIRTHDAY", __namingType, true, true, false);

    /** the lastLoginTime */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.time.LocalDateTime, java.time.LocalDateTime> $lastLoginTime = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LocalDateTimeWrapper::new), "lastLoginTime", "LAST_LOGIN_TIME", __namingType, true, true, false);

    /** the status */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.Integer, java.lang.Integer> $status = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.IntegerWrapper::new), "status", "STATUS", __namingType, true, true, false);

    /** the registTime */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.time.LocalDateTime, java.time.LocalDateTime> $registTime = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LocalDateTimeWrapper::new), "registTime", "REGIST_TIME", __namingType, true, true, false);

    /** the updateTime */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.time.LocalDateTime, java.time.LocalDateTime> $updateTime = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LocalDateTimeWrapper::new), "updateTime", "UPDATE_TIME", __namingType, true, true, false);

    /** the deleteFlg */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.Boolean, java.lang.Boolean> $deleteFlg = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.BooleanWrapper::new), "deleteFlg", "DELETE_FLG", __namingType, true, true, false);

    /** the version */
    public final org.seasar.doma.jdbc.entity.VersionPropertyType<com.isystk.sample.domain.entity.TUser, java.lang.Long, java.lang.Long> $version = new org.seasar.doma.jdbc.entity.VersionPropertyType<>(com.isystk.sample.domain.entity.TUser.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LongWrapper::new), "version", "VERSION", __namingType, false);

    private final java.util.function.Supplier<com.isystk.sample.domain.dao.DefaultEntityListener<com.isystk.sample.domain.entity.TUser>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUser, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUser, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUser, ?>> __entityPropertyTypeMap;

    private _TUser() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "TUser";
        __catalogName = "";
        __schemaName = "";
        __tableName = "t_user";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUser, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUser, ?>> __list = new java.util.ArrayList<>(21);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUser, ?>> __map = new java.util.HashMap<>(21);
        __idList.add($userId);
        __list.add($userId);
        __map.put("userId", $userId);
        __list.add($email);
        __map.put("email", $email);
        __list.add($password);
        __map.put("password", $password);
        __list.add($familyName);
        __map.put("familyName", $familyName);
        __list.add($name);
        __map.put("name", $name);
        __list.add($familyNameKana);
        __map.put("familyNameKana", $familyNameKana);
        __list.add($nameKana);
        __map.put("nameKana", $nameKana);
        __list.add($zip);
        __map.put("zip", $zip);
        __list.add($prefectureId);
        __map.put("prefectureId", $prefectureId);
        __list.add($area);
        __map.put("area", $area);
        __list.add($address);
        __map.put("address", $address);
        __list.add($building);
        __map.put("building", $building);
        __list.add($tel);
        __map.put("tel", $tel);
        __list.add($sex);
        __map.put("sex", $sex);
        __list.add($birthday);
        __map.put("birthday", $birthday);
        __list.add($lastLoginTime);
        __map.put("lastLoginTime", $lastLoginTime);
        __list.add($status);
        __map.put("status", $status);
        __list.add($registTime);
        __map.put("registTime", $registTime);
        __list.add($updateTime);
        __map.put("updateTime", $updateTime);
        __list.add($deleteFlg);
        __map.put("deleteFlg", $deleteFlg);
        __list.add($version);
        __map.put("version", $version);
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
    public void preInsert(com.isystk.sample.domain.entity.TUser entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.isystk.sample.domain.entity.TUser> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.isystk.sample.domain.entity.TUser entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.isystk.sample.domain.entity.TUser> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.isystk.sample.domain.entity.TUser entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.isystk.sample.domain.entity.TUser> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.isystk.sample.domain.entity.TUser entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.isystk.sample.domain.entity.TUser> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.isystk.sample.domain.entity.TUser entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.isystk.sample.domain.entity.TUser> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.isystk.sample.domain.entity.TUser entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.isystk.sample.domain.entity.TUser> context) {
        Class __listenerClass = com.isystk.sample.domain.dao.DefaultEntityListener.class;
        com.isystk.sample.domain.dao.DefaultEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUser, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUser, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.isystk.sample.domain.entity.TUser, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<com.isystk.sample.domain.entity.TUser, ?, ?> getGeneratedIdPropertyType() {
        return $userId;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<com.isystk.sample.domain.entity.TUser, ?, ?> getVersionPropertyType() {
        return $version;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<com.isystk.sample.domain.entity.TUser, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public com.isystk.sample.domain.entity.TUser newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.isystk.sample.domain.entity.TUser, ?>> __args) {
        com.isystk.sample.domain.entity.TUser entity = new com.isystk.sample.domain.entity.TUser();
        if (__args.get("userId") != null) __args.get("userId").save(entity);
        if (__args.get("email") != null) __args.get("email").save(entity);
        if (__args.get("password") != null) __args.get("password").save(entity);
        if (__args.get("familyName") != null) __args.get("familyName").save(entity);
        if (__args.get("name") != null) __args.get("name").save(entity);
        if (__args.get("familyNameKana") != null) __args.get("familyNameKana").save(entity);
        if (__args.get("nameKana") != null) __args.get("nameKana").save(entity);
        if (__args.get("zip") != null) __args.get("zip").save(entity);
        if (__args.get("prefectureId") != null) __args.get("prefectureId").save(entity);
        if (__args.get("area") != null) __args.get("area").save(entity);
        if (__args.get("address") != null) __args.get("address").save(entity);
        if (__args.get("building") != null) __args.get("building").save(entity);
        if (__args.get("tel") != null) __args.get("tel").save(entity);
        if (__args.get("sex") != null) __args.get("sex").save(entity);
        if (__args.get("birthday") != null) __args.get("birthday").save(entity);
        if (__args.get("lastLoginTime") != null) __args.get("lastLoginTime").save(entity);
        if (__args.get("status") != null) __args.get("status").save(entity);
        if (__args.get("registTime") != null) __args.get("registTime").save(entity);
        if (__args.get("updateTime") != null) __args.get("updateTime").save(entity);
        if (__args.get("deleteFlg") != null) __args.get("deleteFlg").save(entity);
        if (__args.get("version") != null) __args.get("version").save(entity);
        return entity;
    }

    @Override
    public Class<com.isystk.sample.domain.entity.TUser> getEntityClass() {
        return com.isystk.sample.domain.entity.TUser.class;
    }

    @Override
    public com.isystk.sample.domain.entity.TUser getOriginalStates(com.isystk.sample.domain.entity.TUser __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.isystk.sample.domain.entity.TUser __entity) {
    }

    /**
     * @return the singleton
     */
    public static _TUser getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _TUser newInstance() {
        return new _TUser();
    }

    private static class ListenerHolder {
        private static com.isystk.sample.domain.dao.DefaultEntityListener<com.isystk.sample.domain.entity.TUser> listener = new com.isystk.sample.domain.dao.DefaultEntityListener<>();
    }

}
