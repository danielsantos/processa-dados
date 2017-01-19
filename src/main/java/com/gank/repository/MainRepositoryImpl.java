package com.gank.repository;

import com.gank.config.BaseRepository;
import com.gank.mapper.UsuarioRowMapper;
import com.gank.model.Usuario;
import com.gank.util.LogUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MainRepositoryImpl extends BaseRepository implements MainRepository  {

    private static final Logger LOG = Logger.getLogger(MainRepositoryImpl.class);

    private static final String SQL_SELECT_USUARIOS = "SQL_SELECT_USUARIOS";

    private static final String SQL_INSERT_USUARIOS = "SQL_INSERT_USUARIOS";

    @Autowired
    @Qualifier("jdbcBU")
    private NamedParameterJdbcTemplate jdbc;

    public void transferirDados() throws Exception {

        Map<String, Object> params = new HashMap<>();

        String query = getQuery(SQL_SELECT_USUARIOS, null);

        List<Usuario> usuarios = jdbc.query(query, params, new UsuarioRowMapper());

        for (Usuario u : usuarios) {
            LOG.info(LogUtil.LOG_SEPARADOR);
            LOG.info("Usuario [id=" + u.getId() + ", nome=" + u.getNome() + "]");

            jdbc.update(getQuery(SQL_INSERT_USUARIOS, null), getParameters(u));
        }

        LOG.info(LogUtil.LOG_SEPARADOR);

    }


    private MapSqlParameterSource getParameters(Usuario usuario) {

        // TODO Criar uma classe para encapsular a montagem dos parametros, tanto para insert quanto para update
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("ID", usuario.getId() );
        parameters.put("NOME", usuario.getNome());

        return new MapSqlParameterSource(parameters);

    }

}
