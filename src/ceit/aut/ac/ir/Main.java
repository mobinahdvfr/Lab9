package ceit.aut.ac.ir;

import ceit.aut.ac.ir.gui.CFrame;
import ceit.aut.ac.ir.utils.FileUtils;

import javax.swing.*;

/**
 * it has the main method
 * @author Mobina Hadavifar
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {


        CFrame frame = new CFrame("iNote");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
