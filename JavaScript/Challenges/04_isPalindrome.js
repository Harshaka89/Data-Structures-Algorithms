/*DESCRIPTION: A palindrome is a word or sentence that's spelled the same way both forward and backward,
ignoring punctuation, case, and spacing. Note
You'll need to remove all non-alphanumeric characters (punctuation, spaces and symbols) and turn everything
lower case in order to check for palindromes.
*/

function palindrome(str) {
  str = str.toLowerCase().replace(/[^A-Za-z0-9]/g, ""); //Removes all non alphanumeric characters
  var N = str.length;
  for(var i = 0; i < str.length/2; i++){
    if(str[i] !== str[N-1]){
      return false;
    }
    N--;
  }
  return true;
}
palindrome("eye");
