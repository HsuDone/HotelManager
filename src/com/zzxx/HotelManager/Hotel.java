package com.zzxx.HotelManager;

import java.util.Scanner;

/**
 * @author ����
 *
 */
public class Hotel {
	private static int totalFloor = 4;
	private static int RoomsPerFloor = 6;
	private Room[][] rooms = new Room[totalFloor][RoomsPerFloor];
	public void InitRooms() {
		for(int i = 0 ; i < totalFloor ; i ++) 
			for(int j = 0 ; j < RoomsPerFloor ; j ++)
			{
				rooms[i][j] = new Room((i+1)+"0"+(j+1));
			}
	}
	public void ShowRoomsList() {
		System.out.println("�ͷ�״�����±�");
		for (int i = 0; i < totalFloor; i++) {
			for (int j = 0; j < RoomsPerFloor; j++) {
				System.out.print("\t"+rooms[i][j]+"\t");
			}System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Hotel h = new Hotel();
		h.InitRooms();
		h.Login();
	}
	
	public boolean checkIN(String Name,String num) 
	{
		for (int i = 0; i < totalFloor; i++) 
			for (int j = 0; j < RoomsPerFloor; j++) 
				if (rooms[i][j].getRoomnum().equals(num)) 
					return	rooms[i][j].addGuest(Name);
		System.out.println("������ķ��Ų����ڣ������¼��������µķ���");
		return false;
	}
	public boolean checkOUT(String romNum) {
		for (int i = 0; i < totalFloor; i++) 
			for (int j = 0; j < RoomsPerFloor; j++) 
				if (rooms[i][j].getRoomnum().equals(romNum)) 
				{
					rooms[i][j].deleteGuest();
					return true;
				}	
		System.out.println("������ķ��Ų����ڣ������¼��������µķ���");
		return false;
	}
	public void Login() {
		String key;
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------��ӭʹ��ָ����Ϣ�Ƶ����ϵͳ---------------------------------");
		boolean IsExit = false;
		while( ! IsExit) 
		{
			System.out.println("���������ָ�show�����鿴\t in������ס\t out�����˷�\t exit�����˳�ϵͳ\n");
			key = sc.nextLine();
			
			switch (key) {
				case "in":
					boolean IsCheckIn = false;
					System.out.println("�������������մ�����");
					String Name = sc.nextLine();
					while( ! IsCheckIn) 
					{
						System.out.println("����������Ҫ��ס�ķ��ţ�");
						String romNum = sc.nextLine();
						IsCheckIn = this.checkIN(Name, romNum);
					}
					System.out.println("-----------------------��ס�ɹ���ָ����Ϣ�Ƶ껶ӭ����-----------------------");
					break;
				case "out":
					boolean IsCheckOut = false;
					while( ! IsCheckOut) 
					{
						System.out.println("���������ķ��ţ�");
						String romNum = sc.nextLine();
						IsCheckOut = this.checkOUT(romNum);
					}System.out.println("------------------------�˷��ɹ����ڴ��´����Ĺ��٣�------------------------");
					break;
				case "show":
					this.ShowRoomsList();
					break;
				case "exit":
					IsExit = true;
					sc.close();
					System.out.println("-----------------------��л����ʹ�ã��´��ټ�--------------------------");
					break;
				default:
					System.out.println("-----------------------�������Ƿ�Ҫ��������ȷ��ָ�� ��-------------------------");
					break;
			}
		}
	}
}
