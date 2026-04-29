#include <iostream>
#include <string>
#include <vector>
#include <cmath>
#include <iomanip>

using namespace std;

void Q1(double billing, double bonus){
    double total_bonus = billing * bonus;
    double liq_billing = billing - total_bonus;
    cout<<"Valor do Bônus: "<<total_bonus<<endl;
    cout<<"Faturamento Final: "<<liq_billing<<endl;
}

void Q2(int n_units, int n_sold, int extra_units){
    cout<<"Controle de Estoque E-Comerce"<<endl;
    int stock = n_units - n_sold + extra_units;
    cout<<"Estoque Final: "<<stock<<endl;
}

void Q3(int total_caixas){
    cout<<"Divisão de Cargas"<<endl;
    int truck_load = 12;
    int full_load_trucks = total_caixas/truck_load;
    int extra_truck_load = total_caixas%truck_load;
    cout<<"Caminhoes Completos: "<<full_load_trucks<<endl;
    cout<<"Caixas Restantes: "<<extra_truck_load<<endl;
}

void Q4(double billing, double costs, double tax){
    cout<<"Análise de Margem de Lucro"<<endl;
    double total_tax = billing*tax;
    double net_profit = billing - (costs + total_tax);
    double margin = net_profit/billing;
    cout<<"Imposto Total: "<<total_tax<<endl;
    cout<<"Lucro Líquido: "<<net_profit<<endl;
    cout<<"Margem de Lucro: "<<margin<<endl;
    cout<<"Margem de Lucro superior a 30%: "<<(margin > 0.3 ? "Sim":"Não")<<endl;
}

void Q5(int range){
    cout<<"Conversão de Tempo de Contrato:"<<endl;
    int n_anos = range/12;
    int n_meses = range%12;
    cout<<"Duração do contrato é de "<<n_anos<<" anos e "<<n_meses<<" meses."<<endl;
}

int main(){
    Q1(50000, 0.1);
    Q2(250, 75, 100);
    Q3(1250);
    Q4(15000, 5000, 0.15);
    Q5(40);
    return 0;
}
