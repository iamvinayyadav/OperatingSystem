package bankersjava;

import java.util.Scanner;

public class bankersjava {
 static int need[][],allocate[][],max[][],avail[][],np,nr;
 
 static void takeinput(){
     Scanner sc=new Scanner(System.in);
     System.out.print("processes and resources : ");
     np=sc.nextInt();
     nr=sc.nextInt();
     need=new int[np][nr];
     max=new int[np][nr];
     allocate=new int[np][nr];
     avail=new int[1][nr];
     
     System.out.println("allocation matrix");
     
     for(int i=0;i<np;i++) for(int j=0;j<nr;j++)
         allocate[i][j]=sc.nextInt();
      
     System.out.println("max matrix");
     
     for(int i=0;i<np;i++)
          for(int j=0;j<nr;j++)
         max[i][j]=sc.nextInt();
      
        System.out.println("available matrix");
        for(int j=0;j<nr;j++)
         avail[0][j]=sc.nextInt();
    }
     static int[][] calc_need(){
       for(int i=0;i<np;i++)
         for(int j=0;j<nr;j++)
          need[i][j]=max[i][j]-allocate[i][j];
       
       return need;
     }
       
      static boolean check(int i){
       for(int j=0;j<nr;j++) 
       if(avail[0][j]<need[i][j])
          return false;
   
    return true;
}

public static void main(String[] args) {
    takeinput();
    calc_need();
    boolean finish[]= new boolean[np];
    int count=0;
    
    while (count<np){
        boolean allocated=false;
        for(int i=0;i<np;i++)
        if(finish[i]==false && check(i)){
            for(int k=0;k<nr;k++)
            avail[0][k]=avail[0][k]-need[i][k]+max[i][k];
         System.out.println("Allocated process : "+i);
         allocated=finish[i]=true;
               count++;
             }
          if(allocated==false) break;
       }
       if(count==np)
        System.out.println("\nSafely allocated");
       else
        System.out.println("All proceess cant be allocated safely"); 
        
    }  
}
