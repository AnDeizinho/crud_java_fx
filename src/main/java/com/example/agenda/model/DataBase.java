package com.example.agenda.model;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private Connection con;
    private final String URL = "jdbc:sqlite:./banco.db";
    private final String TABLE_NAME = "tbl_contatos";
    private final String CREATE_COMMAND= "CREATE TABLE IF NOT EXISTS %s (%s, %s, %s, %s, %s);" ;
    private final String ID_COLUMN = "id integer PRIMARY KEY AUTOINCREMENT";
    private final String FIRST_NAME_COLUMN = "name text NOT NULL";
    private final String LAST_NAME_COLUMN = "last_name text NOT NULL";
    private final String FONE_COLUMN = "fone text NOT NULL";
    private final String EMAIL_COLUMN = "email text NOT NULL";
    private final String ID = ID_COLUMN.split(" ")[0];
    private final String FIRST_NAME = FIRST_NAME_COLUMN.split(" ")[0];
    private final String LAST_NAME = LAST_NAME_COLUMN.split(" ")[0];
    private final String FONE = FONE_COLUMN.split(" ")[0];
    private final String EMAIL = EMAIL_COLUMN.split(" ")[0];
    private final String INSERT_COMMAND = String.format("INSERT INTO %s (%s, %s,%s,%s) VALUES (?,?,?,?);",
            TABLE_NAME, FIRST_NAME, LAST_NAME, FONE, EMAIL);

    private final String UPDATE_COMMAND = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ? WHERE id = ",
            TABLE_NAME, FIRST_NAME, LAST_NAME, FONE, EMAIL);
    private final String DELETE_COMMAND = String.format("DELETE FROM %s WHERE id = ", TABLE_NAME);
    public DataBase()
    {
        execute(String.format(CREATE_COMMAND, TABLE_NAME, ID_COLUMN,
                FIRST_NAME_COLUMN, LAST_NAME_COLUMN, FONE_COLUMN, EMAIL_COLUMN));
    }

    public void execute(String command)
    {
        try {
            open();
            Statement st = con.createStatement();
            st.execute(command);
        }catch (Exception error)
        {
            System.out.println(error.getMessage());
        }finally {
            close();
        }
    }
    public ArrayList<Contato> selectAll()
    {
        return select(String.format("select * from %s", TABLE_NAME));
    }
    public ArrayList<Contato> select(String command)
    {
        ArrayList<Contato> contatos = new ArrayList();
        try{
            open();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(command);
            while(rs.next())
            {
                contatos.add(new Contato(rs.getInt(ID), rs.getString(FIRST_NAME), rs.getString(LAST_NAME),
                        rs.getString(FONE), rs.getString(EMAIL)));
            }
        }catch (Exception error)
        {
            System.out.println(error.getMessage());
        }finally {
            close();
            return contatos;
        }
    }
    private int prepStatement(String command, Contato contato)
    {
        int ret = -1;
        try {
            open();
            PreparedStatement p = con.prepareStatement(command);
            p.setString(1, contato.getName());
            p.setString(2, contato.getSobrenome());
            p.setString(3, contato.getFone());
            p.setString(4, contato.getEmail());
            ret = p.executeUpdate();

        }catch (Exception error)
        {
            System.out.println(error.getMessage());
            ret = -2;
        }
        finally
        {
            close();
            return ret;
        }
    }
    public void insert(Contato contato)
    {
        prepStatement(INSERT_COMMAND, contato);
    }
    public void update(Contato contato){
        prepStatement(UPDATE_COMMAND + contato.getId(), contato);
    }
    public void delete(int id)
    {
        execute(DELETE_COMMAND + id);
    }
    public boolean open()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
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
