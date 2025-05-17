# Sistema de Gestão de Biblioteca

Bem-vindo ao projeto de **Sistema de Gestão de Biblioteca**! Este projeto foi desenvolvido como parte do desafio da trilha de Java do Ignite. O principal objetivo é aplicar conceitos fundamentais de Java, tais como herança, polimorfismo, estruturas de repetição e manipulação de datas.

## Funcionalidades

### Gerenciamento de Livros

- **Listar todos os livros disponíveis:** Exibe apenas os livros que estão disponíveis para empréstimo.
- **Realizar empréstimo de um livro:** Permite que um usuário selecione um livro disponível e registre o empréstimo.

## Estrutura do Projeto

O projeto é organizado nas seguintes classes principais:

- **Livro:** Representa os livros da biblioteca, com atributos como `id`, `titulo`, `autor`, `disponivel`, `dataCadastro` e `dataAtualizacao`.
- **Autor:** Representa os autores dos livros, com atributos como `id`, `nome` e `dataNascimento`.
- **Emprestimo:** Gerencia os empréstimos de livros, incluindo informações sobre o livro emprestado e as datas de empréstimo e devolução.
- **Biblioteca:** Gerencia a coleção de livros, autores e empréstimos.

## Requisitos

- **Java Development Kit (JDK) 8 ou superior**
- **IDE de sua escolha:** (Eclipse, IntelliJ IDEA, NetBeans, etc.)

## Como Iniciar

Ao iniciar a aplicação, você será questionado se deseja ver os livros disponíveis. Após escolher um livro, é possível realizar um empréstimo, que será registrado, e assim o livro será marcado como indisponível.

## Contribuindo

Sinta-se à vontade para contribuir com o projeto! Você pode:

- Reportar bugs
- Sugerir novas funcionalidades
- Enviar **pull requests** com melhorias ou correções

## Licença

Este projeto está licenciado sob a MIT License.


