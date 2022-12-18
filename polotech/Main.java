package br.com.americanas.polotech;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Main {
    public static void main(String[] args) {
        boolean validaSenha = true, menu2 = true;
        String senha, confirmaSenha, nome, confirmaNome, mensagem;
        String[] tweeter = new String[1000];
        int contaTweeter = 0, contaTimeLine = 0;

        Scanner scanner = new Scanner(System.in);
        usuario user = new usuario();

        System.out.println("=====================");
        System.out.println("Bem Vindo ao Twitter!");
        System.out.println("=====================");
        System.out.println("Escolha sua opção:");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastrar");

        int opcao = Integer.parseInt(scanner.nextLine());

        switch (opcao){
            case 1:

                System.out.print("Usuário: ");
                nome = scanner.nextLine();
                System.out.print("Senha: ");
                senha = scanner.nextLine();
                if(nome.equals(user.name) && senha.equals(user.password)){
                    System.out.println("Login feito com sucesso!");
                    System.out.println("1 - Timeline");
                    System.out.println("2 - Tweetar");
                    System.out.println("3 - Sair");
                }
            break;
            case 2:
                System.out.println("=== Cadastro de novo usuário ===");
                System.out.println("Escolha seu usuário: ");
                nome = scanner.nextLine();
                while(validaSenha) {
                    System.out.println("Escolha sua senha: ");
                    senha = scanner.nextLine();
                    System.out.println("Confirme sua senha: ");
                    confirmaSenha = scanner.nextLine();
                    if(senha.equals(confirmaSenha)){
                        validaSenha = false;
                        user.name = nome;
                        user.password = senha;
                        System.out.println("Usuário cadastrado com sucesso!");
                        System.out.println("Para começar entre com seu usuário e senha:");
                        System.out.print("Usuário: ");
                        confirmaNome = scanner.nextLine();
                        System.out.print("Senha: ");
                        senha = scanner.nextLine();
                        if(confirmaNome.equals(user.name) && senha.equals(user.password)){
                            System.out.println("Login feito com sucesso!");
                            while(menu2) {
                                System.out.println("1 - Timeline");
                                System.out.println("2 - Tweetar");
                                System.out.println("3 - Sair");
                                opcao = 0;
                                opcao = Integer.parseInt(scanner.nextLine());
                                switch (opcao) {
                                    case 1:
                                        if (contaTweeter != 0) {
                                            for (int i = contaTimeLine - 1; i >= 0; i--) {
                                                if (tweeter[i] != null) {
                                                    System.out.println(tweeter[i]);
                                                    System.out.println(i);
                                                }
                                                if(i == 0){
                                                    break;
                                                }
                                            }

                                        } else {
                                            System.out.println("Não há nenhum tweet para ver no momento");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("O que você está pensando?");
                                        mensagem = scanner.nextLine();

                                        DateTimeFormatter dateTimeF = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
                                        mensagem = "["+dateTimeF.format(LocalDateTime.now())+"] - " +  mensagem + " - @" +user.name;
                                        tweeter[contaTimeLine] = mensagem;
                                        contaTimeLine++;
                                        contaTweeter = contaTimeLine;
                                        System.out.println("Tweet feito com sucesso!");
                                        break;
                                    case 3:
                                        System.out.println("teste");
                                        menu2 = false;
                                        break;

                                }
                            }
                        }else{
                            System.out.println("Usuário ou senha incorretos");
                        }


                    }else {
                        System.out.println("Senha inválida, tente novamente");
                    }
                }
            break;
            default:
                System.out.println("Opção inválida");
        }

    }
}
