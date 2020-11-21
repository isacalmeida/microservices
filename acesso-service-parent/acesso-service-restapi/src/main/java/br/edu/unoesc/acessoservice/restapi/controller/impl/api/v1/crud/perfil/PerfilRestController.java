package br.edu.unoesc.acessoservice.restapi.controller.impl.api.v1.crud.perfil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.acessoservice.business.common.service.PerfilService;
import br.edu.unoesc.acessoservice.common.model.Perfil;
import br.edu.unoesc.acessoservice.restapi.common.constants.AcessoRestapiConstants;
import br.edu.unoesc.acessoservice.restapi.common.dto.PerfilDTO;
import br.edu.unoesc.acessoservice.restapi.converter.PerfilDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractMasterRestController;

@RestController
@RequestMapping(AcessoRestapiConstants.PERFIL_V1)
public class PerfilRestController extends AbstractMasterRestController<Perfil, PerfilDTO, PerfilService, PerfilDTOConverter> {
}
