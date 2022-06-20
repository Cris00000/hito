package Java_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int respuesta=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
			return;
		}
		
		System.out.println("Se ha cargado el Driver de MySQL");
		String cadenaConexion = "jdbc:mysql://localhost:3306/hito";
		String user = "root";
		String pass = ""; 
		Connection con;
		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			System.out.println("Error en la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha establecido la conexión con la Base de datos");
		
		do {
			
			System.out.println(" ");
			System.out.println("Selecciona una opción");
			System.out.println(" ");
			System.out.println("1. Añadir productos");
			System.out.println("2. Quitar productos");
			System.out.println("3. Modificar productos");
			System.out.println("4. Mostrar productos");
			System.out.println("5. Salir");
			System.out.println("----------------------");
			
			respuesta= lector.nextInt();
			
			switch(respuesta) {
			case 1:
				System.out.println(" ");
				System.out.println("Has seleccionado añadir un producto");
				System.out.println(" ");
				System.out.println("Inserta el codigo del producto");
				String basura=lector.nextLine();
				String codigoProducto= lector.nextLine();
				System.out.println("Inserta el nombre del producto");
				String nombre= lector.nextLine();
				System.out.println("Inserta la fecha de envasado del producto");
				String fechaEnvasado= lector.nextLine();
				System.out.println("Inserta las unidades del producto");
				int unidades = lector.nextInt();
				System.out.println("Inserta el precio del producto");
				double precio = lector.nextDouble();
				System.out.println("¿Está disponible?");
				Boolean disponible = lector.nextBoolean();
				
					try {
						Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						ResultSet rs = sentencia.executeQuery("select * from producto");
						rs.moveToInsertRow(); 
						rs.updateString("idProducto", codigoProducto); 
						rs.updateString("nombre", nombre); 
						rs.updateString("fechaEnvasado", fechaEnvasado); 
						rs.updateInt("unidades", unidades); 
						rs.updateDouble("precio", precio); 
						rs.updateBoolean("disponible", disponible); 
						rs.insertRow();
						
					} catch (SQLException e) {
						System.out.println("Se ha producido un error");
						System.out.println(e.getMessage());
					}
				break;
			case 2:
				System.out.println(" ");
				System.out.println("Has seleccionado quitar un producto");
				System.out.println(" ");
				System.out.println("Inserta el id del producto");
				basura=lector.nextLine();
				String idProducto=lector.nextLine();
				try {
					Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = sentencia.executeQuery("select * from producto where idProducto='"+idProducto+"'");
					boolean existe = rs.next();
					if (existe) {
						rs.deleteRow();
					}
		
				} catch (SQLException e) {
					System.out.println("Se ha producido un error");
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println(" ");
				System.out.println("Has seleccionado quitar un producto");
				System.out.println(" ");
				System.out.println("Inserta el id del producto");
				basura=lector.nextLine();
				idProducto=lector.nextLine();
				System.out.println(" ");
				System.out.println("Selecciona lo que quieres modificar");
				System.out.println("--------------------------");
				System.out.println("1. Nombre");
				System.out.println("2. Fecha de envasado");
				System.out.println("3. Unidades");
				System.out.println("4. Precio");
				System.out.println("5. Disponibilidad");
				System.out.println("--------------------------");
				int respuestaModificar=lector.nextInt();
				if(respuestaModificar==1) {
					System.out.println("Inserta un nombre nuevo");
					basura=lector.nextLine();
					String nombreNuevo=lector.nextLine();
					try {
						Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						ResultSet rs = sentencia.executeQuery("select * from producto where idProducto = '"+idProducto+"'");
						boolean existe = rs.next();
						if (existe) {
							rs.updateString("nombre", nombreNuevo);
							rs.updateRow();
						}
					} catch (SQLException e) {
						System.out.println("Se ha producido un error");
						System.out.println(e.getMessage());
					}
				}  else if(respuestaModificar==2) {
					System.out.println("Inserta una fecha nueva");
					basura=lector.nextLine();
					String fechaNueva=lector.nextLine();
					try {
						Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						ResultSet rs = sentencia.executeQuery("select * from producto where idProducto = '"+idProducto+"'");
						boolean existe = rs.next();
						if (existe) {
							rs.updateString("fechaEnvasado", fechaNueva);
							rs.updateRow();
						}
					} catch (SQLException e) {
						System.out.println("Se ha producido un error");
						System.out.println(e.getMessage());
					}
				}else if(respuestaModificar==3) {
					System.out.println("Inserta una cantidad nueva");
					basura=lector.nextLine();
					int cantidadNueva=lector.nextInt();
					try {
						Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						ResultSet rs = sentencia.executeQuery("select * from producto where idProducto = '"+idProducto+"'");
						boolean existe = rs.next();
						if (existe) {
							rs.updateInt("unidades", cantidadNueva);
							rs.updateRow();
						}
					} catch (SQLException e) {
						System.out.println("Se ha producido un error");
						System.out.println(e.getMessage());
					}
				}else if(respuestaModificar==4) {
					System.out.println("Inserta un precio nuevo");
					basura=lector.nextLine();
					double precioNuevo=lector.nextDouble();
					try {
						Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						ResultSet rs = sentencia.executeQuery("select * from producto where idProducto = '"+idProducto+"'");
						boolean existe = rs.next();
						if (existe) {
							rs.updateDouble("precio", precioNuevo);
							rs.updateRow();
						}
					} catch (SQLException e) {
						System.out.println("Se ha producido un error");
						System.out.println(e.getMessage());
					}
				}else if(respuestaModificar==5) {
					System.out.println("Inserta una disponibilidad nueva");
					basura=lector.nextLine();
					Boolean disponibilidadNueva=lector.nextBoolean();
					try {
						Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						ResultSet rs = sentencia.executeQuery("select * from producto where idProducto = '"+idProducto+"'");
						boolean existe = rs.next();
						if (existe) {
							rs.updateBoolean("disponible", disponibilidadNueva);
							rs.updateRow();
						}
					} catch (SQLException e) {
						System.out.println("Se ha producido un error");
						System.out.println(e.getMessage());
					}
				}
				
				break;
			case 4:
				System.out.println("--- LISTA DE PRODUCTOS ---");
				System.out.println(" ");
				System.out.println("Código de producto - Nombre - Fecha de envasado - Unidades - Precio - Disponible");
				
				try {
					Statement sentencia = con.createStatement();
					ResultSet rs = sentencia.executeQuery("select * from producto");
					while (rs.next()) {
						System.out.print(rs.getString("idProducto"));
						System.out.print(" - "); 
						System.out.print(rs.getString("nombre"));
						System.out.print(" - "); 
						System.out.print(rs.getString("fechaEnvasado"));
						System.out.print(" - "); 
						System.out.print(rs.getString("unidades"));
						System.out.print(" - "); 
						System.out.print(rs.getString("precio"));
						System.out.print(" - "); 
						System.out.print(rs.getString("disponible"));
						System.out.println();
					}
				} catch (SQLException e) {
					System.out.println("Error al realizar el listado de productos");
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				break;
			default:
				System.out.println("Opción incorrecta. Inténtalo de nuevo");
			}
			
			
			} while (respuesta!=5);
			
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("No se ha podido cerrar la conexión con la BD");
				System.out.println(e.getMessage());
				return;
			}
			System.out.println("Gracias por usar el programa");
		}

	}
