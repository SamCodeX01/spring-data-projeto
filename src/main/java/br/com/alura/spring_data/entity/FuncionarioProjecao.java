package br.com.alura.spring_data.entity;

public interface FuncionarioProjecao {
    Integer getId();
    String getNome();
    Double getSalario();
}


/*

o que são projeções?........

A projeção também é chamada de Interface based Projection, para definir essa projeção, baseia-se em uma interface.

a diferença entre interface e class-based projections.


Qual o porquê dessa interface?

Quando fazemos projeções com o Spring Data, temos que criar uma interface dentro do nosso projeto. Qual é a função dessa interface?

Criar uma entidade projetada contendo os atributos que queremos apresentar.
O objetivo de criar essa interface é encapsular os valores de retorno da consulta dentro de métodos.

1. Criar uma interface que sera a projeção e colocar os métodos que serão os campos da entidade que serão buscados nas consultas:

public interface FuncionarioProjecao {
    Integer getId();
    String getNome();
    Double getSalario();
}

Como alternativa, podemos também usar uma classe com o mesmo propósito:

public class FuncionarioDto {
    private Integer id;
    private String nome;
    private Double salario;

    //getter e setter

    //construtor recebendo os atributos
    //na ordem da query
}

Uma classe dá muito mais trabalho de escrever e manter, mas pode ter uma vantagem, pois podemos adicionar métodos mais específicos que podem fazer sentido para a view (por exemplo, os de formatação).



2. Retornar uma lista dessa interface de projeção no repositorio:

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, JpaSpecificationExecutor, JpaRepository<Funcionario, Integer> {
    List<Funcionario> findByNome(String nome);

        @Query(value = "select id, nome, salario from funcionarios", nativeQuery = true)
        List<FuncionarioProjecao> findFuncionarioSalario();

    }

    A query do repository irá fazer o select nativo do sql buscando apenas o id, nome e salario dentro da base de dados da entidade funcionarios, convertendo e listando uma projeção apenas desses 3 campos através do método findFuncionarioSalario

3. Criar no service uma entidade projetada com os registros/atributos que queremos apresentar dentro de um relatório:

@Service
public class RelatoriosService {
    private boolean system = true;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private FuncionarioRepository funcionarioRepository;
    private FuncionarioProjecao funcionarioProjecao;

    RelatoriosService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    ═════════════════════════════
                                MENU
                    ═════════════════════════════

                    Qual relatório deseja executar?

                    1 - Pesquisa Funcionário Salário:
                    2 - Buscar.................................:
                    3 - Buscar.................................::
                    1 - Buscar.................................::

                    Escolha: """);

            int op = scanner.nextInt();

            switch (op) {
                case 1 -> pesquisaFuncionarioSalario();
                case 2 -> ......................();
                case 3 -> ......................();
                case 4 -> ......................();
                default -> System.out.println("\n⚠️ Opção inválida!");
            }
            //break;
        }

    }


    private void pesquisaFuncionarioSalario(){
        List<FuncionarioProjecao> list = funcionarioRepository.findFuncionarioSalario(); //FuncionarioProjecao recebe através da @Query no Repositoy o que foi buscado no bando de dados
        list.forEach(f -> System.out.println("Funcionário: id: " + f.getId()
                + " | nome: " + f.getNome() + " | salario: " + f.getSalario()));
        //Acima o forEach lista cada campo buscado no banco de dados que é cada metodo da interface FuncionarioProjecao
    }

}




}

*/