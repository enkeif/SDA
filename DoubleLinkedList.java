import sda.Node;
/**
 *
 * @author nikolina
 * @param 
 * 
 */
 public class DoubleLinkedList<T extends Comparable<T>> {
        private Node<T> head;
       	private Node<T> tail;
       
       	public void setHead(Node<T> head) {
       	       this.head = head;
       	}
       
       	public void setTail(Node<T> tail) {
       	       this.tail = tail;
       	}
       
       	public Node<T> getHead() {
       	       return head;
       	}
       
       	public Node<T> getTail() {
       	       return tail;
       	}

	 public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
			tail = head;
			tail.setLeft(head);
			head.setRight(tail);

		} else {
			tail.setRight(newNode);
			newNode.setLeft(tail);
			tail = newNode;
		}

	}

	public int size() {
		int size = 0;
		Node<T> temp = head;
		if (head == tail) {
			size = 1;
		} else {
			while (temp != null) {
				temp = temp.getRight();
				size++;
			}
		}
		return size;
	}

	//get the node by index	
	public Node<T> get(int index) {
		Node<T> temp = head;
		if (head == null) {
			return null;
		} else {
			for (int i = 0; i < index; i++) {
				temp = temp.getRight();
			}
		}
		return temp;
	}
	
	//removes the given node from the list.
	public void removeAt(Node<T> node) {
		if (node == tail) {
			node.getLeft().setRight(null);
			tail = node.getLeft();
		} else if (node == head) {
			node.getRight().setLeft(null);
			head = node.getRight();
		} 

	}
	
	//returns a copy of the entire list.
	public DoubleLinkedList<T> copy() {
		DoubleLinkedList<T> copied = new DoubleLinkedList<T>();
		Node<T> temp = head;
		while (temp != null) {
			copied.add(temp.getData());
			temp = temp.getRight();
		}
		return copied;
	}
	
	//returns another list but in reverse order.
	public DoubleLinkedList<T> reverse() {
		DoubleLinkedList<T> reversed = new DoubleLinkedList<T>();
		Node<T> temp = tail;
		while (temp != null) {
			reversed.add(temp.getData());
			temp = temp.getLeft();
		}

		return reversed;
	}
	
	//returns true if the current list is a palindrome.
	public boolean isPalindrome() {
		Node<T> temp1 = head;
		Node<T> temp2 = tail;
		for (int i = 0; i < size() / 2; i++) {
			if (temp1.getData() != temp2.getData()) {
				temp1 = temp1.getRight();
				temp2 = temp2.getLeft();
				return false;
			}
		}
		return true;
	}
