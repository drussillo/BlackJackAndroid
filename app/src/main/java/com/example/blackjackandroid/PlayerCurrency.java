package com.example.blackjackandroid;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PlayerCurrency {
    private String id;
    private int dollars;
    private int chips;

    public PlayerCurrency(String id, int dollars, int chips) {
        this.id = id;
        this.dollars = dollars;
        this.chips = chips;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getDollars() {
        return dollars;
    }
    public void setDollars(int dollars) {
        this.dollars = dollars;
    }
    public int getChips() {
        return chips;
    }
    public void setChips(int chips) {
        this.chips = chips;
    }

    public void readDollars(String pathDollars, PlayerCurrency object) throws IOException {
        FileReader dollarsRead = new FileReader(pathDollars);
        object.setDollars(dollarsRead.read());
        dollarsRead.close();
    }
    public void readChips(String pathChips, PlayerCurrency object) throws IOException {
        File chipsFile = new File(pathChips);
        FileReader chipsRead = new FileReader(chipsFile);
        object.setChips(chipsRead.read());
        chipsRead.close();
    }
    public void readCurrency(String pathDollars, String pathChips, PlayerCurrency object) throws IOException {
        object.readDollars(pathDollars, object);
        object.readChips(pathChips, object);
    }
    public void writeDollars(int dollarAmount, String pathDollars) throws IOException {
        FileWriter dollarWriter = new FileWriter(pathDollars);
        dollarWriter.flush();
        dollarWriter.append((char) dollarAmount);
        dollarWriter.close();
    }
    public void writeChips(int chipAmount, String pathChips) throws IOException {
        FileWriter chipWriter = new FileWriter(pathChips);
        chipWriter.flush();
        chipWriter.append((char) chipAmount);
        chipWriter.close();
    }
    public void generateDollars(String pathDollars) throws IOException {
        new File(pathDollars).createNewFile();
    }

    public void generateChips(String pathChips) throws IOException {
        new File(pathChips).createNewFile();
    }
    public void generateDefaultCurrencry(String pathDollars, int dollarAmount, String pathChips, int chipAmount) throws IOException {
        if (new File(pathDollars).exists() == false) {
            generateDollars(pathDollars);
            writeDollars(dollarAmount, pathDollars);
        }
        if (new File(pathChips).exists() == false) {
            generateChips(pathChips);
            writeChips(chipAmount, pathChips);
        }
    }
}
