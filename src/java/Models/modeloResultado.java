/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entidad.Resultado;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import Utils.MysqlDBConexion;
import java.sql.Connection;


public class modeloResultado {
    public List<Resultado> listarPersona(){
		List<Resultado> data = new ArrayList<Resultado>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
                                
		try {
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="SELECT persona.nombres ,persona.apellidos, partido.logo, COUNT(*) FROM voto INNER JOIN persona ON voto.dni_candidato=persona.dni INNER JOIN candidato ON candidato.dni=persona.dni INNER JOIN partido ON partido.nombre_partido=candidato.nombre_partido GROUP BY dni_candidato";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Resultado obj = null;
			while(rs.next()){
                               
				obj = new Resultado();
				obj.setNombre(rs.getString("nombres"));
				obj.setApellido(rs.getString("apellidos"));
				obj.setLogo(rs.getString("logo"));
				obj.setCantidad(rs.getInt("COUNT(*)"));
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