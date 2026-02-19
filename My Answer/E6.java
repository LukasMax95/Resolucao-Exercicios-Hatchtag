import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class E6 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void Q1(){
        Map<String, Double> clientes = new HashMap<>();
        clientes.put("Lira", 5000.00);
        clientes.put("Alon", 3000.00);
        clientes.put("Julia", 4500.00);
        System.out.println(clientes);
        String key = "Alon";
        if(clientes.containsKey(key)){
            clientes.put(key, clientes.get(key) + 1500.00);
            System.out.println(clientes);
        }
        clientes.put("Marcos", 2000.00);
        System.out.println(clientes);
    }

    public static void Q2(){
        Map<String, Integer> produtos = new HashMap<>(Map.of(
            "teclado", 50,
            "mouse", 120,
            "monitor", 30
        ));
        while(true){
            System.out.print("Digite o produto à pesquisar ou quit para saír: ");
            String produto = scanner.nextLine().toLowerCase();
            if("quit".equals(produto)) break;
            if(produtos.containsKey(produto)){
                System.out.println("Quantidade do " + produto + ": " + produtos.get(produto));
            }else System.out.println("Produto não existe");

        }

    }

    public static void Q3(){
        Map<String, Double> faturamento_por_regiao = new HashMap<>(Map.of(
            "Norte", 15000.00,
            "Sul", 22000.00,
            "Leste", 18000.00,
            "Oeste", 25000.00
        ));
        List<Double> faturamentos = new ArrayList<>();
        for (Map.Entry<String, Double> entrada : faturamento_por_regiao.entrySet()) {
            faturamentos.add(entrada.getValue());
        }
        System.out.println("Faturamentos: " + faturamentos);
        Double faturamento_total = 0.0;
        for(double faturamento: faturamentos){
            faturamento_total += faturamento;
        }
        System.out.printf("Faturamento Total: R$%.2f\n", faturamento_total);
        System.out.printf("Faturamento Médio: R$%.2f\n", (faturamento_total/faturamentos.size()));

    }

    public static void Q4(){
        Map<String, List<Integer>> notas = new HashMap<>(Map.of(
            "Lira", new ArrayList<>(Arrays.asList(8, 9, 7)),
            "Paula", new ArrayList<>(Arrays.asList(10, 9, 10)),
            "Tiago", new ArrayList<>(Arrays.asList(6, 7, 8))
        ));
        String key = "Paula";
        if(notas.containsKey(key)){
            double soma_notas = 0.0;
            List<Integer> boletim = notas.get(key);
            for(double nota:boletim){
                soma_notas += (double)nota;
            }
            System.out.printf("A média da %s é de %.1f.\n", key, (soma_notas/notas.size()));
        }
    }

    public static void Q5(){
        Map<String, Double> produtos = new HashMap<>(Map.of(
            "celular", 1500.00,
            "camera", 800.00,
            "radio", 200.00,
            "fone", 100.00
        ));
        String key = "radio";
        Double produto_removido = produtos.remove(key);
        if(produto_removido != null) System.out.printf("Produto Removido: %s (valor: R$%.2f).\n", key, produto_removido);
        else System.out.println("O produto não existe");
        String key2 = "celular";
        System.out.println("Celular ainda existe: " + produtos.containsKey(key2));
        //System.out.println(produtos);

    }
    public static void main(String[] args) {
        System.out.println("Atualização de Cadastro de Clientes (Setor de CRM)");
        Q1();
        System.out.println("Consulta de Estoque Interativa (Setor de Logística)");
        Q2();
        System.out.println("Análise de Faturamento por Região (Setor Financeiro)");
        Q3();
        System.out.println("Sistema de RH – Média de Desempenho (Setor de RH)");
        Q4();
        System.out.println("Limpeza de Banco de Dados (Setor de TI)");
        Q5();
    }
    
}
