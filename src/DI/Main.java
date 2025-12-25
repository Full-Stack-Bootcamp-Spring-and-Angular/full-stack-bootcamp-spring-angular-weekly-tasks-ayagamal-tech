import DI.DatabaseOperations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

void main() {
    // define container
    ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");

    DatabaseOperations databaseOperations = container.getBean("DBoperations",DatabaseOperations.class);
    //databaseOperations.connectToDatabase();
    //databaseOperations.disconnectFromDatabase();

    // Stop for destroy
    ((ClassPathXmlApplicationContext)container).close();

}