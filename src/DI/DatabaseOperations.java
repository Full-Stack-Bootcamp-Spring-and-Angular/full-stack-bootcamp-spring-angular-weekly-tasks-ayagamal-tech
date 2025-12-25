package DI;

public class DatabaseOperations implements DB{


    @Override
    public void connectToDatabase() {
        System.out.println("connection to database established ……");
    }

    @Override
    public void disconnectFromDatabase() {
        System.out.println("connection to database closed……");
    }
}
