
public interface Comparator<E> 
{
	/**
	* Compares e1 with e2
	* @return negative if e1 is higher priority than e2, 0 if equal priority,
	* and positive if e2 is higher priority
	*/
	int compare(E e1, E e2);
}
