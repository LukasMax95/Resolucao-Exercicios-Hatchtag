// snippets c++ no arquivo utils.h
#ifndef UTILS_H
#define UTILS_H

#include <string>
#include <algorithm>
#include <cctype>
#include <iostream>
#include <vector>

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

void capitalyize(string &s){
    for (int i = 0; i < s.length(); i++) {
        if (i == 0 || s[i-1] == ' ') {
            s[i] = toupper(s[i]);
        }
    }
}

#endif