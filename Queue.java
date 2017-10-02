// Queue.java
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
public class Queue
   {
   public int maxSize;         //isi maksimal
   public long[] queArray;     //
   private int front;           // awal
   private int rear;            // akhir
   private int nItems;          // Jumlah Isi
   
   
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize]; //Array buat menambung
      front = 0;
      rear = -1;
      nItems = 0;
      }
//--------------------------------------------------------------
   public void insert(long j)   // put item at rear of queue
      {
      if(rear != maxSize-1){         // deal with wraparound
          queArray[++rear] = j; 
      }  
      else{
          ++rear;
          maxSize++;          
          
          //Buat Array untuk tempat transit
          long[] a = new long[maxSize];
          
          //Titip Array
          for (int i = 0; i < queArray.length; i++) {
              a[i] = queArray[i];
          }
          
          
          a[a.length-1] = j;
          
          //Buat Array Baru dengan nama yang sama tapi parameternya ditambah
          queArray = new long[maxSize];
          
          //Isi ulang Array
          for (int i = 0; i < queArray.length; i++) {
              queArray[i] = a[i];
          }
      }
      nItems++;
   }
//--------------------------------------------------------------
   public long remove()         // take item from front of queue
      {
      
      long temp = queArray[front++]; // get value and incr front
      
      if(front == maxSize){           // deal with wraparound
         front = 0;
      }
      
      nItems--;                      // one less item
      
      return temp;
      
    }
//--------------------------------------------------------------
   public long peekFront()      // peek at front of queue
      {
      return queArray[front];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public int size()           // number of items in queue
      {
      return nItems;
      }
//--------------------------------------------------------------
   
   
   }  // end class Queue
////////////////////////////////////////////////////////////////
