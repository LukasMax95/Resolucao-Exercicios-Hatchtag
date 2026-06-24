#include <iostream>
#include <string>
#include <vector>
#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <iomanip>
#include <algorithm>
#include <cctype>
#include <locale>
#include <regex>
#include <cmath>
#include <stdexcept>
#include <map>
#include <tuple>
#include "utils.h"

using namespace std;

void Q1(){
    tuple<double, double> coordenadas = {-23.5505, -46.6333};
    auto [latitude, longitude] = coordenadas;
    cout << "Iniciando entrega. Latitude: " << latitude 
        << ", Longitude: " << longitude << endl;
}

tuple<double, double> calcular_folha(float salario_bruto){
    double desconto = salario_bruto*0.1;
    double salario_liquido = salario_bruto - desconto;
    tuple<double, double> folha_de_pagamento = {desconto, salario_bruto};
    return folha_de_pagamento;
}

void Q2(){
    auto [desconto, salario_liquido] = calcular_folha(5000.00);
    cout<<"Desconto: R$"<<fixed<<setprecision(2)<<desconto
        <<" |Salário Líquido: R$"<<fixed<<setprecision(2)<<salario_liquido<<endl;

}

void Q3(){
    vector<tuple<string,double,double>> vendas_dia = {
        {"Monitor", 900, 2},
        {"Teclado", 150, 5},
        {"Mouse", 80, 10}
    };
    for(int i = 0; i < vendas_dia.size(); i++){
        auto [produto, preco_unitario, quantidade] = vendas_dia[i];
        cout<<"Produto "<<produto<<" | "<<"Total : R$"<<fixed
            <<setprecision(2)<<(preco_unitario*quantidade)<<endl;
    }
}

tuple<double, double> analizar_vendas(vector<float> vendas){
    double sum = 0;
    for(int i = 0; i < vendas.size(); i++){
        sum += vendas[i];
    }
    tuple<double, double> resultado = {sum, sum/vendas.size()};
    return resultado;
}

void Q4(){
    map<string, vector<float>> dados_filiais = {
        {"Matriz", {10000, 15000, 20000}},
        {"Filial Sul", {5000, 7000}}
    };
    for(auto const& [filial, vendas]:dados_filiais){
        auto [total_vendas, media_vendas] = analizar_vendas(vendas);
        cout<<"Filial: "<<filial<<" -> Total: R$"<<fixed<<setprecision(2)<<total_vendas
            <<", Média: R$"<<fixed<<setprecision(2)<<media_vendas<<endl;
    }
}

tuple<int, int> resumo_chamados(vector<int> tempos){
    int pivot = 0;
    for(int i = 0; i < tempos.size(); i++){
        if(pivot < tempos[i]) pivot = tempos[i];
    }
    tuple<int, int> respota = {tempos.size(), pivot};
    return respota;
}

void Q5(){
    vector<int> tempos = {15, 45, 10, 120, 30};
    auto [quantidade_chamados, tempo_maximo] = resumo_chamados(tempos);
    cout<<"Foram abertos "<<quantidade_chamados<<" chamados hoje.\n"
        <<"Tempo Máximo de SLA: "<<tempo_maximo<<" minutos."<<endl;
}

int main(){
    Q1();
    Q2();
    Q3();
    Q4();
    Q5();
    return 0;
}