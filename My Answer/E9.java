import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class E9{
    public static final Scanner scanner = new Scanner(System.in);

    public record Coordenadas(double x, double y) {}

    public record Folha (double impostos, double salarioLiquido) {}

    public record Produto (String nome, double preco, int quantidade) {}

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
                    return -1.0;
                }
            }
        }
    }

    public static void Q1(){
        double latitude, longitude;
        while(true){
            System.out.print("Digite a latitude: ");
            try {
                latitude = Double.parseDouble(scanner.nextLine().replace(",", "."));
                break;
            } catch (Exception e) {
                System.out.println("Formatação inválida: digite na formatação correta.");
            }
            
        }
        while(true){
            System.out.print("Digite a llongiitude: ");
            try {
                longitude = Double.parseDouble(scanner.nextLine().replace(",", "."));
                break;
            } catch (Exception e) {
                System.out.println("Formatação inválida: digite na formatação correta.");
            }
        }
        Coordenadas coordenadas = new Coordenadas(latitude, longitude);
        System.out.printf("Iniciando entrega. Latitude: %.3f, Longitude: %.3f.\n", coordenadas.x, coordenadas.y);      
    }

    public static Folha calcularFolha(double salario){
        double desconto = salario * 0.1;
        double salarioLiquido = salario - desconto;

        return new Folha(desconto, salarioLiquido);
    }

    public static void Q2(){
        double salario;
        while(true){
            System.out.print("Digite o Salário Bruto: ");
            String valor = scanner.nextLine();
            salario = extractDoubleValue(valor);
            if(salario != -1.0){
                break;
            } else {
                System.out.println("❌ Formato inválido! Digite um valor numérico válido.");
            }
        }
        Folha folha = calcularFolha(salario);
        System.out.printf("Desconto: R$%.2f | Salário Líquido: R$%.2f\n", folha.impostos, folha.salarioLiquido);

        
    }

    public static void Q3(){
        List<Produto> vendas_dia = new ArrayList<>(Arrays.asList(
            new Produto("Monitor", 900, 2),
            new Produto("Teclado", 150, 5),
            new Produto("Mouse", 80, 10)
        ));
        for(int i = 0; i < vendas_dia.size(); i++){
            Produto temp = vendas_dia.get(i);
            System.out.printf("Produto: %s | Total: R$%.2f\n", temp.nome, (temp.preco*(double)temp.quantidade));
        }
    }

    public static record AnaliseVendas(double total_vendido, double media_vendas){}

    public static AnaliseVendas analisar(List<Double> vendas){
        double total = 0;
        for(int i = 0; i < vendas.size(); i++){
            total += vendas.get(i);
        }
        return new AnaliseVendas(total, total/vendas.size());
    }

    public static void analisarVendas(Map<String, List<Double>> dados){
        for(String key:dados.keySet()){
            List<Double> temp = dados.get(key);
            AnaliseVendas analise = analisar(temp);
            System.out.printf(
                "Filial %s -> Total: R$%.2f, Média: R$%.2f\n",
                key,
                analise.media_vendas(),
                analise.total_vendido()
            );
        }        
    }

    public static void Q4(){
        Map <String, List<Double>> dadosFiliais = Map.of(
            "Matriz", List.of(10000.0, 15000.0, 20000.0),
            "Filial Sul", List.of(5000.0, 7000.0)
        );
        analisarVendas(dadosFiliais);

    }

    public static record Resposta(int quantidade_chamados, int tempo_maximo){}

    public static Resposta resumoChamados(List<Integer> lista_tempos){
        int tempo_maximo = 0;
        for(int i = 0; i < lista_tempos.size(); i++) tempo_maximo += lista_tempos.get(i);
        return new Resposta(lista_tempos.size(), tempo_maximo);
    }

    public static void Q5(){
        List<Integer> tempos = List.of(15, 45, 10, 120, 30);
        Resposta resposta = resumoChamados(tempos);
        System.out.println(resposta);
    }
    public static void main(String[] args) {
        //Q1();
        //Q2();
        //Q3();
        //Q4();
        Q5();
    }
}