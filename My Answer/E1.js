const Q1 = (billing, bonus) => {
    //Questão 1
    console.log("Cálculo de Bônus de Vendas")
    total_bonus = billing * bonus
    liq_billing = billing - total_bonus
    console.log(`Valor do Bônus: ${total_bonus.toFixed(2)}`)
    console.log(`Faturamento Final: ${liq_billing.toFixed(2)}\n`)
}
const Q2 = (n_units, n_sold, extra_units) => {
    //Questão 2
    console.log("Controle de Estoque de E-commerce")
    stock = n_units - n_sold + extra_units
    console.log(`Estoque Final: ${stock}\n`)
}
const Q3 = (total_caixas, truck_load = 12) => {
    //Questão 3
    console.log("Divisão de Cargas")
    full_load_trucks = Math.floor(total_caixas / truck_load)
    extra_truck_load = total_caixas % truck_load
    console.log(`Caminhões Completos: ${full_load_trucks}`)
    console.log(`Caixas Restantes: ${extra_truck_load}\n`)
}
const Q4 = (billing, costs, tax) => {
    //Questão 4
    console.log("Análise de Margem de Lucro ")
    total_tax = billing * tax
    net_profit = billing - (costs + total_tax)
    margin = net_profit / billing
    console.log(`Imposto Total: ${total_tax.toFixed(2)}`)
    console.log(`Lucro Líquido: ${net_profit.toFixed(2)}`)
    console.log(`Margem de Lucro: ${margin.toFixed(2)}`)
    console.log(`Margem de Lucro superior a 30%: ${margin > 0.3 ? "Sim" : "Não"}\n`)
}
const Q5 = (meses) => {
    //Questão 5
    console.log("Conversão de Tempo de Contrato:")
    n_anos = meses//12
    n_meses = meses % 12
    console.log(`Duração do contrato é de ${n_anos} anos e ${n_meses} meses.\n`)
}

Q1(50000.0, 0.1)
Q2(250, 75, 100)
Q3(1250)
Q4(15000, 5000, 0.15)
Q5(40)