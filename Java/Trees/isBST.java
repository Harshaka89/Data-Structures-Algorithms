/*  DESCRIPTION: Determine whether a Binary Tree is a Binary Search Tree.
    NOTES:  This solution works by passing in the smallest and largest possible integer values for 
    min and max.  If root is not equal to null it checks if the data at root is larger than or smaller
    than the max and min and if it is then it can't be a BST so return false.  Otherwise compare all nodes to 
    the left of the root and make sure it has a value between the smallest integer value and the data at 
    root.  Then check all nodes to the right of the root and make sure they have a value between the root
    and the maximum value of an integer.  If any of these return false it isn't a BST, because the node 
    must be located on the wrong side of the root.  If all tests pass it will return true when root.left
    and root.right pointers reach null at the end of the tree.
*/  

  public boolean isBST(Node root, int min, int max) {
      if (root != null) {
          if (root.data > max || root.data < min) {
              return false;
          }
          return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
       } 
       else {
          return true;
      }
  }
