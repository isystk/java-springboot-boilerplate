package com.isystk.sample.domain.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class TUserOnetimeValidListener implements EntityListener<TUserOnetimeValid> {

    @Override
    public void preInsert(TUserOnetimeValid entity, PreInsertContext<TUserOnetimeValid> context) {
    }

    @Override
    public void preUpdate(TUserOnetimeValid entity, PreUpdateContext<TUserOnetimeValid> context) {
    }

    @Override
    public void preDelete(TUserOnetimeValid entity, PreDeleteContext<TUserOnetimeValid> context) {
    }

    @Override
    public void postInsert(TUserOnetimeValid entity, PostInsertContext<TUserOnetimeValid> context) {
    }

    @Override
    public void postUpdate(TUserOnetimeValid entity, PostUpdateContext<TUserOnetimeValid> context) {
    }

    @Override
    public void postDelete(TUserOnetimeValid entity, PostDeleteContext<TUserOnetimeValid> context) {
    }
}