package org.openwebflow.mgr.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.openwebflow.mgr.mybatis.entity.SqlMembershipEntity;

import java.util.List;

public interface SqlMembershipEntityMapper {
    @Delete("DELETE from OWF_MEMBERSHIP")
    void deleteAll();

    @Results(value = {@Result(property = "userId", column = "USER_ID"),
            @Result(property = "groupId", column = "GROUP_ID")})
    @Select("SELECT * FROM OWF_MEMBERSHIP where GROUP_ID=#{groupId}")
    List<SqlMembershipEntity> findMembershipsByGroupId(@Param("groupId")
                                                               String groupId);

    @Results(value = {@Result(property = "userId", column = "USER_ID"),
            @Result(property = "groupId", column = "GROUP_ID")})
    @Select("SELECT * FROM OWF_MEMBERSHIP where USER_ID=#{userId}")
    List<SqlMembershipEntity> findMembershipsByUserId(@Param("userId")
                                                              String userId);

    @Insert("INSERT INTO OWF_MEMBERSHIP (USER_ID,GROUP_ID) values (#{userId},#{groupId})")
    void saveMembership(SqlMembershipEntity mse);
}
