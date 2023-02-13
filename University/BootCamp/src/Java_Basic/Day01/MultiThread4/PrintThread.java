package Java_Basic.Day01.MultiThread4;

class PrintThread extends Thread
{
    SharedArea sharedArea;
    public void run()
    {
        //try{
        //Thread.sleep(1000);
        //}catch(InterruptedException e)
        //{
        //System.out.println(
        //		e.getMessage()) ;
        //}
        System.out.println(
                sharedArea.result);
    }
}