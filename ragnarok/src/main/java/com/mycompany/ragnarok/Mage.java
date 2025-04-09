/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ragnarok;

/**
 *
 * @author Cheva
 */
public class Mage extends Character {
    private int magicPower;

    public Mage(String name) {
        super(name, 80); // HP lebih rendah
        this.magicPower = 40;
    }

    public int getMagicPower() {
        return magicPower;
    }

    @Override
    public void addXP(int xp) {
        super.addXP(xp * 2); // XP lebih cepat naik
    }
}

