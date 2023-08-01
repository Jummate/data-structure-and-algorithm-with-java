package com.jummate.dsa1;

public class SinglyLinkedList<T> {
	private Node head = null;
	private Node tail = null;
	private int count;

	public class Node {

		private T element;
		private Node nextNode;

		public Node(T element) {
			this.element = element;
		}

		public Node(T element, Node prevNode) {
			this.element = element;
			prevNode.nextNode = this;
		}
	}

	
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}

	public void addNode(T element) {
		//
		if (this.head == null) {
			this.head = new Node(element);
			this.tail = this.head;
		} else {
			Node newNode = new Node(element, this.tail);
			this.tail = newNode;

		}
		this.count++;
	}

	private void remove(Node prevNode, Node node) {
		this.count--;
		if (this.count == 0) {
			this.head = null;
			this.tail = null;
		} else if (prevNode == null) {
			this.head = node.nextNode;
		} else {
			prevNode.nextNode = node.nextNode;
		}
		if (node.equals(this.tail)) {
			this.tail = prevNode;
		}
	}

	public T removeAt(int index) {
		if (index >= this.count || index < 0) {
			throw new IndexOutOfBoundsException("Index out range or invalid entry!");
		}
		int currentIndex = 0;
		Node current = this.head;
		Node prev = null;

		while (currentIndex < index) {
			prev = current;
			current = current.nextNode;
			currentIndex++;
		}

		remove(prev, current);

		return current.element;
	}

	public int removeNode(T element) {
		int index = 0;
		Node current = this.head;
		Node prev = null;

		while (current != null) {
			if (current.element.equals(element)) {
				break;
			}

			prev = current;
			current = current.nextNode;
			index++;
		}
		if (current == null) {
			return -1;
		}
		remove(prev, current);
		return index;

	}
	
	public int indexOf(T item) {
		int index = 0;
		Node current = this.head;

		while (current != null) {
			if (current.element.equals(item)) {
				return index;
			}
			current = current.nextNode;
			index++;
		}
		return -1;
	}
	
	public boolean contains(T item) {
		return indexOf(item) != -1;
	}
	
	public T findElementAt(int index) {
		if (index >= this.count || index < 0) {
			throw new IndexOutOfBoundsException("Index out range or invalid entry!");
		}
		int currentIndex = 0;
		Node current = this.head;

		while (currentIndex < index) {
			current = current.nextNode;
			currentIndex++;
		}

		return current.element;
	}
	
	public int size() {
		return this.count;
	}

}
