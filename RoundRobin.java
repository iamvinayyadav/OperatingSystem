import java.util.Scanner;

public class RoundRobin {

    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Give number of Processes: ");
        int n = sc.nextInt();
        int process[] = new int[n], waiting_time[]= new int[n], turnaround_time[] = new int[n];
        
        for(int i=0; i<n; ++i){
            process[i] = i+1;
        }
        
        int burst_time[] = new int[n];
        int rem_bt[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Give the burst time for process " + (i+1) + ":");
            burst_time[i] = sc.nextInt();
            rem_bt[i] = burst_time[i];
            waiting_time[i] = 0;
            turnaround_time[i] = 0;
        }
        
        System.out.println("Input the value for time quantum: ");
        int timequantum = sc.nextInt();
        int t = 0, total_wt= 0, total_tat=0;
        
        while(true){
            boolean is_over= true;
            
            for(int i=0; i<n; ++i){
                if(rem_bt[i]>0){
                    
                    is_over = false;
                    if(rem_bt[i] > timequantum){    
                        t += timequantum;
                        rem_bt[i] -= timequantum;
                    }
                    else{
                        t += rem_bt[i];
                        waiting_time[i] = t - burst_time[i];

                        rem_bt[i] = 0;
                    }
                }
            }
            if(is_over) break;
        }
        
        for(int i=0; i<n;++i){
            turnaround_time[i] = burst_time[i] + waiting_time[i];
        }
        
        System.out.println("Processes " + " Burst time " + " Waiting time " + " Turn around time");
      
        
        for (int i=0; i<n; i++)
        {
            total_wt = total_wt + waiting_time[i];
            total_tat = total_tat + turnaround_time[i];
            System.out.println(" " + (i+1) + "\t\t" + burst_time[i] +"\t " + waiting_time[i] +"\t\t " + turnaround_time[i]);
        }
      
        System.out.println("Average waiting time = " + (float)total_wt / (float)n);
        System.out.println("Average turn around time = " + (float)total_tat / (float)n);
    }
    
}
