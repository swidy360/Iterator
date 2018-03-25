package com.swidy.dp.iterator;

public class LinkedList implements Collection{
	Node head = null;
	Node tail = null;
	int size = 0;
	
	
	public void add(Object o) {
		Node n = new Node(o, null);
		if(head == null) {
			head = n;
			tail = n;
		}
		tail.setNext(n);
		tail = n;
		size++;
		
	}
	
	public int size() {
		return size;
	}

	@Override
	public Iterator iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator{
		
		private Node currentNode = head;

		@Override
		public Object next() {
			if(currentNode != null && currentNode.getNext() != null) {
				Object o = currentNode.getNext().getData();
				currentNode = currentNode.getNext();
				return o;
			}
			return null;
		}

		@Override
		public boolean hasNext() {
			if(currentNode != null && currentNode.getNext() != null) {
				 return true;
			} 
			return false;
		}
		
	}
}
