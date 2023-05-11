import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int opcao = 0;
            Loja loja = null;
            Produto produto = null;

            while (opcao != 3) {

                // verificar se o produto está vencido
                if (produto != null && loja != null) {
                    Data dataVencimento = new Data(20, 10, 2023);
                    if (produto.estaVencido(dataVencimento)) {
                        System.out.println("PRODUTO VENCIDO");
                    } else {
                        System.out.println("PRODUTO NÃO VENCIDO");
                    }
                    // imprimir as informações da loja
                    System.out.println(loja.toString());
                }

                System.out.println("(1) criar uma loja");
                System.out.println("(2) criar um produto");
                System.out.println("(3) sair");
                System.out.print("Digite a opção desejada: ");
                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        input.nextLine(); // limpar o buffer
                        System.out.print("Digite o nome da loja: ");
                        String nomeLoja = input.nextLine();

                        System.out.print("Digite a quantidade de funcionários: ");
                        int qtdFuncionarios = input.nextInt();
            
                        System.out.print("Digite o salário base dos funcionários (opcional, pressione Enter para pular): ");
                        //double salarioBase = input.nextDouble();

                        String salarioStr = input.nextLine();

                        double salarioBase;
                        if (salarioStr.isEmpty()) {
                            salarioBase = -1.0; // valor padrão
                        } else {
                            try {
                                salarioBase = Double.parseDouble(salarioStr);
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida.");
                                salarioBase = -1.0; // valor padrão
                            }
                        }

                        input.nextLine(); // limpar o buffer
                        System.out.print("Digite o endereço da loja\n");
                        System.out.print("Nome da rua: ");
                        String rua = input.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = input.nextLine();
                        System.out.print("Estado: ");   
                        String estado = input.nextLine();
                        System.out.print("País: ");
                        String pais = input.nextLine();
                        System.out.print("CEP: ");
                        String cep = input.nextLine();
                        System.out.print("Número: ");
                        String numero = input.nextLine();
                        System.out.print("Complemento: ");
                        String complemento = input.nextLine();

                        System.out.print("Digite o dia de fundação da loja: ");
                        int dia = input.nextInt();

                        System.out.print("Digite o mês de fundação da loja: ");
                        int mes = input.nextInt();

                        System.out.print("Digite o ano de fundação da loja: ");
                        int ano = input.nextInt();

                        Data dataFundacao = new Data(dia, mes, ano);
                        if(salarioBase != -1.0){
                            loja = new Loja(nomeLoja, qtdFuncionarios, new Endereco(rua, cidade, estado, pais, cep, numero, complemento), dataFundacao);
                        } else {
                            loja = new Loja(nomeLoja, qtdFuncionarios, salarioBase, new Endereco(rua, cidade, estado, pais, cep, numero, complemento), dataFundacao);
                        }
                        System.out.println("Loja criada com sucesso!");
                        
                        break;

                    case 2:
                        input.nextLine(); // limpar o buffer
                        System.out.print("Digite o nome do produto: ");
                        String nomeProduto = input.nextLine();

                        System.out.print("Digite o preço do produto: ");
                        double precoProduto = input.nextDouble();

                        System.out.print("Digite o dia de validade do produto: ");
                        dia = input.nextInt();

                        System.out.print("Digite o mês de validade do produto: ");
                        mes = input.nextInt();

                        System.out.print("Digite o ano de validade do produto: ");
                        ano = input.nextInt();

                        Data dataValidade = new Data(dia, mes, ano);
                        produto = new Produto(nomeProduto, precoProduto, dataValidade);
                        System.out.println("Produto criado com sucesso!");
                        
                        break;

                    case 3:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }

        }
    }
}
