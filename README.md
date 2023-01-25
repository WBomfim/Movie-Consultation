### Termos e acordos

Ao iniciar este projeto, você concorda com as diretrizes do Código de Ética e Conduta e do Manual da Pessoa Estudante da Trybe.

---

# Boas vindas ao repositório do desafio da Aceleração Java!

Você já usa o GitHub diariamente para desenvolver os exercícios, certo? Agora, para desenvolver o desafio, você deverá seguir as instruções a seguir. Fique atento a cada passo, e se tiver qualquer dúvida, nos envie por _Slack_! #vqv 🚀

Aqui você vai encontrar os detalhes de como estruturar o desenvolvimento do seu desafio a partir deste repositório, utilizando uma branch específica e um _Pull Request_ para colocar seus códigos.

---
# Instruções para entregar seu projeto

## Não se esqueça de consultar as documentações!

⚠️ **Importante**:

Esse projeto tem como intuito te treinar para ter mais familiaridade com a documentação de aplicações, por tanto, poderão haver alguns comandos ou atributos que não estão no curso, mas que devem ser descritos no decorrer dos requisitos.

Nesses casos, é importante se atentar a aquilo que o requisito pede, e lembrar sempre de utilizar a [documentação oficial](https://docs.oracle.com/en/java/javase/11/) do Java para pesquisar detalhes sobre comandos.


## Antes de começar a desenvolver

Lembre-se que você pode consultar nosso conteúdo sobre [Git & GitHub](https://course.betrybe.com/intro/git/) sempre que precisar!

1. Clone o repositório
  * Por exemplo: `git clone git@github.com:tryber/desafio-aceleracao.git`
  * Entre no diretório do repositório que você acabou de clonar:
    * neste caso `cd desafio-aceleracao`

2. Instale as dependências:
    * `mvn install`

3. Crie uma branch a partir da branch `main`

  * Verifique que você está na branch `main`
    * Exemplo: `git branch`
  * Se não estiver, mude para a branch `main`
    * Exemplo: `git checkout main`
  * Agora, crie uma branch onde você vai guardar os commits do seu desafio
    * Você deve criar uma branch no seguinte formato: `nome-de-usuario-nome-do-desafio`
    * Exemplo:
      * `git checkout -b joaozinho-acc-java-sample`

4. Adicione a sua branch com o novo `commit` ao repositório remoto

  - Usando o exemplo anterior:
    - `git push -u origin joaozinho-acc-java-sample`

5. Crie um novo `Pull Request` _(PR)_
  * Vá até a aba de _Pull Requests_ deste repositório no GitHub
  * Clique no botão verde _"New pull request"_
  * Clique na caixa de seleção _"Compare"_ e escolha a sua branch **com atenção**
  * Clique no botão verde _"Create pull request"_
  * Adicione uma descrição para o _Pull Request_ e clique no botão verde _"Create pull request"_
  * **Não se preocupe em preencher mais nada por enquanto!**
  * Volte até a página de _Pull Requests_ do repositório e confira que o seu _Pull Request_ está criado
 
 ⚠️ **Lembre-se do CheckStyle! Deixe seu Eclipse configurado para arrumar o estilo automaticamente. Qualquer dúvida, volte no conteúdo.**

---

## Durante o desenvolvimento

* ⚠ **PULL REQUESTS COM ISSUES NO CHECKSTYLE NÃO SERÃO AVALIADAS, ATENTE-SE PARA RESOLVÊ-LAS ANTES DE FINALIZAR O DESENVOLVIMENTO!** ⚠

* Faça `commits` das alterações que você fizer no código regularmente

* Lembre-se de sempre após um (ou alguns) `commits` atualizar o repositório remoto

* Os comandos que você utilizará com mais frequência são:
  1. `git status` _(para verificar o que está em vermelho - fora do stage - e o que está em verde - no stage)_
  2. `git add` _(para adicionar arquivos ao stage do Git)_
  3. `git commit` _(para criar um commit com os arquivos que estão no stage do Git)_
  4. `git push -u origin nome-da-branch` _(para enviar o commit para o repositório remoto na primeira vez que fizer o `push` de uma nova branch)_
  5. `git push` _(para enviar o commit para o repositório remoto após o passo anterior)_

---

## Depois de terminar o desenvolvimento (opcional)

Para **"entregar"** seu projeto, siga os passos a seguir:

* Vá até a página **DO SEU** _Pull Request_, adicione a label de _"code-review"_ e marque seus colegas
  * No menu à direita, clique no _link_ **"Labels"** e escolha a _label_ **code-review**
  * No menu à direita, clique no _link_ **"Assignees"** e escolha **o seu usuário**
  * No menu à direita, clique no _link_ **"Reviewers"** e digite `students`, selecione o time `tryber/students-sd-0x`

Se ainda houver alguma dúvida sobre como entregar seu projeto, [aqui tem um video explicativo](https://vimeo.com/362189205).

---

# Requisitos do desafio

## Consultas de filmes

Este desafio é para quem gosta de cinema (e de manipular umas listas em Java vez ou outra 🤪)!

Nós temos uma classe que representa um filme de forma bem simples:

```java
import java.util.Map;
import java.util.Set;

public class Filme {

  public final String titulo;
  public final int anoDeLancamento;
  public final Set<String> categorias;
  public final Set<String> diretores;
  public final Set<String> atores;
  public final Set<String> personagens;
  public final Map<String, Set<String>> atoresPorPersonagem;

  // ...
}
```

Os campos `categorias`, `diretores`, `atores` e `personagens` são todos conjuntos de Strings porque cada um deles pode ter múltipos valores. Por exemplo, um filme pode se encaixar em múltiplas categorias (ação, comédia etc.) e também pode ter mais de um diretor (em alguns filmes da Marvel, os irmãos Russo, Joe e Anthony, por exemplo).

O campo `atoresPorPersonagem` é um Map que associa o nome de um personagem (`String`) a um conjunto de atores (`Set<String>`). Por exemplo, em Space Jam (2021), o personagem LeBron James é interpretado pelo próprio jogador da NBA em sua fase adulta, mas é também interpretado mais jovem pelo ator Stephen Kankole.

Seu objetivo é implementar uma classe que realiza as seguintes consultas sobre uma dada coleção de filmes:

1. Atores que interpretaram a si próprios.
2. Atores que atuaram em filmes de um determinado diretor, por ordem alfabética.
3. Filmes em que o diretor atuou (ou pelo menos um deles), por ordem de lançamento (mais recentes primeiro).
4. [Bônus] Filmes lançados em um determinado ano, agrupados por categoria.

Observações:

- "Atores que interpretaram a si próprios" se refere a atores que, em pelo menos um filme, têm o seu nome como uma das chaves do Map `atoresPorPersonagem` e também como um dos itens pertencentes ao conjunto associado a esta mesma chave.

- "Atores que atuaram em filmes de um determinado diretor" se refere a atores que, em pelo menos um filme, têm o seu nome como um dos itens do campo `atores`, ao mesmo tempo em que o diretor em questão tem o seu nome como um dos itens do campo `diretores`.

- "Filmes em que o diretor atuou (ou pelo menos um deles)" se refere a filmes em que pelo menos um dos itens do campo `diretores` também é um item do campo `atores`.

## Requisitos do código

Você deve programar a classe `Consultas` a partir do modelo a seguir:

- `Consultas.java`
```java
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Consultas {

  private final Collection<Filme> filmes;

  public Consultas(Collection<Filme> filmes) {
    this.filmes = filmes;
  }

  public Set<String> atoresQueInterpretaramSiProprios() {
    return emptySet(); // TODO: Implementar.
  }

  public List<String> atoresQueAtuaramEmFilmesDoDiretorEmOrdemAlfabetica(String diretor) {
    return emptyList(); // TODO: Implementar.
  }

  public List<Filme> filmesEmQuePeloMenosUmDiretorAtuouMaisRecentesPrimeiro() {
    return emptyList(); // TODO: Implementar.
  }

  public Map<String, Set<Filme>> filmesLancadosNoAnoAgrupadosPorCategoria(int ano) {
    return emptyMap(); // TODO: Implementar (bônus).
  }
}
```

Cada método equivale a uma das consultas. Cada método deve retornar dados obtidos do atributo `filmes` que pertence à classe, atendendo ao requisito de cada consulta. Repare nos tipos retornados:

- A primeira consulta retorna um `Set<>`, pois os resultados não têm uma ordem definida.
- A segunda consulta retorna `List<>`, pois os resultados são dispostos em ordem alfabética.
- A terceira consulta retorna `List<>`, pois os resultados são dispostos em ordem de lançamento.
- A quarta consulta retorna um `Map<String, Set<Filme>>`. As chaves (`String`) do Map representam uma categoria, enquanto os valores (`Set<Filme>`) representam o conjunto de filmes que se encaixam nessa categoria.

⚠️ **Importante!** Você nunca deve retornar `null`. Se nenhum dos itens atende aos requisitos da consulta, retorne uma coleção (Set, List ou Map) vazia.

Você também deve prestar atenção à possibilidade de um item ser incluso mais de uma vez na coleção retornada:
- A coleção Set não muda quando se adiciona um item que já pertencia ao conjunto. Portanto, você não precisa se preocupar com duplicidade na consulta 1, em que o tipo retornado é Set.
- A coleção List permite a existência de itens duplicados. Porém **as consultas 2 e 3 (que retornam Lists) não devem retornar coleções contendo itens duplicados**. Certifique-se de que cada ator/filme apareça na lista no máximo uma vez.
- Na consulta 4, se um mesmo filme se encaixa em mais de uma categoria, ele deve estar presente em todos os conjuntos correspondentes. Por consequência, o filme vai aparecer mais de uma vez dentro do Map.

Você pode implementar os métodos da classe `Consultas` de duas formas:

- Por meio de manipulação direta de coleções, construindo Lists, Sets e Maps manualmente, iterando coleções usando `for` e chamando métodos como `add()`, `addAll()` e `get()`.
- Por meio da API `java.util.stream`, chamando métodos como `stream`, `filter`, `map`, `flatMap` e `collect`.

As duas formas são válidas, sendo possível inclusive utilizar as duas ao mesmo tempo. O importante é que os dados sejam retornados conforme o requisito de cada consulta.

## Validação do código

Para conseguir rodar o seu código e verificar se ele funciona, você pode usar uma classe `Principal`, conforme o modelo a seguir:

- `Principal.java`
```java
import java.util.Set;

public class Principal {

  public static void main(String[] args) {
    Consultas consultas = new Consultas(Filmes.todos());
    Set<String> resultados = consultas.atoresQueInterpretaramSiProprios();
    System.out.println(resultados);
  }
}
```

A classe `Filmes` contém alguns filmes que possuem dados incompletos, mas que servem bem ao propósito de validar o resultado das consultas. Essa classe estará disponível para você utilizar e também ler o código fonte, caso necessite. Existe outra classe auxiliar, `ConstrutorDeFilme`, que também será disponibilizada, mas você não precisa se preocupar com ela, já que sua função é facilitar o carregamento dos dados da classe `Filmes`.

Para garantir a experiência completa, não tire os olhos da tela. Bom filme! Quer dizer... boa sorte no desafio! 🍿

---

# Avisos Finais

Ao finalizar e submeter o desafio, não se esqueça de avaliar sua experiência preenchendo o formulário. Leva menos de 3 minutos!

Link: [Formulário](https://be-trybe.typeform.com/to/PsefzL2e)

O avaliador automático não necessariamente avalia seu projeto na ordem em que os requisitos aparecem no readme. Isso acontece para deixar o processo de avaliação mais rápido. Então, não se assuste se isso acontecer, ok?

---
