package java18.test1;

public class TestOne {
    public static void main(String[] args) {
        MyData myData = new MyData();
        User user = new User("Tom","123456",1);
        Book book = new Book("西游记","吴承恩",50.25);

        myData.setUser(user);
        User u = myData.getUser();
        System.out.println(u);
        myData.setBook(book);
        Book b = myData.getBook();
        System.out.println(b);

        MyDataOne mdo = new MyDataOne();
        mdo.setData(user);
        User u1 = (User)mdo.getData();
        System.out.println(u1);
        mdo.setData(u1);
        Book book1 = (Book)mdo.getData();
        System.out.println(book1);

    }
}
