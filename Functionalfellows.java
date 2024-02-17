import java.util.*;
public class Functionalfellows {


    // in this main method we implement created methods for get output of required time to run a particular task that are add elements,remove an elements,check contains,clear elements
    public static void main(String[] args){
        Createlist me = new Createlist();  // first we are create a Createlist object this is used for create collecions and maps initially
        addArray("arraylist",me.createArrayList());
        addArray("linkedlist",me.createLinkedList());
        addSet("Hashset",me.createHashSet());
        addSet("treeset",me.createTreeSet());
        addSet("linkedhashset",me.createLinkedHashSet());
        addArray("arraydeque",me.createArrayDeque());
        addArray("priorityqueue",me.createPriorityQueue());
        addMap("Hashmap",me.createHashMap());
        addMap("treemap",me.createTreeMap());
        addMap("linkedHashmap",me.createLinkedHashMap());
        System.out.println("*******************************");
        removeArray("arraylist",me.createArrayList());
        removeArray("linkedlist",me.createLinkedList());
        removeArray("Hashset",me.createHashSet());
        removeArray("treeset",me.createTreeSet());
        removeArray("linkedhashset",me.createLinkedHashSet());
        removeArray("arraydeque",me.createArrayDeque());
        removeArray("priorityqueue",me.createPriorityQueue());
        removeMap("Hashmap",me.createHashMap());
        removeMap("treemap",me.createTreeMap());
        removeMap("linkedHashmap",me.createLinkedHashMap());
        System.out.println("*******************************");
        containsArray("arraylist",me.createArrayList());
        containsArray("linkedlist",me.createLinkedList());
        containsArray("Hashset",me.createHashSet());
        containsArray("treeset",me.createTreeSet());
        containsArray("linkedhashset",me.createLinkedHashSet());
        containsArray("arraydeque",me.createArrayDeque());
        containsArray("priorityqueue",me.createPriorityQueue());
        containsMap("Hashmap",me.createHashMap());
        containsMap("treemap",me.createTreeMap());
        containsMap("linkedHashmap",me.createLinkedHashMap());
        System.out.println("*******************************");
        clearArray("arraylist",me.createArrayList());
        clearArray("linkedlist",me.createLinkedList());
        clearArray("Hashset",me.createHashSet());
        clearArray("treeset",me.createTreeSet());
        clearArray("linkedhashset",me.createLinkedHashSet());
        clearArray("arraydeque",me.createArrayDeque());
        clearArray("priorityqueue",me.createPriorityQueue());
        clearMap("Hashmap",me.createHashMap());
        clearMap("treemap",me.createTreeMap());
        clearMap("linkedHashmap",me.createLinkedHashMap());
        System.out.println("*******************************");
    }

    // here we wrote a method to add element in collection
    public static void addArray(String name,Collection<Integer> array){ //we expect 2 aruguments name and array,here name only for print the given array type
        int j = 0;                  //j for count the number of times that calculate time to get average time
        long sum = 0;               // sum for add time of add a number in collection in each time of execution
        Random random = new Random();
        while (j<100){
            j++;
            Integer num = random.nextInt(99999);//here num is an integer object
            long start = System.nanoTime();
            array.add(num);
            long end = System.nanoTime();
            array.remove(num);
            sum= sum+end-start;
        }
        long ave = sum/100;
        System.out.println("Average time to add an element in "+name+" is "+ave+" ns");
    }
    public static void addSet(String name, Set<Integer> array){ //this is for set because we cannot add duplicate elements in one set
        int j = 0;                  //j for count the number of times that calculate time to get average time
        long sum = 0;               // sum for add time of add a number in collection in each time of execution
        Random random = new Random();
        while (j<100){
            j++;
            Integer num = random.nextInt(99999);//here num is an integer object
            array.remove(num);       // we are remove num for ensure the adding in sets
            array.add((Integer) 100000);// this is ensure that initial set length is 100000
            long start = System.nanoTime();
            array.add(num);
            long end = System.nanoTime();
            array.remove((Integer) 100000);
            sum= sum+end-start;
        }
        long ave = sum/100;
        System.out.println("Average time to add an element in "+name+" is "+ave+" ns");
    }
    // this method for calculate time taken to add key value in map
    public static void addMap(String name, Map<Integer,Integer> dict){
        int j = 0;
        long sum = 0;
        Random random = new Random();
        while (j<100){
            j++;
            Integer num = random.nextInt(99999);
            long start = System.nanoTime();
            dict.put(100000,num);
            long end = System.nanoTime();
            dict.remove(100000);
            sum= sum+end-start;
        }
        long ave = sum/100;         //calculate the average time taken
        System.out.println("Average time to add an element in "+name+" is "+ave+" ns");
    }

    //here we wrote a method to remove element in collection
    public static void removeArray(String name, Collection<Integer> array){
        int j = 0;
        long sum = 0;
        Random random = new Random();
        while (j<100){
            j++;
            Integer num = random.nextInt(99999);
            long start = System.nanoTime();
            array.remove(num);
            long end = System.nanoTime();
            array.add(num); //add removed element num for ensure that array contains 100000 elements in next iteration
            sum= sum+end-start;
        }
        long ave = sum/100;
        System.out.println("Average time to remove an element in "+name+" is "+ave+" ns");
    }
    //remove an entry from map
    public static void removeMap(String name, Map<Integer,Integer> dict){
        int j = 0;
        long sum = 0;
        Random random = new Random();
        while (j<100){
            j++;
            Integer num = random.nextInt(99999);
            Integer value=dict.get(num);
            long start = System.nanoTime();
            dict.remove(num);
            long end = System.nanoTime();
            dict.put(num,value);
            sum= sum+end-start;

        }
        long ave = sum/100;
        System.out.println("Average time to remove an element in "+name+" is "+ave+" ns");
    }
    // this method to find a particular element in collection
    public static void containsArray(String name, Collection<Integer> array){
        int j = 0;
        long sum = 0;
        Random random = new Random();
        while (j<100){
            j++;
            Integer num = random.nextInt(99999);//how ever num must be in array because our created array contains all elements between 0-99999 inclusive
            long start = System.nanoTime();
            array.contains(num);
            long end = System.nanoTime();
            sum= sum+end-start;
        }
        long ave = sum/100;
        System.out.println("Average time to find an element in "+name+" is "+ave+" ns");
    }
    // to find a particular value in map
    public static void containsMap(String name, Map<Integer,Integer> dict){
        int j = 0;
        long sum = 0;
        Random random = new Random();
        while (j<100){
            j++;
            Integer num = random.nextInt(99999);
            long start = System.nanoTime();
            dict.containsValue(num);
            long end = System.nanoTime();
            sum= sum+end-start;
        }
        long ave = sum/100;
        System.out.println("Average time to find an element in "+name+" is "+ave+" ns");
    }

    // this method for clere all elements in collection and calculate average time
    public static void clearArray(String name,Collection<Integer> array){
        ArrayList<Integer> temp = new ArrayList<>(array);    //here we create a temporary collection for store all elemnts in array because if we clear all elements in array at one length of the array become 0 we cant clear that array once again
        int j = 0;
        long sum = 0;
        while (j<100){
            j++;
            long start = System.nanoTime();
            array.clear();
            long end = System.nanoTime();
            array.addAll(temp);
            sum= sum+end-start;
        }
        long ave = sum/100;
        System.out.println("Average time to clear all elements in "+name+" is "+ave+" ns");
    }
    // average time calculation of clear a map
    public static void clearMap(String name, Map<Integer,Integer> dict){
        HashMap<Integer,Integer> temp = new HashMap<>(); //temp map created for clear elements in map like wise clear array
        for(var entry : dict.entrySet()){
            Integer A = entry.getKey();
            Integer B = entry.getValue();
            temp.put(A,B);
        }
        int j = 0;
        long sum = 0;
        while (j<100){
            j++;
            long start = System.nanoTime();
            dict.clear();
            long end = System.nanoTime();
            for(var entry : temp.entrySet()){
                Integer A = entry.getKey();
                Integer B = entry.getValue();
                dict.put(A,B);
            }
            sum= sum+end-start;
        }
        long ave = sum/100;
        System.out.println("Average time to clear all elements in "+name+" is "+ave+" ns");
    }
}

// we create a class called Createlist for create collections with 100000 elements
class Createlist{
    public ArrayList<Integer> createArrayList(){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0;i<=99999;i++){
            Integer num = i;
            array.add(num);         // we add initial elements in order
        }
        Collections.shuffle(array);     // element's orders are shuffled

        return array;
    }
    public HashSet<Integer> createHashSet(){
        HashSet<Integer> array = new HashSet<>(createArrayList()); //first create a arraylist and cast to it into hashset
        return array;
    }

    public LinkedHashSet<Integer> createLinkedHashSet(){
        LinkedHashSet<Integer> array = new LinkedHashSet<>(createArrayList());
        return array;
    }
    public TreeSet<Integer> createTreeSet(){
        TreeSet<Integer> array = new TreeSet<>(createArrayList());
        return array;
    }
    public ArrayDeque<Integer> createArrayDeque(){
        ArrayDeque<Integer> array = new ArrayDeque<>(createArrayList());
        return array;
    }
    public LinkedList<Integer> createLinkedList(){
        LinkedList<Integer> array = new LinkedList<>(createArrayList());
        return array;
    }
    public PriorityQueue<Integer> createPriorityQueue(){
        PriorityQueue<Integer> array = new PriorityQueue<>(createArrayList());
        return array;
    }
    public HashMap<Integer,Integer> createHashMap(){
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> value = createArrayList();
        ArrayList<Integer> shu = createArrayList();  //we create a array list for key of map
        for(int i = 0;i<=99999;i++){
            Integer val = value.get(i);
            Integer key = shu.get(i);
            map.put(key,val);
        }
        return map;
    }
    public TreeMap<Integer,Integer> createTreeMap(){
        TreeMap<Integer,Integer> map = new TreeMap<>(createHashMap());      //first create a hashmap and cast to it into treemap
        return map;
    }
    public LinkedHashMap<Integer,Integer> createLinkedHashMap(){
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>(createHashMap());
        return map;
    }
    /* in this class we create only one collection and map by adding elements . arraylist and hashmap because they store elements in unsorted way,but some of collections
     and maps are store elements in sorted order thats why we didn't choose them
     */
}