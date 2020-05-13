package br.com.boavista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Home01 {

	public static void main(String[] args) {
	    try {
	    	FileReader leitorArquivo = new FileReader("c:/temp/Treinamentos_Realizados.csv");
	    	BufferedReader buffer = new BufferedReader(leitorArquivo);

	        	Class.forName("org.sqlite.JDBC");
	        	
	        	Connection con = DriverManager.getConnection("jdbc:sqlite:curso.db");
	        	Statement sql = con.createStatement();
	        	    	
	        	sql.executeUpdate("drop table if exists treinamento ");
	        	sql.executeUpdate("create table treinamento (id string, treinamento string, nome string, "
	        			+ "email string, area string)");

	    	String registro = buffer.readLine();

	    	while (registro != null) {
	    		
	    		System.out.println("registro => " + registro);
	    		
	    		String[] campos = registro.split(";");
	    	
	    		StringBuilder sb = new StringBuilder();

	    		sb.append("insert into treinamento values (" + "'" + campos[0] + "'" + ", " + "'" + campos[1] + "'" + ", " + "'" + campos[2] + "'" + ", " + "'" + campos[3] + "'" + ", " + "'" + campos[4] + "'"  + ")");
                         
	    		System.out.println("sb => " + sb);
	    		System.out.println("campos[0] " + campos[0]);
	    		
	    		if  (campos[0] != "id") {
	    			
	    			System.out.println("não deveria passar aqui");

	    		String inserD = sb.toString();
			
	    		sql.executeUpdate(inserD); };
	    		
	    		
				registro = buffer.readLine();

	    	} 
        	con.close();
            buffer.close();
	    
	    }
	         catch (Exception e) {
	        	System.out.println("Erro ao processar dados! \n " + e.getMessage() );
	         }
	}
}