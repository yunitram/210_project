package ui;

import model.Character;
import model.CharacterList;
import model.Tier;
import model.TierList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Tierlist application
public class Torun {
    private Scanner input;
    private CharacterList characterList;
    private TierList tierList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/tierlist.json";

    // effects: runs tierlist programme
    public Torun() {
        input = new Scanner(System.in);
        tierList = new TierList("Tierlist 1");
        characterList = new CharacterList();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        setup();
    }

    //requires: nothing
    // modifies: nothing
    // effects: prints all the base tiers, then the base characters
    public void printTiersandChar() {
        System.out.println(tierList.printTiers());
        System.out.println(characterList.printCharacters());
    }

    // requires: nothing
    // modifies: tierList and characterList
    // effects: creates a tierlist with tiers S - D and creates a characterlist with 5 characters
    public void createTiersandChar() {
        tierList.createElList();
        characterList.createCharacters();
        input = new Scanner(System.in);

    }

    // requires: nothing
    // modifies: nothing
    // effect: asks the user whether they want to take action with the tierlist
    private void askifAction() {
        System.out.println("would you like to take action?");
        System.out.println("y -> yes");
        System.out.println("n -> no");
    }

    // requires: nothing
    // modifies: nothing
    // asks user which operation they would like to do
    private void askwhichAction() {
        System.out.println("which operation would you like to do?");
        System.out.println("add -> add character to a Tier");
        System.out.println("remove -> remove character from a tier");
        System.out.println("createchar -> create a new character");
        System.out.println("createtier -> create a new tier");
        System.out.println("save -> save your current tierlist");
        System.out.println("load -> load a tierlist");

    }

    // requires: nothing
    // modifies: tierList, characterList
    // effect adds a character to a specified tier
    private void addfn() {
        System.out.println("enter character name");
        String charname = input.nextLine();
        System.out.println("enter tier name");
        String tiername = input.nextLine();
        tierList.findTier(tiername).addCharacter(characterList.findChar(charname)); //adds the character to the tier
        characterList.removeCharacter(charname); // returns a list of characters without the charname
    }

    // requires: nothing
    // modifies: tierList, characterList
    // effect: removes a character to a specified tier
    private void removefn() {
        Tier n;
        System.out.println("enter character name");
        String charname = input.nextLine();
        System.out.println("enter tier name");
        String tiername = input.nextLine();
        n = tierList.findTier(tiername);
        characterList.addChar(n.findCharintier(charname));
        n.removeCharacterfromtier(charname);
    }

    // requires: nothing
    // modifies: characterList
    // effects: prompts the user to create a character name and description, adds the character to characterList
    private void createcharfn() {
        String newname;
        String newdesc;
        System.out.println("Character name:");
        newname = input.nextLine();
        System.out.println("Character description:");
        newdesc = input.nextLine();
        Character sheesh = new Character(newname, newdesc);
        characterList.addChar(sheesh);
    }

    // requires: nothing
    // modifies: tierList
    // effects: promts the user to create a Tier name, adds an empty tier to the tierlist
    private void createtierfn() {
        String newname;
        System.out.println("Tier name:");
        newname = input.nextLine();
        tierList.addTier(newname);
    }

    private void saveWorkRoom() {
        try {
            jsonWriter.open();
            jsonWriter.write(tierList);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadWorkRoom() {
        try {
            tierList = jsonReader.read();
            characterList.removeCharacters(characterList, jsonReader.find());
            System.out.println("Loaded " + tierList.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }



    // requires: nothing
    // modifies: this
    // effects: prints menu layout and processes user input
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void setup() {
        this.createTiersandChar();
        boolean keepgoing = true;
        String command;
        while (keepgoing) {
            this.printTiersandChar();
            this.askifAction();
            command = input.nextLine();
            if (command.equals("n")) {
                System.out.println("thank you! goodbye :)");
                keepgoing = false;
            } else {
                this.askwhichAction();
                command = input.nextLine();
                switch (command) {
                    case "add":
                        this.addfn();
                        break;
                    case "remove":
                        this.removefn();
                        break;
                    case "createchar":
                        this.createcharfn();
                        break;
                    case "createtier":
                        this.createtierfn();
                        break;
                    case "save":
                        this.saveWorkRoom();
                        break;
                    case "load":
                        this.loadWorkRoom();
                        break;
                }
            }
        }
    }
}
