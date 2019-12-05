/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Entidad.Partido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Utils.MysqlDBConexion;
import java.io.File;
import java.io.FileInputStream;
public class modeloPartido {
        
    
        public int insertarPartido(Partido p){
        int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm = null;
                //File archivoFoto = new File(p.getFoto());
		try {
			
			//FileInputStream convertir_imagen = new FileInputStream(archivoFoto);
                        conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="insert into partido values(null,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getFoto());
			pstm.setString(3, p.getDescripcion());
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
        public List<Partido> listarPartido(){
		List<Partido> data = new ArrayList<Partido>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
                                
		try {
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="select * from partido";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Partido obj = null;
			while(rs.next()){
                               
				obj = new Partido();
				obj.setid(rs.getString("id_partido"));
				obj.setNombre(rs.getString("nombre_partido"));
				obj.setFoto(rs.getString("logo"));
				obj.setDescripcion(rs.getString("descripcion_partido"));
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
