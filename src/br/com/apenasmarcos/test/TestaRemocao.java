package br.com.apenasmarcos.test;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().recuperarConexao();
        Integer id = 1;
        PreparedStatement statement = connection.prepareStatement("DELETE FROM produto WHERE id = '?'");
        statement.setInt(1, id);
        statement.execute();
        System.out.println(statement.getUpdateCount());

    }
}
