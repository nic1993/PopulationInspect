package edu.hdu.lab.checkIn.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import edu.hdu.lab.checkIn.dto.PersonInfo;
import edu.hdu.lab.checkIn.model.Person;
import edu.hdu.lab.checkIn.model.PersonExample;

public interface PersonMapper {
    int countByExample(PersonExample example);

    int deleteByExample(PersonExample example);

    int deleteByPrimaryKey(Integer persId);

    int insert(Person record);

    int insertSelective(Person record);

    List<Person> selectByExample(PersonExample example);

    Person selectByPrimaryKey(Integer persId);

    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
    
    List<Person> getPersonByRoomId(@Param("room_id")Integer room_id);
    
    List<PersonInfo> searchPerson(Map<String, Object> map);
    
    int searchSize(Map<String, Object> map);
    
    List<PersonInfo> getOverPersbyPoliid(Map<String, Object> map);
    
    List<PersonInfo> getQuickOverPersbyPoliid(Map<String, Object> map);
}