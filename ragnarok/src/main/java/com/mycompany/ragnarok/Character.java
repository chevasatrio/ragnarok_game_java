/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ragnarok;

/**
 *
 * @author Cheva
 */
public class Character {
    protected String name;
    protected int health;
    protected int XP;
    protected String item;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.XP = 0;
        this.item = "None";
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void addXP(int xp) {
        this.XP += xp;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getXP() { return XP; }
    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }
}




