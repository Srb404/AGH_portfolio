package me.ziomki.hardcoreplus.Helpers;

public class ChanceCalculator {

    public static boolean getChance(double percentage) {
        if (percentage/100 > Math.random())
            return true;
        else
            return false;
    }

}
