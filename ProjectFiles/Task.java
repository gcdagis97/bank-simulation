package banksimulation;

public class Task {

	public int arr;
	public int ser;
	
	public Task(int arr, int ser) {

		this.arr = arr;
		this.ser = ser;
	}
	
	public int getarr() {
	     return arr;
	}
	
	public int getser() {
	     return ser;
	}
	
	@Override
	public String toString() {
		return "Task [arr=" + arr + ", ser=" + ser + "]";
	}

}
