function remove_all_but_last_dot(s) {
    last_idx = s.lastIndexOf(".")
    if (last_idx == -1) {
        return s.replace(".", "")
    }
    before = s.slice(0, last_idx).replace(".", "")
    after = s.slice(last_idx)
    if (after.length > 3) {
        after = after.replace(".", "") + ".00"
    }
    return before + after
}

function extract_billing_value(s) {
    s = s.replace("RS", "").replace("R$", "").trim()
    try {
        return parseFloat(s)
    } catch (error) {
        s = s.replace(",", ".")
        s = remove_all_but_last_dot(s)
        return parseFloat(s)
    }
}

const prompt = require('prompt-sync')();

function input(msg) {
    let answer = prompt(`${msg}`);
    return answer;
}

function Q1() {
    console.log("Calculadora de Imposto sobre Vendas")
    billing = extract_billing_value("R$50.000,00")
    tax = 0.15
    liquid_tax = billing * tax
    console.log(`Imposto pago: ${liquid_tax.toFixed(2)}`)
}

function Q2() {
    console.log("Sistema de Cadastro de Colaborador (Setor de RH)")
    let nome = input(`Digite seu nome: `)
    let email = input(`Digite seu email: `)
    nome = nome.trim().split(" ").map((word) => word.charAt(0).toUpperCase() + word.slice(1)).join(" ")
    email = email.trim().toLowerCase()
    console.log(`Cadastro concluído! \n - Nome: ${nome}\n - E-mail de acesso: ${email}\n`)
}

function Q3() {
    console.log("Sistema de Controle de Estoque")
    let fatA = input(`Digite o faturamento da empresa A: `)
    let fatB = input(`Digite o faturamento da empresa B: `)
    fatA = extract_billing_value(fatA)
    fatB = extract_billing_value(fatB)
    total_fat = fatA + fatB
    avg_fat = total_fat / 2
    console.log(`O faturamento total das lojas foi de ${total_fat.toFixed(2)} com média de ${avg_fat.toFixed(2)}`)
}

Q1()
Q2()
Q3()