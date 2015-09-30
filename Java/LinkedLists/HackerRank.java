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

/* MERGE TWO SORTED LINKED LISTS
  You’re given the pointer to the head nodes of two sorted linked lists. The data in both lists will
  be sorted in ascending order. Change the next pointers to obtain a single, merged linked list which 
  also has data in ascending order. Either head pointer given may be null meaning that the corresponding 
  list is empty.
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

Node MergeLists(Node headA, Node headB) {
    if(headA == null){
        return headB;
    }
    if(headB == null){
        return headA;
    }
    if(headA.data < headB.data){
        headA.next = MergeLists(headA.next, headB);
        return headA;
    }
    else{
        headB.next = MergeLists(headB.next, headA);
        return headB;
    }
}
