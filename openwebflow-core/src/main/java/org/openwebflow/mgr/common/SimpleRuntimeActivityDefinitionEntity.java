package org.openwebflow.mgr.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openwebflow.ctrl.RuntimeActivityDefinitionEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SimpleRuntimeActivityDefinitionEntity implements RuntimeActivityDefinitionEntity {
    String _factoryName;

    String _processDefinitionId;
    String _processInstanceId;
    Map<String, Object> _properties = new HashMap<String, Object>();
    String _propertiesText;

    public Map<String, Object> getProperties() {
        return _properties;
    }

    public void setProperties(Map<String, Object> properties) {
        _properties = properties;
    }

    @Override
    public void deserializeProperties() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        _properties = objectMapper.readValue(_propertiesText, Map.class);
    }

    @Override
    public String getFactoryName() {
        return _factoryName;
    }

    public void setFactoryName(String factoryName) {
        _factoryName = factoryName;
    }

    @Override
    public String getProcessDefinitionId() {
        return _processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        _processDefinitionId = processDefinitionId;
    }

    @Override
    public String getProcessInstanceId() {
        return _processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        _processInstanceId = processInstanceId;
    }

    @Override
    public String getPropertiesText() {
        return _propertiesText;
    }

    public void setPropertiesText(String propertiesText) {
        _propertiesText = propertiesText;
    }

    @Override
    public <T> T getProperty(String name) {
        return (T) _properties.get(name);
    }

    @Override
    public void serializeProperties() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        _propertiesText = objectMapper.writeValueAsString(_properties);
    }

    @Override
    public <T> void setProperty(String name, T value) {
        _properties.put(name, value);
    }
}
