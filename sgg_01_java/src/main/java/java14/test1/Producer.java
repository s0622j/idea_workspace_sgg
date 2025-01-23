package java14.test1;

public class Producer extends Thread {
    private Stone stone;
    public Producer(Stone stone){
        this.stone = stone;
    }
    @Override
    public void run() {
        while (true){
            stone.add();
        }
    }
}
