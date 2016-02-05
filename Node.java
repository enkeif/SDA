public class Node<T> {
	private T data;
	private Node<T> left;
	private Node<T> right;
	
	public Node(T data){
		this.data = data;
		setLeft(null);
		setRight(null);
	}
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
