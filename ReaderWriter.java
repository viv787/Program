import java.util.concurrent.Semaphore;
public class ReaderWriter {
    static Semaphore wrt = new Semaphore(1);
    static Semaphore mutex = new Semaphore(1);
    static int ReadCount = 0 ;

    static class Reader extends Thread{
        public void run(){
            try{
                mutex.acquire();
                ReadCount++;
                if(ReadCount==1)
                    wrt.acquire();
                    mutex.release();

                    System.out.println(Thread.currentThread().getName()+ " is reading ");
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + " finished reading");

                    mutex.acquire();
                    ReadCount-- ;
                    if (ReadCount == 0)
                        wrt.release();
                        mutex.release();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    }
                }

                static class Writer extends Thread{
                    public void run() {
                        try{
                            wrt.acquire();
                            System.out.println(Thread.currentThread().getName() + " is writing ");
                            Thread.sleep(500);
                            System.out.println(Thread.currentThread().getName() + " finished writing ");
                            wrt.release();
                        } catch (Exception e){
                            System.out.println(e);
                        }
                        }
                    }

                    public static void main (String[]args){
                        Reader r1 = new Reader();
                        Reader r2 = new Reader();
                        Writer w1 = new Writer();
                        Writer w2 = new Writer();

                        r1.setName("Reader 1");
                        r2.setName("Reader 2");
                        w1.setName("Writer 1");
                        w2.setName("Writer 2");

                        r1.start();
                        w1.start();
                        r2.start();
                        w2.start();
                    }
                    
                       
                    

                }
            
        
    



    

