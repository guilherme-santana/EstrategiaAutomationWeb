@buscarCurso
Feature: Buscar curso por professor

  Scenario: Buscar curso a partir do professor e validar se o valor apresentado na listagem corresponde ao valor do detalhamento
    Given que acesso o site Estrategia concursos
    When clico em Por professor
    Then apresenta a tela "Cursos por professor"
    When clico no professor "Ena Smith"
    Then apresenta a tela com os cursos de "Ena Smith"
    When clico no detalhamento do curso "ANM Inglês 2021 - (Pré-Edital)"
    Then apresenta a tela com os detalhes do curso "ANM Inglês 2021 - (Pré-Edital)"
    And valida se o valor parcelado corresponde com o valor total do curso