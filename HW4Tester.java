import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class HW4Tester
{
  /**
   * Test for the Railyard class
   * @author Ishaan Gupta
   */
  
  //Tests Test Zero, One and Many for Cycle Sort method
  @Test
  public void testCycleSortArraymethod()
  {
    /**
     * Test 0
     * Possible test cases for Test 0 :
     * 0 Classification yard 
     * Classfication yards with 0 tracks
     * Train with 0 cars
     */
    
    //0 Classification yard 
    int classificationYard[] = {};
    Integer b [] = {20,11,16,3,10};
    Integer c [] = {20,11,16,3,10};
    Railyard<Integer> r = new Railyard<Integer>(classificationYard);
    r.cycleSort(b);
    assertArrayEquals("Test 0 for 0 classification Yards for cycle sort",c, b);
    
    //Classification Yards with 0 tracks
    int classificationYard1[] = {0,0,0};
    Integer b1 [] = {20,11,16,3,10};
    Integer c1 [] = {20,11,16,3,10};
    Railyard<Integer> r1 = new Railyard<Integer>(classificationYard1);
    r1.cycleSort(b1);
    assertArrayEquals("Test 0 for 0 tracks for cycle sort",c1, b1);
    
    //Classification Yards with 0 track with other tracks
    int classificationYard10[] = {2,0,1};
    Integer b10 [] = {20,11,16,3,10};
    Integer c10 [] = {11,16,20,3,10};
    Railyard<Integer> r10 = new Railyard<Integer>(classificationYard10);
    r10.cycleSort(b10);
    assertArrayEquals("Test 0 for 0 tracks for cycle sort",c10, b10);
    
    
    //Train with 0 cars
    int classificationYard2[] = {3,4};
    Integer b2 [] = {};
    Integer c2 [] = {};
    Railyard<Integer> r2 = new Railyard<Integer>(classificationYard2);
    r2.cycleSort(b2);
    assertArrayEquals("Test 0 for 0 cars in the train for cycle sort",c2, b2);
    
    /**
     * Test 1
     * Possible cases for Test 1
     * 1 classification Yard
     * 1 track in classification Yards
     * 1 car in the train
     */
    
    //1 classification Yard
    int classificationYard3[] = {2};
    Integer b3 [] = {20,11,16,3,20};
    Integer c3 [] = { 11, 16, 20, 3, 20 };
    Railyard<Integer> r3 = new Railyard<Integer>(classificationYard3);
    r3.cycleSort(b3);
    assertArrayEquals("Test One for 1 classification Yard for cycle sort",c3, b3);
    
    //1 track in classification Yards
    int classificationYard4[] = {1,1};
    Integer b4 [] = {20,11,16,3,10};
    Integer c4 [] = { 20,11,16,3,10 };
    Railyard<Integer> r4 = new Railyard<Integer>(classificationYard4);
    r4.cycleSort(b4);
    assertArrayEquals("Test One for 1 track in classification Yards for cycle sort",c4, b4);
    
    //1 car in the train
    int classificationYard5[] = {2,1};
    Integer b5 [] = {20};
    Integer c5 [] = {20};
    Railyard<Integer> r5 = new Railyard<Integer>(classificationYard5);
    r5.cycleSort(b5);
    assertArrayEquals("Test One for 1 car in the train for cycle sort",c5, b5);
    
    /**
     * Test Many
     * Possible cases for Test Many
     * Many classification Yard
     * Many track in classification Yards
     * Many car in the train
     */
    
    //Many Classification Yard with Many yards and Many Cars
    int classificationYard6[] = {2,3};
    Integer b6 [] = {20,11,16,3,10};
    Integer c6 [] = { 3, 10, 11, 16, 20 };
    Railyard<Integer> r6 = new Railyard<Integer>(classificationYard6);
    r6.cycleSort(b6);
    assertArrayEquals("Test One for 1 car in the train for cycle sort",c6, b6);   
    
    /**
     * Test First
     * Train is mostly sorted except with first car
     * Train is sorted from first classification Yard
     */
    
    //Train is mostly sorted except with first car
    Integer e[] = {54,14,24,34,44,64};     
    
    int[] classificationYards = {5,9};    
    Integer f[] = {14,24,34,44,54,64};
    
    Railyard<Integer> r19 = new Railyard<Integer>(classificationYards);    
    r19.cycleSort(e);    
    assertArrayEquals("Method is testing sorting train out of order at the first element", f, e);
    
    // Train is sorted from first classification Yard
    Integer e1[] = {32,72,12,92,22,42};    
    int[] classificationYard13 = {3, 0, 0};
    
    Integer f1[] = {12,22,32,42,72,92};    
    Railyard<Integer> r13 = new Railyard<Integer>(classificationYard13);
    
    r13.cycleSort(e1);    
    assertArrayEquals("Method is testing sorting a train out of order within the first classification yard", e1, f1);
    
    /**
     * Test Last 
     * Train is mostly sorted except with Last car
     * Train is sorted from Last classification Yard
     */
    
    //Train is mostly sorted except with Last car
    Integer e2[] = {27,37,47,57,67,17};    
    int[] classificationYards12 = {5,9};
    Integer f2[] = {17,27,37,47,57,67};
    Railyard<Integer> r20 = new Railyard<Integer>(classificationYards12);    
    r20.cycleSort(e2);    
    assertArrayEquals("Method is testing sorting a train out of order at the end element", f2, e2);
    
    //Train is sorted from Last classification Yard
    Integer e3[] = {13,8,17,10,15,2};    
    int[] classificationYards15 = {1, 2, 3};
    Integer f3[] = {2,8,10,13,15,17};
    Railyard<Integer> r15 = new Railyard<Integer>(classificationYards15);    
    r15.cycleSort(e3);    
    assertArrayEquals("Method is testing sorting a train out of order within the end classification yard", f3, e3);
    
    /**
     * Test Middle 
     * Train is mostly sorted except with Middle car
     * Train is sorted from Middle classification Yard
     */
    
    //Train is mostly sorted except with Middle car
    Integer e4[] = {15,25,45,35,55,65};
    int[] classificationYards22 = {5,9};
    Integer f4 [] = {15,25,35,45,55,65};
    Railyard<Integer> r22 = new Railyard<Integer>(classificationYards22);    
    r22.cycleSort(e4);    
    assertArrayEquals("Method is testing sorting a train out of order at the middle element", f4, e4);

    //Train is sorted from Middle classification Yard
    Integer e5[] = {13,8,17,10,15,2};
    int[] classificationYards23= {2, 3, 0};
    Integer f5[] = {2,8,10,13,15,17};
    Railyard<Integer> r23  = new Railyard<Integer>(classificationYards23);
    
    r23.cycleSort(e5);    
    assertArrayEquals("Method is testing sorting a train out of order within the middle classification yard", f5, e5);
  }
  
  //Tests all the possible conditions with one set of numbers 
  @Test
  public void testCycleSortArrayConditions()
  {
    //the biggest if is already tested in the previous method with test 0
    int classificationYard6[] = {2};
    Integer b6 [] = {20,11,6,10};
    Integer c6 [] = { 11, 20, 6, 10 };
    Railyard<Integer> r6 = new Railyard<Integer>(classificationYard6);
    r6.cycleSort(b6);
    assertArrayEquals("Test for all the conditions in the algorithm of cycle sort",c6, b6);
  }
  
    
    //Tests Test Zero, One and Many for Cycle Sort method  
    @Test
    public void testClosestSortArrayMethod()
  {
    /**
     * Test 0
     * Possible test cases for Test 0 :
     * 0 Classification yard 
     * Classfication yards with 0 tracks
     * Train with 0 cars
     */
    
    //0 Classification yard 
    int classificationYard[] = {};
    Integer b [] = {20,11,16,3,10};
    Integer c [] = {20,11,16,3,10};
    Railyard<Integer> r = new Railyard<Integer>(classificationYard);
    r.closestSort(b);
    assertArrayEquals("Test 0 for 0 classification Yards for closest sort",c, b);
    
    //Classification Yards with 0 tracks
    int classificationYard1[] = {0,0,0};
    Integer b1 [] = {20,11,16,3,10};
    Integer c1 [] = {20,11,16,3,10};
    Railyard<Integer> r1 = new Railyard<Integer>(classificationYard1);
    r1.closestSort(b1);
    assertArrayEquals("Test 0 for 0 tracks for closest sort",c1, b1);
    
    
    //Train with 0 cars
    int classificationYard2[] = {3,4};
    Integer b2 [] = {};
    Integer c2 [] = {};
    Railyard<Integer> r2 = new Railyard<Integer>(classificationYard2);
    r2.closestSort(b2);
    assertArrayEquals("Test 0 for 0 cars in the train for closest sort",c2, b2);
    
    
    /**
     * Test 1
     * Possible cases for Test 1
     * 1 classification Yard
     * 1 track in classification Yards
     * 1 car in the train
     */
    
    
    //1 classification Yard
    int classificationYard3[] = {2};
    Integer b3 [] = {20,11,16,3,20};
    Integer c3 [] = { 11, 16, 3, 20, 20 };
    Railyard<Integer> r3 = new Railyard<Integer>(classificationYard3);
    r3.closestSort(b3);
    assertArrayEquals("Test One for 1 classification Yard for closest sort",c3, b3);
    
    //1 track in classification Yards
    int classificationYard4[] = {1,1};
    Integer b4 [] = {20,11,16,3,10};
    Integer c4 [] = { 20,11,16,3,10 };
    Railyard<Integer> r4 = new Railyard<Integer>(classificationYard4);
    r4.closestSort(b4);
    assertArrayEquals("Test One for 1 track in classification Yards for closest sort",c4, b4);
    
    //1 car in the train
    int classificationYard5[] = {1,1};
    Integer b5 [] = {20};
    Integer c5 [] = {20};
    Railyard<Integer> r5 = new Railyard<Integer>(classificationYard5);
    r5.closestSort(b5);
    assertArrayEquals("Test One for 1 car in the train for closest sort",c5, b5);
    
    /**
     * Test Many
     * Possible cases for Test Many
     * Many classification Yard
     * Many track in classification Yards
     * Many car in the train
     */
    
    //Many Classification Yard with Many yards and Many Cars
    int classificationYard6[] = {2,3};
    Integer b6 [] = {20,11,16,3,10};
    Integer c6 [] = { 3, 10, 11, 16, 20 };
    Railyard<Integer> r6 = new Railyard<Integer>(classificationYard6);
    r6.closestSort(b6);
    assertArrayEquals("Test One for 1 car in the train for closest sort",c6, b6); 
    
    /**
     * Test First
     * Train is mostly sorted except with first car
     * Train is sorted from first classification Yard
     */
    
    //Train is mostly sorted except with first car
    Integer e[] = {54,14,24,34,44,64};     
    
    int[] classificationYards = {5,9};    
    Integer f[] = {14,24,34,44,54,64};
    
    Railyard<Integer> r19 = new Railyard<Integer>(classificationYards);    
    r19.closestSort(e);    
    assertArrayEquals("Method is testing sorting train out of order at the first element", f, e);
    
    // Train is sorted from first classification Yard
    Integer e1[] = {32,72,12,92,22,42};    
    int[] classificationYard13 = {3, 0, 0};
    
    Integer f1[] = {12,22,32,42,72,92};    
    Railyard<Integer> r13 = new Railyard<Integer>(classificationYard13);
    
    r13.closestSort(e1);    
    assertArrayEquals("Method is testing sorting a train out of order within the first classification yard", e1, f1);
    
    /**
     * Test Last 
     * Train is mostly sorted except with Last car
     * Train is sorted from Last classification Yard
     */
    
    //Train is mostly sorted except with Last car
    Integer e2[] = {27,37,47,57,67,17};    
    int[] classificationYards12 = {5,9};
    Integer f2[] = {17,27,37,47,57,67};
    Railyard<Integer> r20 = new Railyard<Integer>(classificationYards12);    
    r20.closestSort(e2);    
    assertArrayEquals("Method is testing sorting a train out of order at the end element", f2, e2);
    
    //Train is sorted from Last classification Yard
    Integer e3[] = {13,8,17,10,15,2};    
    int[] classificationYards15 = {1, 2, 3};
    Integer f3[] = {2,8,10,13,17,15};
    Railyard<Integer> r15 = new Railyard<Integer>(classificationYards15);    
    r15.closestSort(e3);    
    assertArrayEquals("Method is testing sorting a train out of order within the end classification yard", f3, e3);
    
    /**
     * Test Middle 
     * Train is mostly sorted except with Middle car
     * Train is sorted from Middle classification Yard
     */
    
    //Train is mostly sorted except with Middle car
    Integer e4[] = {15,25,45,35,55,65};
    int[] classificationYards22 = {5,9};
    Integer f4 [] = {15,25,35,45,55,65};
    Railyard<Integer> r22 = new Railyard<Integer>(classificationYards22);    
    r22.closestSort(e4);    
    assertArrayEquals("Method is testing sorting a train out of order at the middle element", f4, e4);

    //Train is sorted from Middle classification Yard
    Integer e5[] = {13,8,17,10,15,2};
    int[] classificationYards23= {2, 3, 0};
    Integer f5[] = {2,8,10,13,17,15};
    Railyard<Integer> r23  = new Railyard<Integer>(classificationYards23);
    
    r23.closestSort(e5);    
    assertArrayEquals("Method is testing sorting a train out of order within the middle classification yard", f5, e5);
 
  }
  
     
  //Tests all the possible conditions with one set of numbers for closest sort method
  @Test
  public void testClosestSortConditions()
  {
    int classificationYard6[] = {3};
    Integer b6 [] = {20,11,16,3,5,0};
    Integer c6 [] = { 3, 5, 0, 11, 16, 20 };
    Railyard<Integer> r6 = new Railyard<Integer>(classificationYard6);
    r6.closestSort(b6);
    assertArrayEquals("Test One for 1 car in the train for closest sort",c6, b6); 
  }
  
  //Tests Test Zero, One and Many for Cycle Sort method which takes list as parameter
  @Test
  public void testCycleSortListMethod()
  {
    /**
     * Test 0
     * Possible test cases for Test 0 :
     * 0 Classification yard 
     * Classfication yards with 0 tracks
     * Train with 0 cars
     */
    
    //0 Classification yard 
    int classificationYard[] = {};    
    ArrayList <Integer> b = new ArrayList<Integer> (5);
    b.add(20);
    b.add(11);
    b.add(16);
    b.add(3);
    b.add(10);
    
    ArrayList <Integer> c = new ArrayList<Integer> (5);
    c.add(20);
    c.add(11);
    c.add(16);
    c.add(3);
    c.add(10);
        
    Railyard<Integer> r = new Railyard<Integer>(classificationYard);
    r.cycleSort(b);
    assertEquals("Test 0 for 0 classification Yards for cycle sort",c, b);
    
    
    //Classification Yards with 0 tracks
    int classificationYard1[] = {0,0,0};
    ArrayList <Integer> b1 = new ArrayList<Integer> (5);
    b1.add(20);
    b1.add(11);
    b1.add(16);
    b1.add(3);
    b1.add(10);
    
    ArrayList <Integer> c1 = new ArrayList<Integer> (5);
    c1.add(20);
    c1.add(11);
    c1.add(16);
    c1.add(3);
    c1.add(10);
        
    Railyard<Integer> r1 = new Railyard<Integer>(classificationYard1);
    r1.cycleSort(b1);
    assertEquals("Test 0 for 0 tracks for cycle sort",c1, b1);
    
    
    //Train with 0 cars
    int classificationYard2[] = {3,4};
    ArrayList <Integer> b2 = new ArrayList<Integer> (0);
    ArrayList <Integer> c2 = new ArrayList<Integer> (0);    
    Railyard<Integer> r2 = new Railyard<Integer>(classificationYard2);
    r2.cycleSort(b2);
    assertEquals("Test 0 for 0 cars in the train for cycle sort",c2, b2);
    
    /**
     * Test 1
     * Possible cases for Test 1
     * 1 classification Yard
     * 1 track in classification Yards
     * 1 car in the train
     */
    
    //1 classification Yard
    int classificationYard3[] = {2};
    ArrayList <Integer> b3 = new ArrayList<Integer> (5);
    b3.add(20);
    b3.add(11);
    b3.add(16);
    b3.add(3);
    b3.add(20);
    
    ArrayList <Integer> c3 = new ArrayList<Integer> (5);
    c3.add(11);
    c3.add(16);
    c3.add(20);
    c3.add(3);
    c3.add(20);    
  
    Railyard<Integer> r3 = new Railyard<Integer>(classificationYard3);
    r3.cycleSort(b3);
    assertEquals("Test One for 1 classification Yard for cycle sort",c3, b3);
    
    
    //1 track in classification Yards
    int classificationYard4[] = {1,1};
    ArrayList <Integer> b4 = new ArrayList<Integer> (5);
    b4.add(20);
    b4.add(11);
    b4.add(16);
    b4.add(3);
    b4.add(10);
    
    ArrayList <Integer> c4 = new ArrayList<Integer> (5);
    c4.add(20);
    c4.add(11);
    c4.add(16);
    c4.add(3);
    c4.add(10);    
    
    Railyard<Integer> r4 = new Railyard<Integer>(classificationYard4);
    r4.cycleSort(b4);
    assertEquals("Test One for 1 track in classification Yards for cycle sort",c4, b4);
    
    
    //1 car in the train
    int classificationYard5[] = {1,1};
    ArrayList <Integer> b5 = new ArrayList<Integer> (1);
    b5.add(20);
   
    ArrayList <Integer> c5 = new ArrayList<Integer> (1);
    c5.add(20);   
    
    Railyard<Integer> r5 = new Railyard<Integer>(classificationYard5);
    r5.cycleSort(b5);
    assertEquals("Test One for 1 car in the train for cycle sort",c5, b5);
    
    
     /**
     * Test Many
     * Possible cases for Test Many
     * Many classification Yard
     * Many track in classification Yards
     * Many car in the train
     */
    
    //Many Classification Yard with Many yards and Many Cars
    int classificationYard6[] = {2,3};
    ArrayList <Integer> b6 = new ArrayList<Integer> (5);
    b6.add(20);
    b6.add(11);
    b6.add(16);
    b6.add(3);
    b6.add(10);
    
    ArrayList <Integer> c6 = new ArrayList<Integer> (5);
    c6.add(3);
    c6.add(10);
    c6.add(11);
    c6.add(16);
    c6.add(20);    
    
    Railyard<Integer> r6 = new Railyard<Integer>(classificationYard6);
    r6.cycleSort(b6);
    assertEquals("Test One for 1 car in the train for cycle sort",c6, b6);   
    
    /**
     * Test First
     * Train is mostly sorted except with first car
     * Train is sorted from first classification Yard
     */
    
    //Train is mostly sorted except with first car
    LinkedList<Integer> train = new LinkedList<Integer>();
    train.add(54);
    train.add(14);
    train.add(24);
    train.add(34);
    train.add(44);
    train.add(64);
    
    int[] classificationYards = {5,9};    
    LinkedList<Integer> sortedTrain = new LinkedList<Integer>();
    
    sortedTrain.add(14);
    sortedTrain.add(24);
    sortedTrain.add(34);
    sortedTrain.add(44);
    sortedTrain.add(54);
    sortedTrain.add(64);
    
    Railyard<Integer> r10 = new Railyard<Integer>(classificationYards);    
    r10.cycleSort(train);    
    assertEquals("Method is testing sorting a train out of order at the first element", sortedTrain, train);
    
    // Train is sorted from first classification Yard
    LinkedList<Integer> train1 = new LinkedList<Integer>();
    train1.add(32);
    train1.add(72);
    train1.add(12);
    train1.add(92);
    train1.add(22);
    train1.add(42);
    
    int[] classificationYard13 = {3, 0, 0};
    
    LinkedList<Integer> train2 = new LinkedList<Integer>();
    train2.add(12);
    train2.add(22);
    train2.add(32);
    train2.add(42);
    train2.add(72);
    train2.add(92);
    
    Railyard<Integer> r13 = new Railyard<Integer>(classificationYard13);
    
    r13.cycleSort(train1);
    
    assertEquals("Method is testing sorting a train out of order within the first classification yard", train2, train1);
    
    /**
     * Test Last 
     * Train is mostly sorted except with Last car
     * Train is sorted from Last classification Yard
     */
    
    //Train is mostly sorted except with Last car
    LinkedList<Integer> t4 = new LinkedList<Integer>();
    t4.add(27);
    t4.add(37);
    t4.add(47);
    t4.add(57);
    t4.add(67);
    t4.add(17);
    
    int[] classificationYards12 = {5,9};
    
    LinkedList<Integer> t5 = new LinkedList<Integer>();
    t5.add(17);
    t5.add(27);
    t5.add(37);
    t5.add(47);
    t5.add(57);
    t5.add(67);
    
    Railyard<Integer> r20 = new Railyard<Integer>(classificationYards12);    
    r20.cycleSort(t4);    
    assertEquals("Method is testing sorting a train out of order at the end element", t5, t4);
    
    //Train is sorted from Last classification Yard
    LinkedList<Integer> t9 = new LinkedList<Integer>();
    t9.add(13);
    t9.add(8);
    t9.add(17);
    t9.add(10);
    t9.add(15);
    t9.add(2);
    
    int[] classificationYards15 = {1, 2, 3};
    LinkedList<Integer> t10 = new LinkedList<Integer>();
    
    t10.add(2);
    t10.add(8);
    t10.add(10);
    t10.add(13);
    t10.add(15);
    t10.add(17);
    Railyard<Integer> r15 = new Railyard<Integer>(classificationYards15);    
    r15.cycleSort(t9);    
    assertEquals("Method is testing sorting a train out of order within the end classification yard", t10, t9);
    
    /**
     * Test Middle 
     * Train is mostly sorted except with Middle car
     * Train is sorted from Middle classification Yard
     */
    
    //Train is mostly sorted except with Middle car
    LinkedList<Integer> train22 = new LinkedList<Integer>();
    train22.add(15);
    train22.add(25);
    train22.add(45);
    train22.add(35);
    train22.add(55);
    train22.add(65);
    
    int[] classificationYards22 = {5,9};
    
    LinkedList<Integer> sTrain22 = new LinkedList<Integer>();
    sTrain22.add(15);
    sTrain22.add(25);
    sTrain22.add(35);
    sTrain22.add(45);
    sTrain22.add(55);
    sTrain22.add(65);
    
    Railyard<Integer> r22 = new Railyard<Integer>(classificationYards22);    
    r22.cycleSort(train22);    
    assertEquals("Method is testing sorting a train out of order at the middle element", sTrain22, train22);

    //Train is sorted from Middle classification Yard
    LinkedList<Integer> train23 = new LinkedList<Integer>();    
    train23.add(13);
    train23.add(8);
    train23.add(17);
    train23.add(10);
    train23.add(15);
    train23.add(2);
    
    int[] classificationYards23= {2, 3, 0};
    
    LinkedList<Integer> sTrain23 =  new LinkedList<Integer>();
    sTrain23.add(2);
    sTrain23.add(8);
    sTrain23.add(10);
    sTrain23.add(13);
    sTrain23.add(15);
    sTrain23.add(17);
    
    Railyard<Integer> r23  = new Railyard<Integer>(classificationYards23);
    
    r23.cycleSort(train23);    
    assertEquals("Method is testing sorting a train out of order within the middle classification yard", sTrain23, train23);
    
  }
  
  //Tests all the possible conditions with one List for cycle sort
  @Test
  public void testCycleSortListConditions()
  {
    int classificationYard6[] = {2};     
    ArrayList <Integer> b = new ArrayList<Integer> (5);
    b.add(20);
    b.add(11);
    b.add(16);
    b.add(3);
    b.add(10);
    
    ArrayList <Integer> c = new ArrayList<Integer> (5);
    c.add(11);
    c.add(16);
    c.add(20);
    c.add(3);
    c.add(10);
        
    Railyard<Integer> r = new Railyard<Integer>(classificationYard6);
    r.cycleSort(b);
    assertEquals("Test for all the conditions in the algorithm of cycle sort",c, b);
  }
  
  
  
    
  
  //Tests Test Zero, One and Many for Closest Sort method which takes list as parameter
  @Test
  public void testClosestSortListMethod()
  {
     /**
     * Test 0
     * Possible test cases for Test 0 :
     * 0 Classification yard 
     * Classfication yards with 0 tracks
     * Train with 0 cars
     */
    
    //0 Classification yard 
    int classificationYard[] = {};    
    ArrayList <Integer> b = new ArrayList<Integer> (5);
    b.add(20);
    b.add(11);
    b.add(16);
    b.add(3);
    b.add(10);
    
    ArrayList <Integer> c = new ArrayList<Integer> (5);
    c.add(20);
    c.add(11);
    c.add(16);
    c.add(3);
    c.add(10);
        
    Railyard<Integer> r = new Railyard<Integer>(classificationYard);
    r.closestSort(b);
    assertEquals("Test 0 for 0 classification Yards for closest sort",c, b);
    
    //Classification Yards with 0 tracks
    int classificationYard1[] = {0,0,0};
    ArrayList <Integer> b1 = new ArrayList<Integer> (5);
    b1.add(20);
    b1.add(11);
    b1.add(16);
    b1.add(3);
    b1.add(10);
    
    ArrayList <Integer> c1 = new ArrayList<Integer> (5);
    c1.add(20);
    c1.add(11);
    c1.add(16);
    c1.add(3);
    c1.add(10);
        
    Railyard<Integer> r1 = new Railyard<Integer>(classificationYard1);
    r1.closestSort(b1);
    assertEquals("Test 0 for 0 tracks for closest sort",c1, b1);
    
    
    //Train with 0 cars
    int classificationYard2[] = {3,4};
    ArrayList <Integer> b2 = new ArrayList<Integer> (0);
    ArrayList <Integer> c2 = new ArrayList<Integer> (0);    
    Railyard<Integer> r2 = new Railyard<Integer>(classificationYard2);
    r2.closestSort(b2);
    assertEquals("Test 0 for 0 cars in the train for closest sort",c2, b2);
    
    /**
     * Test 1
     * Possible cases for Test 1
     * 1 classification Yard
     * 1 track in classification Yards
     * 1 car in the train
     */
    
    //1 classification Yard
    int classificationYard3[] = {2};
    ArrayList <Integer> b3 = new ArrayList<Integer> (5);
    b3.add(20);
    b3.add(11);
    b3.add(16);
    b3.add(3);
    b3.add(20);
    
    ArrayList <Integer> c3 = new ArrayList<Integer> (5);
    c3.add(11);
    c3.add(16);
    c3.add(3);
    c3.add(20);
    c3.add(20);    
  
    Railyard<Integer> r3 = new Railyard<Integer>(classificationYard3);
    r3.closestSort(b3);
    assertEquals("Test One for 1 classification Yard for closest sort",c3, b3);
    
    
    //1 track in classification Yards
    int classificationYard4[] = {1,1};
    ArrayList <Integer> b4 = new ArrayList<Integer> (5);
    b4.add(20);
    b4.add(11);
    b4.add(16);
    b4.add(3);
    b4.add(10);
    
    ArrayList <Integer> c4 = new ArrayList<Integer> (5);
    c4.add(20);
    c4.add(11);
    c4.add(16);
    c4.add(3);
    c4.add(10);    
    
    Railyard<Integer> r4 = new Railyard<Integer>(classificationYard4);
    r4.closestSort(b4);
    assertEquals("Test One for 1 track in classification Yards for closest sort",c4, b4);
    
    
    //1 car in the train
    int classificationYard5[] = {1,1};
    ArrayList <Integer> b5 = new ArrayList<Integer> (1);
    b5.add(20);
   
    ArrayList <Integer> c5 = new ArrayList<Integer> (1);
    c5.add(20);   
    
    Railyard<Integer> r5 = new Railyard<Integer>(classificationYard5);
    r5.closestSort(b5);
    assertEquals("Test One for 1 car in the train for closest sort",c5, b5);
    
    
     /**
     * Test Many
     * Possible cases for Test Many
     * Many classification Yard
     * Many track in classification Yards
     * Many car in the train
     */
    
    //Many Classification Yard with Many yards and Many Cars
    int classificationYard6[] = {2,3};
    ArrayList <Integer> b6 = new ArrayList<Integer> (5);
    b6.add(20);
    b6.add(11);
    b6.add(16);
    b6.add(3);
    b6.add(10);
    
    ArrayList <Integer> c6 = new ArrayList<Integer> (5);
    c6.add(3);
    c6.add(10);
    c6.add(11);
    c6.add(16);
    c6.add(20);    
    
    Railyard<Integer> r6 = new Railyard<Integer>(classificationYard6);
    r6.closestSort(b6);
    assertEquals("Test One for 1 car in the train for closest sort",c6, b6);  
    
    /**
     * Test First
     * Train is mostly sorted except with first car
     * Train is sorted from first classification Yard
     */
    
    //Train is mostly sorted except with first car
    LinkedList<Integer> train = new LinkedList<Integer>();
    train.add(54);
    train.add(14);
    train.add(24);
    train.add(34);
    train.add(44);
    train.add(64);
    
    int[] classificationYards = {5,9};    
    LinkedList<Integer> sortedTrain = new LinkedList<Integer>();
    
    sortedTrain.add(14);
    sortedTrain.add(24);
    sortedTrain.add(34);
    sortedTrain.add(44);
    sortedTrain.add(54);
    sortedTrain.add(64);
    
    Railyard<Integer> r10 = new Railyard<Integer>(classificationYards);    
    r10.closestSort(train);    
    assertEquals("Method is testing sorting a train out of order at the first element", sortedTrain, train);
    
    // Train is sorted from first classification Yard
    LinkedList<Integer> train1 = new LinkedList<Integer>();
    train1.add(32);
    train1.add(72);
    train1.add(12);
    train1.add(92);
    train1.add(22);
    train1.add(42);
    
    int[] classificationYard13 = {3, 0, 0};
    
    LinkedList<Integer> train2 = new LinkedList<Integer>();
    train2.add(12);
    train2.add(22);
    train2.add(32);
    train2.add(42);
    train2.add(72);
    train2.add(92);
    
    Railyard<Integer> r13 = new Railyard<Integer>(classificationYard13);
    
    r13.closestSort(train1);
    
    assertEquals("Method is testing sorting a train out of order within the first classification yard", train2, train1);
    
    /**
     * Test Last 
     * Train is mostly sorted except with Last car
     * Train is sorted from Last classification Yard
     */
    
    //Train is mostly sorted except with Last car
    LinkedList<Integer> t4 = new LinkedList<Integer>();
    t4.add(27);
    t4.add(37);
    t4.add(47);
    t4.add(57);
    t4.add(67);
    t4.add(17);
    
    int[] classificationYards12 = {5,9};
    
    LinkedList<Integer> t5 = new LinkedList<Integer>();
    t5.add(17);
    t5.add(27);
    t5.add(37);
    t5.add(47);
    t5.add(57);
    t5.add(67);
    
    Railyard<Integer> r20 = new Railyard<Integer>(classificationYards12);    
    r20.closestSort(t4);    
    assertEquals("Method is testing sorting a train out of order at the end element", t5, t4);
    
    //Train is sorted from Last classification Yard
    LinkedList<Integer> t9 = new LinkedList<Integer>();
    t9.add(13);
    t9.add(8);
    t9.add(17);
    t9.add(10);
    t9.add(15);
    t9.add(2);
    
    int[] classificationYards15 = {1, 2, 3};
    LinkedList<Integer> t10 = new LinkedList<Integer>();
    
    t10.add(2);
    t10.add(8);
    t10.add(10);
    t10.add(13);
    t10.add(15);
    t10.add(17);
    Railyard<Integer> r15 = new Railyard<Integer>(classificationYards15);    
    r15.closestSort(t9);    
    assertEquals("Method is testing sorting a train out of order within the end classification yard", t10, t9);
    
    /**
     * Test Middle 
     * Train is mostly sorted except with Middle car
     * Train is sorted from Middle classification Yard
     */
    
    //Train is mostly sorted except with Middle car
    LinkedList<Integer> train22 = new LinkedList<Integer>();
    train22.add(15);
    train22.add(25);
    train22.add(45);
    train22.add(35);
    train22.add(55);
    train22.add(65);
    
    int[] classificationYards22 = {5,9};
    
    LinkedList<Integer> sTrain22 = new LinkedList<Integer>();
    sTrain22.add(15);
    sTrain22.add(25);
    sTrain22.add(35);
    sTrain22.add(45);
    sTrain22.add(55);
    sTrain22.add(65);
    
    Railyard<Integer> r22 = new Railyard<Integer>(classificationYards22);    
    r22.closestSort(train22);    
    assertEquals("Method is testing sorting a train out of order at the middle element", sTrain22, train22);

    //Train is sorted from Middle classification Yard
    LinkedList<Integer> train23 = new LinkedList<Integer>();    
    train23.add(13);
    train23.add(8);
    train23.add(17);
    train23.add(10);
    train23.add(15);
    train23.add(2);
    
    int[] classificationYards23= {2, 3, 0};
    
    LinkedList<Integer> sTrain23 =  new LinkedList<Integer>();
    sTrain23.add(2);
    sTrain23.add(8);
    sTrain23.add(10);
    sTrain23.add(13);
    sTrain23.add(15);
    sTrain23.add(17);
    
    Railyard<Integer> r23  = new Railyard<Integer>(classificationYards23);
    
    r23.closestSort(train23);    
    assertEquals("Method is testing sorting a train out of order within the middle classification yard", sTrain23, train23);


  }
  
  //Tests all the possible conditions with one set of numbers for closest sort method
  @Test
  public void testClosestSortListConditions()
  {
    int classificationYard6[] = {3};
  
    ArrayList <Integer> b6 = new ArrayList<Integer> (6);
    b6.add(20);
    b6.add(11);
    b6.add(16);
    b6.add(3);
    b6.add(10);
    b6.add(7);
    
    ArrayList <Integer> c6 = new ArrayList<Integer> (6);
    c6.add(3);
    c6.add(10);
    c6.add(7);
    c6.add(11);
    c6.add(16);
    c6.add(20);    
    
    Railyard<Integer> r6 = new Railyard<Integer>(classificationYard6);
    r6.closestSort(b6);
    assertEquals("Test One for 1 car in the train for closest sort",c6, b6);       
  }
  
  @Test
  public void testGetHeadsUpMethod()
  {
    //The classification yard is non-empty
    int classificationYard[] = {2,3};
    Railyard<Integer> r = new Railyard<Integer>(classificationYard);  
    ArrayList<ArrayList<LinkedList<Integer>>> a = new ArrayList<ArrayList<LinkedList<Integer>>>(2);
    
    a.add(0,new ArrayList<LinkedList<Integer>>(2));
    a.add(1,new ArrayList<LinkedList<Integer>>(3));
    
    a.get(1).add(0,new LinkedList<Integer>());   
    a.get(1).add(1,new LinkedList<Integer>());
    a.get(1).get(1).add(3);      
    r.setRailyard(a);                
    
    assertEquals("Tests the getHeadsUP method",1,r.getHeadsUp(a.get(1)));
    
    //The classification yard is empty
    int classificationYard1[] = {2,3};
    Railyard<Integer> r1 = new Railyard<Integer>(classificationYard1);  
    ArrayList<ArrayList<LinkedList<Integer>>> a1 = new ArrayList<ArrayList<LinkedList<Integer>>>(2);
    
    a1.add(0,new ArrayList<LinkedList<Integer>>(2));
    a1.add(1,new ArrayList<LinkedList<Integer>>(3));
    
    a1.get(1).add(0,new LinkedList<Integer>());   
    a1.get(1).add(1,new LinkedList<Integer>());
    a1.get(1).get(1).add(3);      
    r1.setRailyard(a1);                
    
    assertEquals("Tests the getHeadsUP method",-1,r1.getHeadsUp(a1.get(0)));
  }
  
  //Tests the merge method which takes Generic Array  
  @Test
  public void testMergeArrayMethod()
  { 
    Integer [] originalTrain = {20,11,16,3,10};
    Integer [] newTrain = {11,16,20,3,10};
    int classificationYard[] = {2};
    Railyard<Integer> r = new Railyard<Integer>(classificationYard);  
    ArrayList<ArrayList<LinkedList<Integer>>> a = new ArrayList<ArrayList<LinkedList<Integer>>>(1);    
    a.add(0,new ArrayList<LinkedList<Integer>>(2));   
    
    a.get(0).add(0,new LinkedList<Integer>());   
    a.get(0).add(1,new LinkedList<Integer>());
    
    //Adding elements already cycle sorted in classification yard
    a.get(0).get(0).add(20);   
    a.get(0).get(1).add(11);
    a.get(0).get(1).add(16);
    a.get(0).get(0).add(3);
    a.get(0).get(0).add(10);
    r.setRailyard(a); //  
    
    assertArrayEquals("Tests merge method which takes an array",newTrain,r.merge(0,originalTrain));
  }
  
  @Test
  public void testMergeListMethod()
  {
    int classificationYard[] = {2};
    Railyard<Integer> r = new Railyard<Integer>(classificationYard);  
    ArrayList<ArrayList<LinkedList<Integer>>> a = new ArrayList<ArrayList<LinkedList<Integer>>>(2);    
    a.add(0,new ArrayList<LinkedList<Integer>>(2));   
    
    a.get(0).add(0,new LinkedList<Integer>());   
    a.get(0).add(1,new LinkedList<Integer>());
    
    ArrayList <Integer> b6 = new ArrayList<Integer>(5);
    b6.add(20);
    b6.add(11);
    b6.add(16);
    b6.add(3);
    b6.add(10);  
    
      
    ArrayList <Integer> c6 = new ArrayList<Integer>(5);
    c6.add(11);
    c6.add(16);
    c6.add(20);
    c6.add(3);
    c6.add(10);
    
    //Adding elements already cycle sorted in classification yard
    a.get(0).get(0).add(20);   
    a.get(0).get(1).add(11);
    a.get(0).get(1).add(16);
    a.get(0).get(0).add(3);
    a.get(0).get(0).add(10);
    r.setRailyard(a); //  
    
    assertEquals("Tests merge method which takes a list",c6,r.mergeList(0,b6));
  }
   
  //Test case which works for closest sort and not for cycle sort
  @Test
  public void AdditionalTestCase1()
  {
    int a [] = {2};
    Integer w [] = {2,1,2,1,2};
    Integer w1 [] = { 1, 1, 2, 2, 2 };
    Railyard<Integer> r = new Railyard<Integer>(a);
    r.closestSort(w);
    
    assertArrayEquals("Test case which sorts in Closest sorting and not in cycle sorting",w1,w);
  }
  
  //Tests the getter-setter method for ArrayList of classification Yard
  @Test
  public void testGetterSetterMethod()
  {
    int classificationYard[] = {5,6};
    Railyard<Integer> r = new Railyard<Integer>(classificationYard);  
    ArrayList<ArrayList<LinkedList<Integer>>> a = new ArrayList<ArrayList<LinkedList<Integer>>>(2);
    
    a.add(0,new ArrayList<LinkedList<Integer>>(2));
    a.add(1,new ArrayList<LinkedList<Integer>>(3));
    
    a.get(1).add(0,new LinkedList<Integer>());   
    a.get(1).add(1,new LinkedList<Integer>());
    a.get(1).get(1).add(3);      
    r.setRailyard(a);  
    assertEquals("Tests the getter-setter method for ArrayList of classification Yard",a,r.getRailyard());
  }
  
  //Tests the constructor of the class
  @Test
  public void testConstructor()
  {
    int classificationYard[] = {5,6};
    Railyard<Integer> r = new Railyard<Integer>(classificationYard); 
    ArrayList<ArrayList<LinkedList<Integer>>> a = new ArrayList<ArrayList<LinkedList<Integer>>>(2);
    r.setRailyard(a); 
    assertEquals("Tests the Constructor for the class",a,r.getRailyard());
  }
  
  
    
  
  
}
