package com.gank.mapper;

import com.gank.model.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioRowMapper implements RowMapper<Usuario> {

    public Usuario mapRow(ResultSet resultSet, int rowId) throws SQLException {
        return (Usuario) UsuarioMapperResult(resultSet, rowId);
    }

    private Usuario UsuarioMapperResult(ResultSet resultSet , int rowId) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setNome(resultSet.getString("NOME"));

        return usuario;
    }

}
