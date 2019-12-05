/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entidad.Ubicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Utils.MysqlDBConexion;

public class modeloUbicacion {
        
        public List<Ubicacion> listarDepartamento(){
		List<Ubicacion> data = new ArrayList<Ubicacion>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
                                
		try {
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="select * from ubdepartamento";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Ubicacion obj = null;
			while(rs.next()){
                               
				obj = new Ubicacion();
				obj.setIdDepartamento(rs.getString("idDepa"));
				obj.setDepartamento(rs.getString("departamento"));
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
        public List<Ubicacion> listarProvincia(String departamento){
		List<Ubicacion> data = new ArrayList<Ubicacion>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
                                
		try {
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="SELECT * FROM `ubprovincia` WHERE idDepa=?";
			pstm = conn.prepareStatement(sql);
                        pstm.setString(1, departamento);
			rs = pstm.executeQuery();
			Ubicacion obj = null;
			while(rs.next()){
                               
				obj = new Ubicacion();
				obj.setIdProvincia(rs.getString("idProv"));
				obj.setProvincia(rs.getString("provincia"));
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
}
