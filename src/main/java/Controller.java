import dao.*;
import model.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Controller {

    BasicDataSource dbSource = null;
    private ShardsDao shardsDao;
    private OrdersDao ordersDao;
    private LocationDao locationDao;
    private CharactersDao charactersDao;
    private OrdersCharactersDao ordersCharactersDao;
    private View view;

    public Controller(){

        final String databaseName = "stormlight_archive";
        final String connectionStr = "jdbc:postgresql://localhost:5432/" + databaseName;

        dbSource = new BasicDataSource();
        dbSource.setUrl(connectionStr);
        dbSource.setUsername("postgres");
        dbSource.setPassword("postgres1");

        this.dbSource = dbSource;

        this.shardsDao = new JdbcShardsDao(this.dbSource);
        this.ordersDao = new JdbcOrdersDao(this.dbSource);
        this.locationDao = new JdbcLocationDao(this.dbSource);
        this.charactersDao = new JdbcCharactersDao(this.dbSource);
        this.ordersCharactersDao = new JdbcOrdersCharactersDao(this.dbSource);
        this.view = new View();
    }

    public void run(){
        System.out.println("Running Code");


        boolean isRunning = true;

        view.displayMenuHeader();

        while(isRunning){

        // 1. Display menu options
            view.displayMenuOptions();

        // 2. get user selection from menu
            int userSelection = view.getUserSelection();

        // 3. execute menu options

            if(userSelection == 1 ){ // Characters Menu
                view.displayCharactersMenu();
                int characterSelection = view.getUserSelection();
                boolean characterSet = true;

                while(characterSet)
                    if(characterSelection ==1){ // View all Characters
                        List<Characters> characters = charactersDao.getCharacters();
                        view.displayCharacters(characters);
                        System.out.println();
                        characterSet = false;

                    } else if(characterSelection ==2){ // View Character by Id
                        int characterIdSelection = view.getUserSelection();
                        Characters character = charactersDao.getCharactersById(characterIdSelection);
                        view.displayCharacter(character);
                        System.out.println();
                        characterSet = false;

                    } else if(characterSelection ==3){ // View Character by current location
                        List<Location> locations = locationDao.getLocations();
                        System.out.println("Please select a Location by the Id number");
                        view.displayLocations(locations);

                        int characterIdSelection = view.getUserSelection();
                        List<Characters> characters = charactersDao.getCharactersByLocationId(characterIdSelection);
                        view.displayCharacters(characters);
                        System.out.println();
                        characterSet = false;

                    } else if(characterSelection ==4){ // Delete character by Id
                        List<Characters> characters = charactersDao.getCharacters();
                        System.out.println("Please select a Character by their Id number");
                        view.displayCharacters(characters);

                        int characterIdSelection = view.getUserSelection();
                        int numberOfRows = charactersDao.deleteCharactersById(characterIdSelection);
                        System.out.println();
                        characterSet = false;

                    } else if(characterSelection ==5){ // Update a character
                        Characters character = charactersDao.updateCharacters(view.displayUpdateCharacter());
                        List<Characters> characters = charactersDao.getCharacters();
                        view.displayCharacters(characters);
                        System.out.println();
                        characterSet = false;

                    } else if(characterSelection ==6){ // Create a new character
                        Characters character = charactersDao.createCharacters(view.addCreateCharacter());
                        List<Characters> characters = charactersDao.getCharacters();
                        view.displayCharacters(characters);
                        System.out.println();
                        characterSet = false;

                    } else if(characterSelection ==7){ // Exit back to main menu
                        characterSet = false;
                    } else {
                        view.displayInvalidChoice(characterSelection, 1, 7);
                    }

            } else if (userSelection == 2) { //Shards Menu
                /*
                 * Display Shards
                 * */
                view.displayShardsMenu();
                int shardSelection = view.getUserSelection();
                boolean shardSet = true;

                while(shardSet){
                    if(shardSelection ==1){ // View all shads
                        List<Shards> shards = shardsDao.getShards();
                        view.displayShards(shards);
                        System.out.println();
                        shardSet = false;
                    } else if(shardSelection ==2){ // Delete shards
                        List<Shards> shards = shardsDao.getShards();
                        System.out.println("Please select a Shard by their Id number");
                        System.out.println();
                        view.displayShards(shards);

                        int shardIdSelection = view.getUserSelection();
                        int numberOfRows = shardsDao.deleteShards(shardIdSelection);
                        System.out.println();
                        shardSet = false;

                    } else if(shardSelection ==3){ // update shards
                        shardsDao.updateShards(view.displayUpdateShard());
                        List<Shards> shards = shardsDao.getShards();
                        view.displayShards(shards);
                        System.out.println();
                        shardSet = false;

                    } else if(shardSelection ==4){ // create new shard
                        Shards shard = shardsDao.createShards(view.addCreateShard());
                        List<Shards> shards = shardsDao.getShards();
                        view.displayShards(shards);
                        System.out.println();
                        shardSet = false;

                    } else if(shardSelection ==5){ // Exit back to main menu
                        shardSet = false;
                    } else{
                        view.displayInvalidChoice(shardSelection,1,5);
                    }
                }


            } else if (userSelection == 3) { //Orders Menu

                /*
                 * Display Orders
                 *
                 * */
                view.displayOrdersMenu();
                int orderSelection = view.getUserSelection();
                boolean orderSet = true;

                while(orderSet){
                    if(orderSelection == 1){  //Display all the orders
                        List<Orders> orders = ordersDao.getOrders();
                        view.displayOrders(orders);
                        System.out.println();

                        orderSet = false;
                    } else if(orderSelection ==2){  //Display one order and all the characters id and their ideal
                        List<Orders> orders = ordersDao.getOrders();
                        view.displayOrders(orders);
                        System.out.println();

                        int orderIdSelection = view.getUserSelection();
                        List<OrdersCharacters> ordersCharacters = ordersCharactersDao.getOrderById(orderIdSelection);
                        view.displayOrdersCharacters(ordersCharacters);
                        orderSet = false;
                    } else if(orderSelection ==3){
                        orderSet = false;
                    } else{
                        view.displayInvalidChoice(orderSelection,1,4);
                    }
                }





            } else if (userSelection == 4) { // Location Menu
                /*
                 * Display Location
                 * */
                List<Location> locations = locationDao.getLocations();
                view.displayLocations(locations);
                System.out.println();

            } else if (userSelection == 5) {
                /*
                * Quit
                * */
                isRunning = false;

            } else{
                view.displayInvalidChoice(userSelection, 1, 5);
            }
        }
        this.view.displayExitMessage();


    }
}
