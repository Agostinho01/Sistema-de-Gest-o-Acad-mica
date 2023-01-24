/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author User
 */
public class Dim {
       
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  
    public static int width(){
       return screenSize.width;
    }
    
    public static int height(){
        return screenSize.height;
    }
}
