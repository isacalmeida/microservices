package br.edu.unoesc.acessoservice.restapi.controller.impl.api.v1.crud.perfil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.acessoservice.business.common.service.AcessoService;
import br.edu.unoesc.acessoservice.common.model.Acesso;
import br.edu.unoesc.acessoservice.common.model.Perfil;
import br.edu.unoesc.acessoservice.restapi.common.constants.AcessoRestapiConstants;
import br.edu.unoesc.acessoservice.restapi.common.dto.AcessoDTO;
import br.edu.unoesc.acessoservice.restapi.converter.AcessoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractDetailRestController;

@RestController
@RequestMapping(AcessoRestapiConstants.PERFIL_ACESSO_V1)
public class PerfilAcessoRestController extends AbstractDetailRestController<Perfil, Acesso, AcessoDTO, AcessoService, AcessoDTOConverter>{
}
