public void getPreSucc(Key key){
		Node predecessor = null;
		Node successor = null;
		getPreSucc(root, key, predecessor, successor);
	}
	private void getPreSucc(Node current, Key key, Node predecessor, Node successor){
		if(current == null){
			printPreSucc(predecessor, successor);
			return;
		}
		int cmp = key.compareTo(current.key);
		if(cmp < 0){
			successor = current;
			getPreSucc(current.left, key, predecessor, successor);
		}
		else if(cmp > 0){
			predecessor = current;
			getPreSucc(current.right, key, predecessor, successor);
		}
		else{
			if(current.left != null){
				Node temp = current.left;
				while(temp.right != null){
					temp = temp.right;
				}
				predecessor = temp;
			}
			if(current.right != null){
				Node temp = current.right;
				while(temp.left != null){
					temp = temp.left;
				}
				successor = temp;
			}
			printPreSucc(predecessor, successor);
			return;
		}
	}
	public void printPreSucc(Node predecessor, Node successor){
		if(predecessor != null){
			System.out.println("Predecessor is: " + predecessor.data);
		}
		else{
			System.out.println("No predecessor!");
		}
		if(successor != null){
			System.out.println("Successor is: " + successor.data);
		}
		else{
			System.out.println("No successor!");
		}
	}
	
	public static void main(String[] args){
		BST<Integer, Integer> tree = new BST<Integer, Integer>();
		tree.put(30, 30);
		tree.put(20, 20);
		tree.put(40, 40);
		tree.put(70, 70);
		tree.put(60, 60);
		tree.put(80, 80);
		
		tree.printInOrder();
		System.out.println();
		
		tree.getPreSucc(10);
		
	}
