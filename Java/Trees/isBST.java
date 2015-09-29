/* DESCRIPTION: Determine whether a Binary Tree is a Binary Search Tree
*/
    
  public boolean isBST(Node root, int min, int max) {
      if (root != null) {
          if (root.data > max || root.data < min) {
              return false;
          }
          return isBST(root.left, min, root.data)
                  && isBST(root.right, root.data, max);
       } else {
           return true;
      }
  }
