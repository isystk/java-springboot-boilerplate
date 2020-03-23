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
public class MPostTagListener implements EntityListener<MPostTag> {

    @Override
    public void preInsert(MPostTag entity, PreInsertContext<MPostTag> context) {
    }

    @Override
    public void preUpdate(MPostTag entity, PreUpdateContext<MPostTag> context) {
    }

    @Override
    public void preDelete(MPostTag entity, PreDeleteContext<MPostTag> context) {
    }

    @Override
    public void postInsert(MPostTag entity, PostInsertContext<MPostTag> context) {
    }

    @Override
    public void postUpdate(MPostTag entity, PostUpdateContext<MPostTag> context) {
    }

    @Override
    public void postDelete(MPostTag entity, PostDeleteContext<MPostTag> context) {
    }
}