package org.openwebflow.cfg;

import org.activiti.engine.ProcessEngine;
import org.activiti.spring.SpringProcessEngineConfiguration;

import java.util.List;

public class ProcessEngineConfigurationEx extends SpringProcessEngineConfiguration {
    List<StartEngineEventListener> _startEngineEventListeners;

    @Override
    public ProcessEngine buildProcessEngine() {
        try {
            for (StartEngineEventListener listener : _startEngineEventListeners) {
                listener.beforeStartEngine(this);
            }

            ProcessEngine processEngine = super.buildProcessEngine();

            for (StartEngineEventListener listener : _startEngineEventListeners) {
                listener.afterStartEngine(this, processEngine);
            }

            return processEngine;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<StartEngineEventListener> getStartEngineEventListeners() {
        return _startEngineEventListeners;
    }

    public void setStartEngineEventListeners(List<StartEngineEventListener> startEngineEventListeners) {
        _startEngineEventListeners = startEngineEventListeners;
    }

}
