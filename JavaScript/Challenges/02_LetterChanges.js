/*
 * Description: Using the Java language, have the function LetterChanges(str) take 
 * the str parameter being passed and modify it using the following algorithm. Replace
 * every letter in the string with the letter following it in the alphabet 
 * (ie. c becomes d, z becomes a). Then capitalize every vowel in this new string 
 * (a, e, i, o, u) and finally return this modified string. 
 */
 
 function LetterChanges(str) { 
	str = str.toLowerCase();
  	var alpha = "abcdefghijklmnopqrstuvwxyz";
  	var output = "";
  	for(var i = 0; i < str.length; i++){
    	if(str.charCodeAt(i) == 'z'){
        	output = output + "a";
          	continue;
        }
      	if(alpha.indexOf(str[i]) == -1){
          output += str[i];
        	continue;
        }
      	else{
        	output += alpha[alpha.indexOf(str[i])+1];
        }
      output = output.replace("a", "A").replace("e", "E").replace("i", "I").replace("o", "O").replace("u", "U");
    }
  	
  return output; 
         
}
   
// keep this function call here 
LetterChanges(readline());     
