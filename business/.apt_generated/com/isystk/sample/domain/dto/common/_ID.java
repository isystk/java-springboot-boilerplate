package com.isystk.sample.domain.dto.common;

/**
 * @param <T> T
 */
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-27T15:37:45.419+0900")
public final class _ID<T> extends org.seasar.doma.jdbc.domain.AbstractDomainType<java.lang.Integer, com.isystk.sample.domain.dto.common.ID<T>> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    @SuppressWarnings("rawtypes")
    private static final _ID singleton = new _ID();

    private _ID() {
        super(org.seasar.doma.wrapper.IntegerWrapper::new);
    }

    @Override
    protected com.isystk.sample.domain.dto.common.ID<T> newDomain(java.lang.Integer value) {
        if (value == null) {
            return null;
        }
        return com.isystk.sample.domain.dto.common.ID.of(value);
    }

    @Override
    protected java.lang.Integer getBasicValue(com.isystk.sample.domain.dto.common.ID<T> domain) {
        if (domain == null) {
            return null;
        }
        return domain.getValue();
    }

    @Override
    public Class<?> getBasicClass() {
        return java.lang.Integer.class;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<com.isystk.sample.domain.dto.common.ID<T>> getDomainClass() {
        Class<?> clazz = com.isystk.sample.domain.dto.common.ID.class;
        return (Class<com.isystk.sample.domain.dto.common.ID<T>>) clazz;
    }

    /**
     * @return the singleton
     */
    @SuppressWarnings("unchecked")
    public static <T> _ID<T> getSingletonInternal() {
        return (_ID<T>) singleton;
    }

}
