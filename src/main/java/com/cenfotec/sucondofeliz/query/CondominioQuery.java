package com.cenfotec.sucondofeliz.query;


import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.services.CondominioService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CondominioQuery implements GraphQLQueryResolver {

    @Autowired
    private CondominioService condoService;

    public List<Condominio> getCondos(int count) {
        return this.condoService.getAll();
    }

}
