package br.com.apenasmarcos.test;

import java.sql.*;

public class TestaInsersao {

    public static void main(String[] args) throws SQLException {
        String nome = "";
        String descricao = "";

        Connection connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO  produto (nome,descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, nome);
        statement.setString(2, descricao);
        ResultSet resultSet = statement.getGeneratedKeys();

        while(resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("id gerado = " + id);
        }
    }
}
