package edu.hdu.lab.checkIn.dto;

import org.springframework.beans.factory.annotation.Autowired;

import edu.hdu.lab.checkIn.mapper.RoomMapper;
import edu.hdu.lab.checkIn.services.RoomService;

public class RoomStatis {
	
	/* 是否超期 */
	private boolean isOverDue;
	
	private int overDueDayNum;
	
	/* Person  数量 */
	private int personNum;
	
	/*
	@Autowired
	private RoomService roomService;
	*/
	
	public RoomStatis() {
		super();
	}

	/*
	 * TODO to figure it out
	 * */
	/*
	public RoomStatis(Integer roomId) {
		super();
		
		this.isOverDue = roomService.isOverDueByRoomId(roomId);
		this.overDueDayNum = roomService.getOverDueDayNumByRoomId(roomId);
		this.personNum = roomService.getPesonNumByRoomId(roomId);
	}
	
	*/
	public boolean isOverDue() {
		return isOverDue;
	}

	public void setOverDue(boolean isOverDue) {
		this.isOverDue = isOverDue;
	}

	public int getPersonNum() {
		return personNum;
	}

	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}

	public int getOverDueDayNum() {
		return overDueDayNum;
	}

	public void setOverDueDayNum(int overDueDayNum) {
		this.overDueDayNum = overDueDayNum;
	}
	
	
	
	
}
