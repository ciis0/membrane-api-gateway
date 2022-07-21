package com.predic8.membrane.core.kubernetes;

import com.predic8.membrane.core.config.spring.K8sHelperGeneratorAutoGenerated;
import com.predic8.membrane.core.config.spring.k8s.Envelope;
import com.predic8.membrane.core.kubernetes.client.WatchAction;
import com.predic8.membrane.core.rules.Rule;

import java.util.Map;

public class BeanDefinition {

    private final boolean isRule;
    private final String name;
    private final String namespace;
    private final String uid;
    private final String kind;
    private final Map m;
    private final WatchAction action;
    private Envelope envelope;

    public BeanDefinition(WatchAction action, Map m) {
        this.action = action;
        this.m = m;
        Map metadata = (Map) m.get("metadata");
        kind = (String) m.get("kind");
        isRule = Rule.class.isAssignableFrom(K8sHelperGeneratorAutoGenerated.elementMapping.get(kind));
        name = (String) metadata.get("name");
        namespace = (String) metadata.get("namespace");
        uid = (String) metadata.get("uid");
    }

    public boolean isRule() {
        return isRule;
    }

    public Map getMap() {
        return m;
    }

    public WatchAction getAction() {
        return action;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public Envelope getEnvelope() {
        return envelope;
    }

    public void setEnvelope(Envelope envelope) {
        this.envelope = envelope;
    }

    public String getScope() {
        Map meta = (Map) getMap().get("metadata");
        if (meta == null)
            return null;
        Map annotations = (Map) meta.get("annotations");
        if (annotations == null)
            return null;
        return (String) annotations.get("membrane-soa.org/scope");
    }
}