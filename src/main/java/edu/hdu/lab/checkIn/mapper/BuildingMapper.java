package edu.hdu.lab.checkIn.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import edu.hdu.lab.checkIn.model.Building;
import edu.hdu.lab.checkIn.model.BuildingExample;

public interface BuildingMapper {

	int countByExample(BuildingExample example);

    int deleteByExample(BuildingExample example);

    int deleteByPrimaryKey(Integer builId);

    int insert(Building record);

    int insertSelective(Building record);

    List<Building> selectByExample(BuildingExample example);

    Building selectByPrimaryKey(Integer builId);

    int updateByExampleSelective(@Param("record") Building record, @Param("example") BuildingExample example);

    int updateByExample(@Param("record") Building record, @Param("example") BuildingExample example);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);
    
    List<Building> getBuildbyRoomClass(Map<String, Object> map);
    
    List<Building> getBuildbyRoomSubClass(Map<String, Object> map);
    
    List<Building> getOverBuilbyPoliid(Integer poli_id);
    
    List<Building> getQuickOverBuilbyPoliid(Integer poli_id);

	int countBycommID(Integer comm_id);
}