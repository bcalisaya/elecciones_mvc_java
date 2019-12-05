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
import Utils.MysqlDBConexion;
import Entidad.Mesa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class modeloMesa {
    
    
        public List<Mesa> listarMesa(){
		List<Mesa> data = new ArrayList<Mesa>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
                                
		try {
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="select * from mesa";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Mesa obj = null;
			while(rs.next()){
                               
				obj = new Mesa();
				obj.setColegio(rs.getString("colegio"));
				obj.setNumero_mesa(rs.getString("numero_mesa"));
				obj.setNumero_salon(rs.getString("numero_salon"));
				obj.setId_mesa(rs.getString("id_mesa"));
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
    	public List<Mesa> buscarMesa(String codigo){
		List<Mesa> data = new ArrayList<Mesa>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="select * from mesa where codigo_mesa=? ";
                        pstm.setString(1, codigo);
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Mesa obj = null;
			while(rs.next()){
				obj = new Mesa();
				obj.setColegio(rs.getString("colegio"));
				obj.setNumero_mesa(rs.getString("numero_salon"));
				obj.setNumero_salon(rs.getString("numero_mesa"));
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
	
	public int insertarMesa(Mesa obj){
		int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="insert into mesa values(null,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getColegio());
			pstm.setString(2, obj.getNumero_mesa());
			pstm.setString(3, obj.getNumero_salon());
			
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
        
        public int insertarAsignacionMesa(String dni, String id_mesa){
		int salida = -1;
		String buscado;
		Connection conn= null;
		PreparedStatement pstm = null;
		PreparedStatement ps = null;
		try {
			
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="insert into persona values(null,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,dni);
			pstm.setString(2,id_mesa);
			
                        String consultaDni ="select * from mesa where id_mesa=?";
                        ps = conn.prepareStatement(consultaDni);
                        ps.setString(1,id_mesa);
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


