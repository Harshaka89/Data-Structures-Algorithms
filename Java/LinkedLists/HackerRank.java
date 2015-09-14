/*
  Compare two linked lists A and B
  Return 1 if they are identical and 0 if they are not. 
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int CompareLists(Node headA, Node headB) {
    Node currentA = headA;
    Node currentB = headB;
    while(currentA != null || currentB != null){
        if(currentA == null || currentB == null){
            return 0;
        }
        if(currentA.data != currentB.data){
            return 0;
        }
        currentA = currentA.next;
        currentB = currentB.next;
    }
    return 1;
}
