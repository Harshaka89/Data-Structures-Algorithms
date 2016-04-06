/*Description:  Each gun leaves a unique set of scratches, sort of like a fingerprint, on every bullet that 
fires through its chamber. These scratch marks are used widely in forensic investigations of crime scenes.
Given a list of guns and the scratch marks that they leave, and the scratch marks on a bullet, return the 
element number (0-based) of the gun which fired the bullet.
In order for a bullet to match the gun, the gun must leave just as many scratches as are on the bullet, with the
same intervals between scratches. For example, the scratch marks:
"| |||  |   |"
"| |||  |   |"
match, but
"| |||  |   |"
"||| |  |   |"
do not.

Note: that since bullets are round, the scratch marks wrap around. Therefore:
"|| ||| | "
" | || |||"
match (since it's the same scratch marks, only starting at a different location).
If no gun matches the bullet, return -1.
*/

public class Bullets
    {
        public int match(string[] guns, string bullet)
        {  
            for (int i = 0; i < guns.Length; i++)
            {
                if (guns[i].Length != bullet.Length)
                {
                    continue;
                }
             	string temp = guns[i] + guns[i];
                if(temp.Contains(bullet)){
                    return i;
                }
            }
            return -1;
        }
    }
