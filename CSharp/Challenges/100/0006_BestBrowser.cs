/*
DESCRIPTION: 
    You don't need to type 'www.' to open a website anymore.
    Though, you still need to type '.com' to open a website.
    The browser predicts ALL THE VOWELS in the name of the website. (Not '.com', though. Again!)
    Obviously, this means you can type the name of a website faster and save some time.
Now to convince users that his browser will indeed save A LOT of time for users to open a particular 
website, Little Jhool has asked you to prepare a report on the same.
Input format:
The first line contains tc, the number of test cases.
The second line contains the name of websites, as a string.
Output format:
You have to print the ratio of characters you would have typed in Jhool's browser, to your normal browser.
Constraints:
1 <= tc <= 100
1 <= Length of the website <= 200
*/
using System; 
using System.Numerics;
class MyClass {
    static void Main(string[] args) {
        int T = int.Parse(Console.ReadLine());
        while(T-- > 0){
        	string site = Console.ReadLine().ToLower();
        	int count = 4;
        	int i = 4;
       		while(site[i] != '.'){
       			if(site[i] == 'a' || site[i] == 'e' || site[i] == 'i' 
       			|| site[i] == 'o' || site[i] == 'u'){
       				i++;
       				continue;
       			}
       			count++;
       			i++;
       		}
       		Console.WriteLine(count + "/" + site.Length);
        }
    }
}
