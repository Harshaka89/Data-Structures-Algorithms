/* DESCRIPTION:  Return the length of the longest word in the provided sentence.
Your response should be a number.
*/

function findLongestWord(str) {
  var temp = str.split(" ");
  var max = 0;
  for(var i = 0; i < temp.length; i++){
    if(temp[i].length > max){
      max = temp[i].length;
    }
  }
  return max;
}

findLongestWord("The quick brown fox jumped over the lazy dog");
