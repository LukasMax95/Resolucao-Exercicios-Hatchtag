#include <iostream>
#include <string>
#include <regex>
#include <algorithm>
#include <iomanip>
#include <omp.h>

using namespace std;

void Q1(double billing, double costs, double tax){
    double tax_value = billing * tax;
    double profit = billing - costs - tax_value;
    double profit_margin = profit/billing;
    cout<< " - Lucro: " << fixed << setprecision(2) << profit << endl;
    cout<< " - Margem de Lucro: " << fixed << setprecision(2) << profit_margin << endl;
}

void Q1(double billing, double costs){
    double profit = billing - costs;
    double profit_margin = profit/billing;
    cout<< " - Lucro: " << fixed << setprecision(2) << profit << endl;
    cout<< " - Margem de Lucro: " << ((int) (profit_margin*100)) << "%\n";
}

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

void capitalyize(string &s){
    #pragma omp parallel for
    for (int i = 0; i < s.length(); i++) {
        if (i == 0 || s[i-1] == ' ') {
            s[i] = toupper(s[i]);
        }
    }
}

void Q2(string name, string email){
    trimString(name);
    transform(name.begin(), name.end(), name.begin(), ::tolower);
    trimString(email);
    transform(email.begin(), email.end(), email.begin(), ::tolower);
    capitalyize(name);
    cout<< " - Nome: " << name << endl;
    cout<< " - Email: " << email << endl;   
}

void Q3(string email, string new_domain, string old_domain){
    if (email.rfind(old_domain) == email.size() - old_domain.size()) {
        string updated_email = email.substr(0, email.size() - old_domain.size()) + new_domain;
        cout<< " - Email Atualizado: " << updated_email << endl;
        email = updated_email;
    }
}

void Q3(string email, string new_domain){
    int atPos = email.find('@');
    if (atPos != string::npos){
        string localPart = email.substr(0, atPos);
        string updated_email = localPart + new_domain;
        cout<< " - Email Atualizado: " << updated_email << endl;
    }
}

void Q4(string email){
    int atPos = email.find('@');
    if (atPos != string::npos){
        string extracted_username = email.substr(0, atPos);
        cout<< " - Username Extraído: " << extracted_username << endl;
    }
}

void Q5(string name){
    int atPos = name.find(' ');
    if (atPos != string::npos){
        string firstname = name.substr(0, atPos);
        transform(firstname.begin(), firstname.end(), firstname.begin(), ::tolower);
        capitalyize(firstname);
        cout<< ">> Olá, " << firstname << ", seja bem-vindo ao nosso clube!\n";
    }
}

int main(){
    Q1(45000, 23500);
    Q2(" mArCoS aNtOnIo rOcHa ", " MARCOS.ROCHA@GMAIL.COM ");
    Q3("andre_silva@empresa.com.br", "@grupocorp.com", "@empresa.com.br");
    Q4("beatriz.oliveira@grupocorp.com");
    Q5("lucas ferreira souza");
    return 0;
}