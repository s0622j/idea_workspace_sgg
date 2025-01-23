package java14.test2;

public class TestDeadLock {
    public static void main(String[] args) {
        LockSmith lockSmith = new LockSmith();
        Owner owner = new Owner();
        DeadLockThread dt1 = new DeadLockThread(lockSmith,owner,true);// 锁匠线程
        DeadLockThread dt2 = new DeadLockThread(lockSmith,owner,false);// 业主线程
        dt1.start();
        dt2.start();
    }
}

class LockSmith{
    public void say(){
        System.out.println("你给我看房本，我给你开门");
    }
    public void work(){
        System.out.println("给你开门");
    }
}

class Owner{
    public void say(){
        System.out.println("你给我开门，我给你开房本");
    }
    public void work(){
        System.out.println("给你看房本");
    }
}

class DeadLockThread extends Thread{
    private LockSmith lockSmith;
    private Owner owner;
    private boolean flag;

    public DeadLockThread(LockSmith lockSmith,Owner owner,boolean flag){
        this.lockSmith = lockSmith;
        this.owner = owner;
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag){
            // 锁匠线程
            synchronized (lockSmith){
                lockSmith.say();
                synchronized (owner){
                    lockSmith.work();
                }
            }
        }else{
            // 业主线程
            synchronized (owner){
                owner.say();
                synchronized (lockSmith){
                    owner.work();
                }
            }
        }
    }
}
