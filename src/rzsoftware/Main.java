/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rzsoftware;

import java.awt.event.WindowEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import rzsoftware.conectbd.Conexao;
import rzsoftware.screens.Login;

/**
 *
 * @author Rafael
 */
public class Main {

    /**
     * 20/01/2025
     */
    public static void main(String[] args) {
        Connection conn = Conexao.getConnection();
        
        if(conn != null){
            System.out.println("Sucesso");
        
        
        Login login = new Login();
        
        login.pack();
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        
        } else {
            JOptionPane.showMessageDialog(null, "Sem conexão com banco de dados");
        }
    }
    
}
