/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ragnarok;

/**
 *
 * @author Cheva
 */

public class Scene {
    private String description;
    private String choiceA, choiceB, choiceC;
    private int damageA, damageB, damageC;
    private int xpA, xpB, xpC;
    private Scene nextSceneA, nextSceneB, nextSceneC;

    public Scene(String description,
                 String choiceA, String choiceB, String choiceC,
                 int damageA, int damageB, int damageC,
                 int xpA, int xpB, int xpC) {
        this.description = description;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.damageA = damageA;
        this.damageB = damageB;
        this.damageC = damageC;
        this.xpA = xpA;
        this.xpB = xpB;
        this.xpC = xpC;
    }

    // Setters for scene transitions
    public void setNextSceneA(Scene next) { this.nextSceneA = next; }
    public void setNextSceneB(Scene next) { this.nextSceneB = next; }
    public void setNextSceneC(Scene next) { this.nextSceneC = next; }

    // Getters
    public String getDescription() { return description; }
    public String getChoiceA() { return choiceA; }
    public String getChoiceB() { return choiceB; }
    public String getChoiceC() { return choiceC; }

    public int getDamageA() { return damageA; }
    public int getDamageB() { return damageB; }
    public int getDamageC() { return damageC; }

    public int getXPA() { return xpA; }
    public int getXPB() { return xpB; }
    public int getXPC() { return xpC; }

    public Scene getNextSceneA() { return nextSceneA; }
    public Scene getNextSceneB() { return nextSceneB; }
    public Scene getNextSceneC() { return nextSceneC; }
}
