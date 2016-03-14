public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s.length()%2 != 0){
            return false;
        }
        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']'){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            Character x = s.charAt(i);
            switch(x){
                case '(':
                    stack.add(x);
                    break;
                case '{':
                    stack.add(x);
                    break;
                case '[':
                    stack.add(x);
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
