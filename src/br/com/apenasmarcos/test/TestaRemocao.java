package br.com.apenasmarcos.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().recuperarConexao();
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM produto WHERE id = '1'");
        System.out.println(statement.getUpdateCount());

    }
}
