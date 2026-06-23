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
    map<string, double> clientes = {
        {"Lira", 5000.0},
        {"Alon", 3000.0},
        {"Julia", 4500.0}
    };

    clientes["Alon"] += 1500.00;

    clientes["Marcos"] = 2000.00;

    cout << "--- Cadastro de Clientes Atualizado ---" << endl;
    
    for (const auto& registro : clientes) {
        cout << "Cliente: " << registro.first << " | Faturamento: R$" << registro.second << endl;
    }
    cout << "---------------------------------------" << endl;
}

void Q2(){
    map<string, float> estoque = {
        {"teclado", 50},
        {"mouse", 20},
        {"monitor", 30}
    };

    string produto;
    getline(cin, produto);
    replaceAll(produto, " ", "");
    transform(produto.begin(), produto.end(), produto.begin(), ::tolower);
    bool flag = (estoque.find(produto) != estoque.end());
    if(flag) cout << "Quantidade do " << produto << ": " << estoque[produto] << endl;
    else cout << "Produto não encontrado no sistema.\n";
}


void Q3(){
    float sum = 0;
    map<string, float> vendas_regiao = {
        {"Norte", 15000},
        {"Sul", 22000},
        {"Leste", 18000},
        {"Oeste", 25000}
    };
    for(const auto& regiao : vendas_regiao){
        cout << "Vendas na região " << regiao.first << ": R$" << fixed << setprecision(2) << regiao.second << endl;
        sum += regiao.second;
    }
    cout << "Total de vendas: R$" << fixed << setprecision(2) << sum << endl;
    cout << "Média de vendas por região: R$" << fixed << setprecision(2) << (sum / vendas_regiao.size()) << endl;
}

void Q4(){
    map<string, vector<float>> desemmpenho = {
        {"Lira", {8, 9, 7}},
        {"Paula", {10, 9, 10}},
        {"Tiago", {6, 7, 8}}
    };
    vector<float> lista_notas = desemmpenho["Paula"];
    float media = 0;
    for(float nota : lista_notas){
        media += nota;
    }
    cout << "A média da paula foi: " << fixed << setprecision(2) << (media / lista_notas.size()) << endl;
}

void Q5(){
    map<string, float> produtos = {
        {"celular", 1500},
        {"camera", 800},
        {"radio", 200},
        {"fone", 100}
    };
    // remover rádio com o equivalente ao .pop(), imprimir o valor removido, verificar se o celular ainda existe.
    float valor_removido = produtos["radio"];
    produtos.erase("radio");
    cout << "Valor do produto removido (radio): R$" << fixed << setprecision(2) << valor_removido << endl;
    bool celular_existe = (produtos.find("celular") != produtos.end());
    cout << "O produto 'celular' " << (celular_existe ? "existe no estoque." : "não existe no estoque.") << endl;
    cout << (celular_existe ? "True" : "False") << endl;
}

int main(){
    //Q1();
    //Q2();
    Q3();
    cout<<endl;
    Q4();
    Q5();
    return 0;
}