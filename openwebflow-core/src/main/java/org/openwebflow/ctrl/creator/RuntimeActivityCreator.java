package org.openwebflow.ctrl.creator;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.openwebflow.ctrl.RuntimeActivityDefinitionEntity;

public interface RuntimeActivityCreator {
    public ActivityImpl[] createActivities(ProcessEngine processEngine, ProcessDefinitionEntity processDefinition,
                                           RuntimeActivityDefinitionEntity info);
}