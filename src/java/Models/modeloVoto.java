/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entidad.cedulaCandidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Utils.MysqlDBConexion;
import java.util.ArrayList;
import java.util.List;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Bryan
 */
public class modeloVoto {
    public int insertarVoto(cedulaCandidato obj){
                Date date = new Date();
                DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                int salida = -1;
		String buscado;
		Connection conn= null;
		PreparedStatement pstm = null;
		PreparedStatement ps = null;
		try {
			
			conn = (Connection) MysqlDBConexion.getConexion();
			String sql ="insert into voto values(?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getDniVotante());
			pstm.setString(2, obj.getDniCandidato());
			pstm.setString(3, hourdateFormat.format(date));
			pstm.setString(4, obj.getTipo_candidato());
                        String consultaDni ="select * from voto where dni_elector=?";
                        ps = conn.prepareStatement(consultaDni);
                        ps.setString(1, obj.getDniVotante());
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
