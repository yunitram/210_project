package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// represents the whole Tierlist, consists of a list of tiers
public class TierList {
    final List<Tier> tiersList;

    // requires: nothing
    // modifies: nothing
    // effects: constructs a Tierlist with an empty list of Tiers
    public TierList() {
        this.tiersList = new ArrayList<>();
    }

    // requires: nothing
    // modifies: this
    // effects: adds a tier with a name and empty characterlist to the tierlist
    public void addTier(String t) {
        Tier newbie = new Tier();
        newbie.renameTier(t);
        this.tiersList.add(newbie);
    }

    public void swapTiers(String s, String t) {
        Integer w = this.getPos(s);
        Integer x = this.getPos(t);
        Collections.swap(this.tiersList, w, x);
    }

    // takes a name of Tier, produces index position of that Tier in the TierList
    public Integer getPos(String s) {
        int w = 0;
        for (int count = 0; count < this.tiersList.size(); count++) {
            if (this.tiersList.get(count).getName().equals(s)) {
                w = count;
            }
        }
        return w;
    }


    // requires: nothing
    // modifies: this
    // effects: adds tiers S - D to the tierlist
    public void createElList() {
        Tier s = new Tier();
        s.renameTier("S");
        this.addTier("S");
        Tier a = new Tier();
        a.renameTier("A");
        this.addTier("A");
        Tier b = new Tier();
        b.renameTier("B");
        this.addTier("B");
        Tier c = new Tier();
        c.renameTier("C");
        this.addTier("C");
        Tier d = new Tier();
        d.renameTier("D");
        this.addTier("D");
    }

    // requires: nothing
    // modifies: nothing
    // effects: prints all tiers and their characterlists in the tierlist
    public void printTiers() {
        for (Tier tier : this.tiersList) {
            tier.tierandchars();
        }
    }

    // requires: name of tier must be in the tierlist
    // modifies nothing
    // effects: returns the tier associated with the given name
    public Tier findTier(String ch) {
        int w = 0;
        for (int count = 0; count < this.tiersList.size(); count++) {
            if (tiersList.get(count).getName().equals(ch)) {
                w = count;
            }
        } // finds index location of tier
        return this.tiersList.get(w); // returns tier
    }

}