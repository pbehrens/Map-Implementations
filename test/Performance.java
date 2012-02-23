import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import map.ChainedHashMap;
import map.ToInteger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
*
* @author Patrick Behrens
*
* Performance is a set of tests that measures the elapsed time
* of a specified number of insertions and retrievals into Maps.
*
* This Test class test both the variety of hashCode functions, a
* variety of concrete implementations of the Map interface, and
* a variety of insertions and retrievals from those Maps.
*  
*/

public class Performance {
private static LinkedList<Integer> longList;
private static LinkedList<Integer> queries;


/**
* The following test share this methods, so it is run once before any of the other
* test methods in this test class.
*/
	@BeforeClass
	public static void before()
	{
	longList = new LinkedList<Integer>();
	
	Random generator = new Random();
	for(int i = 0; i<1000000; i++)
	{
		longList.add(generator.nextInt(1000000) );
	}
	queries = new LinkedList<Integer>();
	for(int i = 0; i<100000; i++)
	{
		queries.add(generator.nextInt(1000000 ));
	}
}
	
	 /**
	    * An auxiliary method that inserts a specific number, n, of
	    * keys from longList, measures the performance for a given large
	    * number, r, of retrievals from longList, and prints the result
	    * using the given label.
	    *
	    * @param label The text to print before the performance result.
	    * @param map The concrete implementation of the Map interface used
	    *     for insertions and retrievals.
	    * @param n  The number of insertions in longList.
	    * @param r  The number of retrievals from longList.
	    */
	public static void doMeasure(String label, Map<Integer, Integer> map, int n, int r)
	{
		//add values from the long list into the map
		Iterator<Integer> it = longList.iterator();
		long start = System.currentTimeMillis();
		it = queries.iterator();
		for(int i = 0; i<n; i++)
		{
			if(it.hasNext())
			{
			map.put(it.next(), 436278);
			}
			else
			{
				it = longList.iterator();
			}
		}
		//measure performance of retrieving values

		for(int i = 0; i<r; i++)
		{
			if(it.hasNext())
			{
			map.get(it.next());
			}
			else
			{
				it = queries.iterator();
			}
		}	
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println(label + ":" + time + " ms with " + n + " inserts and " + r + " retrievals.");
	}
	
	
	@AfterClass
	public static void after()
	{
		
	}
		
  /**
  * Test that configures a HashMap instance and performs
  * the measurements for the
  * 100 insertions and 100000 retrievals
  * 1000 insertions and 100000 retrievals
  * 10000 insertions and 100000 retrievals
  * 100000 insertions and 100000 retrievals
  * Prints the label description of the test and the Run time of
  * the test in milliseconds.
  */
		@Test
		public void hashMap()
		{
		//hash map test
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		String label = "Performance of HashMap is";
		doMeasure(label, map2, 100, 100000);
		doMeasure(label, map2, 1000, 100000);
		doMeasure(label, map2, 10000, 100000);
		doMeasure(label, map2, 100000, 100000);
		}

      /**
      * Test that configures a TreeMap instance and performs
      * the measurements for the
      * 100 insertions and 100000 retrievals
      * 1000 insertions and 100000 retrievals
      * 10000 insertions and 100000 retrievals
      * 100000 insertions and 100000 retrievals
      * Prints the label description of the test and the Run time of
      * the test in milliseconds.
      */
		@Test
		public void treeMap()
		{
		//Tree Map test
		TreeMap<Integer, Integer> map1 = new TreeMap<Integer, Integer>();
		String label = "Performance of TreeMap is";
		doMeasure(label, map1, 100, 100000);
		doMeasure(label, map1, 1000, 100000);
		doMeasure(label, map1, 10000, 100000);
		doMeasure(label, map1, 100000, 100000);
		}
		
      /**
      * Test that configures a LinkedHashMap instance and performs
      * the measurements for the
      * 100 insertions and 100000 retrievals
      * 1000 insertions and 100000 retrievals
      * 10000 insertions and 100000 retrievals
      * 100000 insertions and 100000 retrievals
      * Prints the label description of the test and the Run time of
      * the test in milliseconds.
      */
		@Test
		public void linkedHashMap()
		{
		//Linked Hash Map test
		LinkedHashMap<Integer, Integer> map3 = new LinkedHashMap<Integer, Integer>();
		String label = "Performance of LinkedHashMap is";
		doMeasure(label, map3, 100, 100000);
		doMeasure(label, map3, 1000, 100000);
		doMeasure(label, map3, 10000, 100000);
		doMeasure(label, map3, 100000, 100000);
		}
		
		/**
	       * Test that configures a ChainedHashMap instance using a LastTwo for
	       * the hashCode type and performs the measurements for the
	       * 100 insertions  and 100000 retrievals
	       * 1000 insertions  and 100000 retrievals
	       * 10000 insertions  and 100000 retrievals
	       * Prints the label description of the test and the
	       * Run time of the test in milliseconds.
	       */
		
		@Test
		public void lastTwo()
		{
		//Chained Hash Map Test
		String label = "Performance of ChainedHashMap with last two digit hash function is";
		LastTwo<Integer> lastTwo = new LastTwo<Integer>();
		ChainedHashMap<Integer, Integer> map4 = new ChainedHashMap<Integer, Integer>((ToInteger) lastTwo, 100);
		doMeasure(label, map4, 100, 1000000);
		doMeasure(label, map4, 1000, 1000000);
		doMeasure(label, map4, 10000, 1000000);
		//doMeasure(label, map4, 100000, 1000000);
		}
		/*
        * Test that configures a ChainedHashMap instance using a LastThree for
        * the hashCode type and performs the measurements for the
        * 100 insertions  and 100000 retrievals
        * 1000 insertions  and 100000 retrievals
        * 10000 insertions  and 100000 retrievals
        * 100000 insertions  and 100000 retrievals
        * Prints the label description of the test and the
        * Run time of the test in milliseconds.
        */
		@Test
		public void lastThree()
		{
		String label = "Performance of ChainedHashMap with last three digit hash function is";
		LastThree<Integer> lastThree = new LastThree<Integer>();
		ChainedHashMap<Integer, Integer> map5 = new ChainedHashMap<Integer, Integer>((ToInteger) lastThree, 1000);
		doMeasure(label, map5, 100, 3000000);
		doMeasure(label, map5, 1000, 3000000);
		doMeasure(label, map5, 10000, 3000000);
		//doMeasure(label, map5, 60000, 3000000);
		}
		/**
	       * Test that configures a ChainedHashMap instance using a DigitSum for
	       * the hashCode type and performs the measurements for the 100 insertions
	       * and 100 retrievals. Prints the label description of the test and the
	       * Run time of the test in milliseconds.
	       */
		@Test
		public void digitSum()
		{
		String label = "Performance of ChainedHashMap with digit sum digit hash function is";
		DigitSum<Integer> digitSum = new DigitSum<Integer>();
		ChainedHashMap<Integer, Integer> map6 = new ChainedHashMap<Integer, Integer>((ToInteger) digitSum, 1000);
		doMeasure(label, map6, 100, 3000000);
		doMeasure(label, map6, 1000, 3000000);
		doMeasure(label, map6, 10000, 3000000);
		//doMeasure(label, map6, 100000, 3000000);
		}
		
		/**
	       * Test that configures a ChainedHashMap instance of size 100 using a
	       * HashcodeModulo for the hashCode type and performs the measurements
	       * for the
	       * 100 insertions and 3000000 retrievals
	       * 1000 insertions and 3000000 retrievals
	       * 10000 insertions and 3000000 retrievals
	       * Prints the label description
	       * of the test and the Run time of the test in milliseconds.
	       */
		@Test
		public void modulo100()
		{
		String label = "Performance of ChainedHashMap with modulo hash function size 100 is";
		Modulo<Integer> modulo100 = new Modulo<Integer>();
		ChainedHashMap<Integer, Integer> map8 = new ChainedHashMap<Integer, Integer>((ToInteger) modulo100, 100);
		doMeasure(label, map8, 100, 3000000);
		doMeasure(label, map8, 1000, 3000000);
		doMeasure(label, map8, 10000, 3000000);
		//doMeasure(label, map8, 100000, 3000000);
		}
		
		/**
	       * Test that configures a ChainedHashMap instance of size 101 using a
	       * HashcodeModulo for the hashCode type and performs the measurements
	       * for the
	       * 100 insertions and 3000000 retrievals
	       * 1000 insertions and 3000000 retrievals
	       * 10000 insertions and 3000000 retrievals
	       * Prints the label description
	       * of the test and the Run time of the test in milliseconds.
	       */
		@Test
		public void modulo101()
		{
		String label = "Performance of ChainedHashMap with modulo hash function size 101 is";
		Modulo<Integer> modulo101 = new Modulo<Integer>();
		ChainedHashMap<Integer, Integer> map9 = new ChainedHashMap<Integer, Integer>((ToInteger) modulo101, 101);
		doMeasure(label, map9, 100, 3000000);
		doMeasure(label, map9, 1000, 3000000);
		doMeasure(label, map9, 10000, 3000000);
		//doMeasure(label, map9, 100000, 3000000);
		}
		
		/**
	       * Test that configures a ChainedHashMap instance of size 1009 using a
	       * HashcodeModulo for the hashCode type and performs the measurements
	       * for the
	       * 100 insertions and 3000000 retrievals
	       * 1000 insertions and 3000000 retrievals
	       * 10000 insertions and 3000000 retrievals
	       * Prints the label description
	       * of the test and the Run time of the test in milliseconds.
	       */
		@Test
		public void modulo1009()
		{
		String label = "Performance of ChainedHashMap with modulo hash function size 1009 is";
		Modulo<Integer> modulo1009 = new Modulo<Integer>();
		ChainedHashMap<Integer, Integer> map10 = new ChainedHashMap<Integer, Integer>((ToInteger) modulo1009, 1009);
		doMeasure(label, map10, 100, 3000000);
		doMeasure(label, map10, 1000, 3000000);
		doMeasure(label, map10, 10000, 3000000);
		//doMeasure(label, map10, 100000, 3000000);
		}
		/**
	       * Test that configures a ChainedHashMap instance of size 10007 using a
	       * HashcodeModulo for the hashCode type and performs the measurements
	       * for the
	       * 100 insertions and 3000000 retrievals
	       * 1000 insertions and 3000000 retrievals
	       * 10000 insertions and 3000000 retrievals
	       * Prints the label description
	       * of the test and the Run time of the test in milliseconds.
	       */
		@Test
		public void modulo10007()
		{
		String label = "Performance of ChainedHashMap with modulo hash function size 10007 is";
		Modulo<Integer> modulo10007 = new Modulo<Integer>();
		ChainedHashMap<Integer, Integer> map11 = new ChainedHashMap<Integer, Integer>((ToInteger) modulo10007, 10007);
		doMeasure(label, map11, 100, 3000000);
		doMeasure(label, map11, 1000, 3000000);
		doMeasure(label, map11, 10000, 3000000);
		//doMeasure(label, map11, 100000, 3000000);
		}
		/**
	       * Test that configures a ChainedHashMap instance of size 10000003 using a
	       * HashcodeModulo for the hashCode type and performs the measurements
	       * for the
	       * 100 insertions and 3000000 retrievals
	       * 1000 insertions and 3000000 retrievals
	       * 10000 insertions and 3000000 retrievals
	       * Prints the label description
	       * of the test and the Run time of the test in milliseconds.
	       */
		@Test
		public void modulo100003()
		{
		String label = "Performance of ChainedHashMap with modulo hash function size 100003 is";
		Modulo<Integer> modulo100003 = new Modulo<Integer>();
		ChainedHashMap<Integer, Integer> map12 = new ChainedHashMap<Integer, Integer>((ToInteger) modulo100003, 100003);
		doMeasure(label, map12, 100, 3000000);
		doMeasure(label, map12, 1000, 3000000);
		doMeasure(label, map12, 10000, 3000000);
		//doMeasure(label, map12, 100000, 3000000);
		}
	}
	
/*These are the hash functions used in the ChainedHashMap. They all implement the ToInteger interface*/	 


class LastTwo<T> implements ToInteger<T>
{

    public int apply(T arg) {
        // TODO Auto-generated method stub
    	int hash;
        String parse = arg.toString();
        if(parse.length() < 2)
        {
        hash = Integer.parseInt(parse);
        }
        else
        {
        hash = Integer.parseInt(parse.substring(parse.length()-2, parse.length()-1)) + Integer.parseInt(parse.substring(parse.length()-1, parse.length()));
        }
        return hash;
    }
     
}

class LastThree<T> implements ToInteger<T>
{

    public int apply(T arg) {
        // TODO Auto-generated method stub
    	int hash;
        String parse = arg.toString();
        if(parse.length() < 3)
        {
        hash = Integer.parseInt(parse);
        }
        else
        {
        hash = Integer.parseInt(parse.substring(parse.length()-3, parse.length()-2)) + Integer.parseInt(parse.substring(parse.length()-2, parse.length()-1)) + Integer.parseInt(parse.substring(parse.length()-1, parse.length()));
        }
        return hash;
    }
     
}

class DigitSum<T> implements ToInteger<T>
{

    public int apply(T arg) {
        // TODO Auto-generated method stub
        int sum = 0;
        String parse = arg.toString();
        char test;
        char[] digits = parse.toCharArray();
        for(int i = 0; i<digits.length; i++)
        {
            sum = sum + Character.digit(digits[i], 10);
            
        }
        return sum;
    }
     
}

class Modulo<T> implements ToInteger<T>
{

    public int apply(T arg) {
        // TODO Auto-generated method stub
        String parse = arg.toString();
        int num = Integer.parseInt(parse);
        int hash = num % 120;
        return hash;
    }
}

