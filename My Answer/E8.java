import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class E8 {

    public static String PadronizarTexto(String texto){
        return Pattern.compile("\\b([a-z])")
            .matcher(texto.strip().toLowerCase())
            .replaceAll(m -> m.group().toUpperCase());
    } 

    public static void Q1(){
        List<String> produtos_baguncados = new ArrayList<>(Arrays.asList(
            " iphone 13 ", "MACBOOK PRO ", " aIrPoDs Pro", "iPad mini ", "caixa de som bluetooth "
        ));
        List<String> produtos_organizados = new ArrayList<>(Arrays.asList());
        for(int i = 0; i < produtos_baguncados.size(); i++){
            String temp = PadronizarTexto(produtos_baguncados.get(i));
            System.out.println(temp + " organizado");
            produtos_organizados.add(temp);
        }
        System.out.println(produtos_organizados);
    }

    public final static Scanner scanner = new Scanner(System.in);

    private static String removeAllButLastDot(String s) {
        int last = s.lastIndexOf('.');
        if (last == -1) return s.replace(".", "");
        String before = s.substring(0, last).replace(".", "");
        String after = s.substring(last);
        if((s.length() - last) > 3) after = after.replace(".", "") + ".00";
        return before + after;
    }

    public static double extractDoubleValue(String newPrice){
        while(true){
            newPrice = newPrice.toUpperCase()
                                       .replace("RS","")
                                       .replace("R$","")
                                       .replace("$", "")
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

    public static double calcular_iss(double valor){
        double valor_imposto = (valor <= 5000) ? (valor*0.03):(valor*0.05);
        return valor_imposto;
    }

    public static void Q2(){
        while(true){
            System.out.print("Digite o valor do serviço: ");
            String valor = scanner.nextLine();
            double valor_formatado = extractDoubleValue(valor);
            if(valor_formatado == 0.0) break;
            System.out.printf("O valor do imposto é: %.2f.\n", calcular_iss(valor_formatado));
            System.out.println("Obs: se desejar, digite 0,0 para sair.");
        }
    }

    public static String analizas_margem(double faturamento, double custo){
        double taxa = (faturamento - custo)/faturamento;
        System.out.println("Taxa de lucratividade foi de " + (taxa*100) + "%.");
        return (taxa >= 0.3) ? "Margem Saudável":"Margem Baixa";
    }

    public static void Q3(){
        System.out.print("Digite o valor do faturamento: ");
        String valor = scanner.nextLine();
        double valor_faturamento = extractDoubleValue(valor);
        System.out.print("Digite o valor do custo: ");
        valor = scanner.nextLine();
        double valor_custo = extractDoubleValue(valor);
        System.out.println("Veredito: " + analizas_margem(valor_faturamento, valor_custo));


    }

    public static void quem_bateu_meta(Map<String, Integer> equipe, int meta_objetivo){
        System.out.println("Quem bateu a meta de " + meta_objetivo + ",00?");
        for(String key:equipe.keySet()){
            int temp = equipe.get(key);
            if (temp >= meta_objetivo) System.out.printf("Vendedor %s bateu a meta!\n", key);
        }
    }

    public static void Q4(){
        Map<String, Integer> equipe_vendas = new HashMap<>(Map.of(
            "João", 12000,
            "Maria", 9500,
            "Ricardo", 10000,
            "Fernanda", 15200,
            "Paulo", 5000
        ));
        quem_bateu_meta(equipe_vendas, 10000);
    }

    public static double comverter_para_real(double valor, double cotacao){
        return valor*cotacao;
    }

    public static void processar_lista_precos(List<Double> lista_precos, double cotacao){
        for(int i = 0; i < lista_precos.size(); i++){
            double temp = lista_precos.get(i)*cotacao;
            System.out.printf("O valor do item é R$%.2f.\n", temp);
        }
    }

    public static void Q5(){
        System.out.println("Parte 1");
        System.out.print("Digite um valor em dólar: ");
        String valor = scanner.nextLine();
        double valor_dolar = extractDoubleValue(valor);
        System.out.print("Digite a cotação do dia: ");
        valor = scanner.nextLine();
        double valor_cotacao = extractDoubleValue(valor);
        double valor_real = comverter_para_real(valor_dolar, valor_cotacao);
        System.out.printf("Valor em Real: R$%.2f\n", valor_real);
        System.out.println("\nParte 2");
        double cot_dolar = 5.20;
        List<Double> precos_usd = new ArrayList<>(Arrays.asList());
        while(true){
            System.out.print("Digite o valor do preco para adicionar à lista: ");
            if(precos_usd.size() > 1) System.out.print("\nSe quiser, digite 0,0 para sair.\nValor: ");
            valor = scanner.nextLine();
            if((precos_usd.size() > 1) && (extractDoubleValue(valor) == 0.0)) break;
            precos_usd.add(extractDoubleValue(valor));
        }
        processar_lista_precos(precos_usd, cot_dolar);

    }
    
    public static void main(String[] args) {
        //Q1();
        //Q2();
        //Q3();
        //Q4();
        Q5();
    }
    
}
