import java.util.*;

public class MyQueue {

	int size;			// maximum size of queue
	int head = 0;		// index for next enqueue
	int tail = 0;		// index for next dequeue
	int entries = 0;	// number of items in queue
	DataItem[] queue;
	
	// Queue constructor
	public MyQueue(int size) {
		this.size = size;
		queue = new DataItem[size];	
	}
	
	// check for an empty queue
	public boolean isEmpty() {
		return entries == 0;
	}
	
	// add a data item at the tail of the queue
	public boolean enqueue(DataItem data) {
		if (entries == size)
			return false;
			
		queue[tail] = data;
		
		// if the queue was empty
		if (entries == 0)
			head = tail;
			
		// increment tail index
		tail = (tail + 1) % size;	
		entries++;
		
		return true;
	}

	// remove data item from the head of the queue
	public DataItem dequeue() {
		if (entries == 0)
			return null;
			
		DataItem data = queue[head];
		
		// increment the head index
		head = (head + 1) % size;
		entries--;	
			
		return data;
	}
	
	public String toString() {
		if (head == -1)
			return "Queue empty";
			
		String result = "";
		for (int i = 0; i <entries; i++)
			result += queue[(i + head) % size].toString() + "\n";	
			
		return result;
	}

	public static void main(String[] args) {
	
		MyQueue q = new MyQueue(3);
		DataItem[] data = new DataItem[4];
		data[0] = new DataItem(3, 4, "alfie");
		data[1] = new DataItem(6, 12, "Frog");
		data[2] = new DataItem(81, 46, "Bastion");
		data[3] = new DataItem(0, 0, "nothing");
		
		if (q.dequeue() == null)
			System.out.println("Cannot remove from an empty queue");
		
		for (int i = 0; i < data.length; i++) {
			System.out.println("adding " + data[i]);
			if (q.enqueue(data[i]))
				System.out.println(q);
			else
				System.out.println(" failed: queue full");
		}

		for (int i = 0; i < data.length; i++) {
				System.out.println("Dequeued " + q.dequeue());
		}
	}
}
