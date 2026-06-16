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

using namespace std;

void replaceAll(string& str, const string& from, const string& to) {
    if(from.empty()) return;
    size_t start_pos = 0;
    while((start_pos = str.find(from, start_pos)) != string::npos) {
        str.replace(start_pos, from.length(), to);
        start_pos += to.length(); // Avança para não pegar a mesma string substituída
    }
}

void trimString(string &s) {
    s.erase(s.begin(), find_if(s.begin(), s.end(), [](unsigned char ch) { return !isspace(ch); }));
    s.erase(find_if(s.rbegin(), s.rend(), [](unsigned char ch) { return !isspace(ch); }).base(), s.end());
}

string removeAllButLastDot(string s){
    int last = s.find_last_of('.');
    if(last == string::npos) {
        s.erase(remove(s.begin(), s.end(), '.'), s.end()); // Remove todos os pontos
        return s;
    }
    
    string before = s.substr(0, last);
    before.erase(remove(before.begin(), before.end(), '.'), before.end());
    
    string after = s.substr(last);
    if((s.length() - last) > 3) {
        after.erase(remove(after.begin(), after.end(), '.'), after.end());
        after += ".00";
    }
    return before + after;
}

double extractBillingValue(){
    string billing;
    getline(cin >> ws, billing);
    transform(billing.begin(), billing.end(), billing.begin(), ::toupper);
    replaceAll(billing, "RS", "");
    replaceAll(billing, "R$", "");
    trimString(billing);
    replaceAll(billing, ",", ".");
    return stod(removeAllButLastDot(billing));
}

void Q1(){
    int vendas[] = {1500, 2000, 800, 3500, 1200};
    int sum = 0;
    float avr = 0;
    int maior_venda = 0, menor_venda = 100000, n = size(vendas);
    #pragma omp parallel for reduction(+:sum, avr) reduction(max:maior_venda) reduction(min:menor_venda)
    for (int i = 0; i < n; i++){
        sum += vendas[i];
        avr += (float)vendas[i]/n;
        if(maior_venda < vendas[i]) maior_venda = vendas[i];
        if(menor_venda > vendas[i]) menor_venda = vendas[i];
    }
    cout << "Relatório:\n - Total de vendas: " << sum
                << "\n - Média de Vendas: " << avr << setprecision(2)
                << "\n - Maior Venda: " << maior_venda
                << " \n - Menor Venda: " << menor_venda << endl;
}

void Q2(){
    vector<string> estoque = {"monitor", "teclado", "mouse", "headseat"};
    string novoItem = "webcam";
    string nomeAtualizar = "teclado";
    string atualizarNome = "teclado_maníaco";
    string removerItem = "mouse";
    for (const string& item : estoque) cout << "| " << item << " |";
    cout<<endl;
    estoque.push_back(novoItem);
    for (const string& item : estoque) cout << "| " << item << " |";
    cout<<endl;
    for (int i = 0; i < estoque.size(); i++){
        if(estoque[i] == nomeAtualizar){
            estoque[i] = atualizarNome;
            cout<<"Item atualizado!\n";
            break;
        }
    }
    for (const string& item : estoque) cout << "| " << item << " |";
    cout<<endl;
    for (int i = 0; i < estoque.size(); i++){
        if(estoque[i] == removerItem){
            estoque.erase(estoque.begin() + i);
            cout<<"Item removido!\n";
            break;
        }
    }
    for (const string& item : estoque) cout << "| " << item << " |";
    cout<<endl;
    
}

void Q3(){//Ordenação de Preços
    vector<int> precos = {50, 80, 20, 150, 40};
    int min = 100000, max = 0;
    int i = 0, j = precos.size()-1;
    for(const int& preco : precos) cout << preco << " ";
    cout<<endl;
    while(i <= j){
        int temp = 0;
        if(precos[i] > precos[j]){
            temp = precos[j];
            precos[j] = precos[i];
            precos[i] = temp;
            j--;
        }else{
            j--;
        }
        cout << i << " " << j << endl;
        if(i == j) {
            j = precos.size() -1;
            i++;
            if(i == precos.size() - 1) break;
        }
        for(const int& preco : precos) cout << preco << " ";
        cout<<endl;
    }
    cout<<"Lista Ordenada:\n";
    for(const int& preco : precos) cout << preco << " ";
    cout<<endl;
    vector<int> top_fretes(precos.end()-2, precos.end());
    cout<<"Top Fretes:\n";
    for(const int& preco : top_fretes) cout << preco << " ";
    cout<<endl;
    
}

void Q4(){
    vector<string> rota = {"São Paulo", "Jundiaí", "Campinas", "Sorocaba"};
    vector<string> novasCidades = {"Itu", "Valinhos"};
    string identificarIndice = "Sorocaba";
    rota.insert(rota.end(), novasCidades.begin(), novasCidades.end());
    int pos = 0;
    bool flag = true;
    for(const string& cidade : rota){
        cout << cidade;
        if(cidade == identificarIndice) flag = false;
        if(flag) pos++;
        if(&rota.back() == &cidade) cout << "." << endl;
        else cout << ", ";
    } 
    cout<<"Indice de "<<identificarIndice<<": "<<pos<<endl;
    cout<<"Sorocaba é a "<<pos+1<<"a cidade da rota.\n";
    
}

void Q5(){
    vector<float> precos = {100.0, 200.0, 300.0, 500.0};
    vector<string> vinhos = {"Branco", "Tinto", "Rose", "Champagne"};
    cout<<"Lista de Produtos:\n";
    for(int i = 0; i < vinhos.size(); i++){
        cout << vinhos[i] << ": S" << fixed << setprecision(2) << precos[i] << ((i+1 == vinhos.size()) ? ".\n" : ";\n");
    }
    string nome_produto;
    while(true){
        cin >> nome_produto;
        if (find(vinhos.begin(), vinhos.end(), nome_produto) != vinhos.end()) {
                break;
        } else {
                cout << "O vinho " << nome_produto << " nao foi encontrado." << endl;
        }
        
    }
    cout << "Digite o novo preço do produto: ";
    float novo_preco = extractBillingValue();
    for(int i = 0; i < vinhos.size(); i++){
        if(nome_produto == vinhos[i]) precos[i] = novo_preco;
    }
    cout<<"Lista atualizada.\n";
    for(int i = 0; i < vinhos.size(); i++){
        cout << vinhos[i] << ": S" << fixed << setprecision(2) << precos[i] << ((i+1 == vinhos.size()) ? ".\n" : ",\n");
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