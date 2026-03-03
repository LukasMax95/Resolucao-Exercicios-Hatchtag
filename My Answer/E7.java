import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class E7 {
    public static void Q1(){
        for(int i = 0; i < 10; i++){
            System.out.printf("O treinamento de java começa em %d minutos!\n", (i+1));
        }
    }

    public static void Q2(){
        List<Integer> vendas = new ArrayList<>(Arrays.asList(2000, 5000, 1000, 8000, 3000));
        double comissao = 0.0;
        for(int i = 0; i < vendas.size(); i++){
            double temp = (double)vendas.get(i);
            comissao += (temp > 4000.00) ? temp*0.1:temp*0.05;   
        }
        System.out.printf("Valor total da comissão: %.2f\n", comissao);


    }

    public static void Q3(){
        List<String> estoqueProdutos = new ArrayList<>(Arrays.asList("monitor", "teclado0", "mouse", "headset", "gabinete"));
        List<Integer> quantidadeProdutos = new ArrayList<>(Arrays.asList(5, 12, 2, 8, 15));
        if(estoqueProdutos.size() == quantidadeProdutos.size()){
            for(int i = 0; i < estoqueProdutos.size(); i++){
                int temp = quantidadeProdutos.get(i);
                if(temp < 8) System.out.printf("Alerta: o produto %s está com apenas %d unidades no estoque.\n", estoqueProdutos.get(i), temp);
            }
        }
    }

    public static void Q4(){
        HashMap<String, Integer> metas = new HashMap<>(Map.of(
            "jan", 1000,
            "fev", 1200,
            "mar", 1100
        ));
        HashMap<String, Integer> gastos = new HashMap<>(Map.of(
            "jan", 900,
            "fev", 1350,
            "mar", 1100
        ));
        if(metas.size() == gastos.size()){
            for(String key : metas.keySet()){
                double temp = (double)gastos.get(key);
                double temp2 = metas.get(key);
                if(temp <= temp2) System.out.printf("Mês %s: dentro do orçamento.\n", key);
                else System.out.printf("Mes %s: Orçamento estourado em R$%.2f.\n", key, (temp - temp2));
            }
        }
    }

    public final static Scanner scanner_input = new Scanner(System.in);

    public static void Q5(){
        HashMap<String, Double> precos = new HashMap<>(Map.of(
            "celular", (double)1500,
            "tablet", (double)2500,
            "notebook", (double)5000
        ));
        System.out.print("Digite o percentual de almento: ");
        String percent = scanner_input.nextLine();
        percent = percent.replace("%", "").replace(" ","").replace(",", ".");
        double factor = Double.parseDouble(percent)/100.00;
        System.out.println(factor);
        for(String key:precos.keySet()){
            double emp = precos.get(key);
            precos.put(key, emp + emp*factor);
        }
        System.out.println("Novo Catálogo:");
        for(String key:precos.keySet()){
            System.out.printf(" - %s: R$%.2f\n", key, precos.get(key));
        }
    }

    public static void main(String[] args) {
        System.out.println("Automação de Convites (Setor de Eventos/RH)");
        Q1();
        System.out.println("Cálculo de Comissão Progressiva (Setor de Vendas)");
        Q2();
        System.out.println("Verificação de Estoque Crítico (Setor de Logística)");
        Q3();
        System.out.println("Análise de Custos Mensais (Setor Financeiro)");
        Q4();
        System.out.println("Reajuste Geral de Preços (Setor Comercial)");
        Q5();
    }
}
