package banksimulation;

public class Teller {

	Object Customer;
    Object Task;
	boolean isBusy;
	
	public Teller(Customer Customer, Task Task, boolean B) {
		this.Customer = Customer;
		this.Task = Task;
		this.isBusy = B;
	}
	
	public Object getCustomer() {
	     return Customer;
	}
	
	public Object getTask() {
		return Task;
	}
	
	public boolean isBusy() {
		return isBusy;
	}

	@Override
	public String toString() {
		return "Teller [Customer=" + Customer + ", Task=" + Task + ", isBusy=" + isBusy + "]";
	}
}