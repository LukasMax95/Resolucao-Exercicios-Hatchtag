import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E5 {

    private static final Scanner scanner = new Scanner(System.in);

    private static String removeAllButLastDot(String s) {
        int last = s.lastIndexOf('.');
        if (last == -1) return s.replace(".", "");
        String before = s.substring(0, last).replace(".", "");
        String after = s.substring(last);
        if((s.length() - last) > 3) after = after.replace(".", "") + ".00";
        return before + after;
    }

    public static double extractDoubleValue(String msg){
        while(true){
            System.out.print(msg);
            String newPrice = scanner.nextLine();
            newPrice = newPrice.toUpperCase()
                                       .replace("RS","")
                                       .replace("R$","")
                                       .trim();
            double numPrice = 0.0;
            try {
                numPrice = Double.parseDouble(newPrice);
                return numPrice;
                
            } catch (NumberFormatException e) {
                newPrice = newPrice.replace(",", ".");
                newPrice = removeAllButLastDot(newPrice);
                try {
                    numPrice = Double.parseDouble(newPrice);
                    return numPrice;
                } catch (NumberFormatException e3) {
                    System.out.println("❌ Formato inválido! Digite um valor numérico válido.");
                }
            }
        }
    }

    public static void Q1(){
        double valor = extractDoubleValue("Digite o valor que deseja investir: ");
        if(valor < 1000.00){
            System.out.println("Perfil iniciante: Sugerimos Tesouro Direto");
        }else if(valor < 5000.00){
            System.out.println("Perfil moderado: Sugerimos Fundos Imobiliários");
        }else{
            System.out.println("Perfil arrojado: Sugerimos Ações");
        }
    }

    public static void Q2(){
        List<String> admins = new ArrayList<>(Arrays.asList("ana@empresa.com", "guilherme@empresa.com", "felipe@empresa.com"));
        System.out.print("digite seu email: ");
        String email = scanner.nextLine();
        email = email.replaceAll("\\s", "").toLowerCase();
        int admin_index = admins.indexOf(email);
        System.out.println((admin_index != -1) ? "Acesso liberado! Bem-vindo ao painel de controle.":"Acesso negado. Você não tem permissões de administrador.");

    }

    public static void Q3(){
        double valor_compra = extractDoubleValue("Digite o valor total da compra: ");
        double desconto = 0.00;
        if(valor_compra >= 500.00){
            System.out.println("15% de desconto:");
            desconto = valor_compra*0.15;
        }else if(valor_compra >= 200.00){
            System.out.println("10% de desconto:");
            desconto = valor_compra*0.1;
        }else{
            System.out.println("Sem desconto:");
        }
        System.out.printf("O valor total para pagar é de R$%.2f com desconto de R$%.2f.\n", (valor_compra - desconto), desconto);
    }

    public static void Q4(){
        double minhas_vendas = extractDoubleValue("Digite o valor total das suas vendas: ");
        double minha_meta = extractDoubleValue("Digite sua meta fiscal: ");
        double loja_vendas = extractDoubleValue("Digite o valor total das vendas da sua loja: ");
        double loja_meta = extractDoubleValue("Digite a meta fiscal da loja: ");
        double bonus = 0.0;
        if((minhas_vendas/minha_meta >= 1.0) && (loja_vendas/loja_meta >= 1)){
            bonus = minhas_vendas*0.2;
        }
        System.out.printf("Seu bônus este mês é de: R$%.2f\n", bonus);
    }

    public static void Q5(){
        System.out.print("Digite o assunto a ser tratado: ");
        String assunto = scanner.nextLine();
        assunto = assunto.toLowerCase();
        if(assunto.contains("pagamento") || assunto.contains("boleto") || assunto.contains("dívida") || assunto.contains("pagar")){
            System.out.println("Encaminhado para o Financeiro.");
        }else if(assunto.contains("entrega") || assunto.contains("atraso")){
            System.out.println("Encaminhado para a Logística");
        }else{
            System.out.println("Encaminhado para o Suporte Geral");
        }
    }
    public static void main(String[] args) {
        //System.out.println("Validação de Investimento (Setor Financeiro)");
        //Q1();
        //System.out.println("Controle de Acesso ao Sistema (Setor de Segurança)");
        //Q2();
        //System.out.println("Cálculo de Desconto Progressivo (Setor de Vendas)");
        //Q3();
        //System.out.println("Análise de Metas Combinadas (Setor Comercial)");
        //Q4();
        System.out.println("Sistema de Triagem de E-mails (Setor de Customer Experience)");
        Q5();
    }
}
