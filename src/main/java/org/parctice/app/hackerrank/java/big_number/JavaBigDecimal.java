package org.parctice.app.hackerrank.java.big_number;

import java.math.BigDecimal;
import java.util.*;

public class JavaBigDecimal {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here

        // code block start

        Arrays.sort(s, Collections.reverseOrder((s1, s2) -> {
            if(s1 == null || s2 == null){
                return 0;
            }
            return new BigDecimal(s1).compareTo(new BigDecimal(s2));
        }));

        // code block end

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
