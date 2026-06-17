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
    cout<<"Digite o valor de seu investimento: ";
    float valor_investir = extractBillingValue();
    if(valor_investir < 1000.0){
        cout << "Perfil Iniciante: sugerimos Tesouro Direto.";
    }else if(valor_investir < 5000.0){
        cout << "Perfil Moderado: sugerimos Fundos Imobiliários.";
    }else{
        cout << "Perfil Arrojado: sugerimos Ações.";
    }
    cout << endl;
}

void Q2(){
    vector<string> admins = {"ana@empresa.com", "guilherme@empresa.com", "felipe@empresa.com"};
    bool flag = false;
    cout << "Digite seu email: ";
    string my_email;
    getline(cin, my_email);
    replaceAll(my_email, " ", "");
    transform(my_email.begin(), my_email.end(), my_email.begin(), ::tolower);
    cout<<"Seu email: "<<my_email<<endl;
    for(int i = 0; i < admins.size(); i++){
        if(my_email == admins[i]){
            flag = true;
            break;
        }
    }
    cout << (flag ? "Acesso Liberado! Bem vindo ao Painel de Controle!":"Acesso Negado. Você não tem permissões de admnistrador.")<<endl;
}

void Q3(){
    cout<<"Digite o valor total de suas compras: ";
    float valor = extractBillingValue();
    cout<<"Valor total de compras: R$"<< fixed << setprecision(2) << valor << endl;
    float desconto = 0.0;
    if(valor >= 500){
        cout << "Desconto de 15%." << endl;
        desconto = (valor*0.15);
    }else if(valor >= 200){
        cout << "Desconto de 10%." << endl;
        desconto = (valor*0.10);
    }else{
        cout << "Sem desconto." << endl;
    }
    float total_a_pagar = (valor - desconto);
    cout<<"Total a Pagar: R$" << fixed << setprecision(2) << total_a_pagar << endl;
    cout<<"Valor do Desconto: R$" << fixed << setprecision(2) << desconto << endl;
}

void Q4(){
    float vendas = 0.0;
    float temp = 0.0;
    while(true){
        cout << "digite o valor de suas vendas ou 0 para saír: ";
        temp = extractBillingValue();
        if(temp == 0.0)break;
        vendas += temp;
    }
    float meta = 0;
    cout << "digite sua meta de vendas: ";
    meta = extractBillingValue();
    cout << "Seu bônus esse mês é de: R$" << fixed << setprecision(2) << ((vendas >= meta) ? (vendas*0.2):0.0) << endl;
}

void Q5(){
    string user_request;
    cout << "Bem vindo ao Sistema de Atendimento ao Consumidor. O que deseja?\n";
    getline(cin >> ws, user_request);
    transform(user_request.begin(), user_request.end(), user_request.begin(), ::tolower);
    if (user_request.find("pagamento") != string::npos || user_request.find("boleto") != string::npos) {
        cout << "Resultado: Encaminhado para o Financeiro." << endl;
    } 
    else if (user_request.find("entrega") != string::npos || user_request.find("atraso") != string::npos) {
        cout << "Resultado: Encaminhado para a Logística." << endl;
    } 
    else {
        // Esta é a terceira condição que apareceu na segunda página da imagem:
        cout << "Resultado: Encaminhado para o Suporte Geral." << endl;
    }
}

int main(){
    //Q1();
    //Q2();
    //Q3();
    //Q4();
    Q5();
    return 0;
}