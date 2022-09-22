package br.com.apenasmarcos.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().recuperarConexao();
        Statement statement = connection.createStatement();
        statement.execute("SELECT * FROM produto");
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            Integer id = resultSet.getInt("ID");
            System.out.print(id + " | ");
            String nome = resultSet.getString("NOME");
            System.out.print(nome+ " | ");
            String descricao = resultSet.getString("DESCRICAO");
            System.out.println(descricao+ "\n");
        }
        connection.close();
    }
}
