package com.caue.sentinela.model.enums;

public enum UserRole {
    ADMIN, //Gerencia usuários, permissões e configurações do sistema.
    SAFETY_TECHNICIAN, //Gerencia riscos, EPIs, acidentes, inspeções e treinamentos.
    OCCUPATIONAL_PHYSICIAN, //Gerencia exames ocupacionais, ASOs e informações médicas.
    HR, //Gerencia funcionários, admissões, demissões e consultas de documentos.
    MANAGER //Consulta dashboards, indicadores e relatórios.
}