package oslab;
import java.util.ArrayList;
import java.util.*;
class producer implements Runnable{
     List<Integer> Buffer=null;
     private int i=0;
     final int max=10;
     producer(List<Integer>Buffer)
     {
         this.Buffer=Buffer;
     }
     public void produce(int i)throws InterruptedException
     {
       synchronized(Buffer)
       {
           while(Buffer.size()== max)
           {
               System.out.println("Producer is Waiting due to Buffer is Full");
               Buffer.wait();
           }
       }
       synchronized(Buffer)
       {
           Buffer.add(i);
           System.out.println("Producer Producing");
           Thread.sleep(250);
           Buffer.notify();
       }
     }
     public void run()
     {
         try{
             while(true)
             {
                 i++;
                 produce(i);
             }
         }
         catch(Exception e)
         {
             System.out.println("Exception overcome"+e);     
         }
     }
}
class Consumer implements Runnable{
    List<Integer> B=null;
     Consumer(List<Integer>Buffer)
     {
         this.B=Buffer;
     }
     public void consume()throws InterruptedException
     {
       synchronized(B)
       {
           while(B.isEmpty())
           {
               System.out.println("Consumer is Waiting as Buffer is Empty");
               B.wait();
           }
       }
       synchronized(B)
       {
           B.remove(0);
           System.out.println("Consumer Consuming");
           Thread.sleep(250);
           B.notify();
       }
     }
     public void run()
     {
         try{
             while(true)
             {
                 consume();
             }
         }
         catch(Exception e)
         {
             System.out.println("Exception overcome"+e);     
         }
}
}
public class Producer_consumer_syn {
    public static void main(String[] args) {
        List<Integer> B=new ArrayList<Integer>();
        Thread p=new Thread(new producer(B));
        Thread c=new Thread(new Consumer(B));
        p.start();
        c.start();
    }
}
