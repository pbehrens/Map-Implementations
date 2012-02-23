import static org.junit.Assert.assertEquals;
import map.MyMap;
import java.util.*;
import org.junit.*;

/*
* @author Patrick Behrens
*
* A set of assertion test methods to test MyMap class methods.
* Only failed assertions are recorded.
*/


   public class MyMapTest {

/**
    * Tests that insertion of key,value of one element.
    */
       @Test
        public void testPutOneElement() {
            MyMap<String, String> mymap = new MyMap<String, String>();
            mymap.put("0", "Hello");
            assertEquals("Hello", mymap.get("0"));
        }

/**
    * Tests that insertion of key,value of two elements.
    */
       @Test
        public void testPutTwoElements() {
            MyMap<String, String> mymap = new MyMap<String, String>();
            mymap.put("0", "Hello");
            mymap.put("1", "Goodbye");
            assertEquals("Goodbye", mymap.get("1"));
        }
       /**
    * Tests that MyMap returns a value when given a key.
    */
       @Test
        public void testGet() {
            MyMap<String, String> mymap = new MyMap<String, String>();
            mymap.put("0", "Hello");
            assertEquals("Hello", mymap.get("0"));
        }

/**
    * Tests that MyMap returns a value is null
    */
       @Test
        public void testGetNull() {
            MyMap<String, String> mymap = new MyMap<String, String>();
            assertEquals(null, mymap.get("1"));
        }
       
       /**
   	 * Tests clearing a MyMap by filling and clearing it to see if it is then returns.
   	 */
        
        @Test //Test Clear
        public void testClear() {
            MyMap<String, String> mymap = new MyMap<String, String>();
            mymap.put("0", "Hello");
            mymap.clear();
            mymap.put("0", "Goodbye");
            assertEquals("Goodbye", mymap.get("0"));
        
            
        }
        
        /**
    	 * Tests clearing a MyMap by inserting, clearing, then inserting a new 
    	 * element with the same key.
    	 */
        
        @Test //Test Clear
        public void testClearEmpty() {
            MyMap<String, String> mymap = new MyMap<String, String>();
            mymap.clear();
            assertEquals(null, mymap.get("0"));
   
        }
        
        /**
         * Tests MyMap size to check if three insertions results in a size of 3.
         */
        
        @Test //test size if map has elements in it
        public void testSizeFull()
        {
            MyMap<String, String> mymap = new MyMap<String, String>();
            mymap.put("0", "Hello");
            mymap.put("1", "Goodbye");
            mymap.put("2", "fdsafdse");
            
            assertEquals(3, mymap.size());
            
        }
        
        /**
         * Tests MyMap's size to check if map has no elements in it.
         */ 
        @Test //test size if map has no elements in it
        public void testSizeEmpty()
        {
            MyMap<String, String> mymap = new MyMap<String, String>();
            assertEquals(0, mymap.size());
            
        }
        
        /**
         * Tests MyMap's size to check if map has no elements in it.
         */ 
        @Test //test size if map has no elements in it
        public void testIsEmptyWhenEmpty()
        {
            MyMap<String, String> mymap = new MyMap<String, String>();
            assertEquals(true, mymap.isEmpty());
            
        }
        
        /**
    	 * Tests if a new MyMap instance is not empty when full.
    	 */
        @Test //test size if map has no elements in it
        public void testIsEmptyWhenFull()
        {
            MyMap<String, String> mymap = new MyMap<String, String>();
            mymap.put("0", "Hello");
            assertEquals(false, mymap.isEmpty());
            
        }
        
        /**
    	 * Tests whether MyMap contains a key after that key,value pair is inserted.
    	 */
        
        @Test //test map to see if it contains a key that is in the map
        public void testContainsKeyTrue()
        {
            
            MyMap<String, String> mymap = new MyMap<String, String>();
            mymap.put("0", "Hello");
            assertEquals(true, mymap.containsKey("0"));
            
        }
        
        /**
    	 * Tests whether MyMap contains a key after a different key,value 
    	 * pair is inserted.
    	 */
        
        @Test //test map to see if it contains a key that isn't in the map
        public void testContainsKeyFalse()
        {
            MyMap<String, String> mymap = new MyMap<String, String>();
            mymap.put("0", "Hello");
            assertEquals(false, mymap.containsKey("3"));
         
        }
        
        /**
    	 * Tests whether MyMap contains a value after that key,value pair is inserted.
    	 */
        
        @Test //Test containsValue if map has an element
        public void testContainsValue()
        {
            MyMap<String, String> mymap = new MyMap<String, String>();
                mymap.put("0", "Hello");
                assertEquals(true, mymap.containsValue("Hello"));

        }
        
        /**
    	 * Tests whether MyMap contains a value after that key,value pair is empty.
    	 */
        @Test //test contains value is the map is empty
        public void testContainsValueEmpty()
        {
            MyMap<String, String> mymap = new MyMap<String, String>();
                mymap.put("0", "Hello");
                mymap.clear();
                assertEquals(false, mymap.containsValue("Hello"));

        }
        
        /**
    	 * Tests MyMap's hashCode to check if hashCode it returns to expected value.  
    	 * HashCode of HashMap, is used, returning the result as the integer hashCode. 
    	 */	
        @Test // hashCode()
         public void testHashCode() {
          MyMap<Integer,String> testMap = new MyMap<Integer,String>();
          for(int i = 0; i <= 3; i++) {
              testMap.put(i, "asdf");
          }
          assertEquals(6, testMap.hashCode());
      }
        
        /**
    	 * Tests MyMap's hashCode to check if hashCode it returns to expected value.  
    	 * HashCode of HashMap, is used, returning the result as the integer hashCode. 
    	 */	
            @Test // hashCode()
             public void testHashCodeTwo() {
              MyMap<Integer,String> testMap = new MyMap<Integer,String>();
              for(int i = 0; i <= 4; i++) {
                  testMap.put(i, "asdadp");
              }
              System.out.println(testMap.hashCode());
              assertEquals(10, testMap.hashCode());
      }
            
            /**
        	 * Tests two MyMaps for equality, by adding elements to both.
        	 */
   
   @Test //test equals if they are equal
             public void testEquals() {
                 MyMap<String, String> mymap = new MyMap<String, String>();
                 mymap.put("0", "Hello");
                 MyMap<String, String> booly = new MyMap<String, String>();
                 booly.put("0", "Hello");
                 
                 assertEquals(true, booly.equals(mymap));
             }
   
   /**
	 * Tests two MyMaps for non-equality, by adding elements to both.
	 */
      
   @Test //test equals if they are not equal
            public void testDoesNotEqual() {
              MyMap<String, String> mymap = new MyMap<String, String>();
              mymap.put("0", "Hello");
              MyMap<String, String> booly = new MyMap<String, String>();
              booly.put("1", "Goodbye");
              booly.put("2", "Hello");
          
          assertEquals(false, booly.equals(mymap));
       }
   
   /**
    * Tests removal of a key,value pair by trying to retrieve it after removal.
    */
             
   @Test //test remove
             public void testRemove() {
                 MyMap<String, String> mymap = new MyMap<String, String>();
                 mymap.put("0", "Hello");
                 mymap.remove("0");
                
                 assertEquals(null, mymap.get("0"));
             
             }
   
   /**
    * Tests removal of two keys,value pair by trying to retrieve it after removal.
    */
             
   @Test
             public void testRemoveTwo() {
                 MyMap<String, String> mymap = new MyMap<String, String>();
                 mymap.put("0", "Hello");
                 mymap.put("1", "Goodbye");
                 mymap.remove("1");
                 assertEquals(null, mymap.get("1"));
             
             }
   
   /**
    * Tests removal of three keys,value pair by trying to retrieve it after removal.
    */
             
   @Test
             public void testRemoveThree() {
                 MyMap<String, String> mymap = new MyMap<String, String>();
                 mymap.put("0", "Hello");
                 mymap.put("1", "Goodbye");
                 mymap.put("2", "Adios");
                 mymap.remove("1");
                 assertEquals(2, mymap.size());
             
             }
   
   /**
    * Tests removal of four keys,value pair by trying to retrieve it after removal.
    */
             
   @Test
             public void testRemoveFour() {
                 MyMap<String, String> mymap = new MyMap<String, String>();
                 mymap.put("0", "Hello");
                 mymap.put("1", "Goodbye");
                 mymap.put("2", "Adios");
                 mymap.remove("1");
                 assertEquals("2", "Adios", mymap.get("2"));
             
             }
   
   /**
	 * Tests that all elements of one MyMaps can be put into a second by 
	 * retrieving values from the second after insertion.
	 */
   @Test // putAll()
              public void testPutAll() {
                  MyMap<Integer, String> mymap = new MyMap<Integer, String>();
                  mymap.put(123, "short");        
                  mymap.put(234, "shorter");
                  mymap.put(345, "shortest");
                  mymap.putAll(mymap);
                  assertEquals("shorter", mymap.get(234));
              }
   
   /**
	 * Tests that all elements of one MyMap are empty.
	 */
   @Test // putAll() when empty
      public void testPutAllEmpty() {
          MyMap<Integer, String> mymap = new MyMap<Integer, String>();

          mymap.putAll(mymap);
          assertEquals(true, mymap.isEmpty());
      }
   
   
       //***********************************
       //Hashmap tests
     //***********************************
   
   /**
	 * Tests insertion of a key, value pairs in HashMap.
	 */

           @Test
            public void testPutOneElementHashMap() {
               HashMap<String, String> mymap = new HashMap<String, String>();
                mymap.put("0", "Hello");
                assertEquals("Hello", mymap.get("0"));
            }
           
           /**
       	 * Tests insertion of multiple key, value pairs in HashMap.
       	 */
           
           @Test
            public void testPutTwoElementsHashMap() {
               HashMap<String, String> mymap = new HashMap<String, String>();
                mymap.put("0", "Hello");
                mymap.put("1", "Goodbye");
                assertEquals("Goodbye", mymap.get("1"));
            }
           
           /**
       	 * Tests that HashMap returns a value when given a key.
       	 */
           
           @Test
            public void testGetHashMap() {
               HashMap<String, String> mymap = new HashMap<String, String>();
                mymap.put("0", "Hello");
                assertEquals("Hello", mymap.get("0"));
            }
           
           /**
       	 * Tests that HashMap returns the null when HashMap is not filled.
       	 */
           @Test
            public void testGetNullHashMap() {
               HashMap<String, String> mymap = new HashMap<String, String>();
                assertEquals(null, mymap.get("1"));
            }
           
           /**
       	 * Tests clearing a HashMap by filling and clearing it to see if it is then null.
       	 */
            
            @Test //Test Clear
            public void testClearHashMap() {
                HashMap<String, String> mymap = new HashMap<String, String>();
                mymap.put("0", "Hello");
                mymap.clear();
                mymap.put("0", "Goodbye");
                assertEquals("Goodbye", mymap.get("0"));
            
                
            }
            
            /**
        	 * Tests clearing a HashMap by seeing if it returns null when nothing is filled.
        	 */
            @Test //Test Clear
            public void testClearEmptyHashMap() {
                HashMap<String, String> mymap = new HashMap<String, String>();
                mymap.clear();
                assertEquals(null, mymap.get("0"));
            
                
            }
            
            /**
        	 * Tests HashMap's size to see if it equals the amount put in.
        	 */
            @Test //test size if map has elements in it
            public void testSizeFullHashMap()
            {
                HashMap<String, String> mymap = new HashMap<String, String>();
                mymap.put("0", "Hello");
                mymap.put("1", "Goodbye");
                mymap.put("2", "fdsafdse");
                
                assertEquals(3, mymap.size());
                
            }
            
            /**
        	 * Tests HashMap's size to see if its empty.
        	 */
            @Test //test size if map has no elements in it
            public void testSizeEmptyHashMap()
            {
                HashMap<String, String> mymap = new HashMap<String, String>();
                assertEquals(0, mymap.size());
                
            }
            
            /**
        	 * Tests HashMap's size to see if its has no elements.
        	 */
            
            @Test //test size if map has no elements in it
            public void testIsEmptyWhenEmptyHashMap()
            {
                HashMap<String, String> mymap = new HashMap<String, String>();
                assertEquals(true, mymap.isEmpty());
                
            }
            
            /**
        	 * Tests HashMap's size to see if its empty when full.
        	 */
            
            @Test //test size if map has no elements in it
            public void testIsEmptyWhenFullHashMap()
            {
                HashMap<String, String> mymap = new HashMap<String, String>();
                mymap.put("0", "Hello");
                assertEquals(false, mymap.isEmpty());
                
            }
            
            /**
        	 * Tests whether HashMap contains a key after that key,value pair is inserted.
        	 */
            
            @Test //test map to see if it contains a key that is in the map
            public void testContainsKeyTrueHashMap()
            {
                
                HashMap<String, String> mymap = new HashMap<String, String>();
                mymap.put("0", "Hello");
                assertEquals(true, mymap.containsKey("0"));
                
            }
            
            /**
        	 * Tests whether HashMap contains a key after that key,value does not match.
        	 */
            
            @Test //test map to see if it contains a key that isn't in the map
            public void testContainsKeyFalseHashMap()
            {
                HashMap<String, String> mymap = new HashMap<String, String>();
                mymap.put("0", "Hello");
                assertEquals(false, mymap.containsKey("3"));
                

            }
            
            /**
        	 * Tests whether HashMap contains a value after that key,value pair is inserted.
        	 */
            
            @Test //Test containsValue
            public void testContainsValueHashMap()
            {
                HashMap<String, String> mymap = new HashMap<String, String>();
                    mymap.put("0", "Hello");
                    assertEquals(true, mymap.containsValue("Hello"));

            }
            
            /**
        	 * Tests whether HashMap contains a value after that key,value pair is empty.
        	 */
            @Test
            public void testContainsValueEmptyHashMap()
            {
                HashMap<String, String> mymap = new HashMap<String, String>();
                    mymap.put("0", "Hello");
                    mymap.clear();
                    assertEquals(false, mymap.containsValue("Hello"));

            }
            
            /**
        	 * Tests HashMap's hashCode to check if hashCode it returns to expected value.  
        	 * HashCode of HashMap, is used, returning the result as the integer hashCode. 
        	 */	
            
            @Test // hashCode()
            public void testHashCode1HashMap() {
                HashMap<Integer,String> testMap = new HashMap<Integer,String>();
                for(int i = 0; i <= 3; i++) {
                    testMap.put(i, "asdf");
                }
                assertEquals(12013782, testMap.hashCode());
            }
         
            /**
        	 * Tests HashMap's hashCode to check if hashCode it returns to expected value.  
        	 * HashCode of HashMap, is used, returning the result as the integer hashCode. 
        	 */
            
            @Test // hashCode()
            public void testHashCode2HashMap() {
                HashMap<Integer,String> testMap = new HashMap<Integer,String>();
                for(int i = 0; i <= 100; i++) {
                    testMap.put(i, "asdf");
                }
                assertEquals(303348598, testMap.hashCode());
            }
            
            /**
        	 * Tests HashMap's hashCode to check if hashCode it returns true.  
        	 * HashCode of HashMap, is used, returning the result as the integer hashCode. 
        	 */	
       
       @Test
                 public void testEqualsHashMap() {
           HashMap<String, String> mymap = new HashMap<String, String>();
                     mymap.put("0", "Hello");
                     HashMap<String, String> booly = new HashMap<String, String>();
                     booly.put("0", "Hello");
                     
                     assertEquals(true, booly.equals(mymap));
                 }
       
       /**
   	 * Tests HashMap's hashCode to check if hashCode it returns false.  
   	 * HashCode of HashMap, is used, returning the result as the integer hashCode. 
   	 */	
          
       @Test
                public void testDoesNotEqualHashMap() {
           HashMap<String, String> mymap = new HashMap<String, String>();
                  mymap.put("0", "Hello");
                  HashMap<String, String> booly = new HashMap<String, String>();
                  booly.put("1", "Goodbye");
                  booly.put("2", "Hello");
              
              assertEquals(false, booly.equals(mymap));
           }
       
       /**
        * Tests removal of a key,value pair by trying to retrieve it after removal.
        */
                 
       @Test
                 public void testRemoveHashMap() {
           HashMap<String, String> mymap = new HashMap<String, String>();
                     mymap.put("0", "Hello");
                     mymap.remove("0");
                    
                     assertEquals(null, mymap.get("0"));
                 
                 }
       
       /**
        * Tests removal of multiple keys,values pair by trying to retrieve it after removal.
        */
                 
       @Test
                 public void testRemoveTwoHashMap() {
           HashMap<String, String> mymap = new HashMap<String, String>();
                     mymap.put("0", "Hello");
                     mymap.put("1", "Goodbye");
                     mymap.remove("1");
                     assertEquals(null, mymap.get("1"));
                 
                 }
                 
       @Test
                 public void testRemoveThreeHashMap() {
           HashMap<String, String> mymap = new HashMap<String, String>();
                     mymap.put("0", "Hello");
                     mymap.put("1", "Goodbye");
                     mymap.put("2", "Adios");
                     mymap.remove("1");
                     assertEquals(2, mymap.size());
                 
                 }
       
       /**
        * Tests removal of multiple keys,values pair by trying to retrieve it after removal.
        */
                 
       @Test
                 public void testRemoveFourHashMap() {
           HashMap<String, String> mymap = new HashMap<String, String>();
                     mymap.put("0", "Hello");
                     mymap.put("1", "Goodbye");
                     mymap.put("2", "Adios");
                     mymap.remove("1");
                     assertEquals("2", "Adios", mymap.get("2"));
                 
                 }
       
       /**
   	 * Tests that all elements of one HashMap can be put into a second by 
   	 * retrieving values from the second after insertion.
   	 */

       @Test // putAll()
          public void testPutAllHashMap() {
              HashMap<Integer, String> mymap = new HashMap<Integer, String>();
              mymap.put(123, "short");        
              mymap.put(234, "shorter");
              mymap.put(345, "shortest");
              mymap.putAll(mymap);
              assertEquals("shorter", mymap.get(234));
          }
       
       /**
   	 * Tests that all elements of one HashMap which will be empty.
   	 */
       @Test // putAll() when empty
          public void testPutAllEmptyHashMap() {
              HashMap<Integer, String> mymap = new HashMap<Integer, String>();

              mymap.putAll(mymap);
              assertEquals(true, mymap.isEmpty());
          }
       
       //***********************************
       //TreeMap tests
       //***********************************
       
       /**
   	 * Tests insertion of one key, value pairs in TreeMap.
   	 */
       
       @Test
        public void testPutOneElementTreeMap() {
           TreeMap<String, String> mymap = new TreeMap<String, String>();
            mymap.put("0", "Hello");
            assertEquals("Hello", mymap.get("0"));
        }
       
       /**
   	 * Tests insertion of multiple key, value pairs in TreeMap.
   	 */
       
       @Test
        public void testPutTwoElementsTreeMap() {
           TreeMap<String, String> mymap = new TreeMap<String, String>();
            mymap.put("0", "Hello");
            mymap.put("1", "Goodbye");
            assertEquals("Goodbye", mymap.get("1"));
        }
       
       /**
   	 * Tests that TreeMap returns a value when given a key.
   	 */
       
       @Test
        public void testGetTreeMap() {
           TreeMap<String, String> mymap = new TreeMap<String, String>();
            mymap.put("0", "Hello");
            assertEquals("Hello", mymap.get("0"));
        }
       
       /**
   	 * Tests that TreeMap returns null when given a key.
   	 */
       @Test
        public void testGetNullTreeMap() {
           TreeMap<String, String> mymap = new TreeMap<String, String>();
            assertEquals(null, mymap.get("1"));
        }
       
       /**
   	 * Tests clearing a TreeMap by filling and clearing it to see if it is the new element.
   	 */
        
        @Test //Test Clear
        public void testClearTreeMap() {
            TreeMap<String, String> mymap = new TreeMap<String, String>();
            mymap.put("0", "Hello");
            mymap.clear();
            mymap.put("0", "Goodbye");
            assertEquals("Goodbye", mymap.get("0"));
        
            
        }
        
        /**
    	 * Tests clearing a TreeMap by filling and clearing it to see if it is then null.
    	 */
        @Test //Test Clear
        public void testClearEmptyTreeMap() {
            TreeMap<String, String> mymap = new TreeMap<String, String>();
            mymap.clear();
            assertEquals(null, mymap.get("0"));
        
            
        }
        
        /**
    	 * Tests TreeMap's size to see if a new instance is full.
    	 */
        
        @Test //test size if map has elements in it
        public void testSizeFullTreeMap()
        {
            TreeMap<String, String> mymap = new TreeMap<String, String>();
            mymap.put("0", "Hello");
            mymap.put("1", "Goodbye");
            mymap.put("2", "fdsafdse");
            
            assertEquals(3, mymap.size());
            
        }
        
        /**
    	 * Tests TreeMap's size to see if a new instance is empty.
    	 */
        @Test //test size if map has no elements in it
        public void testSizeEmptyTreeMap()
        {
            TreeMap<String, String> mymap = new TreeMap<String, String>();
            assertEquals(0, mymap.size());
            
        }
        
        /**
    	 * Tests TreeMap's size to see if a new instance is empty when tree is empty.
    	 */
        
        @Test //test size if map has no elements in it
        public void testIsEmptyWhenEmptyTreeMap()
        {
            TreeMap<String, String> mymap = new TreeMap<String, String>();
            assertEquals(true, mymap.isEmpty());
            
        }
        
        /**
    	 * Tests TreeMap's size to see if a new instance is empty when tree is full.
    	 */
        
        @Test //test size if map has no elements in it
        public void testIsEmptyWhenFullTreeMap()
        {
            TreeMap<String, String> mymap = new TreeMap<String, String>();
            mymap.put("0", "Hello");
            assertEquals(false, mymap.isEmpty());
            
        }
        
        /**
    	 * Tests whether TreeMap contains a key after that key,value pair is inserted.
    	 */
        
        @Test //test map to see if it contains a key that is in the map
        public void testContainsKeyTrueTreeMap()
        {
            
            TreeMap<String, String> mymap = new TreeMap<String, String>();
            mymap.put("0", "Hello");
            assertEquals(true, mymap.containsKey("0"));
            
        }
        
        /**
    	 * Tests whether TreeMap does not contain a key after that key,value pair is inserted.
    	 */
        
        @Test //test map to see if it contains a key that isn't in the map
        public void testContainsKeyFalseTreeMap()
        {
            TreeMap<String, String> mymap = new TreeMap<String, String>();
            mymap.put("0", "Hello");
            assertEquals(false, mymap.containsKey("3"));
            

        }
        
        /**
    	 * Tests whether TreeMap contains a value after that key,value pair is inserted.
    	 */
        
        @Test //Test containsValue
        public void testContainsValueTreeMap()
        {
            TreeMap<String, String> mymap = new TreeMap<String, String>();
                mymap.put("0", "Hello");
                assertEquals(true, mymap.containsValue("Hello"));

        }
        
        /**
    	 * Tests whether TreeMap is empty after that key,value pair is inserted.
    	 */
        
        @Test
        public void testContainsValueEmptyTreeMap()
        {
            TreeMap<String, String> mymap = new TreeMap<String, String>();
                mymap.put("0", "Hello");
                mymap.clear();
                assertEquals(false, mymap.containsValue("Hello"));

        }
        
        /**
    	 * Tests TreeMap's hashCode to check if hashCode it returns to expected value.  
    	 * HashCode of TreeMap, is used, returning the result as the integer hashCode. 
    	 */	
        
        @Test // hashCode()
        public void testHashCode1TreeMap() {
            TreeMap<Integer,String> testMap = new TreeMap<Integer,String>();
            for(int i = 0; i <= 3; i++) {
                testMap.put(i, "asdf");
            }
            assertEquals(12013782, testMap.hashCode());
        }
        
        /**
    	 * Tests TreeMap's hashCode to check if hashCode it returns to expected value.  
    	 * HashCode of TreeMap, is used, returning the result as the integer hashCode. 
    	 */	
     
        @Test // hashCode()
        public void testHashCode2TreeMap() {
            TreeMap<Integer,String> testMap = new TreeMap<Integer,String>();
            for(int i = 0; i <= 100; i++) {
                testMap.put(i, "asdf");
            }
            assertEquals(303348598, testMap.hashCode());
        }
        
        /**
    	 * Tests two TreeMaps for equality, by adding elements to both.
    	 */
   
   @Test
             public void testEqualsTreeMap() {
               TreeMap<String, String> mymap = new TreeMap<String, String>();
                 mymap.put("0", "Hello");
                 TreeMap<String, String> booly = new TreeMap<String, String>();
                 booly.put("0", "Hello");
                 
                 assertEquals(true, booly.equals(mymap));
             }
   
   /**
	 * Tests two TreeMaps for non-equality, by adding three elements to both.
	 */
      
   @Test
            public void testDoesNotEqualTreeMap() {
               TreeMap<String, String> mymap = new TreeMap<String, String>();
              mymap.put("0", "Hello");
              TreeMap<String, String> booly = new TreeMap<String, String>();
              booly.put("1", "Goodbye");
              booly.put("2", "Hello");
          
          assertEquals(false, booly.equals(mymap));
       }
   
   /**
    * Tests removal of a key,value pair by trying to retrieve it after removal.
    */
             
   @Test
             public void testRemoveTreeMap() {
               TreeMap<String, String> mymap = new TreeMap<String, String>();
                 mymap.put("0", "Hello");
                 mymap.remove("0");
                
                 assertEquals(null, mymap.get("0"));
             
             }
   
   /**
    * Tests removal of multiple keys,values by trying to retrieve it after removal.
    */
             
   @Test
             public void testRemoveTwoTreeMap() {
               TreeMap<String, String> mymap = new TreeMap<String, String>();
                 mymap.put("0", "Hello");
                 mymap.put("1", "Goodbye");
                 mymap.remove("1");
                 assertEquals(null, mymap.get("1"));
             
             }
   
   /**
    * Tests removal of multiple keys,values by trying to retrieve it after removal.
    */
             
   @Test
             public void testRemoveThreeTreeMap() {
                   TreeMap<String, String> mymap = new TreeMap<String, String>();
                 mymap.put("0", "Hello");
                 mymap.put("1", "Goodbye");
                 mymap.put("2", "Adios");
                 mymap.remove("1");
                 assertEquals(2, mymap.size());
             
             }
   
   /**
    * Tests removal of multiple keys,values by trying to retrieve it after removal.
    */
             
   @Test
             public void testRemoveFourTreeMap() {
                   TreeMap<String, String> mymap = new TreeMap<String, String>();
                 mymap.put("0", "Hello");
                 mymap.put("1", "Goodbye");
                 mymap.put("2", "Adios");
                 mymap.remove("1");
                 assertEquals("2", "Adios", mymap.get("2"));
             
             }
   
   /**
	 * Tests that all elements of one TreeMap can be put into a second by 
	 * retrieving values from the second after insertion.
	 */
   
   @Test // putAll()
      public void testPutAllTreeMap() {
          TreeMap<Integer, String> mymap = new TreeMap<Integer, String>();
          mymap.put(123, "short");        
          mymap.put(234, "shorter");
          mymap.put(345, "shortest");
          mymap.putAll(mymap);
          assertEquals("shorter", mymap.get(234));
      }
   
   /**
	 * Tests that all elements of one TreeMap can be empty when 
	 * retrieving values from the second after insertion.
	 */
   
   @Test // putAll() when empty
      public void testPutAllEmptyTreeMap() {
          TreeMap<Integer, String> mymap = new TreeMap<Integer, String>();

          mymap.putAll(mymap);
          assertEquals(true, mymap.isEmpty());
      }
       //***********************************
       //Linked Hashmap tests
       //***********************************
   
   /**
	 * Tests insertion of one key, value in LinkedHashMap.
	 */
   
    @Test
    public void testPutOneElementLinkedHashMap() {
       LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       mymap.put("0", "Hello");
       assertEquals("Hello", mymap.get("0"));
    }
    
    /**
	 * Tests insertion of multiple key, value pairs in LinkedHashMap.
	 */
    
  @Test
    public void testPutTwoElementsLinkedHashMap() {
      LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       mymap.put("0", "Hello");
       mymap.put("1", "Goodbye");
       assertEquals("Goodbye", mymap.get("1"));
    }
  
  /**
	 * Tests that LinkedHashMap returns a value when given a key.
	 */
  
  @Test
    public void testGetLinkedHashMap() {
      LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       mymap.put("0", "Hello");
       assertEquals("Hello", mymap.get("0"));
    }
  
  /**
	 * Tests that LinkedHashMap returns null when given a key.
	 */
  
  @Test
    public void testGetNullLinkedHashMap() {
      LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       assertEquals(null, mymap.get("1"));
    }
  
  /**
	 * Tests clearing a LinkedHashMap by filling and clearing it to see if it returns new element.
	 */
   
    @Test //Test Clear
    public void testClearLinkedHashMap() {
       LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       mymap.put("0", "Hello");
       mymap.clear();
       mymap.put("0", "Goodbye");
       assertEquals("Goodbye", mymap.get("0"));
   
       
    }
    
    /**
	 * Tests clearing a LinkedHashMap by filling and clearing it to see if it is then null.
	 */
    
    @Test //Test Clear
    public void testClearEmptyLinkedHashMap() {
       LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       mymap.clear();
       assertEquals(null, mymap.get("0"));
   
       
    }
    
    /**
	 * Tests LinkedHashMap's size to see if a new instance has a size of 3.
	 */
    
    @Test //test size if map has elements in it
    public void testSizeFullLinkedHashMap()
    {
       LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       mymap.put("0", "Hello");
       mymap.put("1", "Goodbye");
       mymap.put("2", "fdsafdse");
       
       assertEquals(3, mymap.size());
       
    }
    
    /**
	 * Tests LinkedHashMap's size to see if a new instance has a size of zero.
	 */
    
    @Test //test size if map has no elements in it
    public void testSizeEmptyLinkedHashMap()
    {
       LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       assertEquals(0, mymap.size());
       
    }
    
    /**
	 * Tests LinkedHashMap's size to see if a new instance has a size is empty.
	 */
   
    @Test //test size if map has no elements in it
    public void testIsEmptyWhenEmptyLinkedHashMap()
    {
       LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       assertEquals(true, mymap.isEmpty());
       
    }
    
    /**
	 * Tests LinkedHashMap's size to see if empty when full.
	 */
   
    @Test //test size if map has no elements in it
    public void testIsEmptyWhenFullLinkedHashMap()
    {
       LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       mymap.put("0", "Hello");
       assertEquals(false, mymap.isEmpty());
       
    }
    
    /**
	 * Tests whether LinkedHashMap contains a key after that key,value pair is inserted.
	 */
   
    @Test //test map to see if it contains a key that is in the map
    public void testContainsKeyTrueLinkedHashMap()
    {
       
       LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       mymap.put("0", "Hello");
       assertEquals(true, mymap.containsKey("0"));
       
    }
    
    /**
	 * Tests whether LinkedHashMap contains a key after that key,value pair is false
	 */
   
    @Test //test map to see if it contains a key that isn't in the map
    public void testContainsKeyFalseLinkedHashMap()
    {
       LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
       mymap.put("0", "Hello");
       assertEquals(false, mymap.containsKey("3"));
       

    }
    
    /**
	 * Tests whether LinkedHashMap contains a value after that key,value pair is inserted.
	 */
   
    @Test //Test containsValue
    public void testContainsValueLinkedHashMap()
    {
       LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
           mymap.put("0", "Hello");
           assertEquals(true, mymap.containsValue("Hello"));

    }
    
    /**
	 * Tests whether LinkedHashMap contains a value after that key,value pair is empty.
	 */
    
    @Test
    public void testContainsValueEmptyLinkedHashMap()
    {
       LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
           mymap.put("0", "Hello");
           mymap.clear();
           assertEquals(false, mymap.containsValue("Hello"));

    }
    
    /**
	 * Tests TreeMap's hashCode to check if hashCode it returns to expected value.  
	 * HashCode of LinkedHashMap, is used, returning the result as the integer hashCode. 
	 */	
    
    @Test // hashCode()
    public void testHashCode1() {
       LinkedHashMap<Integer,String> testMap = new LinkedHashMap<Integer,String>();
       for(int i = 0; i <= 3; i++) {
           testMap.put(i, "asdf");
       }
       assertEquals(12013782, testMap.hashCode());
    }
    
    /**
	 * Tests TreeMap's hashCode to check if hashCode it returns to expected value.  
	 * HashCode of LinkedHashMap, is used, returning the result as the integer hashCode. 
	 */	

    @Test // hashCode()
    public void testHashCode2() {
       LinkedHashMap<Integer,String> testMap = new LinkedHashMap<Integer,String>();
       for(int i = 0; i <= 100; i++) {
           testMap.put(i, "asdf");
       }
       assertEquals(303348598, testMap.hashCode());
    }
    
    /**
	 * Tests two LinkedHashMaps for equality, by adding three elements to both.
	 */

@Test
        public void testEqualsLinkedHashMap() {
   LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
            mymap.put("0", "Hello");
            LinkedHashMap<String, String> booly = new LinkedHashMap<String, String>();
            booly.put("0", "Hello");
            
            assertEquals(true, booly.equals(mymap));
        }

/**
 * Tests two LinkedHashMaps for non-equality, by adding three elements to both.
 */

@Test
       public void testDoesNotEqualLinkedHashMap() {
   LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
         mymap.put("0", "Hello");
         LinkedHashMap<String, String> booly = new LinkedHashMap<String, String>();
         booly.put("1", "Goodbye");
         booly.put("2", "Hello");
     
     assertEquals(false, booly.equals(mymap));
  }

/**
 * Tests removal of a key,value pair by trying to retrieve it after removal.
 */
        
@Test
        public void testRemoveLinkedHashMap() {
   LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
            mymap.put("0", "Hello");
            mymap.remove("0");
           
            assertEquals(null, mymap.get("0"));
        
        }

/**
 * Tests removal of multiple key,value pair by trying to retrieve it after removal.
 */
        
@Test
        public void testRemoveTwoLinkedHashMap() {
   LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
            mymap.put("0", "Hello");
            mymap.put("1", "Goodbye");
            mymap.remove("1");
            assertEquals(null, mymap.get("1"));
        
        }

/**
 * Tests removal of multiple key,value pair by trying to retrieve it after removal.
 */
        
@Test
        public void testRemoveThreeLinkedHashMap() {
   LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
            mymap.put("0", "Hello");
            mymap.put("1", "Goodbye");
            mymap.put("2", "Adios");
            mymap.remove("1");
            assertEquals(2, mymap.size());
        
        }

/**
 * Tests removal of multiple key,value pair by trying to retrieve it after removal.
 */
        
@Test
        public void testRemoveFourLinkedHashMap() {
   LinkedHashMap<String, String> mymap = new LinkedHashMap<String, String>();
            mymap.put("0", "Hello");
            mymap.put("1", "Goodbye");
            mymap.put("2", "Adios");
            mymap.remove("1");
            assertEquals("2", "Adios", mymap.get("2"));
        
        }

/**
 * Tests that all elements of one LinkedHashMap can be put into a second by 
 * retrieving values from the second after insertion.
 */

@Test // putAll()
       public void testPutAllLinkedHashMap() {
           LinkedHashMap<Integer, String> mymap = new LinkedHashMap<Integer, String>();
           mymap.put(123, "short");        
           mymap.put(234, "shorter");
           mymap.put(345, "shortest");
           mymap.putAll(mymap);
           assertEquals("shorter", mymap.get(234));
       }

/**
 * Tests that all elements of one LinkedHashMap can be empty
 *  after put into a second by retrieving values from the second 
 *  after insertion.
 */

       @Test // putAll() when empty
       public void testPutAllEmptyLinkedHashMap() {
           LinkedHashMap<Integer, String> mymap = new LinkedHashMap<Integer, String>();
       
           mymap.putAll(mymap);
           assertEquals(true, mymap.isEmpty());
       }
}