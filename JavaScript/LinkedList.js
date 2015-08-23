/*
 * DESCRIPTION: Implementation of a linked list in JavaScript.  If you want to test it
 */

var LinkedList = function(){
    var list = {};
    list.size = 0;
    list.head = null;
    list.tail = null;

    //Adds item to the head
    list.addToHead = function(value){
        var newNode = createNode(value);
        newNode.next = list.head;
        list.head = newNode;
        if(list.tail == null){
            list.tail = newNode;
        }
        list.size++;
    };
    
    //Adds item to the tail
    list.addToTail = function(value){
        var newNode = createNode(value);
        if(tail == null){
            list.head = newNode;
            list.tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        list.size++;
    };

    //Removes item from the head
    list.removeHead = function(){
        if(list.isEmpty()){
            return;
        }
        list.head = list.head.next;
        list.size--;
        if(list.size == 0){
            list.tail = null;
        }
    };
    
    //Removes item from the tail
    list.removeTail = function(){
        if(list.isEmpty()){
            return;
        }
        var current = list.head;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = current.next.next;
        list.size--;
    };

    //Checks if an item is in the list
    list.contains = function(key) {
        var current = list.head;
        while(current != null){
            if(current.data === key){
                return true;
            }
            else{
                current = current.next;
            }
        }
        return false;
    };

    //Prints every item in the list
    list.printList = function(){
        var current = list.head;
        while(current != null){
            console.log(current.data);
            current = current.next;
        }
    };

    //Checks if list is empty, if it is it prints a message
    list.isEmpty = function(){
      if(list.size == 0){
          console.log("List is empty!");
          return true;
      }
        return false;
    };

    return list;
};

var createNode = function(value){
    var Node = {};
    Node.data = value;
    Node.next = null;
    return Node;
};

//var list = new LinkedList();
