package com.trybe.consultafilmes;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class Consultas.
 *
 */
public class Consultas {

  private final Collection<Filme> filmes;

  public Consultas(Collection<Filme> filmes) {
    this.filmes = filmes;
  }

  /*
   Comentário para fins didáticos:
   Outras opções para resolver o mesmo problema:
    Set<String> atores = new HashSet<>();
    for (Filme filme : filmes) {
      for (String personagem : filme.atoresPorPersonagem.keySet()) {
        if (filme.atoresPorPersonagem.get(personagem).contains(personagem)) {
          atores.add(personagem);
        }
      }
    }
    return atores;

    ou
    
    Set<String> atores = new HashSet<>();
    for (Filme filme : filmes) {
      atores.addAll(filme.atoresPorPersonagem.entrySet().stream()
          .filter(entry -> entry.getValue().contains(entry.getKey()))
          .map(key -> key.getKey())
          .collect(Collectors.toSet()));
    }
    return atores;
  */
  /**
   * Consulta 1: a partir da coleção de filmes desta classe, este método retorna o conjunto
   * de atores que interpretaram a si próprios em pelo menos um desses filmes.
   *
   * <p>Considera-se "atores que interpretaram a si próprios" aqueles que têm o seu nome como
   * uma das chaves do Map `atoresPorPersonagem` e também como um dos itens pertencentes ao
   * conjunto associado a esta mesma chave.</p>
   */
  public Set<String> atoresQueInterpretaramSiProprios() {
    return filmes.stream()
        .flatMap(f -> f.atoresPorPersonagem.entrySet().stream())
        .filter(e -> e.getValue().contains(e.getKey()))
        .map(ator -> ator.getKey())
        .collect(Collectors.toSet());
  }

  /**
   * Consulta 2: a partir da coleção de filmes desta classe, este método retorna a lista de atores
   * que atuaram em pelo menos um filme de um determinado diretor. A lista retornada está disposta
   * em ordem alfabética.
   *
   * <p>Considera-se que um ator tenha atuado em um filme de um determinado diretor se ele tem o
   * seu nome como um dos itens do campo `atores`, ao mesmo tempo em que o diretor em questão
   * tem o seu nome como um dos itens do campo `diretores` do mesmo filme.</p>
   */
  public List<String> atoresQueAtuaramEmFilmesDoDiretorEmOrdemAlfabetica(String diretor) {
    return filmes.stream()
        .filter(f -> f.diretores.contains(diretor))
        .flatMap(f -> f.atores.stream())
        .distinct()
        .sorted()
        .collect(Collectors.toList());
  }

  /**
   * Consulta 3: a partir da coleção de filmes desta classe, este método retorna a lista de filmes
   * em que pelo menos um dos diretores tenha atuado. A lista retornada está disposta em ordem de
   * lançamento, com os filmes mais recentes no início.
   *
   * <p>Considera-se "filmes em que pelo menos um dos diretores tenha atuado" aqueles em que
   * pelo menos um dos itens do campo `diretores` também é um item do campo `atores`.</p>
   */
  public List<Filme> filmesEmQuePeloMenosUmDiretorAtuouMaisRecentesPrimeiro() {
    return filmes.stream()
        .filter(f -> f.diretores.stream().anyMatch(d -> f.atores.contains(d)))
        .distinct()
        .sorted((f1, f2) -> f2.anoDeLancamento - f1.anoDeLancamento)
        .collect(Collectors.toList());
  }

  /**
   * Consulta 4: a partir da coleção de filmes desta classe, este método retorna um Map contendo
   * todos os filmes lançados em um determinado ano agrupados por categoria.
   *
   * <p>Cada chave do Map representa uma categoria, enquanto cada valor representa o
   * conjunto de filmes que se encaixam na categoria da chave correspondente.</p>
   */
  public Map<String, Set<Filme>> filmesLancadosNoAnoAgrupadosPorCategoria(int ano) {
    Set<Filme> filmesDoAno = filmes.stream()
        .filter(f -> f.anoDeLancamento == ano)
        .collect(Collectors.toSet());

    return filmesDoAno.stream()
        .flatMap(f -> f.categorias.stream())
        .distinct()
        .sorted()
        .collect(Collectors.toMap(c -> c, c -> filmesDoAno.stream()
            .filter(f -> f.categorias.contains(c))
            .collect(Collectors.toSet())));
  }
}
