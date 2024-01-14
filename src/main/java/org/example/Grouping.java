package org.example;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Grouping {
    public static void main(String[] args) {
        Set<String> uniqueLines = new HashSet<>();
        List<List<String>> groups = new ArrayList<>();

        // Предполагается, что у вас есть список строк из файла
        List<String> lines = new ArrayList<>();
        // Заполните список строк из файла

        for (String line : lines) {
            boolean foundGroup = false;
            for (List<String> group : groups) {
                for (String groupLine : group) {
                    if (hasMatchingValues(line, groupLine)) {
                        group.add(line);
                        foundGroup = true;
                        break;
                    }
                }
                if (foundGroup) {
                    break;
                }
            }
            if (!foundGroup) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(line);
                groups.add(newGroup);
            }
        }

        // Вывод полученных групп
        System.out.println("Количество групп с более чем одним элементом: " + groups.size());
        for (List<String> group : groups) {
            System.out.println("Группа " + (groups.indexOf(group) + 1));
            for (String line : group) {
                System.out.println(line);
            }
        }
    }

    private static boolean hasMatchingValues(String line1, String line2) {
        String[] values1 = line1.split(";");
        String[] values2 = line2.split(";");

        for (int i = 0; i < values1.length; i++) {
            if (!values1[i].isEmpty() && !values2[i].isEmpty() && values1[i].equals(values2[i])) {
                return true;
            }
        }

        return false;
    }
}

