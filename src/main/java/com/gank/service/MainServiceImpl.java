package com.gank.service;

import com.gank.repository.MainRepository;
import com.gank.util.LogUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainServiceImpl implements MainService {

    private static final Logger LOG = Logger.getLogger(MainServiceImpl.class);

    @Autowired
    private MainRepository mainRepository;

    public void transferirDados() throws Exception {

        LOG.info(LogUtil.LOG_SEPARADOR);
        LOG.info(LogUtil.VAZIO + " [INICIANDO LISTAGEM DE USUÁRIOS]");
        LOG.info(LogUtil.LOG_SEPARADOR);

        mainRepository.transferirDados();

    }

}
