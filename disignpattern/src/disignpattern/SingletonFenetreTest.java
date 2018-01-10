/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disignpattern;

/**
 *
 * @author formation
 */
public class SingletonFenetreTest {

    public static void main(String[] args) {
        //SingletonFenetre f1 = new SingletonFenetre();
        //SingletonFenetre f2 = new SingletonFenetre();        
        SingletonFenetre.getInstance();
        SingletonFenetre.getInstance();
    }
}
