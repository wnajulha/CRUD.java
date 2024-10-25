package conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;

public class Conexao {
    
    public static Connection conectar() throws SQLException{
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://root:moonwalker@172.16.12.213:3306/banco_teste?sslMode=disabled&useOldAliasMetadataBehavior=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
            System.out.println("CNAKNCKASNCASCNKACNKANSCKASCKASNKCNAS");
            System.out.println("CONEXAO NA CLASS:: " + conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
        
    }
}
