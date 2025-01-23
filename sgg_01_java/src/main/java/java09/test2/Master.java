package java09.test2;

public class Master {

    public void playWithPet(Pet pet){
        // instanceof左侧一定是一个对象，右侧一定是一个类
        // 如果左侧的这个对象是右侧这类的对象或者是右侧这个类的子类的对象则返回true，否则返回false
        if(pet instanceof Dog){
            Dog dog = (Dog)pet;
            dog.work();
            dog.play();
        }else {
            pet.play();
        }

    }

}
