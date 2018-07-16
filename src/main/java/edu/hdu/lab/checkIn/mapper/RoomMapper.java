package edu.hdu.lab.checkIn.mapper;

import edu.hdu.lab.checkIn.dto.PersonInfo;
import edu.hdu.lab.checkIn.model.Room;
import edu.hdu.lab.checkIn.model.RoomExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.google.gson.JsonElement;

public interface RoomMapper {
    int countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(Integer roomId);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    //int getSatisInfoByRoomId(Integer roomId);
    Integer getPesonNumByRoomId(Integer roomId);
    
    Integer getOverDueDayNumByRoomId(Integer roomId);
    
    List<Room> getOverDueRoomByPoliid(Integer poli_id);
    
    Integer getRoomNumByPoliid(Integer poli_id);
    
    List<Room> getQuickOverDueRoomByPoliid(Integer poli_id);
    
    List<PersonInfo> searchEmptyRoom(Map<String, Object> map);
    //int getIsOverDueByRoomId()  --> service

	List<PersonInfo> searchRoom(Map<String, Object> map);

	Integer countRoom(Map<String, Object> map);

	List<PersonInfo> searchRoomOnly(Map<String, Object> map);
}