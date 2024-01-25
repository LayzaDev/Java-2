package trabalho_revisao;

import java.util.ArrayList;
import java.util.Scanner;

public class Schedule {
    
    Scanner scan = new Scanner(System.in);
    
    protected ArrayList<Contact>contactsList;
   
    public Schedule(){
       this.contactsList = new ArrayList<>();
       this.menu();
    }
    
    public ArrayList<Contact> getContactsList(){
        return this.contactsList;
    }
    
    public void setContactsList(Contact contact){
        this.contactsList.add(contact);
    }
    
    protected void registerContact(){
        System.out.println("\n============= REGISTRAR CONTATO =============\n");
        
        System.out.println("Nome do contato:");
        String name = scan.next();
        
        System.out.println("Telefone do contato:");
        int phone = scan.nextInt();

        System.out.println("Email do contato: ");
        String email = scan.next();
        Boolean check = false;
        
        do{
            for(Contact contact : this.contactsList){
                if(contact.getPhone() == phone && contact.getEmail().equals(email)) {
                    check = true;
                    System.out.println("\n*** Error: Este email e telefone já existe. ***\n");
                    System.out.println("Insira um numero diferente:");
                    phone = scan.nextInt();
                    System.out.println("\nInsira um email diferente:");
                    email = scan.next();
                } else if(contact.getPhone() == phone){
                    check = true;
                    System.out.println("\n*** Error: Este telefone já existe. ***\n");
                    System.out.println("Insira um numero diferente:");
                    phone = scan.nextInt();
                } else if(contact.getEmail().equals(email)){
                    check = true;
                    System.out.println("\n*** Error: Este email já existe. ***\n");
                    System.out.println("Insira um email diferente:");
                    email = scan.next();
                } else {
                    check = false;
                }
            }
        } while(check == true);
        
        Contact contact = new Contact(name, phone, email);
        this.setContactsList(contact);
        
        System.out.println("\nContato criado com sucesso!");
    }
    
    protected void searchContact(String name){
        
        Boolean contactFound = false;
        
        for (Contact contact : this.contactsList) {
            if(contact.getName().equals(name)){
                contact.showPhone();
                contactFound = true;
            }
        }
        
        if(!contactFound){
            checkContactExistence(contactFound);
        }
    }
    
    protected void searchContact(int phone){
        
        Boolean contactFound = false;
        
        for (Contact contact : this.contactsList) {
            if(phone == contact.getPhone()){
                contact.showName();
                contactFound = true;
            }
        }
        
        if(!contactFound){
            checkContactExistence(contactFound);
        }
    }
    
    protected void checkSearchForm(){
        System.out.println("\n=============== BUSCAR CONTATO ===============\n");
       
        System.out.println("Buscar contato por meio de: "
            + "\n1. Nome"
            + "\n2. telefone"
            + "\n3. Cancelar");
        int op= scan.nextInt();

        switch (op) {
            case 1:
                System.out.println("\nInforme o nome do contato que deseja buscar: ");
                String name = scan.next();
                searchContact(name);
                break;
            case 2:
                System.out.println("\nInsira o telefone do contato que deseja buscar: ");
                int phone = scan.nextInt();
                searchContact(phone);
                break;
            case 3:
                System.out.println("\nBusca cancelada!");
                break;
            default:
                System.out.println("\nError: Opcao invalida!");
                break;
        }
    }
    
    protected void deleteContact(){
         
        System.out.println("\n=============== EXCLUIR CONTATO ===============\n");
        System.out.println("Informe o nome do contato que deseja excluir: ");
        String nome = scan.next();
        
        Boolean contactFound = false;
        
        for(Contact contact : this.contactsList){
            if(contact.getName().equals(nome)){
                this.contactsList.remove(contact);
                contactFound = true;
                System.out.println("\nContato excluído com sucesso!");
                break;
            } 
        }
        
        if(contactFound == false){
            checkContactExistence(contactFound);
        }
    }
    
    private void checkContactExistence(Boolean contactFound){
        if(!contactFound){
            System.out.println("\nContato não encontrado.");
        }
    }
    
    protected void printAgenda(){
        
        System.out.println("\n============= LISTA DE CONTATOS =============");
        
        for(Contact contact : this.contactsList){
            contact.printContact();
        }
    }
    
    protected void menu(){
       
        int option;
        
        do{
            System.out.println("\n==================== MENU ====================\n"
                    + "\n1. Cadastrar Contato"
                    + "\n2. Buscar Contato"
                    + "\n3. Excluir Contato"
                    + "\n4. Imprimir Contato"
                    + "\n5. Sair");
            
                    
            option = scan.nextInt();
            
            switch(option){
                case 1: 
                    this.registerContact();
                    break;
                case 2: 
                    this.checkSearchForm();
                    break;
                case 3: 
                    this.deleteContact();
                    break;
                case 4:
                    this.printAgenda();
                    break;
                case 5:
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
        } while(option != 5);
    }
}
