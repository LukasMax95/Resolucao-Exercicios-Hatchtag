import java.util.Scanner;
import java.util.regex.Pattern;

public class E3 {
    private static final Scanner scanner = new Scanner(System.in);

    private static String removeAllButLastDot(String s) {
        int last = s.lastIndexOf('.');
        if (last == -1) return s.replace(".", "");
        String before = s.substring(0, last).replace(".", "");
        String after = s.substring(last);
        if((s.length() - last) > 3) after = after.replace(".", "") + ".00";
        return before + after;
    }

    public static void Q1(){
        while(true){
            System.out.print("Digite o faturamento: ");
            String billing = scanner.nextLine();
            billing = billing.toUpperCase()
                             .replace("RS","")
                             .replace("R$","")
                             .trim();
            double numBilling = 0.0;
            try {
                numBilling = Double.parseDouble(billing);
                double tax = 0.15;
                double liquid_tax = numBilling * tax;
                System.out.printf("✓ Imposto pago: R$%.2f%n", liquid_tax);
                break;
                
            } catch (NumberFormatException e) {
                //int atPos = billing.indexOf(".");
                //if(atPos != -1) billing = billing.substring(0, atPos) + billing.substring((atPos + 1));
                billing = billing.replace(",", ".");
                billing = removeAllButLastDot(billing);
                try {
                    numBilling = Double.parseDouble(billing);
                    double tax = 0.15;
                    double liquid_tax = numBilling * tax;
                    System.out.printf("✓ Imposto pago: R$%.2f%n", liquid_tax);
                    break;
                } catch (NumberFormatException e3) {
                    System.out.println("❌ Formato inválido! Digite um valor numérico válido.");
                }
            }
        }
    }

    public static double extractBillingValue(){
        while(true){
            String billingValue = scanner.nextLine();
            billingValue = billingValue.toUpperCase()
                                       .replace("RS","")
                                       .replace("R$","")
                                       .trim();
            double numBilling = 0.0;
            try {
                numBilling = Double.parseDouble(billingValue);
                return numBilling;
                
            } catch (NumberFormatException e) {
                billingValue = billingValue.replace(",", ".");
                billingValue = removeAllButLastDot(billingValue);
                try {
                    numBilling = Double.parseDouble(billingValue);
                    return numBilling;
                } catch (NumberFormatException e3) {
                    System.out.println("❌ Formato inválido! Digite um valor numérico válido.");
                }
            }
        }
    }

    public static void Q2(){
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        int pos = nome.indexOf(" ");
        nome = Pattern.compile("\\b([a-z])")
            .matcher(nome.toLowerCase())
            .replaceAll(m -> m.group().toUpperCase());
        String firstname = "";
        if(pos != -1) firstname = nome.substring(0, pos);
        else firstname = nome;
        email = email.strip().toLowerCase().replace(" ", "");
        System.out.println("Cadastro concluído! \n - Nome: " + firstname + "\n - E-mail de acesso: " + email);
    }

    public static void Q3(){
        System.out.print("Digite o faturamento da empresa A: ");
        double fatA = extractBillingValue();
        System.out.print("Digite o faturamento da empresa B: ");
        double fatB = extractBillingValue();
        double totalfat = fatA + fatB;
        double media = (fatA + fatB)/2.0;
        System.out.printf("O faturamento total das lojas foi de R$%.2f com média de R$%.2f.\n", totalfat, media);
    }
    public static void main(String[] args) {
        //para testar cada resposta indivídualmente é só comentar/descomentar a chamada das funções
        System.out.println("Calculadora de Imposto sobre Vendas");
        Q1();
        System.out.println("Sistema de Cadastro de Colaborador (Setor de RH)");
        Q2();
        System.out.println("Análise de Metas de Vendas (Setor Comercial)");
        Q3();
        
    }
}
