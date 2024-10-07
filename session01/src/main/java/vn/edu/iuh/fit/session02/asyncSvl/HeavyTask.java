package vn.edu.iuh.fit.session02.asyncSvl;

public class HeavyTask {

    public String xuly(String p1, String p2){
        //........
        //....
        try {
            for (int i = 0; i < 100; i++){

                Thread.sleep(100);
            }
//            Thread.sleep(10*10000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return "result";
    }
}
