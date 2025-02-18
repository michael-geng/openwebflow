package org.openwebflow.ctrl;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface RuntimeActivityDefinitionEntity {
    /**
     * 反序列化PropertiesText到Map
     */
    void deserializeProperties() throws IOException;

    /**
     * 获取工厂名
     */
    String getFactoryName();

    /**
     * 设置工厂名
     */
    void setFactoryName(String factoryName);

    /**
     * 获取流程定义的ID
     */
    String getProcessDefinitionId();

    /**
     * 设置流程定义ID
     */
    void setProcessDefinitionId(String processDefinitionId);

    /**
     * 获取流程实例的ID
     */
    String getProcessInstanceId();

    /**
     * 设置流程实例ID
     */
    void setProcessInstanceId(String processInstanceId);

    /**
     * 获取PropertiesText，它是一个JSON字符串
     */
    String getPropertiesText();

    /**
     * 设置PropertiesText
     */
    void setPropertiesText(String propertiesText);

    /**
     * 获取指定的属性值
     */
    <T> T getProperty(String name);

    /**
     * 序列化Map至PropertiesText
     */
    void serializeProperties() throws JsonProcessingException;

    <T> void setProperty(String name, T value);
}