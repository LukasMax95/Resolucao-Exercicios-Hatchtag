import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E4 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void Q1(){
        int[] vendas = {1500, 2000, 809, 3500, 1200};
        int total_vendas = 0;
        int quantidade_dias = vendas.length;
        int maior_venda = 0;
        int menor_venda = 100000;
        for(int venda : vendas){
            total_vendas += venda;
            if(maior_venda < venda) maior_venda = venda;
            if(menor_venda > venda) menor_venda = venda;
        }
        double media_vendas = (double)total_vendas/(double)quantidade_dias;
        System.out.println(
            "Relatório:\n - Total de vendas: " + total_vendas
                + "\n - Média de Vendas: " + Math.round(media_vendas)
                + "\n - Maior Venda: " + maior_venda
                + " \n - Menor Venda: " + menor_venda
            );
    }

    public static void Q2(String novoItem, String encontrarItem, String itemAtualizar, String itemAtualizado){
        List<String> estoque = new ArrayList<>(Arrays.asList("monitor", "teclado", "mouse", "headset"));
        System.out.println("Inserir item");
        estoque.add(novoItem);
        System.out.println("Estoque atual: " + estoque);
        int c = 0;
        System.out.println("Encontrar item");
        boolean flag = false;
        for(String item : estoque){
            if(item.equals(encontrarItem)){
                System.out.println(item + " encontrado na posição "+ c + ".");
                flag = true;
                break;
            }
            c++;
        }
        System.out.println((flag) ? "Item encontrado.":"Item não encontrado.");
        System.out.println("Atualizar Item");
        for(int i = 0; i < estoque.size(); i++) {
            if(estoque.get(i).equals(itemAtualizar)) {
                estoque.set(i, itemAtualizado); // Atualiza a posição real na lista
                System.out.println("Item Atualizado");
            }
        }
        System.out.println("Estoque atual: " + estoque);
    }

    public static void Q3(){
        List<Integer> frete = new ArrayList<>(Arrays.asList(50, 80, 20, 150, 40));
        //frete.sort(null);
        frete.sort(Collections.reverseOrder());
        System.out.println(frete);
        List<Integer> top_fretes = frete.subList(0, 2);
        System.out.println(top_fretes);
    }

    public static void Q4(String[] novas_cidades, String encontrar_cidades){
        List<String> cidades = new ArrayList<>(Arrays.asList("Sao Paulo", "Campinas", "Jundiai", "Sorocaba"));
        System.out.println("Cidades registradas: " + cidades);
        System.out.println("Adicionar novas cidades: " + Arrays.asList(novas_cidades));
        for(String cidade : novas_cidades){
            cidades.add(cidade);
        }
        System.out.println("Cidades registradas: " + cidades);
        System.out.println("Encontrar cidade: " + encontrar_cidades);
        boolean flag = false;
        int c = 0;
        for(int i = 0; i < cidades.size(); i++){
            String cidade = cidades.get(i);
            //System.out.println( cidade + " " + (cidade == encontrar_cidades) + " " + encontrar_cidades);
            if(cidade.equals(encontrar_cidades)){
                System.out.println(cidade + " è a "+ c + "ª cidade na rota.");
                flag = true;
                break;
            }
            c++;
        }
        if(!flag) System.out.println(encontrar_cidades + " não foi encontrada.");
    }

    private static String removeAllButLastDot(String s) {
        int last = s.lastIndexOf('.');
        if (last == -1) return s.replace(".", "");
        String before = s.substring(0, last).replace(".", "");
        String after = s.substring(last);
        if((s.length() - last) > 3) after = after.replace(".", "") + ".00";
        return before + after;
    }

    public static double extractDoubleValue(){
        while(true){
            System.out.print("Digite o novo preço do produto: ");
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

    public static void Q5(){
        List<Double> precos = new ArrayList<>(Arrays.asList(100.0, 200.0, 300.0));
        List<String> vinhos = new ArrayList<>(Arrays.asList("Branco", "Tinto", "Champagne"));
        System.out.println("Vinhos: " + vinhos + "\nPreços: " + precos);
        String produtoAtualizar = "";
        double novoPreco = 0.0;
        while(true){
            System.out.print("Digite o nome do produto: ");
            produtoAtualizar = scanner.nextLine();
            int numindex = -1;
            for(int i = 0; i < vinhos.size(); i++){
                String produto = vinhos.get(i);
                System.out.println(produtoAtualizar + produto + (produto.equals(produtoAtualizar)));
                if(produto.equals(produtoAtualizar)){
                    System.out.println("Produto Encontrado");
                    numindex = i;
                    break;
                }
            }
            if(numindex != -1){
                novoPreco = extractDoubleValue();
                precos.set(numindex, novoPreco);
                break;
            }else{
                System.out.println("Produto Inválido ou Inexistente.");
            }

        }
        
        System.out.println("Vinhos: " + vinhos + "\nPreços: " + precos);

    }

    public static void main(String[] args){
        System.out.println("Dashboard de Vendas (Análise de Dados)");
        Q1();
        System.out.println("Gestão de Estoque (Edição e Verificação)");
        Q2("webcam", "impressora", "teclado", "teclado mecanico");
        System.out.println("Organização de Preços (Ordenação e Slicing)");
        Q3();
        System.out.println("Sistema de Logística (Busca e Extensão)");
        String[] novas_cidades = {"Itu", "Valinhos"};
        Q4(novas_cidades, "Sorocaba");
        System.out.println("Atualização de Preços Interativa (Input + Lista)");
        Q5();
        
    }
    
}
