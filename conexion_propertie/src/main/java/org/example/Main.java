package org.example;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Conector conector = Conector.getInstance();
        conector.conectar();

    }
}