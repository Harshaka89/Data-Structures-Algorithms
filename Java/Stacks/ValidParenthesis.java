public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s.length()%2 != 0){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            Character choice = s.charAt(i);
            
            if(stack.isEmpty()){
	            if(choice == '}' || choice == ')' || choice == ']'){
	                return 0;
    	        }
	        }
	        
            switch(choice){
                case '(':
                    stack.add(choice);
                    break;
                case '{':
                    stack.add(choice);
                    break;
                case '[':
                    stack.add(choice);
                    break;
                case ')':
                    if(stack.peek() == '('){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                    break;
                case '}':
                    if(stack.peek() == '{'){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                    break;
                case ']':
                    if(stack.peek() == '['){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
