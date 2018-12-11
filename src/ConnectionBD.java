import java.sql.*;

public class ConnectionBD {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Millionaire.s3db");
    }

    // --------Создание таблицы--------
    public static void CreateDB() throws SQLException {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'Rating' ('Player' text, 'Money' text);");
    }

    // --------Заполнение таблицы--------
    public static void WriteDB(String str1, String str2) throws SQLException {
        statmt.execute("INSERT INTO 'Rating' ('Player', 'Money') VALUES ('"+str1+"','"+ str2+"'); ");
    }

    // -------- Вывод таблицы--------
    public static String[] ReadDB() throws SQLException {
        resSet = statmt.executeQuery("SELECT * FROM Rating");
        int i = 0;
        String[] str=new String[20];

        while (resSet.next()) {
            str[i] = resSet.getString("Player") + " " + resSet.getString("Money");
            i++;
        }

        return str;
    }
}
