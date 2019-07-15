package com.zzxx.HotelManager;

import java.util.Scanner;

/**
 * @author 章旭东
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
		System.out.println("客房状况如下表：");
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
		System.out.println("您输入的房号不存在，请重新检查后输入新的房号");
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
		System.out.println("您输入的房号不存在，请重新检查后输入新的房号");
		return false;
	}
	public void Login() {
		String key;
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------欢迎使用指针信息酒店管理系统---------------------------------");
		boolean IsExit = false;
		while( ! IsExit) 
		{
			System.out.println("请输入操作指令：show——查看\t in——入住\t out——退房\t exit——退出系统\n");
			key = sc.nextLine();
			
			switch (key) {
				case "in":
					boolean IsCheckIn = false;
					System.out.println("请输入您的尊姓大名：");
					String Name = sc.nextLine();
					while( ! IsCheckIn) 
					{
						System.out.println("请输入您想要入住的房号：");
						String romNum = sc.nextLine();
						IsCheckIn = this.checkIN(Name, romNum);
					}
					System.out.println("-----------------------入住成功，指针信息酒店欢迎您！-----------------------");
					break;
				case "out":
					boolean IsCheckOut = false;
					while( ! IsCheckOut) 
					{
						System.out.println("请输入您的房号：");
						String romNum = sc.nextLine();
						IsCheckOut = this.checkOUT(romNum);
					}System.out.println("------------------------退房成功，期待下次您的光临！------------------------");
					break;
				case "show":
					this.ShowRoomsList();
					break;
				case "exit":
					IsExit = true;
					sc.close();
					System.out.println("-----------------------感谢您的使用，下次再见--------------------------");
					break;
				default:
					System.out.println("-----------------------请检查您是否按要求输入正确的指令 ！-------------------------");
					break;
			}
		}
	}
}
