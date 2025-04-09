/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ragnarok;

/**
 *
 * @author Cheva
 */
public class Warrior extends Character {
    private int attackPower;

    public Warrior(String name) {
        super(name, 120); // HP lebih tinggi
        this.attackPower = 20;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage / 2); // tahan damage
    }
}

