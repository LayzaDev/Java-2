package trabalho_revisao;

public class Contact {
    private String name, email;
    private int phone;

    public Contact(String name, int phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getPhone(){
        return this.phone;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public void setPhone(int p){
        this.phone = p;
    }
    
    public void setEmail(String e){
        this.email = e;
    }
    
    public void printContact(){
        System.out.println("\nNome: " + this.getName() 
                    + "\nTelefone: " + this.getPhone()
                    + "\nEmail: " + this.getEmail());
    }
    
    public void showPhone(){
        System.out.println("\nTelefone: " + this.getPhone()); 
    }
    
    public void showName(){
        System.out.println("\nNome: " + this.getName()); 
    }
}
