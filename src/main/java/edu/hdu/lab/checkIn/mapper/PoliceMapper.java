package edu.hdu.lab.checkIn.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import edu.hdu.lab.checkIn.dto.OverData;
import edu.hdu.lab.checkIn.dto.OverDueInspectLog;
import edu.hdu.lab.checkIn.dto.PoliceBasic;
import edu.hdu.lab.checkIn.model.Building;
import edu.hdu.lab.checkIn.model.Community;
import edu.hdu.lab.checkIn.model.Police;
import edu.hdu.lab.checkIn.model.PoliceExample;

public interface PoliceMapper {
    int countByExample(PoliceExample example);

    int deleteByExample(PoliceExample example);

    int deleteByPrimaryKey(Integer poliId);

    int insert(Police record);

    int insertSelective(Police record);

    List<Police> selectByExample(PoliceExample example);

    Police selectByPrimaryKey(Integer poliId);

    int updateByExampleSelective(@Param("record") Police record, @Param("example") PoliceExample example);

    int updateByExample(@Param("record") Police record, @Param("example") PoliceExample example);

    int updateByPrimaryKeySelective(Police record);

    int updateByPrimaryKey(Police record);
    
    //user 
    PoliceBasic login(String user);
    
   // OverDueInspectLog getOverDueInspectLog(Integer poliId);
    
    List<Community> getCommByOffi(Integer statId);
    
    List<Building> getbBuilByOffi(Integer statId);
    
    List<Integer> getUnitByBuidid(Integer statId);
    
    List<Integer> getFloorByBuididAndUnit(@Param(value="builid") Integer builid,@Param(value="unit") Integer unit);

    HashMap<String, Integer> getRoomNumAndUnitbyBuilid(Integer statId);
    
    Integer getOverRoomNumbyBuilid(Integer statId);
    
    Integer getPersonNumbyBuilid(Integer statId);
    
    Integer getImpoPersonNumbyBuilid(Integer statId);

	List<HashMap<String, Integer>> getRoomSortNumbyBuilid(Integer statId);
	
	List<HashMap<String, Integer>> getRoomSubSortNumbyBuilid(Integer statId);

	List<HashMap<String, Integer>> getPersSortNumbyBuilid(Integer statId);

	Integer getEmptyRoomNumbyBuilid(Integer i);

	List<HashMap<String, Integer>> getRoomSortNumbyCommid(Integer comm_id);
	
	List<HashMap<String, Integer>> getRoomSubSortNumbyCommid(Integer comm_id);

	List<HashMap<String, Integer>> getPersSortNumbyCommid(Integer comm_id);
	
	Integer getOverRoomNumbyCommid(Integer comm_id);
	
	Integer getImpoRoomNumbyBuilid(Integer i);
	
	Integer getRoomNumbyCommid(Integer i);
	
	Integer getImpoRoomNumbyCommid(Integer comm_id);
	
	Integer getPersonNumbyCommid(Integer comm_id);

	Integer getEmptyRoomNumbyCommid(Integer i);

	Integer getOverBuilNumbyCommid(Integer i);

	Integer getImpoBuilNumbyCommid(Integer i);

	List<Building> getCommBuilByOffi(Integer i);
	
	List<HashMap<String, Integer>> getRoomSortNumbyPoliid(Integer builId);
	
	List<HashMap<String, Integer>> getRoomSubSortNumbyPoliid(Integer poli_id);

	List<HashMap<String, Integer>> getPersSortNumbyPoliid(Integer statId);
	
	Integer getOverRoomNumByPoliId(Integer poliId);
	
	Integer getOverBuilNumbyPoliid(Integer i);

	Integer getImpoBuilNumbyPoliid(Integer i);
	
	Integer getOverCommNumbyPoliid(Integer i);
	
	Integer getImpoCommNumbyPoliid(Integer i);
	
	List<Building> getBuilbyPoliid(Integer i);

	List<HashMap<String, Integer>> getRoomSortNumbyStatid(Integer i);
	
	List<HashMap<String, Integer>> getPersSortNumbyStatid(Integer statId);
	
	Integer getEmptyRoomNumbyStatid(Integer i);
	
	Integer getOverBuilNumbyStatid(Integer i);
	
	Integer getImpoBuilNumbyStatid(Integer i);

	Integer getCommNumbyStatid(Integer i);
	
	Integer getOverCommNumbyStatid(Integer i);
	
	Integer getImpoCommNumbyStatid(Integer i);
	
	OverData getOverData(Integer poli_id);
	
	OverData getQuickOverData(Integer poli_id);

	Integer getImpoPersonNumbyCommid(Integer comm_id);

	Integer getRoomNumbyPoliid(Integer poli_id);

	Integer getImpoRoomNumbyPoliid(Integer poli_id);

	Integer getPersonNumbyPoliid(Integer poli_id);

	Integer getImpoPersonNumbyPoliid(Integer poli_id);

	Integer getEmptyRoomNumbyPoliid(Integer poli_id);

	Integer countRoom(Map<String, Object> map);

}