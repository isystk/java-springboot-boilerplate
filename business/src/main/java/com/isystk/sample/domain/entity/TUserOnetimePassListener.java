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
public class TUserOnetimePassListener implements EntityListener<TUserOnetimePass> {

    @Override
    public void preInsert(TUserOnetimePass entity, PreInsertContext<TUserOnetimePass> context) {
    }

    @Override
    public void preUpdate(TUserOnetimePass entity, PreUpdateContext<TUserOnetimePass> context) {
    }

    @Override
    public void preDelete(TUserOnetimePass entity, PreDeleteContext<TUserOnetimePass> context) {
    }

    @Override
    public void postInsert(TUserOnetimePass entity, PostInsertContext<TUserOnetimePass> context) {
    }

    @Override
    public void postUpdate(TUserOnetimePass entity, PostUpdateContext<TUserOnetimePass> context) {
    }

    @Override
    public void postDelete(TUserOnetimePass entity, PostDeleteContext<TUserOnetimePass> context) {
    }
}