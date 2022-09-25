package com.fernando;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pessoa")
public class PessoaResource {
    @Inject
    PessoaRepository pessoaRepository;

    @GET
    public Response index() {
        List<Pessoa> pessoas = pessoaRepository.listAll();
        int i = pessoas.size();
        i = i * 2;
        return Response.ok().entity(pessoas).build();
    }
}
