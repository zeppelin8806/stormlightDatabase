import dao.OrdersCharactersDao;
import model.*;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class View {

    private Scanner scanner = new Scanner(System.in);

    public void displayMenuHeader() {
        try{
            System.out.println("Welcome to the Cosmere!!");
            TimeUnit.SECONDS.sleep(2);

        } catch (InterruptedException e){
            System.out.println("Time took too long.");
        }

    }
    public void displayMenuOptions() {

        try{
            System.out.println("---------------------------");
            System.out.println("Please select from the following menu: ");
            System.out.println("---------------------------");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1. Select from characters");
            System.out.println("2. Select from known shards");
            System.out.println("3. View the Orders of the Knights Radiant");
            System.out.println("4. View the major cities of Roshar");
            System.out.println("5. Exit");
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e){
            System.out.println("Time took too long.");
        }

    }

    public int getUserSelection() {
        int userSelection = 0;

        while (true){
            try{
                System.out.println("Please enter a number: ");
                String choice = scanner.nextLine();
                userSelection = Integer.parseInt(choice);
                break;
            } catch (NumberFormatException e){
                System.out.println("Please enter a number...");
            }
        }
        return userSelection;
    }

//**********************************************
    //CHARACTER MENUS
//**********************************************
    public void displayCharactersMenu(){
        try{
            System.out.println("---------------------------");
            System.out.println("Please select from the following Character menu: ");
            System.out.println("---------------------------");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1. View all characters");
            System.out.println("2. View character by id");
            System.out.println("3. View characters by current Location");
            System.out.println("4. Delete character by id");
            System.out.println("5. Update a character");
            System.out.println("6. Create a new character");
            System.out.println("7. Exit");

        } catch (InterruptedException e){
            System.out.println("Time took too long.");
        }
    }

    public void displayCharacters(List<Characters> characters) {
        String heading1 = "  Id  Name                      Gender        Nationality           Location Id";
        String heading2 = "====  ========================  ============  ====================  ===========";
        String formatString = "%4d  %-24s  %-12s  %-20s  %11s";
        System.out.println(heading1);
        System.out.println(heading2);
        for (Characters character : characters) {
            String s = String.format(formatString,
                    character.getCharacterId(),
                    character.getName(),
                    character.getGender(),
                    character.getNationality(),
                    character.getLocationId()
            );
            System.out.println(s);
        }
    }
    public void displayCharacter(Characters characters) {
        String heading1 = "  Id  Name                      Gender        Nationality           Location Id";
        String heading2 = "====  ========================  ============  ====================  ===========";
        String formatString = "%4d  %-24s  %-12s  %-20s  %11s";
        System.out.println(heading1);
        System.out.println(heading2);
        String s = String.format(formatString,
                characters.getCharacterId(),
                characters.getName(),
                characters.getGender(),
                characters.getNationality(),
                characters.getLocationId()
        );
        System.out.println(s);
    }
    public Characters addCreateCharacter(){

        System.out.println("Please enter a new Characters name: ");
        String name = scanner.nextLine();

        System.out.println("Please enter their Gender: ");
        String gender = scanner.nextLine();

        System.out.println("Please enter their nationality: ");
        String nationality = scanner.nextLine();

        System.out.println("Please enter their current location by the location Id: ");
        String locationTemp = scanner.nextLine();
        int location = Integer.parseInt(locationTemp);

        Characters character = new Characters(99, name, gender, nationality,location);


        return character;
    }
    public Characters displayUpdateCharacter(){
        System.out.println("Please enter the Id of and existing Character: ");
        String idTemp = scanner.nextLine();
        int characterId = Integer.parseInt(idTemp);

        System.out.println("Please enter a Characters new or existing name: ");
        String name = scanner.nextLine();

        System.out.println("Please enter their Gender: ");
        String gender = scanner.nextLine();

        System.out.println("Please enter their nationality: ");
        String nationality = scanner.nextLine();

        System.out.println("Please enter their new location by the location Id: ");
        String locationTemp = scanner.nextLine();
        int location = Integer.parseInt(locationTemp);

        Characters character = new Characters(characterId, name, gender, nationality,location);


        return character;
    }
//**********************************************
    //CHARACTER MENUS
//**********************************************

//**********************************************
    //SHARDS MENUS
//**********************************************
    public void displayShardsMenu(){
        try{
            System.out.println("---------------------------");
            System.out.println("Please select from the following Shards menu: ");
            System.out.println("---------------------------");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1. View all Shards");
            System.out.println("2. Delete Shard by id");
            System.out.println("3. Update a Shard");
            System.out.println("4. Create a new Shard");
            System.out.println("5. Exit");

        } catch (InterruptedException e){
            System.out.println("Time took too long.");
        }
    }


    public void displayShards(List<Shards> shards) {
        String heading1 = "  Id  Name                      Type                  Character Id";
        String heading2 = "====  ========================  ====================  ============";
        String formatString = "%4d  %-24s  %-20s  %12s";
        System.out.println(heading1);
        System.out.println(heading2);
        for (Shards shard : shards) {
            String s = String.format(formatString,
                    shard.getShardbladeId(),
                    shard.getShardbladeName(),
                    shard.getShardbladeType(),
                    shard.getCharacterId()
            );
            System.out.println(s);
        }
    }
    public Shards addCreateShard() {

        System.out.println("Please enter a new nane for the Shard: ");
        String name = scanner.nextLine();

        System.out.println("Please enter the Shard Type (Dead Shardblade, Honorblade, Living Shardblade, Shardplate: ");
        String type = scanner.nextLine();

        System.out.println("Please enter the Character that welds this Shard by the Character's Id: ");
        String locationTemp = scanner.nextLine();
        int characterId = Integer.parseInt(locationTemp);

        Shards shard = new Shards(99, name, type, characterId);

        return shard;
    }
    public Shards displayUpdateShard(){
        System.out.println("Please enter the Id of and existing Shard: ");
        String idTemp = scanner.nextLine();
        int shardbladeId = Integer.parseInt(idTemp);

        System.out.println("Please enter a new or existing Shard name: ");
        String name = scanner.nextLine();

        System.out.println("Please enter a new Shard Type (Dead Shardblade, Honorblade, Living Shardblade, Shardplate: ");
        String type = scanner.nextLine();

        System.out.println("Please enter a new or existing Character that welds this Shard by the Character's Id: ");
        String locationTemp = scanner.nextLine();

        int characterId = Integer.parseInt(locationTemp);

        Shards shard = new Shards(shardbladeId, name, type, characterId);

        return shard;
    }
//**********************************************
    //SHARDS MENUS
//**********************************************
//**********************************************
    //ORDERS MENUS
//**********************************************

    public void displayOrdersMenu(){// DISPLAY ORDER MENU
        try{
            System.out.println("---------------------------");
            System.out.println("Please select from the following Orders menu: ");
            System.out.println("---------------------------");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("1. View all Orders");
            System.out.println("2. View Order members by Order Id");
            System.out.println("3. Exit");

        } catch (InterruptedException e){
            System.out.println("Time took too long.");
        }
    }

    public void displayOrders(List<Orders> orders) {
        String heading1 = "  Id  Name           ";
        String heading2 = "====  ===============";
        String formatString = "%4d  %15s";
        System.out.println(heading1);
        System.out.println(heading2);
        for (Orders order : orders) {
            String s = String.format(formatString,
                    order.getOrderId(),
                    order.getName()
            );
            System.out.println(s);
        }

    }
    public void displayOrdersCharacters(List<OrdersCharacters> ordersCharacters) {
        String heading1 = "Order Name       Character Name            Ideal";
        String heading2 = "===============  ========================  =====";
        String formatString = "%-15s  %-24s  %5d";
        System.out.println(heading1);
        System.out.println(heading2);
        for (OrdersCharacters orderCharacter : ordersCharacters) {
            String s = String.format(formatString,
                    orderCharacter.getOrderName(),
                    orderCharacter.getCharacterName(),
                    orderCharacter.getIdeal()
            );
            System.out.println(s);
        }

    }



//**********************************************
    //ORDERS MENUS
//**********************************************
//**********************************************
    //LOCATION MENUS
//**********************************************

    public void displayLocations(List<Location> locations) {
        String heading1 = "  Id  Name             Population";
        String heading2 = "====  ===============  ==========";
        String formatString = "%4d  %-15s  %10s";
        System.out.println(heading1);
        System.out.println(heading2);
        for (Location location : locations) {
            String s = String.format(formatString,
                    location.getLocation_id(),
                    location.getName(),
                    location.getPopulation()
            );
            System.out.println(s);
        }
    }
//**********************************************
    //LOCATION MENUS
//**********************************************

    public void displayExitMessage() {
    }

    public void displayInvalidChoice(int selection, int minValue, int maxValue) {
        try{
            System.out.println(selection + " is not a valid choice");
            System.out.println("Please choose again a number from " + minValue + " to " + maxValue);
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e){
            System.out.println("Time took too long.");
        }
    }
}
