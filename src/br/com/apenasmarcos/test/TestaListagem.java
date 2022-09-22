package br.com.apenasmarcos.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM produto");

        statement.execute();
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
