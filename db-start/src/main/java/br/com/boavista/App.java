package br.com.boavista;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class App {
    public static void main( String[] args ) {
    try {
    	Class.forName("org.sqlite.JDBC");
    	
    	Connection con = DriverManager.getConnection("jdbc:sqlite:cadasto.db");
    	Statement sql = con.createStatement();
    	    	
    	sql.executeUpdate("drop table if exists clientes ");
    	sql.executeUpdate("create table clientes (id integer, nome string)");
    	sql.executeUpdate("insert into clientes values (1, 'Joao')");
    	sql.executeUpdate("insert into clientes values (2, 'Maria')");
    	
    	ResultSet cursor = sql.executeQuery("select * from clientes");
    	    	
    	while (cursor.next()) {
    		System.out.println(cursor.getInt("id") + "-" + cursor.getString("nome"));
    	}
    	con.close();
    } catch (Exception e) {
    	System.out.println("Erro ao processar dados! \n " + e.getMessage() );
    }
    	
    	
    }
}
