package com.gank.repository;

import com.gank.config.BaseRepository;
import com.gank.mapper.UsuarioRowMapper;
import com.gank.model.Usuario;
import com.gank.util.LogUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MainRepositoryImpl extends BaseRepository implements MainRepository  {

    private static final Logger LOG = Logger.getLogger(MainRepositoryImpl.class);

    private static final String SQL_SELECT_NOME = "SQL_SELECT_NOME";

    @Autowired
    @Qualifier("jdbcBU")
    private NamedParameterJdbcTemplate jdbc;

    public void transferirDados() throws Exception {

        Map<String, Object> params = new HashMap<>();

        String query = getQuery(SQL_SELECT_NOME, null);

        List<Usuario> usuarios = jdbc.query(query, params, new UsuarioRowMapper());

        for (Usuario u : usuarios) {
            LOG.info(LogUtil.LOG_SEPARADOR);
            LOG.info("Usuario [nome=" + u.getNome() + "]");
        }

        LOG.info(LogUtil.LOG_SEPARADOR);

    }

}
