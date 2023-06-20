package org.example.models;

public class MenuItem {

    private String itemName;
    private int costInCents;

    public MenuItem(String name, int costInCents) {
        this.itemName = name;
        this.costInCents = costInCents;
    }

    // Note - this GET is not used. Intentionally left in the code - see README
    public String get_name() {
        return itemName;
    }

    public int get_costInCents() {
        return costInCents;
    }

}
