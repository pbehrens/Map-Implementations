package map;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import map.ToInteger;

/**
* Project 1 - COMP 313-488 <br>
*
* The ChainedHashMap  class that implements Map interface is a
* collection that maps keys to values. ChainedHashMap contains concrete methods
* for our Map interface which has associated numerous JUnit 4 tests for
* each method.
*
* @author Patrick Behrens
*
* @param  <K>      the key of a element
* @param  <V>      the value of a element
*
* @version 1.0
*/

public class ChainedHashMap<K, V> implements Map<K, V>
{
private int size;
//private LinkedList[] table;
private LinkedList<Cell>[] table;
private ToInteger hashFunction;

class Cell<K, V> {
     private K key;
     private V value;

     Cell(K key, V value) {
         this.key = key;
         this.value = value;

         }
     
     public boolean equals(Cell<K,V> other) {
         if (this == other){return true;}
           if(this.key.equals(other.key) && this.value.equals(other.value)) {
             return true;
         }
         return false;
     }
}




public <T> ChainedHashMap(ToInteger<T> function, int tableSize)
{
    size = tableSize;
    table = new LinkedList[tableSize];
    for(int i = 0; i < size; i++) {
         table[i] = new LinkedList<Cell>();
     }
    hashFunction = function;
     
}


/**
  * hashCode()<br>
  * Returns the hash code value for this map. The hash code of a map is defined to be
  * the sum of the hash codes of each entry in the map's entrySet() view.
  *
  * @return    the hash code value for this map
  */
public int hashCode() {
     int counter = 0;
     for(int i = 0; i < size; i++) {
         if (table[i] != null)
         for(Cell cell : table[i]) {
               counter += (Integer) cell.key;
         }
     }
     return hashFunction.apply(counter);
 }

/**
  * hashCode2() is the method that checks the object's hashcode and places
  * object into the proper bucket.
  *
  * @param     obj
  * @return    the hash code value for this object
  */

 public int hashCode2(Object obj) {
     
     return hashFunction.apply(obj) % size;
 }

public void clear() {
      for(int i = 0; i<table.length-1; i++)
      {
          table[i].clear();
      }
  }

public boolean containsKey(Object key) {
    for(int i = 0; i < size; i++) {
         for(Cell<K,V> cell : table[i]) {
           if(cell.key.equals(key))
           return true;}
         }
    return false;
}

public boolean containsValue(Object value) {
    for(int i = 0; i < size; i++) {
       for(Cell<K,V> cell : table[i]) {
         if(cell.value.equals(value))
         return true;}
       }
    return false;
}
public Set<java.util.Map.Entry<K, V>> entrySet() {
    // TODO Auto-generated method stub
    return null;
}
/**
      * get()<br>
      * Returns the value to which the specified key is mapped,
    * or if this map contains no mapping for the key.
      *
      * @param     key        key whose associated value is to be returned
      *
      * @return     the value to which this map maps the specified key,
      *                      or null if the map contains no mapping for this key.
      */

 
 public V get(Object key) {

     int bucket = hashCode2(key);
     for(Cell<K,V> cell : table[bucket]) {
              if(cell.key.equals(key)) return cell.value;        
     }
     return null;
 }
 
public boolean isEmpty() {
      
      for(int i = 0; i<table.length-1;i++)
      {
           if(table[i].isEmpty())
          {
              return false;
          }
      }
      return true;
  }
public Set<K> keySet() {
    // TODO Auto-generated method stub
    return null;
}
/**
      * put()<br>
      * Associates the specified value with the specified key in this map
      * If the map previously contained a mapping for
      * the key, the old value is replaced by the specified value.
      *
      * @param     K         key with which the specified value is to be associated
      * @param     V         value to be associated with the specified key
      *
      * @return value    previous value associated with specified key, or
      *                      null if there was no mapping for key. A null return
      *                      can also indicate that the map previously associated
      *                      null with the specified key, if the implementation
      *                      supports null values.
      */

 public V put(K key, V value) {
     int bucket = hashCode2(key);
     table[bucket].add(new Cell(key, value));
     return value;
 }
 
 /**
  * putAll()<br>
  * Copies all of the mappings from the specified map to this map.
  *
  * @param themap mappings to be stored in this map
  */

 public void putAll(Map<? extends K, ? extends V> m) {
       ChainedHashMap<K,V> newmap = (ChainedHashMap) m;
     for(int i = 0; i < newmap.size; i++) {
         if (newmap.table[i] != null)
               for(Cell<K,V> cell : newmap.table[i]) {
                   this.put(cell.key, cell.value);
             }
     }    
 }

/**
    * remove()<br>
    * Removes the value associated with the specified key.
    *
    * @param key            key associated with value to be removed
    *
    * @return value            value associated with key, or null if there was no mapping               * for the key
    *
    */
public V remove(Object key) {
         

   int bucket = hashCode2(key);
         
        
       LinkedList<Cell> temp = table[bucket];
         
       if(temp == null)
             return null;
         
       for(Cell<K,V> cell : table[bucket]) {
       if(cell.key.equals(key)) {
                     
           table[bucket].remove(cell);  
                     
       return cell.value;            
       }
   }
         
   return null;

}

/**
    * equals()<br>
    * Compares this object with a specified object to determine if the objects are the same.
    *
    * @param obj            the object to be compared with the calling object.
    *
    * @return boolean            returns true if the objects are equal and false if the objects            * are not equal
    *
    */
public boolean equals(Object o) {
    if(!(o instanceof ChainedHashMap))
           return false;

    if(this == null || o == null)
           return false;
         
    int thisInt = this.size();
    @SuppressWarnings("unchecked")
    int objInt = ((ChainedHashMap<K, V>) o).size();
       
    if(thisInt != objInt)
           return false;
          

    ChainedHashMap<K,V> testMap = (ChainedHashMap<K,V>) o;
    int i = 0;
                       
    while(i < this.size()) {
        if(testMap.table[i].equals(this.table[i]))
           i++;
                   
        else
           return false;
   }
               return true;
               
           
    }


public int size() {
      int size = 0;
      for(int i = 0; i<table.length-1;i++)
      {
          size += table[i].size();
      }
      return size;
  }
public Collection<V> values() {
    // TODO Auto-generated method stub
    return null;
}



}
    

