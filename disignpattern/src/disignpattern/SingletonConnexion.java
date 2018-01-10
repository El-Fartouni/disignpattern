package disignpattern;

import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author formation
 */
public class SingletonConnexion {
    // --- Instance de la classe

    private static SingletonConnexion instance = null;

    // --- La connexion
    private Connection connexion;

    // --- Un constructeur prive, empeche la creation directe d'objet
    private SingletonConnexion() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            this.connexion = DriverManager.getConnection("jdbc:mysql://localhost/bibliotheque", "root", "");
        } catch (Exception e) {
        }
    } /// SingletonConnexion

    // --- La methode getInstance() permet en mode derive l'instanciation unique
    public static SingletonConnexion getInstance() {
        if (instance == null) {
            instance = new SingletonConnexion();
            System.out.println("La classe est instanciée");
        } else {
            System.out.println("La classe était déjà instanciée");
        }
        return instance;
    } /// getInstance

    // -----------------------------
    public Connection getConnexion() {
        return this.connexion;
    } /// getConnexion

} /// class
