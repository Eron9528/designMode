package cn.bingfa.futuremode;

public class FutureData implements Data{

    protected RealData realData = null;
    protected boolean isReady = false;

    public synchronized void setReadData(RealData readData){
        if (isReady) {
            return;
        }
        this.realData = readData;
        isReady = true;
        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        while(!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "realData.result";
    }
}
