/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disignpattern;

import java.sql.*;

/**
 *
 * @author formation
 */
public class SingletonConnexionTest {

    public static void main(String[] args) {
        // --- TEST SINGLETON
        // --- Ceci echoue car le constructeur est prive
        //SingletonConnexion sc0 = new SingletonConnexion();

        // --- Ceci recupere toujours une seule instance de la classe
        SingletonConnexion sc1 = SingletonConnexion.getInstance();
        Connection cn1 = sc1.getConnexion();

        SingletonConnexion sc2 = SingletonConnexion.getInstance();
        Connection cn2 = sc2.getConnexion();

        StringBuilder lsbContenu = new StringBuilder("");
        try {
            String lsSQL = "SELECT * FROM auteurs";
            Statement lstSQL = cn2.createStatement();
            ResultSet lrs = lstSQL.executeQuery(lsSQL);
            while (lrs.next()) {
                lsbContenu.append(lrs.getString(1));
                lsbContenu.append("-");
                lsbContenu.append(lrs.getString(2));
                lsbContenu.append(System.getProperty("line.separator"));
            }

            lrs.close();
            lstSQL.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(lsbContenu.toString());
        try {
            cn1.close(); // cn2.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    } /// main

} /// class
