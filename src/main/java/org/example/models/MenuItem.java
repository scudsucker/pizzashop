package org.example.models;

public class MenuItem {

    private String _name;
    private int _costInCents;

    public MenuItem(String name, int costInCents) {
        this._name = name;
        this._costInCents = costInCents;
    }

    public String get_names() {
        return _name;
    }

    public int get_costInCents() {
        return _costInCents;
    }

}
