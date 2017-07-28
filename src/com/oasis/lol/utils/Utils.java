package com.oasis.lol.utils;


import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danablend on 28/07/2017 at 22:15.
 */
public class Utils {

    public static String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static String stripColor(String str) {
        return ChatColor.stripColor(str);
    }

    public static <T> List<List<T>> chopList(List<T> list, final int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }

}
