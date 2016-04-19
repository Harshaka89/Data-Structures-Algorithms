/*
Problem Description: Using the Java language, have the function FirstReverse(str) take the str parameter 
being passed and return the string in reversed order. 
*/

function FirstReverse(str) {   
  return str.split("").reverse().join(""); 
}
   
// keep this function call here 
FirstReverse(readline()); 
