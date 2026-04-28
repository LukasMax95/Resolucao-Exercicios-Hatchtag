const Q1 = (billing, costs, tax) => {
    console.log("Relatório de Margem de Lucro")
    total_tax = billing * tax
    net_profit = billing - (costs + total_tax)
    margin = net_profit / billing
    console.log(`Imposto Total: ${total_tax.toFixed(2)}`)
    console.log(`Lucro Líquido: ${net_profit.toFixed(2)}`)
    console.log(`Margem de Lucro: ${margin.toFixed(2)}`)
    console.log(`Margem de Lucro superior a 30%: ${margin > 0.3 ? "Sim" : "Não"}`)
}
const Q2 = (name, email) => {
    console.log("Padronização de Dados de CRM")
    name = name.trim().split(" ").map(
        (word) => word.charAt(0).toUpperCase() + word.slice(1)
    ).join(" ")
    email = email.trim().toLowerCase()
    console.log(`Nome: ${name}`)
    console.log(`Email: ${email}\n`)
}
const Q3 = (email, new_domain, changed_domain) => {
    console.log("Migração de Servidor de E-mail")
    if (changed_domain) {
        email = email.replace(changed_domain, new_domain)
    } else {
        pos = email.indexOf("@")
        email = email.slice(0, pos) + new_domain
    }
    console.log(`Email Atualizado: ${email}\n`)
}
const Q4 = (email) => {
    console.log("Extração de Username para Log")
    pos = email.indexOf("@")
    username = email.slice(0, pos)
    console.log(`Username: ${username}\n`)
}
const Q5 = (name) => {
    console.log("Personalização de E-mail de Marketing")
    pos = name.indexOf(" ")
    firstname = name.slice(0, pos)
    firstname = firstname.charAt(0).toUpperCase() + firstname.slice(1)
    console.log(`Olá, ${firstname}, seja bem-vindo ao nosso clube!\n`)
}

Q1(45000, 23500, 0.15)
Q2(" mArCoS aNtOnIo rOcHa ", " MARCOS.ROCHA@GMAIL.COM ")
Q3("andre_silva@empresa.com.br", "@grupocorp.com", "@empresa.com.br")
Q3("beatriz.oliveira@grupocorp.com", "@novadominio.com")
Q4("beatriz.oliveira@grupocorp.com")
Q5("lucas ferreira souza")