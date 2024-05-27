import org.apache.commons.dbcp2.BasicDataSource;

public class App {

    public static void  main(String [] args){

        /* BasicDataSource dbSource = null;

        final String databaseName = "stormlight_archive";
        final String connectionStr = "jdbc:postgresql://localhost:5432/" + databaseName;

        dbSource = new BasicDataSource();
        dbSource.setUrl(connectionStr);
        dbSource.setUsername("postgres");
        dbSource.setPassword("postgres1");
        */

        Controller controller = new Controller();
        controller.run();
    }
}
