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
#include "utils.h"

using namespace std;

string padronizar_texto(string nome){//equivalente a formato título, mas com a primeira letra de cada palavra em maiúscula e o restante em minúscula
    transform(nome.begin(), nome.end(), nome.begin(), ::tolower);
    //trim string
    trimString(nome);
    capitalyize(nome);
    return nome;
}

void Q1(){
    vector<string> produtos_baguncados = {"iphone 13", "MACBOOK PRO", "alrPoDa Pro", "iPad mini", " caixa de som bluetooth "};
    vector<string> produtos_organizados = {};
    for(int i = 0; i < produtos_baguncados.size(); i++){
        produtos_organizados.push_back(padronizar_texto(produtos_baguncados[i]));
    }
    cout<<"Produtos Organizados:\n";
    for(const string& produto : produtos_organizados) cout << produto << endl;

}

double calcular_iss(float value){
    double valor_do_imposto = ((value > 5000) ? value*0.05:value*0.03);
    return valor_do_imposto;
}

void Q2(){
    cout<<"Imposto para R$8000.00: "<<fixed<<setprecision(2)<<calcular_iss(8000)<<"\n";
    cout<<"Imposto para R$2000.00: "<<fixed<<setprecision(2)<<calcular_iss(2000)<<"\n";
}

void analizar_margem(float faturamento, float custos){
    float lucro = faturamento - custos;
    float margem = (lucro/faturamento) * 100;
    cout<<margem<<endl;
    cout<<((margem >= 30) ? "Margem Saudável":"Margem Baixa")<<endl;
}

void Q3(){
    analizar_margem(10000.00, 6000.00);
    analizar_margem(7000.00, 6000.00);
}

void quem_bateu_meta(map<string, float> equipe_vendas, float meta_objetivo) {
    for (const auto& [pessoa, venda] : equipe_vendas) {
        if (venda >= meta_objetivo) {
            cout << "Vendedor " << pessoa << " bateu a meta!\n";
        }
    }
}

void Q4(){
    map<string, float> equipe_vendas = {
        {"João", 12000},
        {"Maria", 9500},
        {"Ricardo", 10000},
        {"Fernanda", 15200},
        {"Paulo", 5000}
    };
    quem_bateu_meta(equipe_vendas, 10000);
}

double converter_para_real(float preco_dolar, float cotacao){
    double preco_real = preco_dolar*cotacao;
    return preco_real;
}

vector<double> processar_lista_precos(vector<float> precos_usd, float cotacao){
    vector<double> precos_real = {};
    for(int i = 0; i < precos_usd.size(); i++){
        precos_real.push_back(converter_para_real(precos_usd[i], cotacao));
    }
    return precos_real;
}

void Q5(){
    vector<float> precos_usd = {100, 50, 250};
    vector<double> precos_real = processar_lista_precos(precos_usd, 5.20);
    cout<<"Precos em Real: ";
    for (double preco : precos_real) {
        cout << preco << " ";
    }
    cout << endl;
}

int main(){
    Q1();
    Q2();
    Q3();
    Q4();
    Q5();
    return 0;
}