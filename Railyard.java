import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * A class representing a Railyard which is an Arraylist of classification Yards
 * @author Ishaan Gupta
 */
public class Railyard <T extends Comparable <? super T>>
{
  //Arraylist of Classification Yards in a RailYard
  private ArrayList<ArrayList<LinkedList<T>>> RailYard;
  
  
  /**
   * Constructor of the class
   * @param classificationYard Array of classification Yard
   */
  public Railyard(int[] classificationYard)
  {
    RailYard = new ArrayList<ArrayList<LinkedList<T>>>(classificationYard.length);
    
    //Initialization and Declaration of Tracks in Classification Yard in ArrayList
    for (int i = 0; i < classificationYard.length; i++)               
    {
      RailYard.add(i, new ArrayList<LinkedList<T>>(classificationYard[i]));      
      for (int j = 0; j < classificationYard[i]; j++) 
      {
        RailYard.get(i).add(j, new LinkedList<T>());
      }   
    }
  }
  
  /**
   * Perform the cycle sorting of the cars of the train in each Classification Yards
   * @param train Array of train
   */
  public void cycleSort (T[] train)
  {
    if(train.length > 1)
    {
    //Local Variable to store the train Array and used for merging process
    T[] newTrain = train;
    
    //Loop to iterate in the Arraylist of classification Yard
    for (int i = 0; i < RailYard.size(); i++)
    {  
      try{
        //First car of train put on the first track
        RailYard.get(i).get(0).add(train[0]); 
      
        int trackNum = 0;   
        //Loop to iterate along the cars of the train
        for (int j = 1; j < train.length; j++)
        {
           
          //if the preceding car is >= successive car of the train
          if (train[j].compareTo(train[j - 1]) >= 0)      
          {
            RailYard.get(i).get(trackNum).add(newTrain[j]);
          }           
          
          //if the preceding car is < successive car of the train
          else
          {
            //Checking if there is adjacent track available
            if ((RailYard.get(i).size() - 1) >= trackNum + 1)
            {
              trackNum ++;
              RailYard.get(i).get(trackNum).add(newTrain[j]);
            }
            //Putting the car in first track
            else
            {
              RailYard.get(i).get(0).add(newTrain[j]);
              trackNum = 0;
            }
          }
        }    
      }
      catch(IndexOutOfBoundsException e){
        System.out.println("No tracks in " + (i+1) + " classification yard. Moving onto next classification yards");
      }
      train = merge(i,train);
    }    
  }
  }
  
    /**
     * Helper method for Merging of the cars to form a new train after sorting
     * @param i present classification yard
     * @param newTrain train to be modified while adding sorted cars from classification yard
     * @return train merged train
     */
  public T[] merge (int i, T[] newTrain)
  {
    //Local Variable to store the car with minimum value 
    T minCar;
    //Local Variable to store the position of first non-empty track
    int trackNo;
    //Counter used to add the car of in the new train
    int t = 0;
    
    //Loop to run the process of merging till each track of the classification yard gets empty
    while (getHeadsUp(RailYard.get(i)) != -1)
    {        
      trackNo = getHeadsUp(RailYard.get(i));
      minCar = RailYard.get(i).get(trackNo).getFirst();   
      
      //Loop to iterate through each track of the classification Yard after getting the first non-empty track
      for (int k = trackNo + 1; k < RailYard.get(i).size(); k++)
      {
        //Checking for non-empty loop condition
        if (RailYard.get(i).get(k).isEmpty() == false)
        {//Comparing differences with each other
          if (minCar.compareTo(RailYard.get(i).get(k).getFirst()) > 0)
          {
            minCar = RailYard.get(i).get(k).getFirst();
            trackNo = k;
          }
        }
      }
      //Addition of cars in new train
      newTrain[t] = minCar;
      t++;
      //Removing the cars from classification yard
      RailYard.get(i).get(trackNo).removeFirst();
    }
    return newTrain;
  }
  
  
  
  /**
   * Helper Method to check which track is empty in the ArrayList of ClassificationYard
   * @param classificationYard One classification yard with tracks 
   * @return int if value returned = -1, then tracks are empty
   * otherwise the value returned is the position of the track in the ArrayList
   */
  public int getHeadsUp(ArrayList<LinkedList<T>> classificationYard)
  {
    //Local Variable to check if each list of the array is empty
    boolean flag = true;    
    //Local Variable to iterate in the array
    int i = 0;
    
    /**
     * Loop to iterate in the ArrayList of ClassificationYard
     * Find the empty track
     * Or find the position of first non-empty track
     */
    while(flag != false && i < classificationYard.size())
    {
      flag = flag && classificationYard.get(i).isEmpty();
      i ++;
    }
    // To find the track number where the element was found
    if (flag == false)    
      return i - 1;    
    
    //Each track is empty
    return -1;
  }
  
  
  /**
   * Perform the cycle sorting of the cars of the train in each Classification Yards
   * @param train Array of train
   */
  public void cycleSort (List<T> train)
  {
    if(train.size() > 1)
    {
    //Local Variable to store the train Array and used for merging process
    List<T> newTrain = train;
    
    
    //Loop to iterate in the Arraylist of classification Yard
    for (int i = 0; i < RailYard.size(); i++)
    {
      ListIterator<T> it = train.listIterator();
      ListIterator<T> ity = train.listIterator();
      
      try{      
      //First car of train put on the first track
      RailYard.get(i).get(0).add(train.get(0));   
      int trackNum = 0;
      
      //Loop to iterate along the cars of the train      
      T temp3 = ity.next();
      while (ity.hasNext())
      {
        T temp1 = it.next();           
        T temp2 = ity.next();
        
        //if the suceesive car is >= preceding car of the train        
        if (it.hasNext() == true && temp1.compareTo(it.next()) <= 0)
        {
          RailYard.get(i).get(trackNum).add(it.previous()); // j= 1
        }
        
        //if the preceding car is < successive car of the train
        else
        {
          //Checking if there is adjacent track available
          if ((RailYard.get(i).size() - 1) >= trackNum + 1)
          {
            trackNum += 1;
            RailYard.get(i).get(trackNum).add(it.previous());
          }
          //Putting the car in first track
          else
          {
            RailYard.get(i).get(0).add(it.previous());
            trackNum = 0;
          }
        }
      }
      //Merge method is called and merged sorted train stored
      train = mergeList(i,train);
      } 
      catch (IndexOutOfBoundsException e)      
      {
        System.out.println("No tracks in " + (i+1) + " classification yard. Moving onto next classification yards");
      }
    }
  }
  }
  
    /**
     * Helper method for Merging of the cars to form a new train after sorting
     * @param i present classification yard
     * @param train train to be modified while adding sorted cars from classification yard
     * @return train merged train
     */
  public List<T> mergeList(int i, List<T> train)
  {    
    //Local Variable to store the car with minimum value 
    T minCar;
    //Local Variable to store the position of first non-empty track
    int trackNo;      
    // train.clear();        
    ListIterator<T> strain = train.listIterator();
    
    //Loop to run the process of merging till each track of the classification yard gets empty
    while (getHeadsUp(RailYard.get(i)) != -1)
    {        
      trackNo = getHeadsUp(RailYard.get(i));
      minCar = RailYard.get(i).get(trackNo).get(0);   
      
      //Loop to iterate through each track of the classification Yard after getting the first non-empty track
      for (int k = trackNo + 1; k < RailYard.get(i).size(); k++)
      {
        if (RailYard.get(i).get(k).isEmpty() == false)
        {
          if (minCar.compareTo(RailYard.get(i).get(k).get(0)) > 0)
          {
            minCar = RailYard.get(i).get(k).get(0);
            trackNo = k;
          }
        }
      }
      strain.next();
      //Sorted train being merged  
      strain.set(minCar);      
      //Removing the cars from classification yard
      RailYard.get(i).get(trackNo).removeFirst();
    }
    return train;
  }
  
  
  /**
   * Perform the Closest sorting of the cars of the train in each Classification Yards
   * @param train Array of train
   */
  public void closestSort(T [] train)
  {
    if(train.length > 1)
    {
    //Local Variable to store the train Array and used for merging process
    T[] newTrain = train;
    
    //Loop to iterate in the list of classification Yard
    for (int i = 0; i < RailYard.size(); i++)
    {
      try{
      //First car of train put on the first track
      RailYard.get(i).get(0).add(train[0]);  
     
      //Addition of cars of train into a particular classification Yard
      for(int j = 1; j < train.length; j++)
      {        
        //Local variable to stop the loop on given condition
        char flag = 'n';    
        //Local Variable used as a counter
        int k = 0;
        
        //Loop to find if there is any larger value
        while (flag == 'n' && k < RailYard.get(i).size())
        { 
          //Checking the counter remains with size && comparing the car with back element of each track
          if(RailYard.get(i).get(k).isEmpty() != true && train[j].compareTo(RailYard.get(i).get(k).getLast()) >= 0 )
          {
            flag = 'y';          
          }  
          
          else
            k++;
        }
        
        
        //There is one possible value which is less than or equal to the train element
        if(flag == 'y')
        {
          //Local Variable storing the difference of two cars
          int minTemp = train[j].compareTo(RailYard.get(i).get(k).getLast());
          //Local Variable to store the position of track with least valued back car
          int trackPos = k;
          
          //Loop to iterate through remaining each track of the classification Yard
          for(int l = k + 1; l < RailYard.get(i).size(); l++)
          { 
            //Getting the minimum difference between car and back car 
            if(RailYard.get(i).get(l).isEmpty() != true && train[j].compareTo(RailYard.get(i).get(l).getLast()) <= minTemp)
            {
              minTemp = train[j].compareTo(RailYard.get(i).get(l).getLast());
              trackPos = l;
            }
          }
          RailYard.get(i).get(trackPos).addLast(train[j]);        
        }
        
        /**
         * Search for the empty track to move the car of the train
         * If empty track found, car is added to that track
         * else car added to the track whose back element has the smallest value
         */
        else
        {
          //Local Variable storing the difference of two cars
          char flag2 = 'n';
          //Local Variable used as a counter
          int t = 0;
          
          //Loop to iterate till first empty track is found
          while(flag2 == 'n' && t < RailYard.get(i).size())
          {
            if(RailYard.get(i).get(t).isEmpty() == true)
            {
              flag2 = 'y';           
            }
            
            else
              t++;
          }
          
          //Empty track is found, adding the car 
          if(flag2 == 'y')
          {
            RailYard.get(i).get(t).add(train[j]);
          }
          
          /**
           * Empty track is not found. Need to run the last algorithm
           * Finds the track with the least valued back car 
           * And adds the car of the train at the back of that track
           */
          else
          {
            //Local Variable storing the back car of the first track
            T minBackCar = RailYard.get(i).get(0).getLast();
            //Local Variable to store the position of track with least valued back car, if found
            int trackPos = 0;
            
            //Loop to iterate through remainin each track of the classification Yard
            for(int a = 1; a < RailYard.get(i).size(); a++)
            {
              if(RailYard.get(i).get(a).isEmpty() != true && minBackCar.compareTo(RailYard.get(i).get(a).getLast()) > 0)
              {
                minBackCar = RailYard.get(i).get(a).getLast();
                trackPos = a;
              }
            }        
            RailYard.get(i).get(trackPos).addLast(train[j]);
          }
        }      
      }
      }
      catch(IndexOutOfBoundsException e){
        System.out.println("No tracks in " + (i+1) + " classification yard. Moving onto next classification yards");
      }
      //Merge method called and merged sorted train stored
      train = merge(i,train);
    }
  }
  }
  
  /**
   * Perform the Closest sorting of the cars of the train in each Classification Yards
   * @param train List of train
   */
  public void closestSort(List<T> train)
  {
    //Local Variable to store the train Array and used for merging process
    List<T> newTrain = train;   
      if(train.size() > 1)
      {
      //Loop to iterate in the list of classification Yard
      for (int i = 0; i < RailYard.size(); i++)
      {
        ListIterator<T> it = train.listIterator();
       
        //First car of train put on the first track
          try{
          RailYard.get(i).get(0).add(it.next());  
        
        //Addition of cars of train into a particular classification Yard
        //for(int j = 1; j < train.length; j++)       
        while (it.hasNext())
        {
          T temp = it.next();
          //Local variable to stop the loop on given condition
          char flag = 'n';    
          //Local Variable used as a counter
          int k = 0;
          
          //Loop to find if there is any larger value
          while (flag == 'n' && k < RailYard.get(i).size())
          { 
            //Checking the counter remains with size && comparing the car with back element of each track
            //if(RailYard.get(i).get(k).isEmpty() != true && train[j].compareTo(RailYard.get(i).get(k).getLast()) >= 0 )
            if(RailYard.get(i).get(k).isEmpty() != true && temp.compareTo(RailYard.get(i).get(k).getLast()) >= 0 )
            {
              flag = 'y';          
            }  
            
            else
              k++;
          }
          
          
          //There is one possible value which is less than or equal to the train element
          if(flag == 'y')
          {
            //Local Variable storing the difference of two cars
            //int minTemp = train[j].compareTo(RailYard.get(i).get(k).getLast());
            int minTemp = temp.compareTo(RailYard.get(i).get(k).getLast());
            //Local Variable to store the position of track with least valued back car
            int trackPos = k;
            
            //Loop to iterate through remaining each track of the classification Yard
            for(int l = k + 1; l < RailYard.get(i).size(); l++)
            { 
              //Getting the minimum difference between car and back car 
              if(RailYard.get(i).get(l).isEmpty() != true && temp.compareTo(RailYard.get(i).get(l).getLast()) >= minTemp)
              {
                minTemp = temp.compareTo(RailYard.get(i).get(l).getLast());
                trackPos = l;
              }
            }
            RailYard.get(i).get(trackPos).addLast(temp);        
          }
          
          /**
           * Search for the empty track to move the car of the train
           * If empty track found, car is added to that track
           * else car added to the track whose back element has the smallest value
           */
          else
          {
            //Local Variable storing the difference of two cars
            char flag2 = 'n';
            //Local Variable used as a counter
            int t = 0;
            
            //Loop to iterate till first empty track is found
            while(flag2 == 'n' && t < RailYard.get(i).size())
            {
              if(RailYard.get(i).get(t).isEmpty() == true)
              {
                flag2 = 'y';           
              }
              
              else
                t++;
            }
            
            //Empty track is found, adding the car 
            if(flag2 == 'y')
            {
              RailYard.get(i).get(t).add(temp);
            }
            
            /**
             * Empty track is not found. Need to run the last algorithm
             * Finds the track with the least valued back car 
             * And adds the car of the train at the back of that track
             */
            else
            {
              //Local Variable storing the back car of the first track
              T minBackCar = RailYard.get(i).get(0).getLast();
              //Local Variable to store the position of track with least valued back car, if found
              int trackPos = 0;
              
              //Loop to iterate through remainin each track of the classification Yard
              for(int a = 1; a < RailYard.get(i).size(); a++)
              {
                if(RailYard.get(i).get(a).isEmpty() != true && minBackCar.compareTo(RailYard.get(i).get(a).getLast()) > 0)
                {
                  minBackCar = RailYard.get(i).get(a).getLast();
                  trackPos = a;
                }
              }        
              RailYard.get(i).get(trackPos).addLast(temp);
            }
          }      
        }
        } 
      catch (IndexOutOfBoundsException e)      
      {
        System.out.println("No tracks in " + (i+1) + " classification yard. Moving onto next classification yards");
      }
      //Merge method is called and merged sorted train is stored
        train = mergeList(i,train);
      }
      }         
  }
  
  /**
   * Setter method for ArrayList of Classification Yards
   * @param a new ArrayList of Classification Yards
   */
  public void setRailyard(ArrayList<ArrayList<LinkedList<T>>> a)
  {
    RailYard = a;
  }
  
  /**
   * Getter method for ArrayList of Classification Yards
   * @return ArrayList of Classification Yards
   */
  public ArrayList getRailyard()
  {
    return RailYard;
  }
  
  
  /**
   * Main method to run the program independently
   * @param args String input
   */
  public static void main (String args[])
  {
    try
    {
      //Declaring Array Of classification Yard
      int[] listClassYard = new int[Integer.parseInt(args[1])];  
      //Local variable used as counter
      int i = 0;
      //Local variable used as counter
      int j = 0;
      
      //Loop to add the number of tracks in respective classification yard
      while (i < listClassYard.length)  
      {
        j = i + 2;
        listClassYard[i] = Integer.parseInt(args[j]);
        i ++;
      }
    
      j ++;
      
      //Declaration and Initialization of Train to be sorted
      String[] unsortTrain = new String[args.length - j];
      
      //Loop to add cars in the train
      for (int k = 0; k < unsortTrain.length; k++)
      {
        unsortTrain[k] = args[j];
        j ++;
      }   
   
      //Instantiation of Railyard class 
      Railyard<String> railyard = new Railyard<String> (listClassYard);
      
      //Local varible used as flag for printing train
      char flag = 'n';
      
      if (args[0].equals("cycle"))
      {
        railyard.cycleSort(unsortTrain);
        flag = 'y';
      }
      else if (args[0].equals("closest"))
      {
        railyard.closestSort(unsortTrain);
        flag = 'y';
      }
      else
      {
        System.out.println("Enter appropriate name of Sorting algorithm");
      }
      
      //Print elements only when appropriate sorting name given
      if(flag == 'y')
      for (int l = 0; l < unsortTrain.length; l++)
      {
        System.out.println(unsortTrain[l]);
      }
      
    }
    catch (NumberFormatException e)
    {
      System.out.println("Please input valid values.");
    }
  }
   
    
    
  
  
}


