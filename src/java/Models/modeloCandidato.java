/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Utils.MysqlDBConexion;
import Entidad.Candidato;
import Entidad.cedulaCandidato;

/**
 *
 * @author Bryan
 */
public class modeloCandidato {
    
    
    public int insertarCandidato(Candidato obj) {
        int salida = -1;

        Connection conn = null;
        PreparedStatement pstm = null;
        try {

            conn = (Connection) MysqlDBConexion.getConexion();
            String sql = "insert into candidato values(null,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getDni());
            pstm.setString(2, obj.getTipo_candidato());
            pstm.setString(3, obj.getFoto());
            pstm.setString(4, obj.getPartido());
            salida = pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return salida;
    }

    public List listarCedula() {
        String sql = "SELECT persona.dni,persona.nombres,persona.apellidos,partido.nombre_partido, candidato.tipo_candidato,partido.logo\n"
                + "FROM candidato\n"
                + "INNER JOIN partido\n"
                + "  ON  candidato.nombre_partido= partido.nombre_partido\n"
                + "INNER JOIN persona\n"
                + "  ON persona.dni = candidato.dni\n"
                + "WHERE candidato.tipo_candidato = 'presidente'";
        List<cedulaCandidato> lista = new ArrayList<>();
        try {
            MysqlDBConexion cn = new MysqlDBConexion();
            Connection con = cn.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cedulaCandidato ce = new cedulaCandidato();
                ce.setDniCandidato(rs.getString("dni"));
                ce.setNombres(rs.getString("nombres"));
                ce.setApellidos(rs.getString("apellidos"));
                ce.setNombre_partido(rs.getString("nombre_partido"));
                ce.setTipo_candidato(rs.getString("tipo_candidato"));
                ce.setFoto(rs.getString("logo"));
                System.out.println(ce.getNombres());
                lista.add(ce);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}
