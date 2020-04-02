# titamidark
Spring Boot Essentials

1. No arquivo de inicialização do projeto Spring Boot,
tem que colocar a notação
"@EnableAutoConfiguration" - Para que todas as dependencias sejam inicializadas.
"@ComponentScan(basePackages = "xxxxxxxxxxxx") - Informar onde está a classe do Endpoint (pacote)
    Obs: Melhores práticas, colocar a classe de inicialização na raiz do projeto, pois, assim,
    não precisa informar qual é a basePackages.

    Obs2.: Para substituir todas as notações anteriores, inclusivo a notação "@Configuration",
    basta utilizar a notação "@SpringBootApplication"


2.Neste projeto, nosso endpoint será a classe "StudentEndpoint". Iniciando com a notação
"@RestController" - para configurar as chamadas
"@RequestMapping("xxxxx")" - fazer o mapeamento para acessar a API Rest
"@Autowired" - Vai instanciar as dependências do projeto

3. Criar um pacote "Utils" para que sejam criadas classes utilitárias e sempre nelas colocar pelo
menos que as mesmas tenham a notação "@Component"

4. Para ter uma "build" mais rápido, tem que configurar o hot swap:
    . colocar a dependência "devtools"
    . na confguração "settings-compiler" marcar a opção "Build Project Automatically"
    , Digite Ctrl+Shift+L e vá para o "registry" e marque a opção "compiller.automake.allow.when.app.running"
   com isso, toda alteração no código após ser salva, vai startar o build e executar o projeto


