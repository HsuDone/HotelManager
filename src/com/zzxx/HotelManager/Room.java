package com.zzxx.HotelManager;

/**
 * @author ����
 *
 */
public class Room {
	private String Roomnum ;
	private Guest gue;
	
	public Room(String No,Guest g) {
		this.Roomnum = No;
		this.gue = g;
	}
	
	public Room(String No) {
		this.Roomnum = No;
	}
	
	public Room() {
	}
	public boolean addGuest(String Name) {
		if (this.gue != null) {
			System.out.println("�÷����Ѿ�����Ԥ���ˣ��뿼����ס��һ����");
			return false;
		}else 
		{
			this.gue = new Guest(Name);
			return true;
		}
	}
	public void deleteGuest() {
		this.gue = null;
	}
	
	public String getRoomnum() {
		return Roomnum;
	}
	public void setRoomnum(String roomnum) {
		Roomnum = roomnum;
	}
	public Guest getGue() {
		return gue;
	}
	public void setGue(Guest gue) {
		this.gue = gue;
	}
		
	@Override
		public String toString() {
		if(this.gue!=null)
		return this.Roomnum+"--"+this.gue;
		return this.Roomnum+"--"+"����";
	}
}
