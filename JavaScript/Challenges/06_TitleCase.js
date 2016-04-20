/*DESCRIPTION: Return the provided string with the first letter of each word capitalized. Make sure the rest
of the word is in lower case.
For the purpose of this exercise, you should also capitalize connecting words like "the" and "of".
*/
function titleCase(str) {
  var words = str.toLowerCase().split(" ");
  var output = "";
  for(var i = 0; i < words.length; i++){
    for(var j = 0; j < words[i].length; j++){
      if(j === 0){
        output += words[i][0].toUpperCase();
      }
      else{
        output += words[i][j];
      }
    }
    if(i+1 !== words.length){
      output += " ";
    }
  }
  return output;
}
titleCase("I'm a little tea pot");
