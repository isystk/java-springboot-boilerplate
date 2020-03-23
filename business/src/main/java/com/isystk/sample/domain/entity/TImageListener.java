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
public class TImageListener implements EntityListener<TImage> {

    @Override
    public void preInsert(TImage entity, PreInsertContext<TImage> context) {
    }

    @Override
    public void preUpdate(TImage entity, PreUpdateContext<TImage> context) {
    }

    @Override
    public void preDelete(TImage entity, PreDeleteContext<TImage> context) {
    }

    @Override
    public void postInsert(TImage entity, PostInsertContext<TImage> context) {
    }

    @Override
    public void postUpdate(TImage entity, PostUpdateContext<TImage> context) {
    }

    @Override
    public void postDelete(TImage entity, PostDeleteContext<TImage> context) {
    }
}