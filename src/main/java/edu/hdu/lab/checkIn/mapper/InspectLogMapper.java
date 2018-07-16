package edu.hdu.lab.checkIn.mapper;

import edu.hdu.lab.checkIn.dto.InspectShow;
import edu.hdu.lab.checkIn.model.InspectLog;
import edu.hdu.lab.checkIn.model.InspectLogExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface InspectLogMapper {
    int countByExample(InspectLogExample example);

    int deleteByExample(InspectLogExample example);

    int deleteByPrimaryKey(Integer inspId);

    int insert(InspectLog record);

    int insertSelective(InspectLog record);

    List<InspectLog> selectByExample(InspectLogExample example);

    InspectLog selectByPrimaryKey(Integer inspId);

    int updateByExampleSelective(@Param("record") InspectLog record, @Param("example") InspectLogExample example);

    int updateByExample(@Param("record") InspectLog record, @Param("example") InspectLogExample example);

    int updateByPrimaryKeySelective(InspectLog record);

    int updateByPrimaryKey(InspectLog record);
    
    List<InspectShow> getInspbyTime(Map<String, Object> map);
}