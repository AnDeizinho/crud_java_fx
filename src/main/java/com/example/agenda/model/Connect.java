package com.example.agenda.model;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    private Connection con;
    private final String URL = "jdbc:sqlite:banco.db";

    public boolean open()
    {
        try
        {
            this.con = DriverManager.getConnection(URL);
        }catch(Exception error)
        {
            System.out.println(error.getMessage());
            return false;
        }
        return true;
    }
    public boolean close()
    {
        try
        {
            if(!this.con.isClosed())
            {
                this.con.close();
            }
        }catch (Exception error)
        {
            System.out.println(error.getMessage());
            return false;
        }
        return true;
    }

}
