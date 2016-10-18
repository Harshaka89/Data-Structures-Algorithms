namespace ITMO
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = File.ReadAllText("prepare.in").Split('\n');
            string[] PList = text[1].Split(' ');
            string[] TList = text[2].Split(' ');
            int N = int.Parse(text[0]);
            int sum = 0;
            int[] P = new int[N];
            int[] T = new int[N];
            bool flagP = false;
            bool flagT = false;
            int min = int.MaxValue;
            int minIndex = -1;
            for (int i = 0; i < N; i++)
            {
                P[i] = int.Parse(PList[i]);
                T[i] = int.Parse(TList[i]);
                if (P[i] > T[i])
                {
                    flagP = true;
                    sum += P[i];
                }
                else
                {
                    flagT = true;
                    sum += T[i];
                }
            }
            if (flagP == false)
            {
                for (int i = 0; i < N; i++)
                {
                    if (Math.Abs(P[i] - T[i]) < min)
                    {
                        min = Math.Abs(P[i] - T[i]);
                        minIndex = i;
                    }
                }
                sum -= T[minIndex];
                sum += P[minIndex];
            }
            else if (flagT == false)
            {
                for (int i = 0; i < N; i++)
                {
                    if (Math.Abs(P[i] - T[i]) < min)
                    {
                        min = Math.Abs(P[i] - T[i]);
                        minIndex = i;
                    }
                }
                sum -= P[minIndex];
                sum += T[minIndex];
            }
            
            Console.WriteLine(sum);

            System.IO.File.WriteAllText("prepare.out", sum + "");
        }
    }
}
