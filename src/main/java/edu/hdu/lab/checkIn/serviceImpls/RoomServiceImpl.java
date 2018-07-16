package edu.hdu.lab.checkIn.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hdu.lab.checkIn.dto.RoomStatis;
import edu.hdu.lab.checkIn.mapper.RoomMapper;
import edu.hdu.lab.checkIn.services.RoomService;

@Service("RoomService")
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomMapper roomMapper;
	
	
	@Override
	public int getOverDueDayNumByRoomId(Integer roomId) {
		Integer dayNum = roomMapper.getOverDueDayNumByRoomId(roomId);
		if(dayNum == null)
		{
			/* No inspect Log */
			return 0;
		}
		
		return dayNum.intValue();
	}

	@Override
	public boolean isOverDueByRoomId(Integer roomId) {
		
		Integer overDueDayNum = roomMapper.getOverDueDayNumByRoomId(roomId);
		
		if(overDueDayNum == null)
		{
			return true;
		}else
		{
			return overDueDayNum.intValue() >= 0;
		}
	}

	@Override
	public int getPesonNumByRoomId(Integer roomId) {
		Integer persNum = roomMapper.getPesonNumByRoomId(roomId);
		
		return persNum.intValue();
	}

	@Override
	public RoomStatis getRoomStatisInfoByRoomId(Integer roomId) {
		RoomStatis roomStatis = new RoomStatis();
		
		roomStatis.setOverDue(isOverDueByRoomId(roomId));
		roomStatis.setOverDueDayNum(getOverDueDayNumByRoomId(roomId));
		roomStatis.setPersonNum(getPesonNumByRoomId(roomId));
		
		return roomStatis;
	}
	
}
