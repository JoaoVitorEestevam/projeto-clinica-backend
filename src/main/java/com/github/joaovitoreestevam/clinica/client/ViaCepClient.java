package com.github.joaovitoreestevam.clinica.client;

import com.github.joaovitoreestevam.clinica.dto.endereco.ViaCepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacepClient", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    ViaCepDTO buscarEnderecoPorCep(@PathVariable("cep") String cep);
}
