package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// represents the whole Tierlist, consists of a list of tiers
public class TierList implements Writable {
    final List<Tier> tiersList;
    private String name;

    // requires: nothing
    // modifies: nothing
    // effects: constructs a Tierlist with an empty list of Tiers
    public TierList(String name) {
        this.name = name;
        tiersList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Tier> getTiers() {
        return this.tiersList;
    }

    // requires: nothing
    // modifies: this
    // effects: adds a tier with a name and empty characterlist to the tierlist
    public void addTier(String t) {
        Tier newbie = new Tier();
        newbie.renameTier(t);
        this.tiersList.add(newbie);
    }

    public void addFilledTier(Tier t) {
        this.tiersList.add(t);
    }

    // method is unused currently but keeping it in case I want to add a swap function
    // requires: names of two existing tiers
    // modifies: this
    // effects: swaps the positions of the tiers
    public void shiftTiers(String s, String t) {
        int w = this.getPos(s);
        int x = this.getPos(t);
        if (w > x) {
            tiersList.add(x, findTier(s));
            tiersList.remove(w + 1);
        } else if (x > w) {
            tiersList.add(x, findTier(s));
            tiersList.remove(w);
        }
        EventLog.getInstance().logEvent(new Event("Tiers shifted"));
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
    public String printTiers() {
        String s = "<html><p>";
        for (Tier tier : this.tiersList) {
            s = s.concat(tier.tierandchars()).concat("<html><p>");
        }
        return s;
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

    // requires: nothing
    // modifies: nothing
    // effects: converts tierlist into a JSONObject
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("tiers", tierListToJason());
        return json;
    }

    // requires: nothing
    // modifies: nothing
    // effects: places each tier in a tierlist into a JSONArray
    private JSONArray tierListToJason() {
        JSONArray jsonArray = new JSONArray();
        for (Tier t : tiersList) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }
}
