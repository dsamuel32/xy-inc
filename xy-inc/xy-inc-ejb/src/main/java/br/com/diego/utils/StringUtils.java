/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.utils;

import java.util.List;

/**
 *
 * @author Diego NOTE
 */
public class StringUtils {
    
     public static String formatarListToString(List<String> camposInvalidos) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < camposInvalidos.size(); i++) {
            stringBuilder.append(camposInvalidos.get(i));

            if (i < camposInvalidos.size() - 1) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("");
            }

        }

        stringBuilder.append("]");

        return stringBuilder.toString();

    }
}
