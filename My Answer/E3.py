def remove_all_but_last_dot(s: str) -> str:
    # Encontra o último ponto (equivalente ao lastIndexOf)
    last_idx = s.rfind('.')
    
    if last_idx == -1:
        # Se não tem ponto, remove qualquer ponto residual (limpeza)
        return s.replace(".", "")
    
    # Divide a string: tudo antes do último ponto e o que vem depois
    before = s[:last_idx].replace(".", "")
    after = s[last_idx:]
    
    # Se houver mais de 3 caracteres após o ponto, assume que o ponto era de milhar
    if len(after) > 3:
        after = after.replace(".", "") + ".00"
        
    return before + after


def Q1():
    while True:
        fat = input("Digite o faturamento (ex: 25.000,00 ou 25000.00):")
        try:
            fat = fat.upper().replace("R$", "").replace("RS", "").strip().replace(",", ".")
            fat = remove_all_but_last_dot(fat)
            fat_numerico = float(fat)
            
            if fat_numerico < 0:
                print("❌ O faturamento não pode ser negativo. Tente novamente.")
                continue
            
            perc_imposto = 0.15
            imposto = fat_numerico * perc_imposto
            print(f"✓ Imposto pago: R${imposto:,.2f}")
            break
        except ValueError:
            print("❌ Formato inválido! Digite um valor numérico válido.")

def getFat(fat: str) -> float:
    while True:
        try:
            fat = fat.upper().replace("R$", "").replace("RS", "").strip().replace(",", ".")
            fat = remove_all_but_last_dot(fat)
            fat_numerico = float(fat)
            
            return fat_numerico
        except ValueError:
            print("❌ Formato inválido! Digite um valor numérico válido.")

def Q2():
    nome = input("Digite seu nome: ")
    email = input("Digite seu email: ")
    nome = nome.strip().title()
    email = email.strip().lower().replace(" ", "")
    pos = nome.find(" ")
    if(pos != -1):
        firstname = nome.split(" ")[0]
    else:
        firstname = nome
    print(f"Cadastro concluído! \n - Nome:  {firstname} \n - E-mail de acesso:  {email}")

def Q3():
    fatA = input("Digite o faturamento da empresa A: ")
    fatB = input("Digite o faturamento da empresa B: ")
    numFatA = getFat(fatA)
    numFatB = getFat(fatB)
    totalFat = numFatA + numFatB
    mediaFat = (totalFat)/2
    print(f"O faturamento total das lojas foi de {totalFat:.2f} com média de {mediaFat:.2f}.")

#para testar cada resposta indivídualmente é só comentar/descomentar a chamada das funções
Q1()
Q2()
Q3()