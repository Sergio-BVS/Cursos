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
	    	FileReader leitorArquivo = new FileReader("c:/temp/dados_h.txt");
	    	BufferedReader buffer = new BufferedReader(leitorArquivo);

	        	Class.forName("org.sqlite.JDBC");
	        	
	        	Connection con = DriverManager.getConnection("jdbc:sqlite:cadasto.db");
	        	Statement sql = con.createStatement();
	        	    	
	        	sql.executeUpdate("drop table if exists cliente2 ");
	        	sql.executeUpdate("create table cliente2 (id integer, nome string, doc string, "
	        			+ "endereco string, bairro string,  cidade string, uf string, status string)");

	    	String registro = buffer.readLine();

	    	while (registro != null) {
	    		
	    		System.out.println("registro " + registro);
	    		
	    		String[] campos = registro.split(";");
	    	
	    		StringBuilder sb = new StringBuilder();

	    		sb.append("insert into cliente2 values (" + campos[0] + ", " + "'" + campos[1] + "'" + ", " + "'" + campos[2] + "'" + ", " + "'" + campos[3] + "'" + ", " + "'" + campos[4] + "'" + ", " + "'" + campos[5] + "'" + ", " + "'" + campos[6] + "'" +  ", " + "'" + campos[7] + "'" + ")");
                         
	    		System.out.println("sb => " + sb);

	    		String inserD = sb.toString();
			
	    		sql.executeUpdate(inserD);
	    		
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