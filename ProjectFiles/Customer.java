package banksimulation;

public class Customer {

	public int arrivalTime;
	public int serviceTime;
	public int maxwaitingTime;

	public Customer(int arrivalTime, int serviceTime, int maxwaitingTime) {

		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
		this.maxwaitingTime = maxwaitingTime;
	}

	public int getarrivalTime() {
	     return arrivalTime;
	}
	
	public int getserviceTime() {
	     return serviceTime;
	}
	
	public int getmaxwaitingTime() {
	     return maxwaitingTime;
	}
	
	@Override
	public String toString() {
		return "Customer [arrivalTime=" + arrivalTime + ", serviceTime=" + serviceTime + ", maxwaitingTime="
				+ maxwaitingTime + "]";
	}
}