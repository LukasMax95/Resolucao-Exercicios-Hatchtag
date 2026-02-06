
def Q1(billing, bonus):
    print("Cálculo de Bônus de Vendas")
    total_bonus = billing * bonus
    liq_billing = billing - total_bonus
    print(f"Valor do Bônus: {total_bonus}")
    print(f"Faturamento Final: {liq_billing}\n")

def Q2(n_units, n_sold, extra_units):
    print("Controle de Estoque de E-commerce")
    stock = n_units - n_sold + extra_units
    print(f"Estoque Final: {stock}\n")

def Q3(total_caixas, truck_load = 12):
    print("Divisão de Cargas")
    full_load_trucks = total_caixas//truck_load
    extra_truck_load = total_caixas%truck_load
    print(f"Caminhões Completos: {full_load_trucks}")
    print(f"Caixas Restantes: {extra_truck_load}\n")

def Q4(billing, costs, tax):
    print("Análise de Margem de Lucro ")
    total_tax = billing*tax
    net_profit = billing - (costs + total_tax)
    margin = net_profit/billing
    print(f"Imposto Total: {total_tax}")
    print(f"Lucro Líquido: {net_profit}")
    print(f"Margem de Lucro: {margin}")
    print(f"Margem de Lucro superior a 30%: {("Sim" if margin > 0.3 else "Não")}\n")

def Q5(meses):
    print("Conversão de Tempo de Contrato:")
    n_anos = meses//12
    n_meses = meses%12
    print(f"Duração do contrato é de {n_anos} anos e {n_meses} meses.\n")

Q1(50000.0, 0.1)
Q2(250, 75, 100)
Q3(1250)
Q4(15000, 5000, 0.15)
Q5(40)