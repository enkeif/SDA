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
