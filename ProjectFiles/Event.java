package banksimulation;

import banksimulation.Event;


public class Event implements Comparable<Event> //, PrintValue
{
	public int time, type;

   public Event(int timeE, int typeE)
   {
     time = timeE;
     type = typeE;
   }

   public int getTime()
   {
     return time;
   }

   public int getType()
   {
     return type;
   }

   public void setTime(int timeE)
   {
     time = timeE;
   }

   public void setType(int typeE)
   {
     type = typeE;
   }

    public String toString()
    {
      return + time + ", " + type;
    }

    
    
 //  public void printVal()
 //  {
 //    System.out.println("Event: " + "time: " + time + "  type: " + type);
 //  }

   public int compareTo(Event e)
   {
     if( (time < e.getTime()) ||
         ((time == e.getTime()) && (type < e.getType())))
     {
        return -1;
     }
     else if((time == e.getTime()) && (type == e.getType()))
     {
        return 0;
     }
     else
     {
       return 1;
     }
   }

   
}