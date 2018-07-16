package edu.hdu.lab.checkIn.services;

import edu.hdu.lab.checkIn.dto.RoomStatis;

public interface RoomService {
	
	public int getOverDueDayNumByRoomId(Integer roomId);

	public boolean isOverDueByRoomId(Integer roomId);
	
	public int getPesonNumByRoomId(Integer roomId);
	
	public RoomStatis getRoomStatisInfoByRoomId(Integer roomId);
}
