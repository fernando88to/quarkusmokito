package com.fernando;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PessoaResourceTest {

    @InjectMock
    PessoaRepository pessoaRepository;
    @Inject
    PessoaResource pessoaResource;

    @Test
    void index() {
        List<Pessoa> pessoas = List.of(new Pessoa(1L, "fernando"), new Pessoa(2L, "henrique"));
        Mockito.when(pessoaRepository.listAll()).thenReturn(pessoas);
        Response response = pessoaResource.index();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertNotNull(response.getEntity());
        List<Pessoa> responseEntity = (List<Pessoa>) response.getEntity();
        assertFalse(responseEntity.isEmpty());
        assertEquals("fernando", responseEntity.get(0).nome);


    }
}