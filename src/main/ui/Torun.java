package ui;

import model.Character;
import model.CharacterList;
import model.Tier;
import model.TierList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Tierlist application
// Some code was taken from the sample application
public class Torun extends JFrame implements ActionListener {
    private static final int WIDTH = 1300;
    private static final int HEIGHT = 1300;
    private static final int BIGFONT = 20;
    private Scanner input;
    private CharacterList characterList;
    TierList tierlist;
    private TierList tierList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/tierlist.json";
    JLabel tierLabel;
    JLabel characterLabel;
    JLabel inputLabel;
    JFrame frame;
    JButton saveButton;
    JButton loadButton;
    JButton addButton;
    JButton removeButton;
    JPanel viewerPanel;
    JPanel mainPanel;
    JPanel charactersPanel;
    JPanel tierPanel;
    JPanel buttonPanel;
    JPanel inputPanel;
    CardLayout cardLayout;
    String userinput;
    String userinput1;
    JButton quitButton;

    // effects: runs tierlist programme
    public Torun() {
        userinput = "";
        input = new Scanner(System.in);
        tierList = new TierList("Tierlist 1");
        tierList.createElList();
        characterList = new CharacterList();
        characterList.createCharacters();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        makeButtons();
        tierPanel();
        characterPanel();
        buttonPanel();
        inputPanel();
        initializePanel();
    }


    public void tierPanel() {
        tierPanel = new JPanel();
        tierLabel = new JLabel();
        tierLabel.setText(tierList.printTiers());
        tierLabel.setFont(new Font("Average", Font.BOLD, BIGFONT));
        tierLabel.setHorizontalAlignment(SwingConstants.LEFT);
        tierLabel.setForeground(Color.WHITE);
        tierPanel.setBackground(Color.BLACK);
        tierLabel.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        tierPanel.setLayout(new GridLayout());
        tierPanel.add(tierLabel);
    }

    public void inputPanel() {
        inputPanel = new JPanel();
        inputLabel = new JLabel();
        inputLabel.setText(userinput);
        inputLabel.setFont(new Font("Average", Font.BOLD, BIGFONT));
        inputLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputLabel.setForeground(Color.WHITE);
        inputPanel.setMinimumSize(new Dimension(100, 100));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setLayout(new GridLayout());
        inputPanel.add(inputLabel);
    }

    public void characterPanel() {
        charactersPanel = new JPanel();
        characterLabel = new JLabel();
        characterLabel.setText(characterList.printCharacters());
        characterLabel.setFont(new Font("Average", Font.BOLD, BIGFONT));
        characterLabel.setHorizontalAlignment(SwingConstants.LEFT);
        characterLabel.setForeground(Color.WHITE);
        charactersPanel.setBackground(Color.BLACK);
        charactersPanel.setMinimumSize(new Dimension(100, 100));
        charactersPanel.setLayout(new GridLayout());
        charactersPanel.add(characterLabel);
    }

    public void buttonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.setMinimumSize(new Dimension(WIDTH,
                HEIGHT));
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(quitButton);
    }

    public void makeButtons() {
        saveButton = new JButton("Save to file");
        setupButton(saveButton, "Save to file");

        loadButton = new JButton("Load from file");
        setupButton(loadButton, "Load from file");

        addButton = new JButton("Add character to a tier");
        setupButton(addButton, "Add character to a tier");

        removeButton = new JButton("Remove character from a tier");
        setupButton(removeButton, "Remove character from a tier");

        quitButton = new JButton("Quit programme");
        setupButton(quitButton, "Quit programme");
    }

    // MODIFIES: this
    //EFFECTS: sets up an individual button b with ActionCommand s
    private void setupButton(JButton b, String s) {
        b.setFont(new Font("Average", Font.BOLD, BIGFONT));
        b.setHorizontalAlignment(SwingConstants.CENTER);
        b.setForeground(Color.WHITE);
        b.setBackground(Color.BLACK);
        b.addActionListener(this);
        b.setPreferredSize(new Dimension(500, BIGFONT + 10));
        b.setMaximumSize(new Dimension(500, BIGFONT + 10));
        b.setMinimumSize(new Dimension(500, BIGFONT + 10));
        b.setActionCommand(s);
    }

    // MODIFIES: this
    // EFFECTS: sets up window graphic components in initial state
    private void initializePanel() {
        setLayout(new BorderLayout());
        setUndecorated(false);
        setTitle("TierList");
        cardLayout = new CardLayout();
        viewerPanel = new JPanel();
        viewerPanel.add(tierPanel, "tierPanel");
        viewerPanel.add(charactersPanel, "charactersPanel");
        viewerPanel.add(buttonPanel, "buttonPanel");
        viewerPanel.add(inputPanel, "inputPanel");


        add(viewerPanel, BorderLayout.CENTER);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setResizable(true);
        setVisible(true);
        centreOnScreen();
    }

    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Save to file":
                this.saveTierList();
                break;
            case "Load from file":
                this.loadTierList();
                break;
            case "Add character to a tier":
                this.addfn();
                break;
            case "Remove character from a tier":
                this.removefn();
                break;
            case "Quit programme":
                System.exit(0);
        }
    }

//    //requires: nothing
//    // modifies: nothing
//    // effects: prints all the base tiers, then the base characters
//    public void printTiersandChar() {
//        System.out.println(tierList.printTiers());
//        System.out.println(characterList.printCharacters());
//    }
//
//    // requires: nothing
//    // modifies: tierList and characterList
//    // effects: creates a tierlist with tiers S - D and creates a characterlist with 5 characters
//    public void createTiersandChar() {
//        tierList.createElList();
//        characterList.createCharacters();
//        input = new Scanner(System.in);
//
//    }

    // requires: nothing
    // modifies: nothing
    // effect: asks the user whether they want to take action with the tierlist
//    private void askifAction() {
//        System.out.println("would you like to take action?");
//        System.out.println("y -> yes");
//        System.out.println("n -> no");
//    }

    // requires: nothing
    // modifies: nothing
    // asks user which operation they would like to do
//    private void askwhichAction() {
//        System.out.println("which operation would you like to do?");
//        System.out.println("add -> add character to a Tier");
//        System.out.println("remove -> remove character from a tier");
//        System.out.println("createchar -> create a new character");
//        System.out.println("createtier -> create a new tier");
//        System.out.println("save -> save your current tierlist");
//        System.out.println("load -> load a tierlist");
//
//    }

    // requires: nothing
    // modifies: tierList, characterList
    // effect adds a character to a specified tier
    private void addfn() {
        userinput = JOptionPane.showInputDialog(tierPanel, "enter character name", null);
        userinput1 = JOptionPane.showInputDialog(tierPanel, "enter tier name", null);
        tierList.findTier(userinput1).addCharacter(characterList.findChar(userinput)); //adds the character to the tier
        characterList.removeCharacter(userinput); // returns a list of characters without the charname
        tierLabel.setText(tierList.printTiers());
        characterLabel.setText(characterList.printCharacters());
    }

    // requires: nothing
    // modifies: tierList, characterList
    // effect: removes a character to a specified tier
    private void removefn() {
        Tier n;
        userinput = JOptionPane.showInputDialog(tierPanel, "enter character name", null);
        userinput1 = JOptionPane.showInputDialog(tierPanel, "enter tier name", null);
        n = tierList.findTier(userinput1);
        characterList.addChar(n.findCharintier(userinput));
        n.removeCharacterfromtier(userinput);
        tierLabel.setText(tierList.printTiers());
        characterLabel.setText(characterList.printCharacters());
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

    // requires: nothing
    // modifies: nothing
    // effect: saves tierlist to file
    private void saveTierList() {
        try {
            jsonWriter.open();
            jsonWriter.write(tierList);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // requires: nothing
    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadTierList() {
        try {
            tierList = jsonReader.read();
            characterList.removeCharacters(characterList, jsonReader.find());
            System.out.println("Loaded " + tierList.getName() + " from " + JSON_STORE);
            tierLabel.setText(tierList.printTiers());
            characterLabel.setText(characterList.printCharacters());
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }



    // requires: nothing
    // modifies: this
    // effects: prints menu layout and processes user input
//    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
//    public void setup() {
//        this.createTiersandChar();
//        boolean keepgoing = true;
//        String command;
//        while (keepgoing) {
//            this.printTiersandChar();
//            this.askifAction();
//            command = input.nextLine();
//            if (command.equals("n")) {
//                System.out.println("thank you! goodbye :)");
//                keepgoing = false;
//            } else {
//                this.askwhichAction();
//                command = input.nextLine();
//                switch (command) {
//                    case "add":
//                        this.addfn();
//                        break;
//                    case "remove":
//                        this.removefn();
//                        break;
//                    case "createchar":
//                        this.createcharfn();
//                        break;
//                    case "createtier":
//                        this.createtierfn();
//                        break;
//                    case "save":
//                        this.saveTierList();
//                        break;
//                    case "load":
//                        this.loadTierList();
//                        break;
//                }
//            }
//        }
//    }
}
