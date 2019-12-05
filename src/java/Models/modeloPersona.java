/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entidad.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Utils.MysqlDBConexion;
/**
 *
 * @author Bryan
 */
public class modeloPersona
{
	public List<Persona> listarPersona(){
		List<Persona> data = new ArrayList<Persona>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
                                
		try {
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="select * from persona";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Persona obj = null;
			while(rs.next()){
                               
				obj = new Persona();
				obj.setNombre(rs.getString("nombres"));
				obj.setApellidos(rs.getString("apellidos"));
				obj.setDirecciones(rs.getString("direccion"));
				obj.setDni(rs.getString("dni"));
				obj.setEstadocivil(rs.getString("estado_civil"));
				obj.setSexo(rs.getString("sexo"));
				obj.setUbigeo(rs.getString("ubigeo"));
				data.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		return data;
	}
	public List<Persona> listarPersonaDni(String dni){
		List<Persona> data = new ArrayList<Persona>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
                System.out.println("llego al metodo listar por dni");
		try {
			conn = (Connection) MysqlDBConexion.getConexion();
                        String sql ="select * from Persona where dni=?";
                        pstm = conn.prepareStatement(sql);
                        pstm.setString(1, dni);
                        rs = pstm.executeQuery();
			Persona obj = null;
			while(rs.next()){
                               
				obj = new Persona();
				obj.setNombre(rs.getString("nombres"));
				obj.setApellidos(rs.getString("apellidos"));
				obj.setDirecciones(rs.getString("direccion"));
				obj.setDni(rs.getString("dni"));
				obj.setEstadocivil(rs.getString("estado_civil"));
				obj.setSexo(rs.getString("sexo"));
				obj.setUbigeo(rs.getString("ubigeo"));
				obj.setFoto(rs.getString("foto"));
				data.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		return data;
	}
        
        public List<Persona> listarPersonaNombre(String nombre){
		List<Persona> data = new ArrayList<Persona>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
                 
		try {
			conn = (Connection) MysqlDBConexion.getConexion();
                        String sql ="select * from Persona where nombres=?";
                        pstm = conn.prepareStatement(sql);
                        pstm.setString(1, nombre);
                        rs = pstm.executeQuery();
			Persona obj = null;
			while(rs.next()){
                               
				obj = new Persona();
				obj.setNombre(rs.getString("nombres"));
				obj.setApellidos(rs.getString("apellidos"));
				obj.setDirecciones(rs.getString("direccion"));
				obj.setDni(rs.getString("dni"));
				obj.setEstadocivil(rs.getString("estado_civil"));
				obj.setSexo(rs.getString("sexo"));
				obj.setUbigeo(rs.getString("ubigeo"));
				obj.setFoto(rs.getString("foto"));
				data.add(obj);
                                   
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		System.out.println("llego al metodo listar por nombre");
		System.out.println("--");
		return data;
	}
        
        public int actualizar(Persona obj){
            int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="update persona set dni=?,nombres=?,apellidos=?,ubigeo=?,direccion=?,sexo=?,estado_civil=?,foto=? where dni=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getDni());
			pstm.setString(2, obj.getNombre());
			pstm.setString(3, obj.getApellidos());
			pstm.setString(4, obj.getUbigeo());
			pstm.setString(5, obj.getDirecciones());
			pstm.setString(6, obj.getSexo());
			pstm.setString(7, obj.getEstadocivil());
			pstm.setString(8, obj.getFoto());
                        pstm.setString(9, obj.getDni());
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close(
						);
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		
		return salida;
        }
        public void delete(String obj){
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="delete from persona where dni=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,obj);
                        pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close(
						);
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
        }
        public Persona buscarPersona(String dni){
        Persona obj = new Persona();
        Connection conn= null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
                conn = (Connection) MysqlDBConexion.getConexion();
                String sql ="select * from Persona where dni=?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, dni);
                rs = pstm.executeQuery();
                if(rs.next())
                {
                    obj=new Persona();
                        obj.setNombre(rs.getString("nombres"));
			obj.setApellidos(rs.getString("apellidos"));
			obj.setDirecciones(rs.getString("direccion"));
			obj.setDni(rs.getString("dni"));
			obj.setEstadocivil(rs.getString("estado_civil"));
			obj.setSexo(rs.getString("sexo"));
			obj.setUbigeo(rs.getString("ubigeo"));
                   
                }
                
        } catch (Exception e) 
        {
                e.printStackTrace();
        } finally
        {
                try 
                {   
                        if(rs!= null) rs.close();
                        if(pstm!= null) pstm.close();
                        if(conn!= null) conn.close();
                } catch (Exception e2) 
                {
                    e2.printStackTrace();
                }
        }

        return obj;
    }
      
        
	public int insertarPersona(Persona obj){
		int salida = -1;
		String buscado;
		Connection conn= null;
		PreparedStatement pstm = null;
		PreparedStatement ps = null;
		try {
			
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="insert into persona values(null,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getDni());
			pstm.setString(2, obj.getNombre());
			pstm.setString(3, obj.getApellidos());
			pstm.setString(4, obj.getUbigeo());
			pstm.setString(5, obj.getDirecciones());
			pstm.setString(6, obj.getSexo());
			pstm.setString(7, obj.getEstadocivil());
			pstm.setString(8, obj.getFoto());
                        String consultaDni ="select * from persona where dni=?";
                        ps = conn.prepareStatement(consultaDni);
                        ps.setString(1, obj.getDni());
                        if(ps.executeQuery().next()){
                            System.out.println("no ingreso repetido");
                            salida=2;
                        }else{
                            System.out.println("ingreso ");
                            pstm.executeUpdate();
                            salida=1; 
                        }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close(
						);
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		
		return salida;
	}
        
}

