package com.bookhub.domain.exception.handler;

import lombok.Getter;

@Getter
public enum ProblemType {

    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível."),
    RECURSO_NAO_ENCONTRADA("/recurso-nao-encontrada", "Recurso não encontrada"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-negocio","Violação de regra de negócio"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro Inválido."),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro De Sistema."),
    DADOS_INVALIDOS("/dados-invalidos", "Dados Inválidos");

    private String title;
    private String uri;

    ProblemType(String path, String title){
        this.uri = "https://bookhub.com.br" + path;
        this.title = title;
    }
}
