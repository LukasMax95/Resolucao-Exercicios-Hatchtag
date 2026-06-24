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
#include "utils.h"

using namespace std;

void Q1(){
    for(int i = 10; i >= 0; i--){
        cout << "O treinamento de Python (C++) começa em " << i << " minutos.\n";
    }
}

void Q2(){
    vector<float> vendas = {2000, 5000, 1000, 8000, 3000};
    int i = 1;
    for(float venda: vendas){
        bool temp = (venda <= 4000);
        cout << "Comissão da venda " << i << ": " << (temp ? "5%" : "10%") << endl;
        cout << "Valor da comissão: R$" << fixed << setprecision(2) << (temp ? venda*0.05 : venda*0.10) << endl;
        i++;
    }
}

void Q3(){
    vector<string> estoque_produtos = {"monitor", "teclado", "mouse", "headset", "gabinete"};
    vector<int> estoque_quantidades = {5, 12, 2, 8, 15};
    for(int i = 0; i < estoque_quantidades.size(); i++){
        if(estoque_quantidades[i] < 8) cout << "Alerta! O produto " << estoque_produtos[i] << " está com apenas " << estoque_quantidades[i] << " unidades no estoque!" << endl;
    }
}

void Q4(){
    map<string, float> metas = {
        {"jan", 1000},
        {"fev", 1200},
        {"mar", 1100}
    };
    map<string, float> gastos = {
        {"jan", 900},
        {"fev", 1350},
        {"mar", 1100}
    };
    for(const auto& [meta, valor] : metas){
        if(valor >= gastos[meta]) cout << "Mes " << meta << ": Dentro do orçamento." << endl;
        else cout << "Mes " << meta << ": Orçamento estourado em: " << fixed << setprecision(2) << (gastos[meta] - valor) << endl;
    }
}
void Q5(){
    map<string, float> precos = {
        {"celular", 1500},
        {"tablet", 2500},
        {"notebook", 5000}
    };
    cout<<"Digite o percentual de aumento: ";
    float percentual;
    cin >> percentual;
    cout<<"Novo Catálogo:"<<endl;
    for(const auto& [produto, valor] : precos){
        precos[produto] = valor*(1 + percentual/100);
        cout << " - " << produto << ": R$" << fixed << setprecision(2) << precos[produto] << endl;
    }
}

int main(){
    Q1();
    cout<<endl;
    Q2();
    cout<<endl;
    Q3();
    cout<<endl;
    Q4();
    cout<<endl;
    Q5();
    return 0;
}