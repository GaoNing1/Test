package com.bug;

public class Data {
	String time;
	String milliseconds_since_epoch;
	String date;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMilliseconds_since_epoch() {
		return milliseconds_since_epoch;
	}

	public void setMilliseconds_since_epoch(String milliseconds_since_epoch) {
		this.milliseconds_since_epoch = milliseconds_since_epoch;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String toString(){
		return "time="+this.time+";milliseconds_since_epoch="+this.milliseconds_since_epoch+";date="+this.date;
	}
	
}
