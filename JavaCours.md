###### L’interface Collection 

3039197798256
```java
public interface Collection<E> extends Iterable<E> {
  // Opérations simples
  int size();
  boolean isEmpty();
  boolean contains(Object element);
  boolean add(E element);    // Optionnel
  boolean remove(Object element); // Optionnel
  boolean equals(Object o);
  int hashCode();
  Iterator<E> iterator();

  // Opérations de groupe
  boolean containsAll(Collection<?> c);
  boolean addAll(Collection<? extends E> c);    // Optionnel
  boolean removeAll(Collection<?> c); // Optionnel
  default boolean removeIf(Predicate<? super E> filter);
  boolean retainAll(Collection<?> c); // Optionnel
  void clear();    // Optionnel

  // Conversions
  Object[] toArray();
  <T> T[] toArray(T[] a);

  // Itération et Streams
  Iterator<E> iterator();
  default Spliterator<E> spliterator();
  default Stream<E> stream();
  default Stream<E> parallelStream();
}
```

##### Parcourir des collections

Trois techniques permettent de parcourir des collections

Les Streams
La boucle for-each
Les itérateurs

#### Les Stream
```java
String joined = elements.stream()
    .filter(e -> e.getColor() == Color.RED)
    .map(Object::toString)
    .collect(Collectors.joining(", "));
```
#### Boucle for-each
```java
for (String element : uneCollectionDeChaines) {
    // Manipuler element
}
```
#### Itérateur
```java
public interface Iterator<E> {
    boolean hasNext();
    E next();
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
```
###  Parcours d’une collection avec un itérateur
```java
for (Iterator<String> i = uneCollectionDeChaines.iterator(); i.hasNext(); ) {
  String element = i.next(); // Récupère l'élément et passe au suivant
  // ...
}
```

```java
public Iterator<E> {
  boolean hasNext();   // return true if the iteration has more elements
  E next();            // return the next element in the iteration
  void remove();       // remove the last element returned by the iterator
}

// coll refers to an object which implements Collection
// ----- not the preferred idiom from Java 5 on -------
for (Iterator itr = coll.iterator() ; itr.hasNext() ; ) {
  System.out.println(itr.next());
}

for (Object o : coll) {
  System.out.println(o);
}

public Iterable<T> {
  Iterator<T> iterator();   // return an iterator over elements of type T
}

int total = 0;
for (int i : new Counter(3)) {
   total += i;
}
assert total == 6;

class Counter implements Iterable<Integer> {
  private int count;
  public Counter(int count) { this.count = count; }
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      private int i = 0;
      public boolean hasNext() { return i < count; }
      public Integer next() { i++; return i; }
      public void remove(){ throw new UnsupportedOperationException(); }
    };
  }
}
/*--------------------------------------------------------------------------------------*/
interface Stack {
  public void push(int elt);
  public int pop();
  public boolean isEmpty();
}


class ArrayStack implements Stack{
  private final int MAX_ELEMENTS = 10;
  private int[] stack;
  private int index;
  public ArrayStack() {
    stack = new int[MAX_ELEMENTS];
    index = -1;
  }
  public void push(int elt) {
    if (index != stack.length - 1) {
      index++;                                        //1
      stack[index] = elt;                             //2
    } else {
      throw new IllegalStateException("stack overflow");
    }
  }
  public int pop() {
    if (index != -1) {
      return stack[index];
      index--;
    } else {
      throw new IllegalStateException("stack underflow");
    }
  }
  public boolean isEmpty() { return index == -1; }
}
/*--------------------------------------------------------------------------------------*/
public class SynchronizedArrayStack implements Stack {
  private final Stack stack;
  public SynchronizedArrayStack(Stack stack) {
    this.stack = stack;
  }
  public synchronized void push(int elt) { stack.push(elt); }
  public synchronized int pop() { return stack.pop(); }
  public synchronized boolean isEmpty() { return stack.isEmpty(); }
}
/*--------------------------------------------------------------------------------------*/
Stack stack = new SynchronizedArrayStack(new ArrayStack());
...
// don't do this in a multi-threaded environment
if (!stack.isEmpty()) {
  stack.pop();              // can throw IllegalStateException

}

synchronized(stack) {
  if (!stack.isEmpty()) {
    stack.pop();
  }
}
/*--------------------------------------------------------------------------------------*/
// The interface Comparable<T> contains a method that can be used to compare one object to another:
interface Comparable<T> {
  public int compareTo(T o);
}
Integer int0 = 0;
Integer int1 = 1;
assert int0.compareTo(int1) < 0;

class Integer implements Comparable<Integer> {
  ...
  public int compareTo(Integer that) {
	  return this.value < that.value ? -1 :
	           this.value == that.value ? 0 : 1 ;
  }
  ...
}
/*--------------------------------------------------------------------------------------*/
// Here is code to find the maximum element in a nonempty collection, from the class Collections:
public static <T extends Comparable<T>> T max(Collection<T> coll) {
    T candidate = coll.iterator().next();
    for (T elt : coll) {
        if (candidate.compareTo(elt) < 0) candidate = elt;
    }
    return candidate;
}

List<Integer> ints = Arrays.asList(0,1,2);
	assert Collections.max(ints) == 2;

List<String> strs = Arrays.asList("zero","one","two");
	assert Collections.max(strs).equals("zero");

// But we may not choose T to be Number (since Number does not implement Comparable):
List<Number> nums = Arrays.asList(0,1,2,3.14);
	assert Collections.max(nums) == 3.14; // compile-time error

public static <T extends Comparable<T>> T max(Collection<T> coll) {
  Iterator<T> it = coll.iterator();
  T candidate = it.next();
  while (it.hasNext()) {
    T elt = it.next();
    if (candidate.compareTo(elt) < 0) candidate = elt;
  }
  return candidate;
}
/*--------------------------------------------------------------------------------------*/
//  Permitting comparison of apples with oranges
abstract class Fruit implements Comparable<Fruit> {
  protected String name;
  protected int size;
  protected Fruit(String name, int size) {
    this.name = name; this.size = size;
  }
  public boolean equals(Object o) {
    if (o instanceof Fruit) {
      Fruit that = (Fruit)o;
      return this.name.equals(that.name) && this.size == that.size;
    } else return false;
  }
  public int hashCode() {
    return name.hashCode()*29 + size;
  }
  public int compareTo(Fruit that) {
    return this.size < that.size ? - 1 :
           this.size == that.size ? 0 : 1 ;
  }
}
class Apple extends Fruit {
  public Apple(int size) { super("Apple", size); }
}
class Orange extends Fruit {
  public Orange(int size) { super("Orange", size); }
}
class Test {
  public static void main(String[] args) {

    Apple a1 = new Apple(1); Apple a2 = new Apple(2);
    Orange o3 = new Orange(3); Orange o4 = new Orange(4);

    List<Apple> apples = Arrays.asList(a1,a2);
    assert Collections.max(apples).equals(a2);

    List<Orange> oranges = Arrays.asList(o3,o4);
    assert Collections.max(oranges).equals(o4);

    List<Fruit> mixed = Arrays.<Fruit>asList(a1,o3);
    assert Collections.max(mixed).equals(o3); // ok
  }
}
/*--------------------------------------------------------------------------------------*/
// Prohibiting comparison of apples with oranges
abstract class Fruit {
  protected String name;
  protected int size;
  protected Fruit(String name, int size) {
    this.name = name; this.size = size;
  }
  public boolean equals(Object o) {
    if (o instanceof Fruit) {
      Fruit that = (Fruit)o;
      return this.name.equals(that.name) && this.size == that.size;
    } else return false;
  }
  public int hashCode() {
    return name.hashCode()*29 + size;
  }
  protected int compareTo(Fruit that) {
    return this.size < that.size ? -1 :
           this.size == that.size ? 0 : 1 ;
  }
}
class Apple extends Fruit implements Comparable<Apple> {
  public Apple(int size) { super("Apple", size); }
  public int compareTo(Apple a) { return super.compareTo(a); }
}
class Orange extends Fruit implements Comparable<Orange> {
  public Orange(int size) { super("Orange", size); }
  public int compareTo(Orange o) { return super.compareTo(o); }
}
class Test {
  public static void main(String[] args) {

    Apple a1 = new Apple(1); Apple a2 = new Apple(2);
    Orange o3 = new Orange(3); Orange o4 = new Orange(4);
    
    List<Apple> apples = Arrays.asList(a1,a2);
    assert Collections.max(apples).equals(a2);

    List<Orange> oranges = Arrays.asList(o3,o4);
    assert Collections.max(oranges).equals(o4);

    List<Fruit> mixed = Arrays.<Fruit>asList(a1,o3);
    assert Collections.max(mixed).equals(o3); // compile-time error
  }
}
/*--------------------------------------------------------------------------------------*/
//Here is a comparator that considers the shorter of two strings to be smaller. Only if two strings have the same length are they compared using the natural (alphabetic) ordering.
Comparator<String> sizeOrder =
  new Comparator<String>() {
    public int compare(String s1, String s2) {
      return
        s1.length() < s2.length() ? -1 :
        s1.length() > s2.length() ? 1 :
        s1.compareTo(s2) ;
      }
};

//Here is an example:
assert "two".compareTo("three") > 0;
assert sizeOrder.compare("two","three") < 0;
/*--------------------------------------------------------------------------------------*/
public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll)
// we also have:
public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp)

Collection<String> strings = Arrays.asList("from","aaa","to","zzz");
assert max(strings).equals("zzz");
assert min(strings).equals("aaa");
assert max(strings,sizeOrder).equals("from");
assert min(strings,sizeOrder).equals("to");

// Here is the code for a version of max using comparators:
public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp) {
  T candidate = coll.iterator().next();
  for (T elt : coll) {
     if (cmp.compare(candidate, elt) < 0) { candidate = elt; }
  }
  return candidate;
}

//It is easy to define a comparator that provides the natural ordering:
public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
  return new Comparator<T> {
    public int compare(T o1, T o2) { return o1.compareTo(o2); }
  }
}

//Using this, it is easy to define the version of max that uses the natural ordering in terms of the version that uses a given comparator:
public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
  return max(coll, Comparators.<T>naturalOrder());
}

public static <T> Comparator<T> reverseOrder(final Comparator<T> cmp) {
  return new Comparator<T>() {
    public int compare(T o1, T o2) { return cmp.compare(o2,o1); }
  };
}

// Finally, we can define the two versions of min in terms of the two versions of max by using the two versions of reverseOrder:
public static <T> T min(Collection<? extends T> coll, Comparator<? super T> cmp) {
  return max(coll, reverseOrder(cmp));
}
public static <T extends Comparable<? super T>> T min(Collection<? extends T> coll) {
  return max(coll, Comparators.<T>reverseOrder());
}

// As a final example of comparators, here is a method that takes a comparator on elements and returns a comparator on lists of elements:
public static <E> Comparator<List<E>> listComparator(final Comparator<? super E> comp) {
  return new Comparator<List<E>>() {
    public int compare(List<E> list1, List<E> list2) {
      int n1 = list1.size();
      int n2 = list2.size();
      for (int i = 0; i < Math.min(n1,n2); i++) {
        int k = comp.compare(list1.get(i), list2.get(i));
        if (k != 0) return k;
      }
      return (n1 < n2) ? -1 : (n1 == n2) ? 0 : 1;
    }
  };
}
/*--------------------------------------------------------------------------------------*/
// Comparators
class Comparators {
  public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp) {
    T candidate = coll.iterator().next();
    for (T elt : coll) {
      if (cmp.compare(candidate, elt) < 0) { candidate = elt; }
    }
    return candidate;
  }
  public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
    return max(coll, Comparators.<T>naturalOrder());
  }
  public static <T> T min(Collection<? extends T> coll, Comparator<? super T> cmp) {
    return max(coll, reverseOrder(cmp));
  }
  public static <T extends Comparable<? super T>> T min(Collection<? extends T> coll) {
    return max(coll, Comparators.<T>reverseOrder());
  }
  public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
    return new Comparator<T>() {
      public int compare(T o1, T o2) { return o1.compareTo(o2); }
    };
  }
  public static <T> Comparator<T> reverseOrder(final Comparator<T> cmp) {
    return new Comparator<T>() {
      public int compare(T o1, T o2) { return cmp.compare(o2,o1); }
    };
  }
  public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
    return new Comparator<T>() {
      public int compare(T o1, T o2) { return o2.compareTo(o1); }
    };
  }
}
// Base class for enumerated types
public abstract class Enum<E extends Enum<E>> implements Comparable<E> {
  private final String name;
  private final int ordinal;
  protected Enum(String name, int ordinal) {
    this.name = name; this.ordinal = ordinal;
  }
  public final String name() { return name; }
  public final int ordinal() { return ordinal; }
  public String toString() { return name; }
  public final int compareTo(E o) {
    return ordinal - o.ordinal;
  }
}
/*Class corresponding to an enumerated type
 corresponds to
 enum Season { WINTER, SPRING, SUMMER, FALL }*/
final class Season extends Enum<Season> {
  private Season(String name, int ordinal) { super(name,ordinal); }
  public static final Season WINTER = new Season("WINTER",0);
  public static final Season SPRING = new Season("SPRING",1);
  public static final Season SUMMER = new Season("SUMMER",2);
  public static final Season FALL   = new Season("FALL",3);
  private static final Season[] VALUES = { WINTER, SPRING, SUMMER, FALL };
  public static Season[] values() { return VALUES.clone(); }
  public static Season valueOf(String name) {
    for (Season e : VALUES) if (e.name().equals(name)) return e;
    throw new IllegalArgumentException();
  }
}
/*--------------------------------------------------------------------------------------*/
class Pair<T, U> {
  private final T first;
  private final U second;
  public Pair(T first, U second) { this.first=first; this.second=second; }
  public T getFirst() { return first; }
  public U getSecond() { return second; }

  public static void main(String[] args) {
  	Pair<String, Integer> pair = new Pair<String, Integer>("one",2);
	assert pair.getFirst().equals("one") && pair.getSecond() == 2;   	
  }
}

class Cell<T> {
  private final int id;
  private final T value;
  private static int count = 0;
  private static synchronized int nextId() { return count++; }
  public Cell(T value) { this.value=value; id=nextId(); }
  public T getValue() { return value; }
  public int getId() { return id; }
  public static synchronized int getCount() { return count; }

  public static void main(String[] args) {
  	Cell<String> a = new Cell<String>("one");
	Cell<Integer> b = new Cell<Integer>(2);
	assert a.getId() == 0 && b.getId() == 1 && Cell.getCount() == 2;
  }
}
/*--------------------------------------------------------------------------------------*/
// Type parameters are in scope for nested, nonstatic classes
public class LinkedCollection<E> extends AbstractCollection<E> {
  private class Node {
    private E element;
    private Node next = null;
    private Node(E elt) { element = elt; }
  }
  private Node first = new Node(null);
  private Node last = first;
  private int size = 0;
  public LinkedCollection() {}
  public LinkedCollection(Collection<? extends E> c) { addAll(c); }
  public int size() { return size; }
  public boolean add(E elt) {
    last.next = new Node(elt); last = last.next; size++;
    return true;
  }
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      private Node current = first;
      public boolean hasNext() {
        return current.next != null;
      }
      public E next() {
        if (current.next != null) {
          current = current.next;
          return current.element;
        } else throw new NoSuchElementException();
      }
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
}
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------*/
```

