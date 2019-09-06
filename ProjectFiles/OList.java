package banksimulation;

import banksimulation.Node2;
import banksimulation.OList;

//OList.java

//Class to implement the Ordered List ADT for generic objects of type T
//The type T extends Comparable so that we can use the compareTo() method

public class OList<T extends Comparable >
{
  private Node2<T> start;//starting node of the list
  private int size;//size of the list

  //constructor
  public OList()
  {
    start = null;
    size = 0;
  }

  //copy constructor
  public OList(OList L)
  {
    Node2<T> curr = L.getStart();
    T item = curr.getData();
    size = L.getSize();
    start = new Node2(item, null); //copy the first node 
    Node2<T> save = start;
    Node2<T> newnode = null;
    for(int i =1; i<=size-1; i++)
    {
      curr= curr.getLink();//update the current node to be copied from list L
      item = curr.getData();//retrieve the data of the current node 
      newnode = new Node2(item,null);//copy the data of the current node
                                     //into a new node
      save.setLink(newnode);//the previous node on the copy list
                            //points to the new node on the copy list
      save = newnode;//save the new node address for the next cycle
    }
  }

  public void insert(T y)
  {
    Node2<T> curr=null;
    Node2<T> save=null;
    Node2<T> newnode=null;

    //search for the correct order position of data value y
    curr = start;//initialize the search at the beginning of the list
    while((curr != null) && (curr.getData().compareTo(y)<0))
    {
      //if y comes after the current data, update the search 
      save=curr;
      curr=curr.getLink();
    }
    newnode = new Node2(y,curr);//new node to hold inserted value
    if(curr==start)    
    {
      start = newnode; //insertion at the beginning of the list
    }
    else
    {
      save.setLink(newnode); //previous node points to the new value
    }
    size++;
  }

  public void del(T y) //search for first occurance of value y, and remove
  {
    Node2<T> curr=null;
    Node2<T> save=null;

    //search for first occurance of y
    curr = start;
    while((curr != null) && (curr.getData().compareTo(y) != 0))
    {
      save = curr;
      curr = curr.getLink();
    }
    if(curr == null)
    {
      System.out.println("no deletion: " + y + " not on list");
    }
    else
    {
       size--;
       if(curr == start)
       {
         start = curr.getLink();//deletion at the beginning
       }
       else
       {
         save.setLink(curr.getLink());//delete the current node:
                                   //previous node points to following node
       }
    }
  }

  public void printListBasic()
  {
    Node2<T> curr = start;
    System.out.println("list contents: ");
    while(curr != null)
    {
      T out = curr.getData();
      System.out.println(out.toString());
      curr = curr.getLink();
    }
    System.out.println(" ");
  }

  public void printList()
  {
    Node2<T> curr = start;
    //System.out.println("list contents: ");
    while(curr != null)
    {
      T out = curr.getData();
      System.out.println(out);
      curr = curr.getLink();
    }
    System.out.println(" ");
  }

  public int getSize()
  {
    return size;
  }

  public Node2 getStart()
  {
    return start;
  }

  public T getData(int i)
  {
    Node2<T> curr = start;
    for(int j=1; j<i; j++)
    {
      curr = curr.getLink();
    }
    return curr.getData();
  }
}


