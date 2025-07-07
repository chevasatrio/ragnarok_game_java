/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ragnarok;

/**
 *
 * @author Cheva
 */
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pilih job
        System.out.println("=== Selamat datang di Dunia Petualangan ===");
        System.out.println("Pilih job karakter:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.print("Masukkan pilihan (1/2): ");
        int job = scanner.nextInt();
        scanner.nextLine(); //newline

        System.out.print("Masukkan nama karaktermu: ");
        String name = scanner.nextLine();

        Character player;
        if (job == 1) {
            player = new Warrior(name);
        } else {
            player = new Mage(name);
        }

        System.out.println("\nHalo " + player.getName() + ", petualanganmu dimulai sekarang!");

        // scene
                // Scene 1 - Desa
        Scene scene1 = new Scene(
            "Kamu berada di desa damai.",
            "Pergi ke hutan", "Tetap di desa", "Cari barang",
            0, 0, 0,
            0, 0, 0
        );

        // Scene 2 - Hutan awal
        Scene scene2 = new Scene(
            "Kamu masuk ke hutan. Seekor monster muncul!",
            "Serang monster", "Kabur", "Sembunyi",
            20, 0, 10,
            10, 0, 5
        );

        // Scene 3 - Peti harta
        Scene scene3 = new Scene(
            "Kamu menemukan peti harta karun.",
            "Ambil harta", "Lewati", "Hancurkan peti",
            0, 0, 10,
            20, 0, 5
        );

        // Scene 4 - Hutan gelap
        Scene scene4 = new Scene(
            "Hutan semakin gelap dan menyeramkan...",
            "Lanjut jalan", "Berbalik", "Pasang perangkap",
            10, 0, 5,
            10, 0, 10
        );

        // Scene 5 - Sungai ajaib
        Scene scene5 = new Scene(
            "Kamu sampai di sungai bercahaya biru.",
            "Seberangi sungai", "Menunggu", "Lempar batu",
            15, 0, 5,
            15, 0, 5
        );

        // Scene 6 - Gua misterius
        Scene scene6 = new Scene(
            "Ada gua misterius dengan cahaya aneh.",
            "Masuk ke dalam", "Istirahat di luar", "Intai dari jauh",
            20, 0, 10,
            20, 0, 5
        );

        // Scene 7 - Lorong bawah tanah
        Scene scene7 = new Scene(
            "Lorong bawah tanah gelap dan panjang.",
            "Masuk lorong", "Balik ke atas", "Ledakkan pintu",
            15, 0, 20,
            15, 0, 25
        );

        // Scene 8 - Ruang puzzle
        Scene scene8 = new Scene(
            "Kamu masuk ke ruangan penuh teka-teki.",
            "Pecahkan teka-teki", "Lewati saja", "Hancurkan semuanya",
            10, 0, 25,
            30, 0, 5
        );

        // Scene 9 - Gerbang bos
        Scene scene9 = new Scene(
            "Gerbang raksasa berdiri di depanmu.",
            "Masuki arena", "Siapkan perlengkapan", "Intip dari jauh",
            10, 0, 5,
            10, 0, 5
        );

        // Scene 10 - Boss terakhir
        Scene scene10 = new Scene(
            "Bos terakhir muncul: Naga Kegelapan!",
            "Lawan langsung", "Gunakan item", "Negosiasi",
            50, 20, 10,
            100, 30, 20
        );

        // Scene akhir / kemenangan
        Scene sceneEnd = new Scene(
            "Kamu mengalahkan sang naga dan menyelamatkan dunia!",
            "Rayakan", "Istirahat", "Kembali ke desa",
            0, 0, 0,
            0, 0, 0
        );



        // Hubungkan scene
        scene1.setNextSceneA(scene2); // ke hutan
        scene1.setNextSceneC(scene3); // cari barang

        scene2.setNextSceneA(scene3);
        scene2.setNextSceneC(scene3);

        scene3.setNextSceneA(scene4);

        scene4.setNextSceneA(scene5);
        scene5.setNextSceneA(scene6);
        scene6.setNextSceneA(scene7);
        scene7.setNextSceneA(scene8);
        scene8.setNextSceneA(scene9);
        scene9.setNextSceneA(scene10);
        scene10.setNextSceneA(sceneEnd);



        // Game loop
        Scene currentScene = scene1;
        while (currentScene != null && player.getHealth() > 0) {
            System.out.println("\n=======================================");
            System.out.println(currentScene.getDescription());
            System.out.println("A. " + currentScene.getChoiceA());
            System.out.println("B. " + currentScene.getChoiceB());
            System.out.println("C. " + currentScene.getChoiceC());
            System.out.println("Ketik A, B, C, INFO, atau KELUAR:");


            String input = scanner.nextLine().trim().toUpperCase();

           if (input.equals("INFO")) {
                System.out.println("Status: " + player.getName());
                System.out.println("Health: " + player.getHealth());
                System.out.println("XP: " + player.getXP());
                continue;
            } else if (input.equals("KELUAR")) {
                System.out.println("Kamu memilih keluar dari permainan.");
                break;
            }


            switch (input) {
                case "A":
                    player.takeDamage(currentScene.getDamageA());
                    player.addXP(currentScene.getXPA());
                    currentScene = currentScene.getNextSceneA();
                    break;
                case "B":
                    player.takeDamage(currentScene.getDamageB());
                    player.addXP(currentScene.getXPB());
                    currentScene = currentScene.getNextSceneB();
                    break;
                case "C":
                    player.takeDamage(currentScene.getDamageC());
                    player.addXP(currentScene.getXPC());
                    currentScene = currentScene.getNextSceneC();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        // end
        System.out.println("\n=======================================");
        if (player.getHealth() <= 0) {
            System.out.println("Karakter kamu mati! Permainan berakhir.");
        } else if (currentScene == null) {
            System.out.println("Kamu berhasil menyelesaikan game!");
        } else {
            System.out.println("Game dihentikan oleh pemain.");
        }


        System.out.println("Status akhir:");
        System.out.println("Nama: " + player.getName());
        System.out.println("Health: " + player.getHealth());
        System.out.println("XP: " + player.getXP());
        System.out.println("Item: " + player.getItem());

        scanner.close();
    }
}

