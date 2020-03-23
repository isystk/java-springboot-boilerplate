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
public class TPostImageListener implements EntityListener<TPostImage> {

    @Override
    public void preInsert(TPostImage entity, PreInsertContext<TPostImage> context) {
    }

    @Override
    public void preUpdate(TPostImage entity, PreUpdateContext<TPostImage> context) {
    }

    @Override
    public void preDelete(TPostImage entity, PreDeleteContext<TPostImage> context) {
    }

    @Override
    public void postInsert(TPostImage entity, PostInsertContext<TPostImage> context) {
    }

    @Override
    public void postUpdate(TPostImage entity, PostUpdateContext<TPostImage> context) {
    }

    @Override
    public void postDelete(TPostImage entity, PostDeleteContext<TPostImage> context) {
    }
}