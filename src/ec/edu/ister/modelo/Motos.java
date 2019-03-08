/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ister.modelo;

import ec.edu.ister.controlador.ConexionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Registro Automoviles-....
 */
public class Motos extends ConexionMysql {

    Moto moldeMoto = new Moto(); 
    
    static PreparedStatement preparedStatement = null; 

    public boolean setRegistroDeMotos(int codigo, String nombre, int cantidad, String descripcion, double precio, int serie, int ano) {
        moldeMoto.setCodigo(codigo);
        moldeMoto.setNombre(nombre); 
        moldeMoto.setCantidad(cantidad);
        moldeMoto.setDescripcion(descripcion);
        moldeMoto.setPrecio(precio);
        moldeMoto.setSerie(serie);
        moldeMoto.setAno(ano); 
        if (registarMotos(moldeMoto)) {
            JOptionPane.showMessageDialog(null, "Datos guardados");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al grabar");
            return false;
        }
    }
    public boolean registarMotos(Moto obMoto) {
        PreparedStatement ps;
        Connection conexion = getConexion();
        String queryRegistro = "INSERT INTO motos (codigo,nombre,cantidad,descripcion,precio,serie,ano) VALUES(?,?,?,?,?,?,?);";
        try {
            ps = conexion.prepareStatement(queryRegistro);
            ps.setInt(1, obMoto.getCodigo());
            ps.setString(2, obMoto.getNombre());
            ps.setInt(3, obMoto.getCantidad());
            ps.setString(4, obMoto.getDescripcion());
            ps.setDouble(5, obMoto.getPrecio());
            ps.setDouble(6, obMoto.getSerie());
            ps.setInt(7, obMoto.getAno());
            ps.execute();
            return true;
        } catch (SQLException evt) {
            System.out.println(evt.toString()); 

        } finally {
            try {
                conexion.close();
            } catch (SQLException evt) {
                System.out.println(evt.toString());
            }
        }
        return false;
    }
    public boolean setModificar(int codigo, String nombre, int cantidad, String descripcion, double precio, int serie, int ano) {
        PreparedStatement ps;
        Connection conexion = getConexion();
        String update = "UPDATE motos SET nombre='"+nombre+"',cantidad='"+cantidad+"',descripcion='"+descripcion+"',precio='"+precio+"',serie='"+serie+"',ano='"+ano+"' WHERE codigo='"+codigo+"';";
        try {
            ps = conexion.prepareStatement(update);
            ps.execute();
            JOptionPane.showMessageDialog(null,"Registro actulizar");
            return true;
        } catch (SQLException evt) {
            System.out.println(evt.getMessage());
            JOptionPane.showMessageDialog(null,"Error al actulizar");
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException evt) {
                System.out.println(evt.getMessage());
            }
        }
    }
    public boolean setEliminarAutos(int codigo) {
        PreparedStatement ps;
        Connection conexion = getConexion();
        String delete = "DELETE FROM motos WHERE codigo='"+codigo+"';";
        try {
            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Eliminado");
            return true;
        } catch (SQLException evt) {
            JOptionPane.showMessageDialog(null,"Error al eliminar...");
            System.out.println(evt.getMessage());
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException evt) {
                System.out.println(evt.getMessage());
            }
        }
    }
}
