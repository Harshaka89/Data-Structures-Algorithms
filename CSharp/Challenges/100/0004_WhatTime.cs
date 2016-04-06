/* PROBLEM STATEMENT:
 * Computers tend to store dates and times as single numbers which represent the number of seconds or milliseconds since a particular
 * date. Your task in this problem is to write a method whatTime, which takes an int, seconds, representing the number of seconds 
 * since midnight on some day, and returns a string formatted as "<H>:<M>:<S>". Here, <H> represents the number of complete hours 
 * since midnight, <M> represents the number of complete minutes since the last complete hour ended, and <S> represents the number
 * of seconds since the last complete minute ended. Each of <H>, <M>, and <S> should be an integer, with no extra leading 0's. Thus,
 * if seconds is 0, you should return "0:0:0", while if seconds is 3661, you should return "1:1:1".
 * Constraints:  Seconds must be >= 0 and <= 86399
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TopCoder
{
    class Time
    {
        public string whatTime(int seconds)
        {
            if (seconds < 0) 
            {
                seconds = 0;
            }
            else if(seconds > 86399)
            {
                seconds = 86399;
            }
            TimeSpan t = TimeSpan.FromSeconds(seconds);
            string output = string.Format("{0:D1}:{1:D1}:{2:D1}",t.Hours,t.Minutes,t.Seconds);
            return output;
        }
    }
}
