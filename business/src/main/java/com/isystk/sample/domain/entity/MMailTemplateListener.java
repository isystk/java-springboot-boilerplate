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
public class MMailTemplateListener implements EntityListener<MMailTemplate> {

    @Override
    public void preInsert(MMailTemplate entity, PreInsertContext<MMailTemplate> context) {
    }

    @Override
    public void preUpdate(MMailTemplate entity, PreUpdateContext<MMailTemplate> context) {
    }

    @Override
    public void preDelete(MMailTemplate entity, PreDeleteContext<MMailTemplate> context) {
    }

    @Override
    public void postInsert(MMailTemplate entity, PostInsertContext<MMailTemplate> context) {
    }

    @Override
    public void postUpdate(MMailTemplate entity, PostUpdateContext<MMailTemplate> context) {
    }

    @Override
    public void postDelete(MMailTemplate entity, PostDeleteContext<MMailTemplate> context) {
    }
}