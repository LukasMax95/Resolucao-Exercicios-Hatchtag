#include <iostream>
#include <string>
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
/*void Q1() {
    string billing = "R$25,000.000,00";
    
    // 1. Limpeza inicial (Remover R$ e espaços)
    replaceAll(billing, "R$", "");
    trimString(billing); // Resulta em "25,000.000,00"

    // 2. Padronizar separadores
    // Primeiro, transformamos a vírgula decimal em ponto
    replaceAll(billing, ",", "."); // Resulta em "25.000.000.00"[cite: 1]

    // 3. Remover pontos de milhar e manter apenas o decimal
    // A sua função removeAllButLastDot fará o trabalho pesado
    string cleanedBilling = removeAllButLastDot(billing); // Resulta em "25000000.00"[cite: 1]

    // 4. Converter para double
    double numbilling = stod(cleanedBilling);[cite: 1]

    // Resultado
    cout << "String original: R$25,000.000,00" << endl;
    cout << "String limpa: " << cleanedBilling << endl;
    cout << "Variável numbilling (double): " << fixed << setprecision(2) << numbilling << endl;
}*/

void Q1(){
    cout<<"Digite o faturamento: ";
    string billing;
    getline(cin, billing);
    // 1. Converter para maiúsculo
    transform(billing.begin(), billing.end(), billing.begin(), ::toupper);
    
    // 2. Substituir substrings
    replaceAll(billing, "RS", "");
    replaceAll(billing, "R$", "");
    
    // 3. Trim
    trimString(billing);
    replaceAll(billing, ",", ".");
    double numBilling = stod(removeAllButLastDot(billing));
    try {
        double tax = 0.15;
        double liquid_tax = numBilling * tax;
        cout<<"Imposto pago: R$"<<fixed<<setprecision(2)<<liquid_tax<<endl;
        
    }catch (const invalid_argument& e3) {
        cout<<"Formato inválido! Digite um valor numérico válido."<<endl;
    }
    cout << billing << " " << numBilling << endl;
}

void capitalyize(string &s){
    #pragma omp parallel for
    for (int i = 0; i < s.length(); i++) {
        if (i == 0 || s[i-1] == ' ') {
            s[i] = toupper(s[i]);
        }
    }
}

double extractBillingValue(){
    string billing;
    getline(cin, billing);
    transform(billing.begin(), billing.end(), billing.begin(), ::toupper);
    replaceAll(billing, "RS", "");
    replaceAll(billing, "R$", "");
    trimString(billing);
    replaceAll(billing, ",", ".");
    return stod(removeAllButLastDot(billing));
}

void Q2(){
    string name, email;
    cout<<"Digite seu nome: ";
    getline(cin, name);
    cout<<"Digite seu email: ";
    getline(cin, email);
    transform(name.begin(), name.end(), name.begin(), ::tolower);
    capitalyize(name);
    cout<<"Nome formatado: "<<name<<endl;
    string firstname = "";
    int pos = name.find(" ");
    if(pos != string::npos) firstname = name.substr(0, pos);
    else firstname = name;
    replaceAll(email, " ", "");
    transform(email.begin(), email.end(), email.begin(), ::tolower);
    cout<<"Cadastro concluído! \n - Nome: " << firstname << "\n - E-mail de acesso: " << email<<endl;
}
void Q3(){
    cout<<"Digite o faturamento da empresa A: ";
    double fatA = extractBillingValue();
    cout<<"Digite o faturamento da empresa B: ";
    double fatB = extractBillingValue();
    double totalfat = fatA + fatB;
    double media = (fatA + fatB)/2.0;
    cout<<"O faturamento total das lojas foi de R$"<<fixed<<setprecision(2)<<totalfat<<" com média de R$"<<fixed<<setprecision(2)<<media<<endl;
}

int main(){
    Q1();
    Q2();
    Q3();
    return 0;
}