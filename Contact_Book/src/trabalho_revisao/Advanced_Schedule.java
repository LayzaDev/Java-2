package trabalho_revisao;

import java.util.Scanner;

public class Advanced_Schedule extends Schedule {
    
    public Advanced_Schedule(){
        super();
    }
    
    private void modifyName(){
        System.out.println("\nInforme o nome do contato que deseja alterar: ");
        String name = scan.next();

        for (Contact contact : this.contactsList) {
            if(contact.getName().equals(name)){
                contact.printContact();
                System.out.println("\nNovo nome: ");
                String newName = scan.next();
                contact.setName(newName);
            }
        }
    }
    
    private void modifyPhone(){
        System.out.println("\nInsira o telefone do contato que deseja alterar: ");
                int phone = scan.nextInt();
                
                for(Contact contact : this.contactsList){
                    if(contact.getPhone() == phone){
                        contact.printContact();
                        System.out.println("\nNovo telefone: ");
                        int number = scan.nextInt();
                        contact.setPhone(number);
                    }
                }
    }

    private void modifyEmail(){
        System.out.println("\nInsira o email do contato que deseja alterar: ");
        String email = scan.next();

        for(Contact contact : this.contactsList){
            if(contact.getEmail().equals(email)){
                contact.printContact();
                System.out.println("\nNovo email:");
                String newEmail = scan.next();
                contact.setEmail(newEmail);
            }
        }
    }
    
    private void modifyEverything(){
        System.out.println("\nInforme o nome do contato que deseja alterar: ");
        String name = scan.next();
        
        for (Contact contact : this.contactsList) {
            if(contact.getName().equals(name)){
                contact.printContact();
                System.out.println("\nNovo nome: ");
                String newName = scan.next();
                contact.setName(newName);
                System.out.println("\nNovo telefone:");
                int newPhone = scan.nextInt();
                contact.setPhone(newPhone);
                System.out.println("\nNovo email:");
                String newEmail = scan.next();
                contact.setEmail(newEmail);
            }
        }
    }
    
    private void modifyContact(){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n============== ALTERAR CONTATO ==============\n");
        
        System.out.println("O que deseja alterar?: "
                + "\n1. Nome"
                + "\n2. Telefone"
                + "\n3. Email"
                + "\n4. Todas as opções"
                + "\n5. Cancelar");
        
        int op = scan.nextInt();

        switch (op) {
            case 1:
                this.modifyName();
                System.out.println("\nNome alterado com sucesso!");
                break;
            case 2:
                this.modifyPhone();
                System.out.println("\nTelefone alterado com sucesso!");
                break;
            case 3:
                this.modifyEmail();
                System.out.println("\nEmail alterado com sucesso!");
                break;
            case 4:
                this.modifyEverything();
                System.out.println("\nContato alterado com sucesso!");
                break;
            case 5:
                System.out.println("\nCancelado com sucesso!");
                break;
            default:
                System.out.println("\nError: Opcao invalida!");
                break;
        }
    }
    
    @Override
    protected void menu(){
        
        Scanner scan = new Scanner(System.in);
        
        int op;
        
        do{
            System.out.println("\n==================== MENU ====================\n"
                        + "\n1. Cadastrar Contato"
                        + "\n2. Buscar Contato"
                        + "\n3. Excluir Contato"
                        + "\n4. Imprimir Contato"
                        + "\n5. Alterar Contato"
                        + "\n6. Sair");

            op = scan.nextInt();

            switch(op){
                case 1: 
                    super.registerContact();
                    break;
                case 2: 
                    super.checkSearchForm();
                    break;
                case 3: 
                    super.deleteContact();
                    break;
                case 4:
                    super.printAgenda();
                    break;
                case 5:
                    this.modifyContact();
                    break;
                case 6:
                    System.out.println("\n=============================================");
                    System.out.println("                 Encerrando...");
                    System.out.println("=============================================\n");
                    break;
                default:
                    System.out.println("\n=============================================");
                    System.out.println("             Opcao invalida...");
                    System.out.println("=============================================");
                    break;
            }
        } while(op != 6);
    }
}
/*    
    private void modifyContact(String searchKey) {
        System.out.println("\n============== ALTERAR CONTATO ==============\n");
        
        for (Contact contact : this.contactsList) {
            if (searchKey.equals("Nome") && contact.getName().equals(searchKey) ||
                searchKey.equals("Telefone") && contact.getPhone() == Integer.parseInt(searchKey)) {
                
                contact.printContact();
                System.out.println("\nNovo " + searchKey + ": ");
                String newValue = scan.next();

                if (searchKey.equals("Nome")) {
                    contact.setName(newValue);
                } else {
                    contact.setPhone(Integer.parseInt(newValue));
                }

                System.out.println("\nContato alterado com sucesso!");
                return;
            }
        }
    }
    
    private void newMenu() {
        System.out.println("\nBuscar contato por meio de: "
                + "\n1. Nome"
                + "\n2. Telefone"
                + "\n3. Cancelar");

        int op = scan.nextInt();

        switch (op) {
            case 1:
                System.out.println("\nInforme o nome do contato que deseja buscar: ");
                String name = scan.next();
                modifyContact(name);
                break;
            case 2:
                System.out.println("\nInsira o telefone do contato que deseja buscar: ");
                int phone = scan.nextInt();
                modifyContact(String.valueOf(phone));
                break;
            case 3:
                System.out.println("\nCancelado com sucesso!");
                break;
            default:
                System.out.println("\nError: Opcao invalida!");
                break;
        }
    }
    
    @Override
    protected void menu() {
        super.menu();
        
        System.out.println("\n 5. Alterar Contato"
                    + "\n 6. Sair");
        
        int op = scan.nextInt();
            
        switch (op) {
            case 5:
                this.newMenu();
                break;
            case 6:
                System.out.println("\n=============================================");
                System.out.println("                 Encerrando...");
                System.out.println("=============================================\n");
                break;
            default:
                System.out.println("\n=============================================");
                System.out.println("             Opcao invalida...");
                System.out.println("=============================================");
                break;
        }
    }
}
*/
 
    

