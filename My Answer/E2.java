import java.util.regex.Pattern;

public class E2{

    public static void Q1(double billing, double costs, double tax){
        double tax_value = billing * tax;
        double profit = billing - costs - tax_value;
        double profit_margin = profit/billing;
        System.out.println(
            " - Lucro: " + String.format("%.2f", profit) +
            "\n - Margem de Lucro: " + String.format("%.2f", profit_margin)
        );
    }

    public static void Q1(double billing, double costs){
        double profit = billing - costs;
        double profit_margin = profit/billing;
        System.out.println(
            " - Lucro: " + String.format("%.2f", profit) +
            "\n - Margem de Lucro: " + ((int) (profit_margin*100)) + "%\n"
        );
    }

    public static void Q2(String nome, String email){
        nome = nome.strip();
        nome = Pattern.compile("\\b([a-z])")
            .matcher(nome.toLowerCase())
            .replaceAll(m -> m.group().toUpperCase());
        email = email.strip().toLowerCase();
        System.out.println(" - Nome: " + nome + "\n - Email: " + email + "\n");

    }

    public static void Q3(String email, String new_domain){
        int atPos = email.indexOf('@');
        if (atPos != -1){
            String localPart = email.substring(0, atPos);
            String updated_email = localPart + new_domain;
            System.out.println(" - Email Atualizado: " + updated_email + "\n");
            email = updated_email;
        } 
    }

    public static void Q3(String email, String new_domain, String old_domain){
        if (email.endsWith(old_domain)) {
            String updated_email = email.substring(0, email.length() - old_domain.length()) + new_domain;
            System.out.println(" - Email Atualizado: " + updated_email + "\n");
            email = updated_email;
        }
    }

    public static void Q4(String email){
        int atPos = email.indexOf('@');
        if (atPos != -1){
            String extracted_username = email.substring(0, (atPos));
            System.out.println(" - Username Extraído: " + extracted_username + "\n");
        } 
    }

    public static void Q5(String name){
        int atPos = name.indexOf(' ');
        if (atPos != -1){
            String firstname = name.substring(0, (atPos));
            firstname = Pattern.compile("\\b([a-z])")
            .matcher(firstname.toLowerCase())
            .replaceAll(m -> m.group().toUpperCase());
            System.out.println(">> Olá, " + firstname + ", seja bem-vindo ao nosso clube!");
        } 
    }

    public static void main(String[] args){
        System.out.println("Relatório de Margem de Lucro");
        Q1(45000, 23500);
        System.out.println("Padronização de Dados de CRM");
        Q2(" mArCoS aNtOnIo rOcHa ", " MARCOS.ROCHA@GMAIL.COM ");
        System.out.println("Migração de Servidor de E-mail");
        Q3("andre_silva@empresa.com.br", "@grupocorp.com", "@empresa.com.br");
        System.out.println("Extração de Username para Log");
        Q4("beatriz.oliveira@grupocorp.com");
        System.out.println("Personalização de E-mail de Marketing");
        Q5("lucas ferreira souza");
    }
}