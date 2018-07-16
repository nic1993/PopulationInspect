package edu.hdu.lab.checkIn.mapper;

import edu.hdu.lab.checkIn.model.Community;
import edu.hdu.lab.checkIn.model.CommunityExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CommunityMapper {
    int countByExample(CommunityExample example);

    int deleteByExample(CommunityExample example);

    int deleteByPrimaryKey(Integer commId);

    int insert(Community record);

    int insertSelective(Community record);

    List<Community> selectByExample(CommunityExample example);

    Community selectByPrimaryKey(Integer commId);

    int updateByExampleSelective(@Param("record") Community record, @Param("example") CommunityExample example);

    int updateByExample(@Param("record") Community record, @Param("example") CommunityExample example);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);
    
    List<Community> getCommunitybyOverDate(Integer poli_id);
    
    List<Community> getCommunitybyQuickOverDate(Integer poli_id);
}