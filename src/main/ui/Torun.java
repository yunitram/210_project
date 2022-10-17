package ui;

import model.Character;
import model.CharacterList;
import model.Tier;
import model.TierList;

import java.util.Scanner;

// Tierlist application
public class Torun {
    private Scanner input;
    private Scanner input1;
    CharacterList characterList = new CharacterList();
    TierList tierList = new TierList();

    // effects: runs tierlist programme
    public Torun() {
        setup();
    }

    //requires: nothing
    // modifies: nothing
    // effects: prints all the base tiers, then the base characters
    public void printTiersandChar() {
        tierList.printTiers();
        characterList.printCharacters();
    }

    // requires: nothing
    // modifies: tierList and characterList
    // effects: creates a tierlist with tiers S - D and creates a characterlist with 5 characters
    public void createTiersandChar() {
        tierList.createElList();
        characterList.createCharacters();
        input = new Scanner(System.in);
        input1 = new Scanner(System.in);

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
    }

    // requires: nothing
    // modifies: tierList, characterList
    // effect adds a character to a specified tier
    private void addfn() {
        System.out.println("enter character name");
        String charname = input.next();
        System.out.println("enter tier name");
        String tiername = input1.next();
        tierList.findTier(tiername).addCharacter(characterList.findChar(charname)); //adds the character to the tier
        characterList.removeCharacter(charname); // returns a list of characters without the charname
    }

    // requires: nothing
    // modifies: tierList, characterList
    // effect: removes a character to a specified tier
    private void removefn() {
        Tier n;
        System.out.println("enter character name");
        String charname = input.next();
        System.out.println("enter tier name");
        String tiername = input1.next();
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
        newname = input.next();
        System.out.println("Character description:");
        input1.nextLine();
        newdesc = input1.nextLine();
        Character sheesh = new Character(newname, newdesc);
        characterList.addChar(sheesh);
    }

    // requires: nothing
    // modifies: tierList
    // effects: promts the user to create a Tier name, adds an empty tier to the tierlist
    private void createtierfn() {
        String newname;
        System.out.println("Tier name:");
        newname = input.next();
        tierList.addTier(newname);
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
            command = input.next();
            if (command.equals("n")) {
                System.out.println("thank you! goodbye :)");
                keepgoing = false;
            } else {
                this.askwhichAction();
                command = input.next();
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
                }
            }
        }
    }
}
