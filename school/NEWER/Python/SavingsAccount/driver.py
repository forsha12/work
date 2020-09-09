#driver program for the SavingsAccount class
import SavingsAccount

name = input("Enter your name: ")
balance = float(input("Initial money amount: "))

account = SavingsAccount.SavingsAccount(name, balance)

action = 'y'
while action != 'x':
    print("What would you like to do? Withdrawal, Deposit, or Exit.")
    action = input("w OR d OR x: ")
    if action == 'w':
        withdrawal = float(input("Enter amount to withdrawal: "))
        account.makeWithdrawal(withdrawal)
    elif action == 'd':
        deposit = float(input("Enter amount to deposit: "))
        account.makeDeposit(deposit)
    elif action == 'x':
        print("Thank you!")
    else:
        print("Invalid choice.")
