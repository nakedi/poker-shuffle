package com.advance.poker.ui.service;

import com.advance.poker.ui.util.NumberUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class ConsoleService {
    public final static String RESET = "\u001B[0m";
    public final static String RED = "\u001B[31m";
    public final static String GREEN = "\u001B[32m";
    public final String YELLOW = "\u001B[33m";


    public void printWelcomeMessage(){
        println(" ------",GREEN);
        println("|      |",GREEN);
        println("|      |",GREEN);
        println("|   |",GREEN);
        println("|___| Poker   By Nakedi Mabusela",GREEN);
        println("<================================>",RESET);
    }

    public void printShuffleMessage(){
        println("Shuffling...Shiffling...Shiffling...",RESET);
    }

    public void println(String line,String color){
        System.out.println(color+" "+line+" "+color);
    }

    public void print(String line,String color){
        System.out.println(color+" "+line+" "+color);
    }

    public String printAndScanForNumber(String line,String color) {
        System.out.print(color + " " + line + " " + color);
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String lineFromConsole;
        boolean done = false;
        do {
            lineFromConsole = scanner.nextLine();
            if(!NumberUtil.isNumeric(lineFromConsole) ){
                this.println("Please enter a numeric value ",color);
            }else{
                done = true;
            }
        }while(!done);
        return lineFromConsole;
    }

    public String printAndScanForString(String line,String validChoices,String color) {
        System.out.print(color + " " + line + " " + color);
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> validChoicesList =   Arrays.asList(validChoices.split(","));
        String lineFromConsole;
        boolean done = false;
        do {
            lineFromConsole = scanner.nextLine();
            if(!validChoicesList.contains(lineFromConsole.trim().toUpperCase()) ){
                this.println("Please eneter these options  \""+validChoices+"\"",color);
            }else{
                done = true;
            }
        }while(!done);
        return lineFromConsole;
    }
}
