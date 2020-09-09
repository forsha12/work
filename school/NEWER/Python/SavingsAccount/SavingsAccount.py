#class savings account
class SavingsAccount:
    def __init__(self, _name, _balance):
        self.name = _name
        self.balance = _balance

    #adds the deposit to total balance
    def makeDeposit(self, deposit):
        self.balance += deposit
        print("Balance is now: ${0:10,.2f}".format(self.balance))

    #takes out money only if the withdrawal is within the balance amount
    def makeWithdrawal(self, withdrawal):
        if withdrawal > self.balance:
            print("Withdrawal amount over balance. Current Balance: ${0:10,.2f}".format(self.balance))
        else:

            print("Withdrawal made. Balance is now: ${0:10,.2f}".format(self.balance))


