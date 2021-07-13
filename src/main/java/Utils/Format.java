/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Nhat Minh
 */
public class Format {
    public static String FloatConvert(float f)
    {
        NumberFormat formatter = new DecimalFormat("#.##");
        String s = formatter.format(f);
        s = s.replace(",", ".");
        return s;
    }
}
