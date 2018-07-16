package edu.hdu.lab.checkIn.mapper;

import edu.hdu.lab.checkIn.model.PoliceStation;
import edu.hdu.lab.checkIn.model.PoliceStationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoliceStationMapper {
    int countByExample(PoliceStationExample example);

    int deleteByExample(PoliceStationExample example);

    int deleteByPrimaryKey(Integer statId);

    int insert(PoliceStation record);

    int insertSelective(PoliceStation record);

    List<PoliceStation> selectByExample(PoliceStationExample example);

    PoliceStation selectByPrimaryKey(Integer statId);

    int updateByExampleSelective(@Param("record") PoliceStation record, @Param("example") PoliceStationExample example);

    int updateByExample(@Param("record") PoliceStation record, @Param("example") PoliceStationExample example);

    int updateByPrimaryKeySelective(PoliceStation record);

    int updateByPrimaryKey(PoliceStation record);
}