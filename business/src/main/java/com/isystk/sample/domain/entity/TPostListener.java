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
public class TPostListener implements EntityListener<TPost> {

    @Override
    public void preInsert(TPost entity, PreInsertContext<TPost> context) {
    }

    @Override
    public void preUpdate(TPost entity, PreUpdateContext<TPost> context) {
    }

    @Override
    public void preDelete(TPost entity, PreDeleteContext<TPost> context) {
    }

    @Override
    public void postInsert(TPost entity, PostInsertContext<TPost> context) {
    }

    @Override
    public void postUpdate(TPost entity, PostUpdateContext<TPost> context) {
    }

    @Override
    public void postDelete(TPost entity, PostDeleteContext<TPost> context) {
    }
}