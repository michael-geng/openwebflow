package org.openwebflow.mgr.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.openwebflow.ctrl.RuntimeActivityDefinitionEntity;
import org.openwebflow.mgr.common.SimpleRuntimeActivityDefinitionEntity;

import java.util.List;

public interface SqlRuntimeActivityDefinitionManagerMapper {
    @Delete("DELETE from OWF_ACTIVITY_CREATION")
    void deleteAll();

    @Select("SELECT * FROM OWF_ACTIVITY_CREATION")
    @Results(value = {@Result(property = "factoryName", column = "FACTORY_NAME"),
            @Result(property = "processDefinitionId", column = "PROCESS_DEFINITION_ID"),
            @Result(property = "processInstanceId", column = "PROCESS_INSTANCE_ID"),
            @Result(property = "propertiesText", column = "PROPERTIES_TEXT")})
    List<SimpleRuntimeActivityDefinitionEntity> findAll();

    @Insert("INSERT INTO OWF_ACTIVITY_CREATION (FACTORY_NAME,PROCESS_DEFINITION_ID,PROCESS_INSTANCE_ID,PROPERTIES_TEXT) values (#{factoryName},#{processDefinitionId},#{processInstanceId},#{propertiesText})")
    void save(RuntimeActivityDefinitionEntity entity);
}
