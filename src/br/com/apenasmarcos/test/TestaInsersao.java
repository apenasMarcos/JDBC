package br.com.apenasmarcos.test;

import java.sql.*;

public class TestaInsersao {

    public static void main(String[] args) throws SQLException {

        Connection connection = new ConnectionFactory().recuperarConexao();
        connection.setAutoCommit(false);
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO  produto (nome,descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            adicionarItem("", "", statement);
            connection.commit();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Rollback executado");
            connection.rollback();
        }
    }

    private static void adicionarItem(String nome, String descricao, PreparedStatement statement) throws SQLException {
        statement.setString(1, nome);
        statement.setString(2, descricao);
        ResultSet resultSet = statement.getGeneratedKeys();

        while(resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("id gerado = " + id);
        }
    }
}
