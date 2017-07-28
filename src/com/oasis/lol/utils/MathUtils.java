package com.oasis.lol.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Daniel on 28/07/2017 at 22:24.
 */

public class MathUtils {

    public static boolean stringContainsNumber(String s) {
        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean trueOrFalse(double percentChance) {
        int random = MathUtils.randomNumberFromTo(1, 1000);
        return random < (percentChance * 10);
    }

    public static boolean isLocationInTriangle(Location location, Location v1, Location v2, Location v3) {
        double a = 0.5 * (-v2.getZ() * v3.getX() + v1.getZ() * (-v2.getX() + v3.getX()) + v1.getX() * (v2.getZ() - v3.getZ()) + v2.getX() * v3.getZ());
        int sign = a < 0 ? -1 : 1;
        double s = (v1.getZ() * v3.getX() - v1.getX() * v3.getZ() + (v3.getZ() - v1.getZ()) * location.getX() + (v1.getX() - v3.getX()) * location.getZ()) * sign;
        double t = (v1.getX() * v2.getZ() - v1.getZ() * v2.getX() + (v1.getZ() - v2.getZ()) * location.getX() + (v2.getX() - v1.getX()) * location.getZ()) * sign;

        return s > 0 && t > 0 && (s + t) < 2 * a * sign;
    }

    public static String getCardinalDirection(Player player) {
        double rotation = (player.getLocation().getYaw() - 90) % 360;
        if (rotation < 0) {
            rotation += 360.0;
        }
        if (0 <= rotation && rotation < 22.5) {
            return "N";
        } else if (22.5 <= rotation && rotation < 67.5) {
            return "NE";
        } else if (67.5 <= rotation && rotation < 112.5) {
            return "E";
        } else if (112.5 <= rotation && rotation < 157.5) {
            return "SE";
        } else if (157.5 <= rotation && rotation < 202.5) {
            return "S";
        } else if (202.5 <= rotation && rotation < 247.5) {
            return "SW";
        } else if (247.5 <= rotation && rotation < 292.5) {
            return "W";
        } else if (292.5 <= rotation && rotation < 337.5) {
            return "NW";
        } else if (337.5 <= rotation && rotation < 360.0) {
            return "N";
        } else {
            return null;
        }
    }

    public static String getSimpleCardinalDirection(Player player) {
        float yaw = player.getLocation().getYaw();
        String dir = "Error";
        if((yaw <= 45 && yaw >= 0) || (yaw <= 360 && yaw >= 315)) {
            dir =  "South";
        }
        else if(yaw > 45 && yaw < 135) {
            dir = "West";
        }
        else if(yaw >= 135 && yaw <= 225) {
            dir =  "North";
        }
        else if(yaw > 225 && yaw < 315) {
            dir =  "East";
        }
        return dir;
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }

    public static BigDecimal truncateDecimal(double x, int numberofDecimals) {
        if ( x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
    }

    public static int firstNumberSequence(String string) {
        int i = 0;
        while (!Character.isDigit(string.charAt(i))) i++;
        int j = i;
        while (Character.isDigit(string.charAt(j))) j++;
        return Integer.parseInt(string.substring(i, j));
    }

    public static int romanToDecimal(String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        return decimal;
    }

    // This method is used in the one above to convert roman numerals to integers.
    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }

    public static String getFormattedTimeString(long timeInSeconds) {
        String timeStr = new String();
        long sec_term = 1;
        long min_term = 60 * sec_term;
        long hour_term = 60 * min_term;
        long result = Math.abs(timeInSeconds);

        int hour = (int) (result / hour_term);
        result = result % hour_term;
        int min = (int) (result / min_term);
        result = result % min_term;
        int sec = (int) (result / sec_term);

        if (timeInSeconds < 0) {
            timeStr = "-";
        }

        if (hour > 1) {
            timeStr += hour + " hours, ";
        } else if (hour > 0) {
            timeStr += hour + " hour, ";
        }

        if (min > 1) {
            timeStr += min + " minutes and ";
        } else if (min > 0) {
            timeStr += min + " minute and ";
        }

        if (sec > 1) {
            timeStr += sec + " seconds";
        } else if (sec > 0) {
            timeStr += sec + " second";
        }
        return timeStr;
    }

    public static String convertToRoman(int mInt) {
        String[] rnChars = { "M",  "CM", "D", "C",  "XC", "L",  "X", "IX", "V", "I" };
        int[] rnVals = {  1000, 900, 500, 100, 90, 50, 10, 9, 5, 1 };
        String retVal = "";

        for (int i = 0; i < rnVals.length; i++) {
            int numberInPlace = mInt / rnVals[i];
            if (numberInPlace == 0) continue;
            retVal += numberInPlace == 4 && i > 0? rnChars[i] + rnChars[i - 1]:
                    new String(new char[numberInPlace]).replace("\0",rnChars[i]);
            mInt = mInt % rnVals[i];
        }
        return retVal;
    }

    public static int randomNumberFromTo(int min, int max) {
        Random r = new Random();
        int randomNum = r.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static boolean isValidIpAddress(String str) {
        String regex =
                "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
