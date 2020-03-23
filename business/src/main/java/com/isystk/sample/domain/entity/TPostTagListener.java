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
public class TPostTagListener implements EntityListener<TPostTag> {

    @Override
    public void preInsert(TPostTag entity, PreInsertContext<TPostTag> context) {
    }

    @Override
    public void preUpdate(TPostTag entity, PreUpdateContext<TPostTag> context) {
    }

    @Override
    public void preDelete(TPostTag entity, PreDeleteContext<TPostTag> context) {
    }

    @Override
    public void postInsert(TPostTag entity, PostInsertContext<TPostTag> context) {
    }

    @Override
    public void postUpdate(TPostTag entity, PostUpdateContext<TPostTag> context) {
    }

    @Override
    public void postDelete(TPostTag entity, PostDeleteContext<TPostTag> context) {
    }
}