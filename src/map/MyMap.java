package map;
import java.util.*;
/**
* Project 1 - COMP 313-488 <br>
*
* The MyMap interface class that implements Map interface is a
* collection that maps keys to values. MyMap contains concrete methods
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


public class MyMap<K, V> implements Map<K, V>{
   
   /**
      * Cell class initiates both key and value as references.
      *
      * @param <K> key of a element
      * @param <V> value of a element
      */

   private Cell<K, V> head = null;
   private Cell<K, V> end = null;
   
   
   
   class Cell<K, V> {
       private K key;
       private V value;
       private Cell<K, V> next;
       Cell(K key, V value) {
       this.key = key;
       this.value = value;
       this.next = null;}
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
      *                     null if there was no mapping for key. A null return
      *                     can also indicate that the map previously associated
      *                     null with the specified key, if the implementation
      *                     supports null values.
      */
   
   public V put(K key, V value) {
       Cell<K,V> newCell = new Cell<K,V>(key, value);
       //if contains key, then replace old value
       if(head == null) {
       head = newCell;
       end = newCell;
       }
       else if(head == newCell)
       {
    	   head = newCell;
       }
       else{
       end.next = newCell;
       end = newCell;
       }
       return value;
   }
   
   
   /**
      * get()<br>
      * Returns the value to which the specified key is mapped,
      * or if this map contains no mapping for the key.
      *
      * @param     key        key whose associated value is to be returned
      *
      * @return     the value to which this map maps the specified key,
      *                     or null if the map contains no mapping for this key.
      */
   
   public V get (Object key) {
       if(head == null) {return null;}
       Cell<K,V> search = head;
       while (search.next != null)
       {if(search.key.equals(key)) return search.value;
       else {search = search.next;}
   }

   if(search.key.equals(key)) return search.value;
   
   return null;
   
   }
   
   /**
      * clear()<br>
      * Removes all mappings from this map
      * The map will be empty after this call returns.
      */
   
   public void clear() {
       head = null;
   
   }
   
   /**
    * hashCode()<br>
    * Returns the hash code value for this map. The hash code of a map is defined to be
    * the sum of the hash codes of each entry in the map's entrySet() view.
    *
    * @return    the hash code value for this map
    */
   
   
   public int hashCode(){
       Integer hash = 0;
       Cell<K,V> search = head;
       
       
       while (search.next != null) {
           hash += (Integer) search.key;
           search = search.next;
       }
       hash += (Integer) search.key;
       
       String str = hash.toString();
       
       if(str.length() == 1) {
           hash = Integer.parseInt(str);
           return hash;
       }
       
       String str2 = str.substring(str.length() - 2, str.length());
       hash = Integer.parseInt(str2);
       
       return hash;
   }
   
   /**
      * containsKey()<br>
      * Returns true if this map contains a mapping for the specified
      * key.
      *
      * @param     key1        key whose presence in this map is to be tested
      *
      * @return             true if this map contains a mapping for the specified key.
      */
   
  
   public boolean containsKey(Object key1) {
       if (head == null)
          {
              return false;
          }
          //search linked list for key value
          if(this.get(key1) != null)
          {
              return true;
          }
          else
          {
              return false;
          }        
   }
   
   /**
      * containsValue()<br>
      * Returns true if this map maps one or more keys to the specified
      * value.
      *
      * @param     value1        value whose presence in this map is to be tested
      *
      * @return             true if this map maps one or more keys to the specified value.  
      */

   
   public boolean containsValue(Object value1) {
       if (head == null)
         {
             return false;
         }
         //search linked list for value
         if(this.get(value1) != null)
         {
             return true;
         }
         else
         {
             return true;
         }
   }

   
   public Set<java.util.Map.Entry<K, V>> entrySet() {
       // TODO Auto-generated method stub
       return null;
   }
   
   /**
      * isEmpty()<br>
      * Returns true if this map contains no key-value mappings.
      *
      * @return             true if this map contains no key-value mappings.  
      */

   
   public boolean isEmpty() {
       if(head == null)
          {
              return true;
          }
          else
          {
              return false;
          }
   }
   
   /**
    * Set<K> MyMap.keySet()<br>
    * Returns a Set view of the keys contained in this map. The set is backed by the map,
    * so changes to the map are reflected in the set, and vice-versa.
    *
    * @return     a set view of the keys contained in this map
    */

  
   public Set<K> keySet() {
       // TODO Auto-generated method stub
       return null;
   }

   /**
    * remove()<br>
    * Removes the mapping for this key from this map if it is present
    * if this map contains a mapping from key to value that mapping is removed
    *
    * @param key     key whose mapping is to be removed from the map
    *
    * @return         the previous value associated with key, or null if there was no mapping for key.
    */

   
   public V remove(Object key) {
       if(head == null)
           return null;

          Cell<K,V> search = head;

          if(search.key.equals(key))
          {
           head = null;
           end = null;
           return search.value;
          }

          Cell<K,V> preSearch = search;

          while(search.next != null)
          {
           search = search.next;

           if(search.key.equals(key))
           {
              preSearch.next = search.next;

              return search.value;
           }

           preSearch = preSearch.next;
          }
          
          return null;
   }
   
   /**
    * size()<br>
    * Returns the number of key-value mappings in this map.
    *
    * @return     the number of key-value mappings in this map
    */

   
   public int size() {
       Cell<K,V> search = head;
          //if null return 0

          if (head == null)
          {
              return 0;
          }
          //increment counter for each element in linked list
          int size = 1;
          while (search.next != null)
          {
              size = size + 1;
              search = search.next;
          }
          return size;
   }
   
   /**
    * Collection<V> MyMap.values()<br>
    * Returns a Collection view of the values contained in this map. The collection is
    * backed by the map, so changes to the map are reflected in the collection, and vice-versa.
    *
    * @return     a collection view of the values contained in this map
    */

   
   public Collection<V> values() {
       // TODO Auto-generated method stub
       return null;
   }
   
   /**
    * equals()<br>
    * Compares the specified object with this map for equality.
    * Returns true if the given object is also a map and the two Maps represent the same mappings.
    *
    * @param     other
    *
    * @return    true if the specified object is equal to this map.
    */
   
   public boolean equals(Object o)
   {
       if(!(o instanceof MyMap))
         return false;
       
       @SuppressWarnings("unchecked")
       MyMap<K,V> comp = ((MyMap<K,V>) o);
       MyMap<K,V> search = ((MyMap<K,V>)this);
       
       if(comp.size() != search.size())
           return false;
       
       while(comp.head.next != null && search.head.next !=null) {
         if(!(comp.head.key.equals(search.head.key)))
           return false;
         if(!(comp.head.value.equals(search.head.value)))
             return false;
         comp.head = comp.head.next;
         search.head = search.head.next;
       }
       
       return true;
         
 }


   /**
    * putAll()<br>
    * Copies all of the mappings from the specified map to this map.
    *
    * @param themap mappings to be stored in this map
    */
   
   
   
   public void putAll(Map<? extends K, ? extends V> themap) {
      
      @SuppressWarnings("unchecked")
        MyMap<K,V> newmap = (MyMap<K,V>) themap;

      if(newmap.head == null)
          this.head = null;
      
      else if(newmap.head != null) {
          
        Cell<K,V> search = newmap.head;
        Cell<K,V> copy = this.head;
          
        copy = search;
      
        while(search.next != null) {
          search = search.next;
          copy = copy.next;
          copy = search;
        }
        
        this.end = copy;
        
      }
      
   } 
   
}