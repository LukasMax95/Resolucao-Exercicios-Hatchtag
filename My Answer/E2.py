def Q1(billing, costs, tax = 0):
    print("Relatório de Margem de Lucro")
    profit = 0
    if tax == 0:
        profit = billing - costs
    else:
        tax_value = billing * tax
        profit = billing - costs - billing*tax_value
    print(f" - Lucro: {profit:.2f}\n - Margem de Lucro:{(profit/billing):.2f}\n")

def Q2(nome, email):
    print("Padronização de Dados de CRM")
    nome = nome.strip().title()
    email = email.strip().lower()
    print(f" - Nome: {nome}\n - Email: {email}\n")

def Q3a(email, new_domain):#caso geral
    print("Migração de Servidor de E-mail (caso generalizado)")
    pos = email.find("@")
    email = email[:pos] + new_domain
    print(f"Email Atualizado: {email}\n")

def Q3b(email, new_domain, changed_domain):#caso especifico
    print("Migração de Servidor de E-mail (caso específico)")
    email = email.replace(changed_domain, new_domain)
    print(f"Email Atualizado: {email}\n")

def Q4(email):
    print("Extração de Username para Log")
    pos = email.find("@")
    username = email[:pos]
    print(f"Username Estraído: {username}\n")

def Q5(name):
    print("Personalização de E-mail de Marketing")
    pos = name.find(" ")
    firstname = name[:pos]
    print(f"Olá, {firstname.title()}, seja bem-vindo ao nosso clube!")




Q1(45000, 23500)
Q2(" mArCoS aNtOnIo rOcHa ", " MARCOS.ROCHA@GMAIL.COM ")
Q3a("andre_silva@empresa.com.br", "@grupocorp.com")
Q3b("andre_silva@empresa.com.br", "@grupocorp.com", "@empresa.com.br")
Q4("beatriz.oliveira@grupocorp.com")
Q5("lucas ferreira souza")