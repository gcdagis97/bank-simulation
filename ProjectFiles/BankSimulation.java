package banksimulation;

import java.util.*;
import java.io.*; // Import from file

public class BankSimulation
{	
	//initializations at startup
	static int CURR = 918; //initialize current system time
	static int count = 0; //customers leaving the bank	
	static int tt, TT = 0; //initialize throughtime and total throughtime variables
	
	static Task TaskCurr = new Task(916, 3); //initialize TaskCurr
	static Task T = new Task(925, 2); //initialize T, next task to be placed on tasks stack
	static Stack1gen<Task> Tasks = new Stack1gen<Task>(); //initialize stack of Task objects
	static Task a = new Task(910, 12);
	static Task b = new Task(913, 3); //temp Task objects to fill Tasks
	
	static Queue2<Customer> Qcust = new Queue2<Customer>(); //initialize queue of Customer objects
	static Customer i = new Customer(912, 6, 15);
	static Customer j = new Customer(913, 3, 10); //temp Cust objects to fill Qcust
	static Customer k = new Customer(915, 4, 15);
	static Customer C1 = new Customer(908, 3, 20);
	static Customer C2 = new Customer(905, 4, 15); //C1/C2 = customers at teller 1/2
	static Customer C3; //c3 has no customer at initialization 
	static int B1, B2 = 0; //teller free
	static int B3 = 1; //teller busy
	
	
	static OList<Event> Elist = new OList<Event>(); //initialize OList of Event objects
	static Event v = new Event(918, 2);
	static Event w = new Event(918, 7);
	static Event x = new Event(920, 1);
	static Event y = new Event(920, 5); //create temp Event objects to fill Elist
	static Event z = new Event(925, 6);
	static Event next;
	
	static Customer CUST = new Customer(918, 5, 5); //next cust to arrive in bank
	static Customer arr1 = new Customer(924, 10, 15);
	static Customer arr2 = new Customer(930, 2, 10);
	static Queue2<Customer> CustArr = new Queue2<Customer>();
	static Task task1 = new Task(933, 1);
	static Queue2<Task> TaskArr = new Queue2<Task>();
	
	public static void execute(Event e)
	{
		switch (e.type) {
		case 1:
			B1 = 0;
			tt = CURR - C1.getarrivalTime();
			TT = TT + tt; 
			count++;
			System.out.println("\n******\nType " + e.type + " event (exit from teller " + e.type + ")\narrTime: " + C1.getarrivalTime() + ", serTime = " + C1.getserviceTime() + ", waiTime = " + C1.getmaxwaitingTime() + ", at time: " + CURR);
			System.out.println("cust throughtime tt: " + tt);
			System.out.println("total throughtime TT: " + TT);
			System.out.println(count + " customers have exited the bank");
			if(Qcust.getSize() > 0)
			{
				C1 = Qcust.dequeue();
				if(C1.getarrivalTime() + C1.getmaxwaitingTime() < CURR)
				{
					System.out.println("Cust already left bank.");
				}
				else
				{
					next = new Event(CURR + C1.getserviceTime(), 1);
					Elist.insert(next);
					B1 = 1;
				}
			}
			break;
		case 2:
			B2 = 0;
			tt = CURR - C2.getarrivalTime();
			TT = TT + tt; 
			count++;
			System.out.println("\n******\nType " + e.type + " event (exit from teller " + e.type + ")\narrTime: " + C2.getarrivalTime() + ", serTime = " + C2.getserviceTime() + ", waiTime = " + C2.getmaxwaitingTime() + ", at time: " + CURR);
			System.out.println("cust throughtime tt: " + tt);
			System.out.println("total throughtime TT: " + TT);
			System.out.println(count + " customers have exited the bank");
			if(Qcust.getSize() > 0)
			{
				C2 = Qcust.dequeue();
				if(C2.getarrivalTime() + C2.getmaxwaitingTime() < CURR)
				{
					System.out.println("***Cust already left bank.");
				}
				else
				{
					next = new Event(CURR + C2.getserviceTime(), 2);
					Elist.insert(next);
					B2 = 1;
				}
			}
			break;
		case 3:
			//do stuff ;
		case 4:
			//do stuff ;
		case 5: 
			B3 = 0;
			System.out.println("\n******\nType 5 Event\nTask processed: " + TaskCurr.getarr() + " " + TaskCurr.getser() + "\nAt time: " + CURR);
			if(Tasks.getSize() > 0)
			{
				TaskCurr = Tasks.pop();
				next = new Event(CURR + TaskCurr.getser(), 5);
				Elist.insert(next);
				B3 = 1;
			}
			else
			{
				if(Qcust.getSize() > 0)
				{
					C3 = Qcust.dequeue();
					if(C3.getarrivalTime() + C3.getmaxwaitingTime() < CURR)
					{
						System.out.println("***Cust already left bank.");
						//B3 = 0;
					}
					else
					{
						next = new Event(CURR + C3.getserviceTime(), 3);
						Elist.insert(next);
						B3 = 1;
					}
				}
			}
			break;
		case 6:
			System.out.println("\n******\nType 6 Event:\nTask Arrived from file: " + T.getarr() + " " + T.getser());
			System.out.println("Time: " + CURR);
			Tasks.push(T);
			if(B3 == 0)
			{
				TaskCurr = Tasks.pop();
				next = new Event(CURR + TaskCurr.getser(), 5);
				Elist.insert(next);
				B3 = 1;
			}
			if(TaskArr.getSize() > 0)
			{
				T = TaskArr.dequeue();
				next = new Event(T.getarr(), 6);
				Elist.insert(next);
			}
			break;
		case 7:
			Qcust.enqueue(CUST);
			System.out.println("\n******\nType 7 Event:\nCust Arrived from file: " + CUST.getarrivalTime() + " " + CUST.getserviceTime() + " " + CUST.getmaxwaitingTime());
			System.out.println("Time: " + CURR);
			if(CustArr.getSize() > 0)
			{
				CUST = CustArr.dequeue();
				next = new Event(CUST.getarrivalTime(), 7);
				Elist.insert(next);
			}
			if(Qcust.getSize() == 1)
			{
				if(B1 == 0)
				{
					C1 = Qcust.dequeue();
					next = new Event(CURR + C1.getserviceTime(), 1);
					Elist.insert(next);
					B1 = 1;
				}
				else if(B2 == 0)
				{
					C2 = Qcust.dequeue();
					next = new Event(CURR + C2.getserviceTime(), 2);
					Elist.insert(next);
					B2 = 1;
				}
				else if(B3 == 0)
				{
					C3 = Qcust.dequeue();
					next = new Event(CURR + C3.getserviceTime(), 3);
					Elist.insert(next);
					B3 = 1;
				}
			}
			break;
		default: 
			break;
		}
	}

	public static void main(String[] args)
	{
		
		Tasks.push(a); Tasks.push(b); //fill Tasks stack
		Qcust.enqueue(i); Qcust.enqueue(j); Qcust.enqueue(k); //fill Qcust queue
		Elist.insert(v); Elist.insert(w); Elist.insert(x); Elist.insert(y); Elist.insert(z); //fill Elist Olist
		CustArr.enqueue(arr1);
		CustArr.enqueue(arr2); //fill CustArr and TaskArr //needs file i/o implementation
		TaskArr.enqueue(task1);
		
		//program execution code
		Event e;	
		while(Elist.getSize() > 0) //loop based on contents of Event list.
		{
			e = Elist.getData(1); //take event from front of event list
			CURR = e.getTime();
			execute(e); //execute event
			Elist.del(Elist.getData(1)); //remove event from list
			Elist.printList();
		}
		System.out.println("******\nSimulation Complete. Results:");
		System.out.println("Current time: " + CURR);
		System.out.println("Total customer throughtime: " + TT);
		System.out.println("Total customer count: " + count);
		System.out.println("******\nPrinting Eventlist..."); //should be empty by now
		Elist.printList();
		System.out.print("Printing Cust Queue...");
		Qcust.printQ();
		System.out.print("Printing Tasks Stack...");
		if(Tasks.getSize() > 0)
		{
			System.out.println(Tasks.getTop().getarr() + " " + Tasks.getTop().getser());
		}
		else
			System.out.println("stack is empty");
		

	}
}