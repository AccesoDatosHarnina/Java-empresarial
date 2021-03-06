import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
		String URL_BASEDATOS = "jdbc:mysql://localhost:3306/ejemplo";
		
		//cargar la clase en memoria
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conexion = null;
		//asignar el driver a la conexion
		try {
			conexion=DriverManager.getConnection(URL_BASEDATOS,"harnina","zzzz");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ya");
		//Creamos un Statement que sirve para enviar sqls
		Statement instruccion = null;
		try {
			instruccion=conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Los resultados se meten en un cursor, que es una matriz
		// ResultSet
		ResultSet conjuntoResultados=null;
		try {
			conjuntoResultados=instruccion.executeQuery("SELECT * FROM persona");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//A lo primero que quiero acceder es a lso metadatos
		ResultSetMetaData metaDatos = null;
		try {
			metaDatos = conjuntoResultados.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//El nunmero de columnas, por ejem plo, no seon datos, son metadatos
		int numeroDeColumnas = 0;
		try {
			numeroDeColumnas=metaDatos.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//escribiendo los metadatos de la columna
		for (int i = 1; i <= numeroDeColumnas; i++) {
			try {
				System.out.printf("%-8s\t", metaDatos.getColumnName(i));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Acceder a los datos crudos
		System.out.println();
		try {
			while(conjuntoResultados.next()) {
				for (int i = 1; i <= numeroDeColumnas; i++) {
					//como no sabe lo que hay en cada campo lo lleva a Object
					System.out.printf("%-8s\t", conjuntoResultados.getObject(i));
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
