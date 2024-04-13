package Proyecto_1084922560.Conexion;

public class Configuracion {
    private String dbURL;
    private String username;
    private String password;

    public Configuracion() {
        this.dbURL = "jdbc:mysql://localhost:3306/colegio";
        this.username = "root";
        this.password = "1717";
    }

    public String getDbURL() {
        return dbURL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }   
    
}
