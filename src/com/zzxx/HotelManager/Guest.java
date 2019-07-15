package com.zzxx.HotelManager;

/**
 * @author ÕÂÐñ¶«
 *
 */
public class Guest {
	private String Name;
	
	public Guest(String Name) {
		this.Name = Name;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
		public String toString() {
				return this.Name;
		}
	
}
