public class E1 {

    //Cálculo de Bônus de Vendas (RH/Vendas)
    public static void Q1(double billing, double bonus){
        System.out.println("Cálculo de Bônus de Vendas");
        double total_bonus = billing * bonus;
        double liq_billing = billing - total_bonus;
        System.out.println("Valor do Bônus: " + total_bonus);
        System.out.println("Faturamento Final: " + liq_billing + "\n");
    }

    //Controle de Estoque de E-commerce (Logística)
    public static void Q2(int n_units, int n_sold, int extra_units){
        System.out.println("Controle de Estoque de E-commerce");
        int stock = n_units - n_sold + extra_units;
        System.out.println("Estoque Final: " + stock + "\n");

    }

    //Divisão de Cargas (Logística/Transporte)
    public static void Q3(int total_caixas){
        System.out.println("Divisão de Cargas");
        int truck_load = 12;
        int full_load_trucks = total_caixas/truck_load;
        int extra_truck_load = total_caixas%truck_load;
        System.out.println("Caminhões Completos: " + full_load_trucks);
        System.out.println("Caixas Restantes: " + extra_truck_load + "\n");
    }

    //Análise de Margem de Lucro (Financeiro)
    public static void Q4(double billing, double costs, double tax){
        System.out.println("Análise de Margem de Lucro ");
        double total_tax = billing*tax;
        double net_profit = billing - (costs + total_tax);
        double margin = net_profit/billing;
        System.out.println("Imposto Total: " + total_tax);
        System.out.println("Lucro Líquido: " + net_profit);
        System.out.println("Margem de Lucro: " + margin);
        System.out.println("Margem de Lucro superior a 30%: " + (margin > 0.3 ? "Sim":"Não") + "\n");
    }

    //Conversão de Tempo de Contrato (Gestão de Projetos)
    public static void Q5(int range){
        System.out.println("Conversão de Tempo de Contrato:");
        int n_anos = range/12;
        int n_meses = range%12;
        System.out.println("Duração do contrato é de " + n_anos + " anos e " + n_meses + " meses.\n");
    }

    public static void main(String[] args) {
        Q1(50000.0, 0.1);
        Q2(250, 75, 100);
        Q3(1250);
        Q4(15000, 5000, 0.15);
        Q5(40);
    }
}